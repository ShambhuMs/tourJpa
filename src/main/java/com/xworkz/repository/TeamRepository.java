package com.xworkz.repository;

import com.xworkz.DTO.Team;

import java.util.List;
import java.util.Objects;

public interface TeamRepository {
   public void saveAll(List<Team> list);
   void save(Team team);
   void update(long id,String captain);
   Team find(long id);
 void delete(long id);
 Team findByName(String name);
 List<Team> findByCategoryType(String type);
 Object fetchByname(String name);
 Object[] fetchMultipleColumnByName(String name);

 Object fetchMultipleRow(String name1,String name2);
    List<Object[]> fetchAllCaptainAndCategoryType();
}
