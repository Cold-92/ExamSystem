package util;

import domain.User;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.IdentityHashMap;

//给数据读取增加一个缓存机制
//将程序启动时，将文件中数据一次性全部读到内存中
//增强底层执行效率
//修改文件很复杂，采取措施直接重写一边覆盖掉
public class UserFileReader {

    //静态保证集合唯一
    private static HashMap<String, User> userBox = new HashMap<>();

    static{
        BufferedReader bfr = null;
        try{
            bfr = new BufferedReader(new FileReader("src//dbFile//User.txt"));
            String userData = bfr.readLine();
            while(userData != null){
                String[] values = userData.split("-");
                User user = new User(values[0], values[1]);
                userBox.put(values[0], user);
                userData = bfr.readLine();
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally {//装饰者模式：只需关闭包装流
            try{
                if(bfr != null){
                    bfr.close();
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    public static User getUser(String account){
        return userBox.get(account);
    }

}
