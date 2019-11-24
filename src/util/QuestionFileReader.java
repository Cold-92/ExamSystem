package util;

import domain.Question;

import java.awt.desktop.QuitStrategy;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

//缓存，再程序执行时，将文件中1题目一次性全部读取出来
public class QuestionFileReader {

    private HashSet<Question> questionBox = new HashSet<>();

    BufferedReader bfr = null;

    {
        try {
            bfr = new BufferedReader(new FileReader("src//dbFile//Question.txt"));
            String userData = bfr.readLine();
            while(userData != null){
                //题干和答案分开
                String[] values = userData.split("#");
                if(values.length == 2){
                    //无图片信息
                    questionBox.add(new Question(values[0], values[1]));
                }else if(values.length == 3){
                    //含有图片信息
                    questionBox.add(new Question(values[0], values[1], values[2]));
                }
                userData = bfr.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                bfr.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public HashSet<Question> getQuestionBox(){
        return questionBox;
    }

}
