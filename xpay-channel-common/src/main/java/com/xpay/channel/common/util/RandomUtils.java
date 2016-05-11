package com.xpay.channel.common.util;



import java.util.Random;

/**
 * 概率工具类,用于权重计算
 * @desc see class name
 * @author pangyiyang
 * @time 2016年3月8日 下午4:59:05
 */
public class RandomUtils {

    public static Random rand = new Random(System.currentTimeMillis());
    /**
     * 根据随机数组返回某个区间 比如probability = [20,30,50] 则返回0/1/2，0、1、2的概率分别是20%、30%、50%
     *
     * @param probability
     * @return
     */
    public static int roll(Integer[] probability) {
        int sum = 0;
        for (Integer rd : probability) {
            sum += rd;
        }
        return roll(probability, sum);
    }

    public static int roll(Integer[] probability, int base) {
        int roll = getRandNumber(base);
        for (int i = 0; i < probability.length; i++) {
            if (roll < probability[i]) {
                return i;
            }
            roll -= probability[i];
        }
        return -1;
    }

    public static int getRandNumber(int maxNumber) {
        return rand.nextInt(maxNumber);
    }

    public static void main(String[] args) {
        Integer[] parm = new Integer[3];
        parm[0] =0;
        parm[1] =0;
        parm[2] =0;
        int count10=0;
        int count90=0;
        int count91=0;
        for (int i=0;i<10000;i++){
            int rand = RandomUtils.roll(parm);
            if(rand==0){
                count10++;
            }else if(rand==1){
                count90++;
            }else{
                count91++;
            }
        }
        System.out.println("#######10%一共执行"+count10+"次#######");
        System.out.println("#######90%一共执行"+count90+"次#######");
        System.out.println("#######90%一共执行"+count91+"次#######");
    }
}
