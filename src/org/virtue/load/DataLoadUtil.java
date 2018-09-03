package org.virtue.load;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataLoadUtil {
    public static String getParam(int page){
        return "t-c-x-f-g-rs-re-ps-pe-p"+page+"-m-n";
    }



    // 判断一个字符串是否含有中文
    public static boolean isChinese(String str) {
        Pattern p = Pattern.compile("[\u4e00-\u9fa5]");
        Matcher m = p.matcher(str);
        if (m.find()) {
            return true;
        }
        return false;
    }

    @Test
    public void test(){
       System.out.println(isChinese("小于一个月"));
    }
}
