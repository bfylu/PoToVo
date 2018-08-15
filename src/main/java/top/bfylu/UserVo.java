package top.bfylu;

/**
 * 一个userVo类
 * @author bfy--lujian
 * @version 1.0.0
 * 创建时间：2018/8/14 18:05
 * @email bfyjian@gmail.com
 */
public class UserVo {
    private int id;

    private String userName;

    private String password;

    private InfoVo info;

    public int getId() {

        return id;

    }

    public void setId(int id) {

        this.id = id;

    }

    public String getUserName() {

        return userName;

    }

    public void setUserName(String userName) {

        this.userName = userName;

    }

    public String getPassword() {

        return password;

    }

    public void setPassword(String password) {

        this.password = password;

    }

    public InfoVo getInfo() {

        return info;

    }

    public void setInfo(InfoVo info) {

        this.info = info;

    }
}
