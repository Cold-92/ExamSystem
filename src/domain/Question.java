package domain;

//damain实体对象，存储文件题目，增强可读性
public class Question {
    private String title;
    private String answer;
    private String picture;//存储图片路径,没图就是null

    public Question() {}
    public Question(String title, String answer) {
        this.title = title;
        this.answer = answer;
    }
    public Question(String title, String answer, String picture) {
        this.title = title;
        this.answer = answer;
        this.picture = picture;
    }


    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getAnswer() {
        return answer;
    }
    public void setAnswer(String answer) {
        this.answer = answer;
    }
    public String getPicture() {
        return picture;
    }
    public void setPicture(String picture) {
        this.picture = picture;
    }

    //重写equals和hashcode方法
    //将Question对象存入HashSet集合内，让HashSet集合去除重复题目
    public boolean equals(Object obj){
        //判断是不是同一个
        if(this == obj){
            return true;
        }
        //判断是不是同一类不同个
        if(obj instanceof Question){
            //比较题目(选项前部分)
            Question anotherQuestion = (Question)obj;
            //0表示从头开始，到第一次出现<br>之前，<br>不截
            String thisTitle = this.title.substring(0, this.title.indexOf("<br>"));
            String anotherTitle = anotherQuestion.title.substring(0, anotherQuestion.title.indexOf("<br>"));
            if(this.title.equals(anotherTitle)){
                return true;
            }
        }
        return false;
    }

    public int hashCode(){
        String thisTitle = this.title.substring(0, this.title.indexOf("<br>"));
        return thisTitle.hashCode();
    }

}
