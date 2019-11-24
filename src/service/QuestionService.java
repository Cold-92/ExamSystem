package service;

import dao.QuestionDao;
import domain.Question;
import mySpring.MySpring;

import java.util.ArrayList;

public class QuestionService {

    private QuestionDao dao = MySpring.getBean("dao.QuestionDao");

    //获取随机产生从试卷
    public ArrayList<Question> getPaper(int count){
        return dao.getPaper(count);
    }

}
