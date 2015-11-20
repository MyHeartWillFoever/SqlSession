package com.boge;

import java.io.IOException;
import java.io.Reader;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.boge.mapper.UserMapper;
import com.boge.pojo.User;

public class Insert {
	public static void main(String[] args) throws IOException, InterruptedException  {
		Reader reader = Resources.getResourceAsReader("mybatis.xml"); 
        SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(reader);  
        SqlSession session = sf.openSession(true); 
        UserMapper userMapper = session.getMapper(UserMapper.class);
        for (int i = 0; i < 10; i++) {
        	 System.out.println("*****"+i);
        	 User user = new User();
//        	 user.setId(100+i);//id是自增的
             user.setName("******嘿嘿"+i);
             user.setAddress("山东菏泽");
             user.setCode("274000");
             user.setNote("低调");
             user.setSex("汉子");
             userMapper.insert(user);
             Thread.sleep(200);
		}
	}
}
