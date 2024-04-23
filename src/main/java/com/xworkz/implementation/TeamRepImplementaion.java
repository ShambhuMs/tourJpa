package com.xworkz.implementation;

import com.xworkz.DTO.Team;
import com.xworkz.repository.TeamRepository;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class TeamRepImplementaion implements TeamRepository {
    @Override
    public List<Team> findByCategoryType(String type) {
        EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("com.xworkz");
        EntityManager entityManager= entityManagerFactory.createEntityManager();
        try {
          Query query=  entityManager.createQuery("select t from Team t where categoryType= :type");
          query.setParameter("type",type);
         List<Team> list= query.getResultList();
            int count=0;
           list.forEach(result->{
               System.out.println("Details of list elements......");
               System.out.println(result.getId());
               System.out.println(result.getName());
               System.out.println(result.getCaptain());
               System.out.println(result.getNoOfPlayers());
               System.out.println(result.getCategoryType());
           });
           System.out.println("No of records : "+list.stream().count());
           int res=0;
        Iterator<Team> iterator= list.iterator();
           while (iterator.hasNext()){
              int i= iterator.next().getNoOfPlayers();
              res=res+i;
           }
            System.out.println("No of players in a table: "+res);
           return list;
        }catch (Exception e){
            System.out.println("Got some exception......"+e);
        }
        finally {
            entityManager.close();
            entityManagerFactory.close();
        }
    return null;
    }

    @Override
    public List<Object[]> fetchAllCaptainAndCategoryType() {
        EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("com.xworkz");
        EntityManager entityManager= entityManagerFactory.createEntityManager();
        try {
            Query query= entityManager.createQuery("select t.captain,t.categoryType from Team t");
            List<Object[]> list=query.getResultList();
            for (Object[] s: list ) {
                for (int i = 0; i <s.length ; i++) {
                    System.out.println(s[i]);
                }
            }
        }catch (Exception e){
            System.out.println("Got some exception..."+e);
        }finally {
            entityManager.close();
            entityManagerFactory.close();
        }
        return null;
    }

    @Override
    public Team fetchTeamByNameCriteria(String name) {
        EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("com.xworkz");
        EntityManager entityManager= entityManagerFactory.createEntityManager();
        try{
        CriteriaBuilder  criteriaBuilder=  entityManager.getCriteriaBuilder();
       CriteriaQuery<Team> criteriaQuery= criteriaBuilder.createQuery(Team.class);
        Root<Team> root= criteriaQuery.from(Team.class);
         CriteriaQuery query=  criteriaQuery.select(root);
         Predicate predicate=criteriaBuilder.equal(root.get("name"),name);
          CriteriaQuery query1=  query.where(predicate);
     Query query2=  entityManager.createQuery(query1);
    Object object= query2.getSingleResult();
            System.out.println(object);

        }catch (Exception e){
            System.out.println("Got some exception..."+e);
        }finally {
            entityManager.close();
            entityManagerFactory.close();
        }
        return null;
    }

    @Override
    public List<String> fetchCaptainByCriteria() {
       EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("com.xworkz");
       EntityManager entityManager= entityManagerFactory.createEntityManager();
        try {
           CriteriaBuilder criteriaBuilder= entityManager.getCriteriaBuilder();
           CriteriaQuery criteriaQuery= criteriaBuilder.createQuery(Team.class);
           Root root= criteriaQuery.from(Team.class);
         CriteriaQuery query1=  criteriaQuery.select(root.get("captain"));
        Query query= entityManager.createQuery(query1);
       List<String> list= query.getResultList();
            System.out.println("Captain details................");
       list.forEach(c->{
           System.out.println("Captain name: "+c);
       });
       return list;
        }catch (Exception e){
            System.out.println("Got some exception..."+e);
        }finally {
            entityManager.close();
            entityManagerFactory.close();
        }



        return null;
    }

    @Override
    public List<Team> fetchTeamDetailsByCreteria() {
     EntityManagerFactory entityManagerFactory=   Persistence.createEntityManagerFactory("com.xworkz");
    EntityManager entityManager= entityManagerFactory.createEntityManager();
    try {
     CriteriaBuilder criteriaBuilder= entityManager.getCriteriaBuilder();
  CriteriaQuery criteriaQuery=   criteriaBuilder.createQuery(Team.class);
  Root<Team> root=  criteriaQuery.from(Team.class);
 CriteriaQuery query=   criteriaQuery.select(root);
 Query query1= entityManager.createQuery(query);
 List<Team> teams= query1.getResultList();
 teams.forEach(x->{
     System.out.println("ID: "+x.getId());
     System.out.println("Name: "+x.getName());
     System.out.println("Captain: "+x.getCaptain());
     System.out.println("CategoryType: "+x.getCategoryType());
     System.out.println("=============================");
 });
    return teams;
    }catch (Exception e){
        System.out.println("Got some exception..."+e);
    }finally {
        entityManager.close();
        entityManagerFactory.close();
    }
        return null;
    }

    @Override
    public List<Object[]> countBasedOnCategoryType() {
        EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("com.xworkz");
        EntityManager entityManager= entityManagerFactory.createEntityManager();
        try
        {
         Query query=  entityManager.createQuery("select categoryType,count(categoryType) from Team group by categoryType");
         List<Object[]> values=query.getResultList();
            System.out.println("Count result based on categoryType....");
            for (Object[] result: values ) {
                for (int i = 0; i < result.length; i++) {
                    System.out.println(result[i]);
                }
            }

        }catch (Exception e){
            System.out.println("Got some exception..."+e);
        }finally {
            entityManager.close();
            entityManagerFactory.close();
        }
        return null;
    }

    @Override
    public Object[] minMatchPlayed() {
        EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("com.xworkz");
        EntityManager entityManager= entityManagerFactory.createEntityManager();
        try {
            Query query= entityManager.createQuery("select name,min(noOfMatches) from Team");
          Object[] value= (Object[]) query.getSingleResult();
            System.out.println("Min match played TeamName and min match:");
            for (int i = 0; i < value.length; i++) {
                System.out.println(value[i]);
            }


        }catch (Exception e){
            System.out.println("Got some exception..."+e);
        }finally {
            entityManager.close();
            entityManagerFactory.close();
        }
        return null;
    }

    @Override
    public List<Team> matchesBetweenRange(int startRange, int endRange) {
        EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("com.xworkz");
        EntityManager entityManager= entityManagerFactory.createEntityManager();
        try{
            Query query=  entityManager.createQuery("select t from Team t where t.noOfMatches between :startRange and :endRange");
            query.setParameter("startRange",startRange);
            query.setParameter("endRange",endRange);
            List<Team> teams=query.getResultList();
             teams.forEach(x->{
                 System.out.println(x.getId());
                 System.out.println(x.getName());
                 System.out.println(x.getCaptain());
                 System.out.println(x.getNoOfPlayers());
                 System.out.println(x.getCategoryType());
                 System.out.println(x.getNoOfMatches());
                 System.out.println("====================");
             });
        }catch (Exception e){
            System.out.println("Got some exception..."+e);
        }finally {
            entityManager.close();
            entityManagerFactory.close();
        }
        return null;
    }

    @Override
    public int countTotalNoOfMatches() {
        EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("com.xworkz");
       EntityManager entityManager= entityManagerFactory.createEntityManager();
       try{
         Query query=  entityManager.createQuery("select sum(noOfMatches) from Team");
         long value= (long) query.getSingleResult();
           System.out.println("total no of matches : "+value);
       }catch (Exception e){
           System.out.println("Got some exception..."+e);
       }finally {
           entityManager.close();
           entityManagerFactory.close();
       }
        return 0;
    }

    @Override
    public int deleteTeamByName(String name) {
        EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("com.xworkz");
        EntityManager entityManager= entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction=entityManager.getTransaction();
        try {
            entityTransaction.begin();
            Query query = entityManager.createNamedQuery("deleteTeam");
            query.setParameter("name",name);
            int value=  query.executeUpdate();
            entityTransaction.commit();
            System.out.println(value);
        }catch (Exception e){
            System.out.println("Got some exception..."+e);
            entityTransaction.rollback();
        }finally {
            entityManager.close();
            entityManagerFactory.close();
        }
        return 0;
    }

    @Override
    public int updateCaptainByTeamName(String teamName, String captain) {
        EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("com.xworkz");
        EntityManager entityManager= entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction=entityManager.getTransaction();
        try {
            entityTransaction.begin();
            Query query = entityManager.createNamedQuery("updateCaptain");
            query.setParameter("captain",captain);
            query.setParameter("teamName",teamName);
            int value=  query.executeUpdate();
            entityTransaction.commit();
            System.out.println(value);
        }catch (Exception e){
            System.out.println("Got some exception..."+e);
            entityTransaction.rollback();
        }finally {
            entityManager.close();
            entityManagerFactory.close();
        }
        return 0;
    }

    @Override
    public Object fetchMultipleRow(String name1, String name2) {
        EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("com.xworkz");
        EntityManager entityManager= entityManagerFactory.createEntityManager();
        try {
            Query query= entityManager.createQuery("select t from Team t where name in(:name1,:name2)");
            query.setParameter("name1",name1);
            query.setParameter("name2",name2);

        List<Team> list=   query.getResultList();
            System.out.println("Got the result data of 2 rows...!!!!"+name1+" And "+name2);
        list.forEach(x-> {
            System.out.println(x.getId());
            System.out.println(x.getName());
            System.out.println(x.getCaptain());
            System.out.println(x.getNoOfPlayers());
            System.out.println(x.getCategoryType());
            System.out.println("============================");

        } );

        }catch (Exception e){
            System.out.println("Got some exception..."+e);
        }finally {
            entityManager.close();
            entityManagerFactory.close();
        }
        return null;
    }

    @Override
    public Object[] fetchMultipleColumnByName(String name) {
        EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("com.xworkz");
        EntityManager entityManager= entityManagerFactory.createEntityManager();
        try {
            Query query= entityManager.createQuery("select captain,noOfPlayers from Team  where name= :name");
            query.setParameter("name",name);
            Object[] object= (Object[]) query.getSingleResult();
            System.out.println("Multiple column result: ");
            for (int i = 0; i < object.length; i++) {
                System.out.println(object[i]);
            }
            return object;
        }catch (Exception e){
            System.out.println("Got some exception..."+e);
        }finally {
            entityManager.close();
            entityManagerFactory.close();
        }
        return new Object[0];
    }

    @Override
    public Object fetchByname(String name) {
        EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("com.xworkz");
        EntityManager entityManager= entityManagerFactory.createEntityManager();
        try {
            Query query= entityManager.createQuery("select captain from Team  where name= :name");
            query.setParameter("name",name);
          Object object=  query.getSingleResult();
            System.out.println("Result is: "+object);
            return object;
        }catch (Exception e){
            System.out.println("Got some exception..."+e);
        }finally {
            entityManager.close();
            entityManagerFactory.close();
        }
        return null;
    }

    @Override
    public Team findByName(String name) {
        EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("com.xworkz");
        EntityManager entityManager= entityManagerFactory.createEntityManager();
        try {
            Query query= entityManager.createQuery("select s from Team s where name= :name");
            query.setParameter("name",name);
            Team team=(Team)   query.getSingleResult();
            return team;
        }catch (Exception e){
            System.out.println("Got some exception..."+e);
        }finally {
            entityManager.close();
            entityManagerFactory.close();
        }

        return null;
    }

    @Override
    public void save(Team team) {
        EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("com.xworkz");
        EntityManager entityManager= entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction= entityManager.getTransaction();
        try {
            entityTransaction.begin();
            entityManager.persist(team);
            entityTransaction.commit();
            System.out.println("stored...");
        }catch (Exception e){
            System.out.println("Got some exception...");
            entityTransaction.rollback();
        }finally {
            entityManager.close();
            entityManagerFactory.close();
        }
    }

    @Override
    public void update(long id, String captain) {
        EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("com.xworkz");
        EntityManager entityManager= entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction= entityManager.getTransaction();
        try {
            entityTransaction.begin();
            Team team=   entityManager.find(Team.class,id);
            team.setCaptain(captain);
            entityTransaction.commit();
            System.out.println("updated...");
        }catch (Exception e){
            System.out.println("Got some exception...");
            entityTransaction.rollback();
        }finally {
            entityManager.close();
            entityManagerFactory.close();
        }
    }

    @Override
    public Team find(long id) {
        EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("com.xworkz");
        EntityManager entityManager= entityManagerFactory.createEntityManager();
        System.out.println("Got the required data...");
            Team team= entityManager.find(Team.class,id);
            return team;
    }

    @Override
    public void delete(long id) {
        EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("com.xworkz");
        EntityManager entityManager= entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction= entityManager.getTransaction();
        try {
            entityTransaction.begin();
            Team team=entityManager.find(Team.class,id);
            entityManager.remove(team);
            entityTransaction.commit();
            System.out.println("Deleted....");
        }catch (Exception e){
            System.out.println("Got some exception...");
            entityTransaction.rollback();
        }
        finally {
            entityManager.close();
            entityManagerFactory.close();
        }
    }

    @Override
    public void saveAll(List<Team> teams) {
      EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("com.xworkz");
     EntityManager entityManager= entityManagerFactory.createEntityManager();
    EntityTransaction entityTransaction= entityManager.getTransaction();
      try {
          entityTransaction.begin();
          for (Team t:teams  ) {
             entityManager.persist(t);
          }
          entityTransaction.commit();
          System.out.println("List elements are stored...");
      }catch (Exception e){
          System.out.println("Got some exception...");
          entityTransaction.rollback();
      }finally {
          entityManager.close();
          entityManagerFactory.close();
      }

    }
}
