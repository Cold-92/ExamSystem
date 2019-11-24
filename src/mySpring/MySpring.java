package mySpring;

import java.util.HashMap;

//管理对象的产生
//对象的控制权交给类负责
//IOC控制反转
//生命周期托管的方式实现对象的单例
public class MySpring {

    //存储所有被管理的对象
    private static HashMap<String, Object> beanBox = new HashMap<>();

    //获取任何一个类的对象
    //必须传入类全名
    //<T>是接收的类型，T是返回值类型
    public static <T>T getBean(String className){
        T obj = null;
        try {
            //先从beanBox中取
            obj = (T)beanBox.get(className);
            //如果obj是null，之前没有创建过该类对象
            if(obj == null){
                //获取类
                Class c = Class.forName(className);
                //获取对象（默认调用无参构造方法）
                obj = (T)c.newInstance();
                //新的对象存入集合
                beanBox.put(className, obj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }

}
