package com.shadowkhan.unit;

/**
 * @author linwei
 * 生成6位验证码
 * @date 2020/02/23
 */
public class GetCode {
    public static String getNumber(){
//        String str = "1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String str = "1234567890";
        String code = "";
        for(int i= 0;i<6;i++){
            int index = (int)(Math.random()*str.length());
            code+=str.charAt(index);
        }
        return code;
    }
}
