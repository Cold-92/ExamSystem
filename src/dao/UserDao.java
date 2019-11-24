package dao;

import domain.User;
import util.UserFileReader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

//model层---数据读取层（持久层）
//只负责数据的读和写，不负责逻辑处理
public class UserDao {
    //查询一个人的信息
    public User selectOne(String account){
        User user = UserFileReader.getUser(account);
        return user;
    }

}
