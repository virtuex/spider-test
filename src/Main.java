import com.alibaba.fastjson.JSONObject;
import org.virtue.load.DataLoadUtil;
import org.virtue.load.DateUtil;
import org.virtue.load.JsonUtil;
import org.virtue.pojo.Product;
import org.virtue.spider.HttpUtil;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    public static String indexPage = "http://www.chinatrc.com.cn/zhongxindeng-web/product/index/";
    public static void main(String[] args) {
        //registrationTime  申请登记日期
        //publicityTime  公示日期
        //trustTremType 存续期限
        List<Product> products = new ArrayList<>();
        int sum=1;
        String response = HttpUtil.getResponse(indexPage+ DataLoadUtil.getParam(1));
        Map<String, Object> strToMap = JsonUtil.convertJsonStrToMap(response);
        Integer count = (Integer) strToMap.get("count");
        int totalPage = count/10+1;
        //一共totalPage页
        for(int i=1;i<=totalPage;i++) {
            System.out.println("开始爬取第"+i+"页");
            String response2 = HttpUtil.getResponse(indexPage+ DataLoadUtil.getParam(i));
            Map<String, Object> strToMap2 = JsonUtil.convertJsonStrToMap(response2);
            String jsonArray = strToMap2.get("publicityList").toString();
            List<Map> collection = JSONObject.parseArray(jsonArray, Map.class);
            for (Map<String, Object> map : collection) {
                Product product = new Product();
                // product.setEndDate();
                //计算截止日期
                long endtime = (long) ((JSONObject.parseObject(map.get("registrationTime").toString(), Map.class).get("time")));
                String endStr = DateUtil.dateToStr(new Date(endtime));
                String type = (String) map.get("trustTremType");
                int trustTremType;
                if(type.contains(".")&&!DataLoadUtil.isChinese(type)){
                    trustTremType = Double.valueOf(type).intValue();
                }else {
                    if (!DataLoadUtil.isChinese(type)){
                        trustTremType = Integer.valueOf(type);
                    }else{
                        trustTremType = 0;
                    }
                }
                String s = DateUtil.computeEndDate(endStr, trustTremType);
                product.setEndDate(s);
                //
                product.setManager((String) map.get("trustCompanyName"));
                product.setProductNo((String) map.get("proectIssueCode"));
                System.out.println("产品编码--->"+(String) map.get("proectIssueCode"));
                product.setProductName((String) map.get("trustProductName"));
                long retime = (long) ((JSONObject.parseObject(map.get("publicityTime").toString(), Map.class).get("time")));
                product.setRecordDate(DateUtil.dateToStr(new Date(retime)));
                product.setToIndustry((String) map.get("trustPropertyApplicationDesc"));
                //信托功能暂时没有找到
                //product.setTrustFunction();
                product.setWealthOpTyle((String) map.get("trustUseApplicationDesc"));
                System.out.println("第"+sum+"条数据爬去成功"+product);
                sum++;
                products.add(product);
            }
        }
        System.out.println(products);

    }
}
