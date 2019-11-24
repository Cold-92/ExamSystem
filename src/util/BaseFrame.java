package util;

import javax.swing.*;

//所有窗口模板
//设计模式：模板模式
public abstract class BaseFrame extends JFrame {

    public BaseFrame(){}
    public BaseFrame(String title){
        super(title);
    }

    //规定流程
    public void init(){
        this.setFontAndSoOn();
        this.addElement();
        this.addListener();
        this.setFrameSelf();
    }

    //设置每个组件的位置，尺寸，字体等
    protected abstract void setFontAndSoOn();

    //将所有组件添加再面板上
    protected abstract void addElement();

    //绑定事件监听器
    protected abstract void addListener();

    //设置窗体本身属性
    protected abstract void setFrameSelf();

}
