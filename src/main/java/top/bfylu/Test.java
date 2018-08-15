package top.bfylu;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

/**
 * @author bfy--lujian
 * @version 1.0.0
 * 创建时间：2018/8/14 18:13
 * @email bfyjian@gmail.com
 */
public class Test {

    public static void main(String[] arge) {
        Mapper mapper = new DozerBeanMapper();
        User user = new User();
        user.setId(1);
        user.setAge("18");
        user.setName("bfylu");
        user.setPassword("lu123456");
        UserVo userVo = (UserVo) mapper.map(user,UserVo.class);

        System.out.println("password==>>" + userVo.getPassword());
    }
}
