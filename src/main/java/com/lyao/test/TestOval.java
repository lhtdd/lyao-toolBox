package com.lyao.test;

import net.sf.oval.ConstraintViolation;
import net.sf.oval.Validator;
import net.sf.oval.constraint.MatchPattern;
import net.sf.oval.constraint.NotEmpty;
import net.sf.oval.constraint.NotNull;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author lyao
 * @date 2018/5/9 14:21
 */
public class TestOval {
    public static final String carNoPattern = "^([京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领A-Z0-9]{1}[A-Z0-9]{1}([京津沪渝桂蒙宁新藏冀晋辽吉黑苏浙皖赣闽鲁粤鄂湘豫川云贵陕甘青琼])?[A-HJ-Z0-9]{1}[A-NP-Z0-9]{3}[A-NP-Z0-9挂学警港澳领试超外]{1}([A-HJ-NP-Z0-9外])?)|([A-Z0-9]{7})$";

    @NotNull(message = "不能为空")
    @NotEmpty(message = "不能是空字符串")
    @MatchPattern(pattern = carNoPattern, message = "车牌号码有误")
    private String carNo;

    public static boolean patternValid(String param, String patternRule){
        Pattern pattern = Pattern.compile(patternRule);
        Matcher matcher = pattern.matcher(param);
        boolean matches = matcher.matches();
        return matches;
    }

    public static void main(String[] args) {
        TestOval testOval= new TestOval();
        testOval.carNo = "鲁AA7290";
        if (TestOval.patternValid("鲁AA7290", carNoPattern)){
            System.out.println("a");
        }else {
            System.out.println("b");
        }
        //Validator validator = new Validator();
        //List<ConstraintViolation> violations = validator.validate(testOval);
        //for(ConstraintViolation var : violations){
        //    System.out.println(var.getMessage());
        //}
    }
}
