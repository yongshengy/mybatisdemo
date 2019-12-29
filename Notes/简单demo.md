- 导入mybatis依赖和jdbc driver
- 创建表和实体类
- 创建配置文件：config.xml MyBatis的配置文件都是采用dtd约束的
- config.xml: configuration - environments(transaction, datasource type) - mappers 
- mappper.xml mapper - cache/crud  
- 如果使用原生接口方式调用mapper中的sql, SqlSessionFactory = builder.build(config file); openSession 执行对应的mapper 中sql的名字；
- 如果使用Mapper代理实现自定义类的方式：创建Mapper接口类，sqlSession.getMapper - 执行Mapper中的方法即可。

