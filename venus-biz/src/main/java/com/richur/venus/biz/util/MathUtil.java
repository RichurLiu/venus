package com.richur.venus.biz.util;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author richur
 * @Date 2019/9/6 4:03 PM
 */
public class MathUtil {
    /**
     * 保留两位小数
     * @param num
     * @return
     */
    public static double getTwoDecimal(Float num){
        return Math.round(num * 100) / 100.0;
    }

    private static final DecimalFormat decimalFormat = new DecimalFormat("#,###");
    private static final DecimalFormat df = new DecimalFormat("0.##");


    /**
     * 计算置信区间
     * @param confidence 置信系数（1.65，1.96，2.58）
     * @param x 实验组数据
     * @param y 对照组数据
     * @param n 实验组用户数
     * @param m 对照组用户数
     * @return 置信区间
     */
    public static Double[] getConfidenceInterval(double confidence,double[] x, double[]y, long n, long m){

        if(n == 0 || m == 0){
            return new Double[]{0D, 0D};
        }

        double xAvg = getExpectation(x);
        double yAvg = getExpectation(y);
        double xVariance = varianceImperative(x);
        double yVariance = varianceImperative(y);

        double confidenceFloor = (xAvg - yAvg) - confidence * Math.sqrt(xVariance/n + yVariance/m);
        double confidenceCeil  = (xAvg - yAvg) + confidence * Math.sqrt(xVariance/n + yVariance/m);

        return new Double[]{confidenceFloor, confidenceCeil};

    }

    /**
     * 计算期望（均值）
     * @param num
     * @return
     */
    public static double getExpectation(double[] num){
        double average = 0.0;
        for (double p : num) {
            average += p;
        }
        average /= num.length;
        return average;
    }

    /**
     * 计算方差
     * @param num
     * @return
     */
    public static double varianceImperative(double[] num) {
        double average = 0.0;
        for (double p : num) {
            average += p;
        }
        average /= num.length;

        double variance = 0.0;
        for (double p : num) {
            variance += (p - average) * (p - average);
        }
        return variance / num.length;
    }

    public static void main(String[] args) {
        double[] x = {42477919/3013977, 88049077/5366662, 122319311/7797721};
        double[]y = {21249060/1507320, 54557862/3433949, 88376209/5591670};
        long n = 3013977 + 5366662 + 7797721;
        long m = 1507320 + 3433949 + 5591670;
        Double[] confidenceInterval = getConfidenceInterval(1.96, x, y, n, m);
        System.out.println("["+confidenceInterval[0]+","+confidenceInterval[1]+"]");
    }

}
