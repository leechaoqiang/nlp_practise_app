package com.vincent.nlp;

import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.seg.CRF.CRFSegment;
import com.hankcs.hanlp.seg.Segment;
import com.hankcs.hanlp.seg.common.Term;
import com.hankcs.hanlp.tokenizer.IndexTokenizer;
import com.hankcs.hanlp.tokenizer.NLPTokenizer;
import com.hankcs.hanlp.tokenizer.StandardTokenizer;

import java.util.List;

/**
 * Created by lichaoqiang on 18/3/29.
 */
public class HanLPDemoClient {

    public void firstDemoTokennizer() {
        System.out.println(HanLP.segment("你好，欢迎使用HanLP汉语处理包！"));
    }
    /***
     * 标准分词
     *
     */
    public void standardTokenizer() {
        List<Term> termList = StandardTokenizer.segment("我们提供商品和服务");
        System.out.println(termList);
    }
    /**
     * NLP分词<br/>
     * NLP分词NLPTokenizer会执行全部命名实体识别和词性标注。
     * */
    public void nlpTokenizer() {
        List<Term> termList = NLPTokenizer.segment("中华人民共和国总理李克强正在正在访问西欧国家并推销中国高铁");
        System.out.println(termList);
    }

    /**
     * 索引分词<br/>
     * 索引分词IndexTokenizer是面向搜索引擎的分词器，能够对长词全切分，另外通过term.offset可以获取单词在文本中的偏移量。
     */
    public void indexTokenizer() {
        List<Term> termList = IndexTokenizer.segment("主副食品");
        for (Term term : termList) {
            System.out.println(term + " [" + term.offset + ":" + (term.offset + term.word.length()) + "]");
        }
    }

    /**
     * CRF分词
     */
    public void crfTokenizer() {
        Segment segment = new CRFSegment();
        segment.enablePartOfSpeechTagging(true);
        List<Term> termList = segment.seg("你看过四谛咖赫土吗");
        System.out.println(termList);
        for (Term term : termList) {
            if (term.nature == null) {
                System.out.println("识别到新词：" + term.word);
            }
        }
    }

    public static void main(String[] args) {
        HanLPDemoClient client = new HanLPDemoClient();
//        client.firstDemoTokennizer();

//        client.standardTokenizer();


//        client.nlpTokenizer();

//        client.indexTokenizer();

        client.crfTokenizer();

    }

}
