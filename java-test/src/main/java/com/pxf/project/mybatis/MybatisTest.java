package com.pxf.project.mybatis;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pxf.project.mybatis.entity.UserRoleInfo;
import com.pxf.project.mybatis.mapper.UserRoleInfoMapper;
import org.apache.ibatis.executor.SimpleExecutor;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.session.*;
import org.apache.ibatis.transaction.Transaction;
import org.apache.ibatis.transaction.jdbc.JdbcTransaction;
import org.apache.logging.log4j.core.jackson.Log4jJsonObjectMapper;
import org.apache.logging.log4j.core.util.JsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class MybatisTest {

    public static Logger logger = LoggerFactory.getLogger(MybatisTest.class);

//    private static SqlSessionFactory sqlSessionFactory;
//    private static Configuration configuration;
//    private static Connection connection;
//    private static JdbcTransaction jdbcTransaction;

    private static String url ="jdbc:mysql://127.0.0.1:3306/panxf_user?useUnicode=true&amp;characterEncoding=utf-8&amp;autoReconnect=true&amp;failOverReadOnly=false";
    private static String userName ="root";
    private static String password ="123456";

//    static {
//        try {
//            String resource = "mybatis/mybatis-config.xml";
//            InputStream inputStream = Resources.getResourceAsStream(resource);
//            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//            configuration = sqlSessionFactory.getConfiguration();
////            connection = DriverManager.getConnection(url,userName,password);
//            Connection connection = configuration.getEnvironment().getDataSource().getConnection();
//            jdbcTransaction = new JdbcTransaction(connection);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    public static void main(String[] args) throws Exception {


        String resource = "mybatis/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Configuration configuration = sqlSessionFactory.getConfiguration();

        //.
//        Connection connection = sqlSession.getConnection();
        Connection connection = DriverManager.getConnection(url,userName,password);
        JdbcTransaction jdbcTransaction = new JdbcTransaction(connection);
        SimpleExecutor executor = new SimpleExecutor(configuration,jdbcTransaction);
        MappedStatement mappedStatement = configuration.getMappedStatement("com.pxf.project.mybatis.mapper.UserRoleInfoMapper.selectById");
        List<Object> list = executor.doQuery(mappedStatement, 1, RowBounds.DEFAULT, SimpleExecutor.NO_RESULT_HANDLER, mappedStatement.getBoundSql(1));
        logger.info("list===>>{}", JSONArray.toJSON(list));


        //.
        UserRoleInfo userRoleInfo = sqlSession.selectOne("com.pxf.project.mybatis.mapper.UserRoleInfoMapper.selectById", 1);
        logger.info("userRoleInfo==>>{}",userRoleInfo);

        //.
        UserRoleInfoMapper mapper = sqlSession.getMapper(UserRoleInfoMapper.class);
        UserRoleInfo userRoleInfo1 = mapper.selectById(1);
        logger.info("userRoleInfo1==>>{}",userRoleInfo1);



    }
}
