package top.bfylu;

/**
 * userDo类
 * @author bfy--lujian
 * @version 1.0.0
 * 创建时间：2018/8/14 18:04
 * @email bfyjian@gmail.com
 */
public class User {

        private int id;

        private String name;

        private String password;

        private Info info;

        private String age;

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public int getId() {

            return id;

        }

        public void setId(int id) {

            this.id = id;

        }

        public String getName() {

            return name;

        }

        public void setName(String name) {

            this.name = name;

        }

        public String getPassword() {

            return password;

        }

        public void setPassword(String password) {

            this.password = password;

        }

        public Info getInfo() {

            return info;

        }

        public void setInfo(Info info) {

            this.info = info;

        }

}
