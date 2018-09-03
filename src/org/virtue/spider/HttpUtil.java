package org.virtue.spider;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HttpUtil {
    /**
     * 获取响应
     * @param path
     * @return
     */
    public static String getResponse(String path){
        StringBuffer sb = new StringBuffer();
        try {
            URL url = new URL(path);
            InputStream in =url.openStream();
            InputStreamReader isr = new InputStreamReader(in);
            BufferedReader bufr = new BufferedReader(isr);
            String str;
            while ((str = bufr.readLine()) != null) {
                sb.append(str);
            }
            bufr.close();
            isr.close();
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    /**
     * 根据响应获取总页数
     * @param response
     * @return
     */
    public static int getTotalPage(String response){
        //找到id="countConfig">的位置
        String target = "id=\"countConfig\">";
        String replace = response.replace(" ", "");
        int i = replace.indexOf(target);
        int start = i+target.length();
        String substring1 = replace.substring(start);
        int e = substring1.indexOf("</span>");
        String substring = substring1.substring(0, e);
        System.out.println(substring);
        return 1;
    }

    /**
     * 获取指定HTML标签的指定属性的值
     * @param source 要匹配的源文本
     * @param element 标签名称
     * @param attr 标签的属性名称
     * @return 属性值列表
     */
    public static List<String> match(String source, String element, String attr) {
        List<String> result = new ArrayList<String>();
        String reg = "<" + element + "[^<>]*?\\s" + attr + "=['\"]?(.*?)['\"]?(\\s.*?)?>";
        Matcher m = Pattern.compile(reg).matcher(source);
        while (m.find()) {
            String r = m.group(1);
            result.add(r);
        }
        return result;
    }
}
