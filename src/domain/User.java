package domain;
//model层---存储数据层
//domain实体对象
//存储文件中一行记录
public class User {
    private String account;
    private String password;

    public User() {
    }
    public User(String account, String password) {
        this.account = account;
        this.password = password;
    }

    public String getAccount() {
        return account;
    }
    public void setAccount(String account) {
        this.account = account;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
