package com.vincent.nlp;

import com.hankcs.hanlp.HanLP;

/**
 * Created by lichaoqiang on 18/3/29.
 */
public class TraditionalChinese2SimplifiedChineseDemo {
    public static void main(String[] args) {
        System.out.println(HanLP.convertToTraditionalChinese("我会在海边等你归来"));
        System.out.println(HanLP.convertToSimplifiedChinese("「等妳當上皇后以後」"));
    }
}
