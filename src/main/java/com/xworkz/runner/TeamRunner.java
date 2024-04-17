package com.xworkz.runner;

import com.xworkz.DTO.Team;
import com.xworkz.implementation.TeamRepImplementaion;
import com.xworkz.repository.TeamRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class TeamRunner {
    public static void main(String[] args) {
   //  EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("com.xworkz");

  //      System.out.println("Running...............");
   //    EntityManager entityManager=entityManagerFactory.createEntityManager();
        Team team=new Team();
        team.setName("RCB");
        team.setCaptain("Duplesis");
        team.setNoOfPlayers(11);
        team.setCategoryType("CRICKET");

        Team team1=new Team();
        team1.setName("MI");
        team1.setCaptain("Hardik");
        team1.setNoOfPlayers(13);
        team1.setCategoryType("CRICKET");

        Team team2=new Team();
        team2.setName("CSK");
        team2.setCaptain("Ruturaj");
        team2.setNoOfPlayers(12);
        team2.setCategoryType("CRICKET");

        Team team3=new Team();
        team3.setName("Panjab");
        team3.setCaptain("Shikar dhavan");
        team3.setNoOfPlayers(11);
        team3.setCategoryType("CRICKET");

        Team team4=new Team();
        team4.setName("DC");
        team4.setCaptain("Rishab");
        team4.setNoOfPlayers(13);
        team4.setCategoryType("CRICKET");

        Team team5=new Team();
        team5.setName("KKR");
        team5.setCaptain("Shreyas");
        team5.setNoOfPlayers(11);
        team5.setCategoryType("CRICKET");

        Team team6=new Team();
        team6.setName("RR");
        team6.setCaptain("Sanju samsan");
        team6.setNoOfPlayers(13);
        team6.setCategoryType("CRICKET");


        Team team7=new Team();
        team7.setName("LSG");
        team7.setCaptain("K L Rahul");
        team7.setNoOfPlayers(11);
        team7.setCategoryType("CRICKET");

        Team team8=new Team();
        team8.setName("GT");
        team8.setCaptain("Subman gill");
        team8.setNoOfPlayers(11);
        team8.setCategoryType("CRICKET");

       List<Team> list=new ArrayList<>();
        list.add(team1);
        list.add(team2);
        list.add(team3);
        list.add(team4);
        list.add(team5);
        list.add(team6);
        list.add(team7);
        list.add(team8);

       TeamRepository teamRepository=new TeamRepImplementaion();
//       teamRepository.saveAll(list);
      // teamRepository.save(team8);
      // teamRepository.update(2l,"Kohli");
//       Team teamup= teamRepository.find(3l);
//        System.out.println(teamup);
   // teamRepository.delete(1l);

//     Team teamFBN=   teamRepository.findByName("RCB");
//        System.out.println("Result is: "+teamFBN);
//        teamRepository.findByCategoryType("CRICKET");
     //   teamRepository.fetchByname("RCB");
     //   teamRepository.fetchMultipleColumnByName("MI");
      //  teamRepository.fetchMultipleRow("RCB","CSK");
        teamRepository.fetchAllCaptainAndCategoryType();

    }
}
