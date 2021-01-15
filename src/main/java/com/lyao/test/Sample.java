package com.lyao.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author lyao
 * @date 2017/12/20 10:04
 */
public class Sample {

    public static void main(String[] args){
        String rule = "^(.*)\\|(.*)\\|\\d+\\|\\d+\\|\\d+\\|\\d+\\|\\d+\\|([\\d\\s]+)\\|\\d+\\|\\d+\\|\\d+\\|\\d+\\|([\\d\\s]+)$";
        String rule1 = "^(.*)\\|\\d+\\|\\d+\\|\\d+\\|\\d+\\|\\d+\\|([\\d\\s]+)$";
        String str = "|丹河站|1|04|1401|1408301|77|20180510 150413|03|1401|0|0|20000101 000000";
        String str1 = "丹河站|1|04|1401|1408301|77|20180510 150413|03|1401|0|0|20000101 000000";
        String str2 = "大通主线站|1|6|3701|6300501|106|20160128 093549";
        String str3 = "云冈站||23|02|1401|1403406|56|20160101 003455|01|1401|1401301|2|20151231 195458";

        Pattern pattern = Pattern.compile(rule);
        Matcher matcher0 = pattern.matcher(str3);
        if (matcher0.find())
        {
            System.out.println(matcher0.group(1));
            System.out.println(matcher0.group(2));
            System.out.println(matcher0.group(3));
            System.out.println(matcher0.group(4));

        }

        /*Pattern pattern = Pattern.compile(rule1);
        Matcher matcher0 = pattern.matcher(str2);
        if (matcher0.find())
        {
            System.out.println(matcher0.group(1));
            System.out.println(matcher0.group(2));

        }*/
    }

}
