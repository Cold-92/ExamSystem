package view;

import mySpring.MySpring;
import util.BaseFrame;
import service.UserService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//登录窗口
public class LoginFrame extends BaseFrame {

    public LoginFrame(){
        this.init();
    }
    public LoginFrame(String title){
        super(title);
        this.init();
    }

    //属性：
    //创建面板
    private JPanel mainPanel = new JPanel();
    //添加组件：
    //创建登录面板上面的标签
    private JLabel titleLabel = new JLabel("在 线 考 试 系 统");
    private JLabel accountLabel = new JLabel("账 户：");
    private JLabel passwordLabel = new JLabel("密 码：");
    //创建登录面板上的文本框
    private JTextField accountField = new JTextField();
    private JPasswordField passwordField = new JPasswordField();
    //创建登录面板上的按钮
    private JButton loginButton = new JButton("登录");
    private JButton exitButton = new JButton("退出");

    //设置每个组件的位置，尺寸，字体等
    protected void setFontAndSoOn(){
        //设置组件的位置---布局管理（使用自定义）

        //设置panel布局管理为自定义（面板默认为流式）
        mainPanel.setLayout(null);

        //设置面板背景颜色
//        mainPanel.setBackground(Color.WHITE);

        //设置标题组件的位置，和字体属性
        titleLabel.setBounds(120, 40, 340, 35);
        titleLabel.setFont(new Font("黑体", Font.BOLD, 34));
        accountLabel.setBounds(94, 124, 90, 30);
        accountLabel.setFont(new Font("黑体", Font.BOLD, 24));
        accountField.setBounds(204, 124, 260, 30);
        accountField.setFont(new Font("黑体", Font.BOLD, 24));
        passwordLabel.setBounds(94, 174, 90, 30);
        passwordLabel.setFont(new Font("黑体", Font.BOLD, 24));
        passwordField.setBounds(204, 174, 260, 30);
        passwordField.setFont(new Font("黑体", Font.BOLD, 24));
        loginButton.setBounds(154, 232, 100, 30);
        loginButton.setFont(new Font("黑体", Font.BOLD, 22));
        exitButton.setBounds(304, 232, 100, 30);
        exitButton.setFont(new Font("黑体", Font.BOLD, 22));
    }

    //将所有组件添加再面板上
    protected void addElement(){
        //将组件添加到面板
        mainPanel.add(titleLabel);
        mainPanel.add(accountLabel);
        mainPanel.add(accountField);
        mainPanel.add(passwordLabel);
        mainPanel.add(passwordField);
        mainPanel.add(loginButton);
        mainPanel.add(exitButton);
        //将面板添加到窗体上
        this.add(mainPanel);
    }

    //绑定事件监听器(响应式监听器)
    protected void addListener(){
        //绑定事件监听器
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //从文本框中获取用户名和密码
                UserService userService = new UserService();
                String account = accountField.getText();
                //只获取文本
                //String password = passwordField.getText();
                //获取加密后的文本
                char[] passwordText = passwordField.getPassword();
                String password = new String(passwordText);
//                UserService service = new UserService();
                UserService service = MySpring.getBean("service.UserService");
                String result = service.login(account, password);
                if(result.equals("登录成功")){
                    //将原窗口隐藏
                    LoginFrame.this.setVisible(false);
                    //弹出新的考试界面
                    new ExamFrame(account + "的考试界面");
                }else{
                    //弹出登陆失败警告框
                    //参数（parent，massage）
                    //匿名内部类中只写this表示内部类这个类
                    JOptionPane.showMessageDialog(LoginFrame.this, result);
                    //清空文本框和密码框
                    accountField.setText("");
                    passwordField.setText("");
                }
            }
        });
    }

    //设置窗体本身属性
    protected void setFrameSelf(){
        //设置窗体边界和起始位置
        this.setBounds(500,200, 560, 340);
        //设置关闭窗体按钮
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //设置窗体不可拖拽
        this.setResizable(false);
        //设置窗体可见
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new LoginFrame();
    }

}
