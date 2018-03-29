package com.vincent.nlp;

import com.hankcs.hanlp.tokenizer.SpeedTokenizer;

/**
 * Created by lichaoqiang on 18/3/29.
 */
public class HighSpeedSegmentDemo {
    public static void main(String[] args) {
        String text = "江西鄱阳湖干枯，中国最大淡水湖变成大草原";
        System.out.println(SpeedTokenizer.segment(text));
        long start = System.currentTimeMillis();
        int pressure = 1000000;
        for (int i = 0; i < pressure; ++i) {
            SpeedTokenizer.segment(text);
        }
        double costTime = (System.currentTimeMillis() - start) / (double)1000;
        System.out.printf("分词速度：%.2f字每秒", text.length() * pressure / costTime);
    }
}
