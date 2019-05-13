package learning.mybatis;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import learning.mybatis.data.CityMapper;
import learning.mybatis.model.City;

public class AutoIncrementApp {

  public static void main (String[] args) {
    try {
      InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
      SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
      SqlSession session = sqlSessionFactory.openSession();

      CityMapper mapper = session.getMapper(CityMapper.class);
      
      // insert文のパラメーターとして渡すオブジェクトを生成
      City city = new City();
      city.name = "foo";
      city.countryCode = "JPN";
      city.district = "bar";
      city.population = 123456;

      mapper.insertCity(city);
      System.out.println("New City ID: " + city.ID);

      // 取得したPrimari Keyを使ってselect
      City result = mapper.selectCity(city.ID);
      System.out.println("City [ID=" + result.ID + ", Name=" + result.name + 
              ", CountryCode=" + result.countryCode + ", District=" + result.district + 
              ", Population=" + result.population + "]");

      session.commit();
      session.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}