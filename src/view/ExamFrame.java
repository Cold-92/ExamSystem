package view;


import domain.Question;
import mySpring.MySpring;
import service.QuestionService;
import util.BaseFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

//考试窗口
public class ExamFrame extends BaseFrame {

    public ExamFrame(){
        this.init();
    }
    public ExamFrame(String title){
        super(title);
        this.init();
    }

    //添加三个面板，进行区域分割
    //主面板面板
    //朱面板包括了右侧信息面板和下放按钮面板和题目文本域
    private JPanel mainPanel = new JPanel();
    //右侧信息展示面板
    private JPanel messagePanel = new JPanel();
    //下方按钮展示面板
    private JPanel buttonPanel = new JPanel();
    //添加组件：
    //考试题目文本域
    private JTextArea examArea = new JTextArea();
    //文本域的滚动条（滚动条包着文本域）
    private JScrollPane scrollPane = new JScrollPane(examArea);
    //展示图片
    private JLabel pictureLabel = new JLabel();
    //展示当前题号
    private JLabel nowNumLabel = new JLabel("当前题号：");
    private JTextField nowNumField = new JTextField();
    //展示题目总数
    private JLabel totalCountLabel = new JLabel("题目总数：");
    private JTextField totalCountField = new JTextField();
    //展示已答题数量
    private JLabel answerCountLabel = new JLabel("已答题数：");
    private JTextField answerCountField = new JTextField();
    //展示未答题数量
    private JLabel unanswerCountLabel = new JLabel("未答题数：");
    private JTextField unanswerCountField = new JTextField();
    //展示时间
    private JLabel timeLabel = new JLabel("剩余答题时间");
    private JLabel realTimeLabel = new JLabel("00:00:00");
    //展示按钮
    private JButton aButton = new JButton("A");
    private JButton bButton = new JButton("B");
    private JButton cButton = new JButton("C");
    private JButton dButton = new JButton("D");
    private JButton previousButton = new JButton("上一题");
    private JButton nextButton = new JButton("下一题");
    private JButton submitButton = new JButton("提交试卷");

    //设置每个组件的位置，尺寸，字体等
    protected void setFontAndSoOn(){
        //设置布局管理----自定义
        mainPanel.setLayout(null);
        //主页面背景色
        mainPanel.setBackground(Color.LIGHT_GRAY);

        //题目展示文本域区域
        //滚动条包文本域，直接定位滚动条
        scrollPane.setBounds(16, 10, 650, 450);
        examArea.setFont(new Font("黑体", Font.BOLD, 34));
        examArea.setEnabled(false);//文本域的文字不能编辑

        //messagePanel区域
        messagePanel.setLayout(null);
        messagePanel.setBounds(680, 10, 300, 550);
        //设置边框
        messagePanel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        //图片
        pictureLabel.setBounds(10, 10, 280, 230);
        pictureLabel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        pictureLabel.setIcon(null);//展示图片信息
        //当前题号
        nowNumLabel.setBounds(40, 270, 100, 30);
        nowNumLabel.setFont(new Font("黑体", Font.PLAIN, 20));
        nowNumField.setBounds(150, 270, 100, 30);
        nowNumField.setFont(new Font("黑体", Font.BOLD, 20));
        nowNumField.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        nowNumField.setEnabled(false);
        //当前题号居中
        nowNumField.setHorizontalAlignment(JTextField.CENTER);
        //总题数
        totalCountLabel.setBounds(40, 310, 100, 30);
        totalCountLabel.setFont(new Font("黑体", Font.PLAIN, 20));
        totalCountField.setBounds(150, 310, 100, 30);
        totalCountField.setFont(new Font("黑体", Font.BOLD, 20));
        totalCountField.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        totalCountField.setEnabled(false);
        totalCountField.setHorizontalAlignment(JTextField.CENTER);
        //已答题数量
        answerCountLabel.setBounds(40, 350, 100, 30);
        answerCountLabel.setFont(new Font("黑体", Font.PLAIN, 20));
        answerCountField.setBounds(150, 350, 100, 30);
        answerCountField.setFont(new Font("黑体", Font.BOLD, 20));
        answerCountField.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        answerCountField.setEnabled(false);
        answerCountField.setHorizontalAlignment(JTextField.CENTER);
        //未答题数量
        unanswerCountLabel.setBounds(40, 390, 100, 30);
        unanswerCountLabel.setFont(new Font("黑体", Font.PLAIN, 20));
        unanswerCountField.setBounds(150, 390, 100, 30);
        unanswerCountField.setFont(new Font("黑体", Font.BOLD, 20));
        unanswerCountField.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        unanswerCountField.setEnabled(false);
        unanswerCountField.setHorizontalAlignment(JTextField.CENTER);
        //剩余时间
        timeLabel.setBounds(90, 460, 150, 30);
        timeLabel.setFont(new Font("黑体", Font.PLAIN, 20));
        timeLabel.setForeground(Color.BLUE);
        realTimeLabel.setBounds(108, 490, 150, 30);
        realTimeLabel.setFont(new Font("黑体", Font.BOLD, 20 ));
        //设置字体颜色
        realTimeLabel.setForeground(Color.BLUE);

        //button区域
        buttonPanel.setLayout(null);
        buttonPanel.setBounds(16, 470, 650, 90);
        buttonPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        aButton.setBounds(40, 10, 120, 30);
        bButton.setBounds(190, 10, 120, 30);
        cButton.setBounds(340, 10, 120, 30);
        dButton.setBounds(490, 10, 120, 30);
        previousButton.setBounds(40, 50, 100, 30);
        nextButton.setBounds(510, 50, 100, 30);
        submitButton.setBounds(276, 50, 100, 30);
        submitButton.setForeground(Color.RED);
        //添加小手特效
        aButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        bButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        cButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        dButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        previousButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        nextButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        submitButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        //重新设置右侧message组件值
        nowNumField.setText(nowNum + 1 + "");
        totalCountField.setText(totalCount + "");
        answerCountField.setText(answerCount + "");
        unanswerCountField.setText(unanswerCount + "");
        realTimeLabel.setText(time+"");

        //展示考试题目
        this.showQuestionAndPicture();
    }

    //将所有组件添加再面板上
    protected void addElement(){
        buttonPanel.add(aButton);
        buttonPanel.add(bButton);
        buttonPanel.add(cButton);
        buttonPanel.add(dButton);
        buttonPanel.add(previousButton);
        buttonPanel.add(nextButton);
        buttonPanel.add(submitButton);
        messagePanel.add(pictureLabel);
        messagePanel.add(nowNumLabel);
        messagePanel.add(nowNumField);
        messagePanel.add(answerCountLabel);
        messagePanel.add(answerCountField);
        messagePanel.add(totalCountLabel);
        messagePanel.add(totalCountField);
        messagePanel.add(unanswerCountLabel);
        messagePanel.add(unanswerCountField);
        messagePanel.add(timeLabel);
        messagePanel.add(realTimeLabel);
        mainPanel.add(scrollPane);
        mainPanel.add(messagePanel);
        mainPanel.add(buttonPanel);
        this.add(mainPanel);
    }

    //绑定事件监听器
    protected void addListener(){
        //创建一个监听器，用于下一题按钮
        nextButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //先清除所有选项按钮颜色
                ExamFrame.this.claerOptionButtonColor();
                //当前题目序号增加一个
                nowNum++;
                //判断当前题目是否到达最后
                if(nowNum == totalCount){//最后一题
                    examArea.setText("全部题目作答完毕\n请点击下方红色提交按钮");
                    //让下一个题目按钮失效
                    nextButton.setEnabled(false);
                    //让全部选项按钮失效
                    ExamFrame.this.setOptionButtonEnable(false);
                }else{//不是最后一题
                    //显示下一个题目和图片
                    ExamFrame.this.showQuestionAndPicture();
                    //修改右侧当前题号
                    nowNumField.setText(nowNum + 1 + "");
                }
                //修改已答题和未答题数目
                answerCountField.setText(++answerCount + "");
                unanswerCountField.setText(--unanswerCount + "");
            }
        });

        //创建监听器，用于上一题按钮
        previousButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //清除所有按钮颜色
                ExamFrame.this.claerOptionButtonColor();
                //还原四个选项按钮未可用状态
                ExamFrame.this.setOptionButtonEnable(true);
                //设置下一题按钮变成可用
                nextButton.setEnabled(true);
                //设置当前题号减少一个
                nowNum--;
                //判断是否到达第一题
                if(nowNum == 0){
                    //禁用上一题按钮
                    previousButton.setEnabled(false);
                }
                //还原之前题目是是什么选项
                ExamFrame.this.restoreButton();
                //显示题目
                ExamFrame.this.showQuestionAndPicture();
                //修改右侧数据
                nowNumField.setText(nowNum + 1 + "");
                answerCountField.setText(--answerCount + "");
                unanswerCountField.setText(++unanswerCount + "");

            }
        });


        //创建监听器，用于四个选项按钮
        ActionListener optionListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //清除之前所有选项按钮的颜色
                ExamFrame.this.claerOptionButtonColor();
                //获取到哪一个按钮点击
                JButton button = (JButton)e.getSource();
                //让被点中的按钮颜色变化
                button.setBackground(Color.YELLOW);
                //将当前按钮选项存储在answers数组中
                answers[nowNum] = button.getText();
//                answers[nowNum] = e.getActionCommand();
            }
        };
        //将监听器对象绑定在四个选项按钮上
        aButton.addActionListener(optionListener);
        bButton.addActionListener(optionListener);
        cButton.addActionListener(optionListener);
        dButton.addActionListener(optionListener);

        //创建监听器，用于提交按钮
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //显示确认框  是--0， 否--1， 取消--2
                int value = JOptionPane.showConfirmDialog(ExamFrame.this, "是否确认提交试卷？");
                if(value == 0){
                    //倒计时时间停止
//                timeControlThread.stop();//废弃方法
                    timeControlThread.stopTimeThread();
                    //所有按钮失效
                    ExamFrame.this.setOptionButtonEnable(false);
                    previousButton.setEnabled(false);
                    nextButton.setEnabled(false);
                    //按钮颜色回归本色
                    ExamFrame.this.claerOptionButtonColor();
                    //最终成绩的计算并展示
                    double score = ExamFrame.this.checkPaper();
                    examArea.setText("考试已结束\n您最终的成绩为：" + score);
                }

            }
        });

    }

    //设置窗体本身属性
    protected void setFrameSelf(){
        this.setBounds(260, 130, 1000, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
        //展示窗口的同时开启线程,执行时间处理
        timeControlThread.start();
    }

    private QuestionService service = MySpring.getBean("service.QuestionService");
    //随机生成一套试卷
    private ArrayList<Question> paper = service.getPaper(5);
    //创建一个用于存储学生选择答案的容器（长度固定）
    private String[] answers = new String[paper.size()];
    //记录当前题目序号
    private int nowNum = 0;
    //记录实体总数
    private int totalCount = paper.size();
    //记录已经答过的题数
    private int answerCount = 0;
    //记录没有答题的数量
    private int unanswerCount = totalCount;

    //处理图片展示
    private ImageIcon drawImage(String path){
        ImageIcon imageIcon = new ImageIcon(path);//通过路径创建Icon
        //设置imageIcon中image属性
        imageIcon.setImage(imageIcon.getImage().getScaledInstance(280, 230, Image.SCALE_DEFAULT));
        //将设置好的imageIcon返回
        return imageIcon;
    }
    
    //展示题目
    private void showQuestionAndPicture(){
        //从paper中获取一道题目
        Question question = paper.get(nowNum);
        //先获取当前question的图片路径
        String picturePath = question.getPicture();
        if(picturePath != null){
            //有图片
            pictureLabel.setIcon(this.drawImage("src//image//" + picturePath));
        }else{
            //没有图片
            pictureLabel.setIcon(null);
        }
        //处理题目中换行标记<br>表示换行
        examArea.setText((nowNum+1) + "."+ question.getTitle().replace("<br>", "\n  "));
    }

    //清除所有选项按钮颜色
    private void claerOptionButtonColor(){
        aButton.setBackground(null);
        bButton.setBackground(null);
        cButton.setBackground(null);
        dButton.setBackground(null);
    }

    //让所有选项按钮失效
    private void setOptionButtonEnable(boolean key){
        aButton.setEnabled(key);
        bButton.setEnabled(key);
        cButton.setEnabled(key);
        dButton.setEnabled(key);
    }

    //负责还原上一题的选项
    private void restoreButton(){
        //获取当前题目的答案（学生选择的）
        String answer = answers[nowNum];
        //如果该题没选
        if(answer == null){
            return ;
        }
        //选了
        switch(answer){
            case "A":
                aButton.setBackground(Color.YELLOW);
                break;
            case "B":
                bButton.setBackground(Color.YELLOW);
                break;
            case "C":
                cButton.setBackground(Color.YELLOW);
                break;
            case "D":
                dButton.setBackground(Color.YELLOW);
                break;
            default:
                this.claerOptionButtonColor();
                break;
        }
    }

    //创建一个变量，用来记录时间（以分钟为单位）
    private int time = 1;
    //创建一个线程对象，控制时间变化
    private TimeControlThread timeControlThread = new TimeControlThread();

//    //将小时，分钟，秒 拼接成字符串
    private StringBuilder connectString(int hour, int minute, int second){
        //先将 hour，minute，second拼接成字符串
        StringBuilder timeString = new StringBuilder();
        //处理小时
        if (hour >= 0 && hour < 10) {
            timeString.append("0");
        }
        timeString.append(hour);
        timeString.append(":");
        //处理分钟
        if (minute >= 0 && minute < 10) {
            timeString.append("0");
        }
        timeString.append(minute);
        timeString.append(":");
        //处理秒
        if (second >= 0 && second < 10) {
            timeString.append("0");
        }
        timeString.append(second);

        return timeString;
    }

    //内部类，处理时间倒计时
    private class TimeControlThread extends Thread {
        private boolean flag = true;//此时正常执行线程
        //给外部终止线程
        public void stopTimeThread(){
            this.flag = false;
        }

        public void run() {
            //初始的时间数据
            int hour = time / 60;
            int minute = time % 60;
            int second = 0;
            while (flag) {
                //每次循环开始先拼串，把time转化成 小时：分钟：秒
                StringBuilder timeString = ExamFrame.this.connectString(hour, minute, second);
                //展示拼接之后的字符串
                //加一个小线程处理选择选项时时间停顿问题
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        realTimeLabel.setText(timeString.toString());
                    }
                });
//                realTimeLabel.setText(timeString.toString());
                try {
                    Thread.sleep(400);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //时间改变
                if (second > 0) {
                    second--;
                } else {//秒数为0
                    if (minute > 0) {
                        minute--;
                        second = 59;
                    } else {//分钟为0
                        if (hour > 0) {
                            hour--;
                            minute = 59;
                            second = 59;
                        } else {
                            System.out.println("时间截止");
                            //时间显示红色
                            realTimeLabel.setForeground(Color.RED);
                            //所有按钮失效
                            ExamFrame.this.setOptionButtonEnable(false);
                            previousButton.setEnabled(false);
                            nextButton.setEnabled(false);
                            //弹出消息框，考试结束，提交试卷
                            JOptionPane.showMessageDialog(ExamFrame.this, "考试结束，请提交试卷！");
                            break;
                        }
                    }
                }
            }
        }
    }

    //负责计算最终的成绩
    private double checkPaper(){
        double score = 100;
        for(int i = 0; i < paper.size(); i++){//paper是集合ArrayList，每一道题目是Question对象
            Question question = paper.get(i);
            String realAnswer = question.getAnswer();
            if(!realAnswer.equals(answers[i])){
                score = score-(100/paper.size());//错一题减一题的分
            }
        }
        return score;
    }

}
