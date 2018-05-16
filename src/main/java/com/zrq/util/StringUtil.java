package com.zrq.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by zrq on 2018-5-8.
 */
public class StringUtil {
    private static Pattern linePattern = Pattern.compile("-(\\w)");
    /**横线转驼峰*/
    public static String lineToHump(String str){
        str = str.toLowerCase();
        Matcher matcher = linePattern.matcher(str);
        StringBuffer sb = new StringBuffer();
        while(matcher.find()){
            matcher.appendReplacement(sb, matcher.group(1).toUpperCase());
        }
        matcher.appendTail(sb);
        return sb.toString();
    }
    /**驼峰转横线(简单写法，效率低于{@link #humpToLine2(String)})*/
    public static String humpToLine(String str){
        return str.replaceAll("[A-Z]", "-$0").toLowerCase();
    }
    private static Pattern humpPattern = Pattern.compile("[A-Z]");
    /**驼峰转下划线,效率比上面高*/
    public static String humpToLine2(String str){
        Matcher matcher = humpPattern.matcher(str);
        StringBuffer sb = new StringBuffer();
        while(matcher.find()){
            matcher.appendReplacement(sb, "-"+matcher.group(0).toLowerCase());
        }
        matcher.appendTail(sb);
        return sb.toString();
    }


    /**
     * 转为对称的n位字符串
     * @param str
     * @return
     */
    public static String changeToString(Integer str,Integer len){
        StringBuffer sb = new StringBuffer();
        sb.append("00000"+str);
        return sb.substring(sb.length()-len,sb.length());
    }

//    public static void main(String[] args) {
//        String lineToHump = lineToHump("f_parent_no_leader");
//        System.out.println(lineToHump);//fParentNoLeader
//        System.out.println(humpToLine(lineToHump));//f_parent_no_leader
//        System.out.println(humpToLine2(lineToHump));//f_parent_no_leader
//    }
}
