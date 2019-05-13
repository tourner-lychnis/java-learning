package learning.mybatis.data;

import learning.mybatis.model.City;

public interface CityMapper {

  public City selectCity(int ID);

  // 追加
  public int insertCity(City city);
}