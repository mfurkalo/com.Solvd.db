/*
 * Copyright (c)
 *   * Maksym Furkalo,
 *   * work with DB using the DAO pattern,
 *   * use for free
 */

package utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisFactory {
    private static Logger log = LogManager.getLogger(MyBatisFactory.class.getName());
    private static SqlSessionFactory ssf = null;

    static {
        String resource = "mybatis/mybatis-config.xml";
        try {
            InputStream inputStream = Resources.getResourceAsStream(resource);
            ssf = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            log.log(Level.FATAL, e.getMessage(), e);
            throw new RuntimeException(e);
        }
    }

    public static SqlSession getSession() {
        return ssf.openSession();
    }
}
