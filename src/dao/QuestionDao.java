package dao;

import domain.Question;
import mySpring.MySpring;
import util.QuestionFileReader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

//负责读取文件，随机生成一套试卷
public class QuestionDao {
    //获取缓存
    private QuestionFileReader qfr = MySpring.getBean("util.QuestionFileReader");

    //将缓存集合临时改成List，查找元素时存在位置
    //Collection中的容器可以相互构建
    private ArrayList<Question> questionBank = new ArrayList<>(qfr.getQuestionBox());


    //选择ArrayList<Question>可变题目数量，增加灵活性
    public ArrayList<Question> getPaper(int count){
        //存储最终试卷题目
        HashSet<Question> paper = new HashSet<>();
        while(paper.size() != count){
            //随机产生一个题目索引位置
            Random r = new Random();
            //范围0-9（左闭右开）
            int index = r.nextInt(questionBank.size());
            paper.add(this.questionBank.get(index));
        }
        return new ArrayList<Question>(paper);
    }

}
