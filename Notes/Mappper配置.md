- MyBatis的两类配置文件：
    - 全局配置文件：事务管理，打印sql语句，开启二级缓存，延迟加载等
    - Mapper配置文件：定义业务的sql语句，而且Mapper要在全局配置文件中注册；
    - 数据查询分为单表查询和多表关联查询，多表又包括一对一，一对多，多对多

- 单表查询
    - id parameterType resultType 
    - parameterType：
        - 基本数据类型 int 
        - 包装类 java.lang.Integer 
        - String java.lang.String
        - 多参数 省略parameterType，通过参数下标取出参数值 #{param1} #{param2}
        - POJO 当多个参数比较麻烦的时候，可以封装为对象 #{属性名}
    - resultType: 和parameterType基本一致

- 多表关联查询
    - 一对多
        - 定义resultMap，使用association标签配置classes级联
        - associate标签 - javaType属性映射实体类
        - collection标签 - ofType属性映射实体类
    - 多对多：实际是双向的一对多，双方都用collection标签设置级联
    
