package service;

import dao.UserDao;
import domain.User;
import mySpring.MySpring;

//model层---数据处理层（业务层）
//负责处理读出来的数据
public class UserService {

    //需要一个dao对象作为属性用来读取数据
    private UserDao dao = MySpring.getBean("dao.UserDao");

    public String login(String account, String password){
       User user = dao.selectOne(account);
       if(user != null){
           if(user.getPassword().equals(password)){
               return "登录成功";
           }
       }
       return "用户名或密码错误";
    }

}
