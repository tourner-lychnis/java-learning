package learning.mybatis;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import learning.mybatis.data.CityMapper;
import learning.mybatis.model.City;

public class SimpleSelectApp {

  public static void main (String[] args) {
    try {
      InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
      SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
      SqlSession session = sqlSessionFactory.openSession();

      CityMapper mapper = session.getMapper(CityMapper.class);
      City result = mapper.selectCity(1);
      System.out.println("City [ID=" + result.ID + ", Name=" + result.name + 
              ", CountryCode=" + result.countryCode + ", District=" + result.district + 
              ", Population=" + result.population + "]");

      session.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
