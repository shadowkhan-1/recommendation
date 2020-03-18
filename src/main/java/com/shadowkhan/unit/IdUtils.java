package com.shadowkhan.unit;

/**
 * IdUtils.java
 * com.prereadweb.utils
 */

/**
 * @Description: 生成ID工具类
 * @author: Yangxf
 * @date: 2019/4/14 12:40
 */
public class IdUtils {

    /**
     * 以毫微秒做基础计数, 返回唯一有序增长ID
     * <pre>System.nanoTime()</pre>
     * <pre>
     * 线程数量: 100
     * 执行次数: 1000
     * 平均耗时: 222 ms
     * 数组长度: 100000
     * Map Size: 100000
     * </pre>
     * @return ID长度32位
     */
    public static String getPrimaryKey(){
        return MathUtils.makeUpNewData(Thread.currentThread().hashCode()+"", 3)+ MathUtils.randomDigitNumber(5);           //随机7位数
    }

    public static String getPrimaryKey(Integer length){
        return MathUtils.makeUpNewData(Thread.currentThread().hashCode()+"", 3)+ MathUtils.randomDigitNumber(length-3);           //随机7位数
    }
}
