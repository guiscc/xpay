package com.xpay.common.utils.sequence;

import org.apache.commons.lang3.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

/**
 * 2 0 1 6 0 8 2 1 1  8  4  8  1  2  6  3   5  0   0  0  1
 * 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15  16 17 18  19 20 21
 * 1-4 年
 * 5-6 月
 * 7-8 日
 * 9-10 时
 * 11-13 分
 * 13-14 秒
 * 15-17 毫秒
 * 18-21 业务类型
 * <p>
 * Created by sxfans on 16/8/21.
 */
public class RandomSequenceImpl implements Sequence {

    private static Calendar calendar = Calendar.getInstance();
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");

    @Override
    public String getDTAndSeq(String groupId, int len) {
        StringBuilder stringBuilder = new StringBuilder();
        Date date = calendar.getTime();
        stringBuilder.append(simpleDateFormat.format(date));
        stringBuilder.append(getRandomStr(len));
        return stringBuilder.toString();
    }

    @Override
    public String getSeq(String groupId, int len) {
        return getRandomStr(len);
    }


    private String getRandomStr(int len) {
        len = len == 0 ? 1 : len;
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i <= len; i++) {
            int num = random.nextInt(9);
            stringBuilder.append(num);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new RandomSequenceImpl().getSeq("test", 5));
    }
}
