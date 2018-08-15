
#   对象转换工具(Dozer)

##  url : https://github.com/bfylu/PoToVo

*   Dozer可以在JavaBean到JavaBean之间进行递归数据复制,并且这些JavaBean可以是不同的复杂的类型。
    
    所有的mapping，Dozer将会很直接的将名称相同的fields进行复制，如果field名不同，或者有特别的对应要求，则可以在xml中进行定义。

    dozer官网 : http://dozer.sourceforge.net/documentation/about.html
    
*   Maven:    
```xml

<dependency>
    <groupId>net.sf.dozer</groupId>
    <artifactId>dozer</artifactId>
    <version>5.5.1</version>
</dependency>

```  

##  2 Dozer 支持的转换类型
    Dozer支持
    
    Primitive 基本数据类型 , 后面带 Wrapper 是包装类 Complex Type 是复杂类型 
    
    · Primitive to Primitive Wrapper 
    
    · Primitive to Custom Wrapper 
    
    · Primitive Wrapper to Primitive Wrapper 
    
    · Primitive to Primitive 
    
    · Complex Type to Complex Type 
    
    · String to Primitive 
    
    · String to Primitive Wrapper 
    
    · String to Complex Type if the Complex Type contains a String constructor 
    
    · String 到复杂类型 , 如果复杂类型包含一个 String 类型的构造器 
    
    · String to Map 
    
    · Collection to Collection 
    
    · Collection to Array 
    
    · Map to Complex Type 
    
    · Map to Custom Map Type 
    
    · Enum to Enum 
    
    · Each of these can be mapped to one another: java.util.Date, java.sql.Date, java.sql.Time, java.sql.Timestamp, java.util.Calendar, java.util.GregorianCalendar 
    
    · String to any of the supported Date/Calendar Objects. 
    
    · Objects containing a toString() method that produces a long representing time in (ms) to any supported Date/Calendar object.   
    

##  Dozer使用(不与spring集成下)

####3.1 dozer使用分类

*   根据有无映射文件和文件的多少，有三种方式 :

``` 

第一种：该方式用于数据类型为基本类型，名称相同的对象映射

Mapper mapper = new DozerBeanMapper();

SourceObject sourceObject = new SourceObject();

DestinationObject destObject = (DestinationObject) mapper.map(sourceObject, DestinationObject.class);

//  or

DestinationObject destObject = new DestinationObject();

mapper.map(sourceObject, destObject);

第二种：该方式用于数据类型不一致，或者名称不相同或者有级联关系等情况下的映射，该方式可以添加多个配置文件dozerBeanMapping.xml、someOtherDozerBeanMappings.xml 等

List myMappingFiles = new ArrayList();

myMappingFiles.add("dozerBeanMapping.xml");

//myMappingFiles.add("someOtherDozerBeanMappings.xml");

DozerBeanMapper mapper = new DozerBeanMapper();

SourceObject sourceObject = new SourceObject();

mapper.setMappingFiles(myMappingFiles);

DestinationObject stObject=

(DestinationObject) mapper.map(sourceObject, DestinationObject.class);

第三种：该方式用于数据类型不一致，或者名称不相同或者有级联关系等情况下的映射，配置文件只有一个映射文件叫dozerBeanMapping.xml且在根目录下

Mapper mapper = DozerBeanMapperSingletonWrapper.getInstance();

SourceObject sourceObject = new SourceObject();

DestinationObject destObject = (DestinationObject) mapper.map(sourceObject, DestinationObject.class);

//or

//Mapper mapper = DozerBeanMapperSingletonWrapper.getInstance();

//DestinationObject destObject = new DestinationObject();

mapper.map(sourceObject, destObject);

```

####3.2 举例说明：

*   userDo类:

```java

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

```

*   userVo类:

```java

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

```

*   一个性別枚举类

```java

package top.bfylu;

/**
 * 一个性別枚举类
 * @author bfy--lujian
 * @version 1.0.0
 * 创建时间：2018/8/14 18:05
 * @email bfyjian@gmail.com
 */
public enum  GenderType {
    male, //男
    famele //女
}

```

*   一个infoDo类:

```java

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

```

*   一个infoVo类

```java

package top.bfylu;

/**
 * 一个infoVo类
 * @author bfy--lujian
 * @version 1.0.0
 * 创建时间：2018/8/14 18:09
 * @email bfyjian@gmail.com
 */
public class InfoVo {
    private int id;

    private String date;

    private Integer gender;

    public int getId() {

        return id;

    }

    public void setId(int id) {

        this.id = id;

    }

    public String getDate() {

        return date;

    }

    public void setDate(String date) {

        this.date = date;

    }

    public Integer getGender() {

        return gender;

    }

    public void setGender(Integer gender) {

        this.gender = gender;

    }
}

```

*   Test测试类

```java

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

```

####3.2.1 字段名称不同映射配置:
```xml

<mapping>

<class-a>ce.dozer.User</class-a>

<class-b>ce.dozer.UserVO</class-b>

<field>

<a>name</a>

<b>userName</b>

</field>

</mapping>

```

*   3.2.2 User与UserVo的Date映射配置如下：

```xml


<mapping date-format="yyyy-MM-dd">

<class-a>ce.dozer.User</class-a>

<class-b>ce.dozer.UserVO</class-b>

<field>

<a>info.createDate</a>

<b>info.date</b>

</field>

</mapping>

```

*   3.2.3 在示例中我们看到在userDo和userVo对象中关联了其他的对象，这个问题不用担心，因为对象名称相同dozer会为我们自动转换。而问题
    不在这，在与对象中有枚举类型，我们该怎么写配置呢？在这里我们就必须自己编写一个处理类来处理枚举与Integer的转换了（假设我们的处理类
    为util.EnumIntConverter），配置如下：

```xml

<configuration>

<stop-on-errors>true</stop-on-errors>

<date-format>yyyy-MM-dd</date-format>

<wildcard>true</wildcard>

<custom-converters> 

<converter type=" util.EnumIntConverter">

<class-a>java.lang.Enum</class-a>

<class-b>java.lang.Integer</class-b>

</converter>

</custom-converters>

</configuration>

<mapping>

<class-a>ce.dozer.User</class-a>

<class-b>ce.dozer.UserVO</class-b>

<field>

<a>info.gender</a>

<b>info.gender</b>

</field>

</mapping>

```     

*   最终的dozerBeanMapping.xml 配置文件：

```xml

<?xml version="1.0" encoding="UTF-8"?>

<mappings xmlns="http://dozer.sourceforge.net" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"

          xsi:schemaLocation="http://dozer.sourceforge.net

          http://dozer.sourceforge.net/schema/beanmapping.xsd">


    <configuration>

        <stop-on-errors>true</stop-on-errors>

        <date-format>yyyy-MM-dd</date-format>

        <wildcard>true</wildcard>

        <custom-converters>

            <converter type=" util.EnumIntConverter">

                <class-a>java.lang.Enum</class-a>

                <class-b>java.lang.Integer</class-b>

            </converter>

        </custom-converters>

    </configuration>

    <mapping date-format="yyyy-MM-dd">

        <class-a>top.bfylu.User</class-a>

        <class-b>top.bfylu.UserVo</class-b>

        <field>

            <a>info.createDate</a>

            <b>info.date</b>

        </field>

        <field>

            <a>info.gender</a>

            <b>info.gender</b>

        </field>

        <field>

            <a>info.createDate</a>

            <b>info.date</b>

        </field>

        <field>

            <a>name</a>

            <b>userName</b>

        </field>

    </mapping>

</mappings>
```


##  4 与spring的集成

####4.1 1、dozer 要与spring集成需要将dozer交给spring管理，配置如下：

```xml
<bean id="mapper" class="org.dozer.spring.DozerBeanMapperFactoryBean">

<property name="mappingFiles">

<list>  <value>classpath*:dozer-config/dozerBeanMapping.xml</value>

</list>

</property>

</bean>
```

####4.2 2、当我们的dozer交给了spring管理，当spring容器启动后我们可以将下面的代码添加到用于继承的基类中去：

```

private Mapper mapper ;

public Mapper getMapper() {

return mapper;

}

public void setMapper(Mapper mapper) {

this.mapper = mapper;

}

```

####4.3 3、在继承者类中就可以直接如下使用

``` 
getMapper().map(sourceObject, DestinationObject.class)
```


