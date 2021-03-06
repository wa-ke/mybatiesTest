# mybatiesTest


## Demo01
- 根据id查询
```text
 //创建会话工厂，引入Config文件
        SqlSessionFactory sqlSessionFactory =new SqlSessionFactoryBuilder().
                build(Resources.getResourceAsStream("Config/sqlMapperConfig.xml"));

        //通过工厂得到SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //通过SqlSession操纵数据库
        User user = sqlSession.selectOne("test.findUserById",1);


#{}: 相当于占位符
${}: 字符串拼接

selectOne(): 查询一条记录
selectList(): 查询多条记录

SqlSession: 是线程不安全的，建议在方法体内执行
```

## Demo02
```text
传统dao方法开发
```

## Demo03
```text
mapper代理开发，namespace要求与接口文件的地址一样
接口中的方法名和xml文件中的statement的id一样，输入参数类型也要一致，返回值类型也要一致

mapper接受的参数只有一个，但可以通过多种POJO包装类型，来实现多类型

```

## sqlMapConfig属性
```text
properties: 引入外部配置文件，通常不在其内部配置属性，而通过外部properties文件配置属性

setting: 全局属性配置，可查api

typeAliases: 定义类型别名，针对parameterType和resultType

typeHandlers: 类型处理器，完成JDBC类型到java类型的转换

objectFactory: 对象工厂

plugins: 插件
```
- mapper配置
```html
<!--        单个文件引入-->
<!--        引入传统dao配置文件-->
        <mapper resource="Demo01/User.xml"></mapper>

<!--        引入映射文件-->
        <mapper resource="Demo03/UserMapper.xml"></mapper>

<!--        通过映射接口加载配置文件
    规范要求，mapper映射文件名和接口名一致，且在一个目录
-->
        <mapper class="Demo03.UserMapper"></mapper>
        
<!--        批量加载
自动扫描包里面的mapper接口，并添加
-->
        <package name="Demo03"/>

<!--    定义sql片段
    经验：是基于单表来定义sql片段，这样的话sql片段可重用性才高
    一般不包括where标签
-->
    <sql id="query_user">
        <if test="userCustomer != null">
            <if test="userCustomer.password != null and userCustomer.password != ''">
                and password like '%${userCustomer.password}%'
            </if>
            <if test="userCustomer.name != null and userCustomer.name != ''">
                and name like '%${userCustomer.name}%'
            </if>
        </if>

    </sql>

<!--    用户信息的综合查询-->
    <select id="findUserCount" parameterType="Demo04.UserQueryVo" resultType="int">
        select count(*) from user
<!-- 动态sql，自动拼接sql语句-->
    <where>
<!--     where会自动去掉第一个and，等于sql中的where，会自动拼接到sql语句中-->
    <if test="userCustomer != null">
            <if test="userCustomer.password != null and userCustomer.password != ''">
                and password like '%${userCustomer.password}%'
            </if>
            <if test="userCustomer.name != null and userCustomer.name != ''">
                and name like '%${userCustomer.name}%'
            </if>
        </if>
<!-- 引用sql片段-->
<include refid="query_user"></include>
    </where>

    </select>



```

## Demo05

```text
一对一：
resultType: 不可实现延迟加载
resultMap: 可实现延迟加载

一对一映射使用association，存储到POJO中
一对多或多对多使用collocation，可嵌套使用: 存储到list中
只需要一条集合记录可使用resultType
多条记录展示可使用resultMap
```