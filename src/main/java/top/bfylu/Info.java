package top.bfylu;

import java.util.Date;

/**
 * 一个infoDo类
 * @author bfy--lujian
 * @version 1.0.0
 * 创建时间：2018/8/14 18:08
 * @email bfyjian@gmail.com
 */
public class Info {
    private int id;

    private Date createDate;

    private GenderType gender;

    public int getId() {

        return id;

    }

    public void setId(int id) {

        this.id = id;

    }

    public Date getCreateDate() {

        return createDate;

    }

    public void setCreateDate(Date createDate) {

        this.createDate = createDate;

    }

    public GenderType getGender() {

        return gender;

    }

    public void setGender(GenderType gender) {

        this.gender = gender;

    }
}
