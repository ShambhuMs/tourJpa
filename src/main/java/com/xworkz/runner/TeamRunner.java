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
        team.setNoOfMatches(8);

        Team team1=new Team();
        team1.setName("MI");
        team1.setCaptain("Hardik");
        team1.setNoOfPlayers(13);
        team1.setCategoryType("CRICKET");
        team1.setNoOfMatches(9);

        Team team2=new Team();
        team2.setName("CSK");
        team2.setCaptain("Ruturaj");
        team2.setNoOfPlayers(12);
        team2.setCategoryType("CRICKET");
        team2.setNoOfMatches(10);

        Team team3=new Team();
        team3.setName("Panjab");
        team3.setCaptain("Shikar dhavan");
        team3.setNoOfPlayers(11);
        team3.setCategoryType("CRICKET");
        team3.setNoOfMatches(11);

        Team team4=new Team();
        team4.setName("DC");
        team4.setCaptain("Rishab");
        team4.setNoOfPlayers(13);
        team4.setCategoryType("CRICKET");
        team4.setNoOfMatches(12);

        Team team5=new Team();
        team5.setName("KKR");
        team5.setCaptain("Shreyas");
        team5.setNoOfPlayers(11);
        team5.setCategoryType("CRICKET");
        team5.setNoOfMatches(13);

        Team team6=new Team();
        team6.setName("RR");
        team6.setCaptain("Sanju samsan");
        team6.setNoOfPlayers(13);
        team6.setCategoryType("CRICKET");
        team6.setNoOfMatches(14);

        Team team7=new Team();
        team7.setName("LSG");
        team7.setCaptain("K L Rahul");
        team7.setNoOfPlayers(11);
        team7.setCategoryType("CRICKET");
        team7.setNoOfMatches(15);

        Team team8=new Team();
        team8.setName("GT");
        team8.setCaptain("Subman gill");
        team8.setNoOfPlayers(11);
        team8.setCategoryType("CRICKET");
        team8.setNoOfMatches(16);

       List<Team> list=new ArrayList<>();
        list.add(team1);
        list.add(team2);
        list.add(team3);
        list.add(team4);
        list.add(team5);
        list.add(team6);
        list.add(team7);
        list.add(team8);

        Team team9=new Team();
        team9.setName("Bengal Tigers");
        team9.setCaptain("Rahul Kapoor");
        team9.setNoOfMatches(12);
        team9.setNoOfPlayers(14);
        team9.setCategoryType("FOOTBALL");


        Team team10=new Team();
        team10.setName("Mumbai Mavericks");
        team10.setCaptain(" Priya Patel");
        team10.setNoOfMatches(13);
        team10.setNoOfPlayers(14);
        team10.setCategoryType("FOOTBALL");


        Team team11=new Team();
        team11.setName("Kerala Blasters");
        team11.setCaptain("Arjun Singh");
        team11.setNoOfMatches(13);
        team11.setNoOfPlayers(14);
        team11.setCategoryType("FOOTBALL");


        List<Team> list1=new ArrayList<>();
        list1.add(team9);
        list1.add(team10);
        list1.add(team11);

        Team team12=new Team();
        team12.setName(" Delhi Spikers  ");
        team12.setCaptain("Ananya Sharma");
        team12.setNoOfMatches(4);
        team12.setNoOfPlayers(7);
        team12.setCategoryType("VOLLEYBALL");

        Team team13=new Team();
        team13.setName(" Chennai Smashers");
        team13.setCaptain("Vikram Singh");
        team13.setNoOfMatches(4);
        team13.setNoOfPlayers(7);
        team13.setCategoryType("VOLLEYBALL");

        List<Team> list2=new ArrayList<>();
        list2.add(team13);
        list2.add(team12);
       TeamRepository teamRepository=new TeamRepImplementaion();
    //   teamRepository.saveAll(list2);
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
     //   teamRepository.fetchAllCaptainAndCategoryType();
   // teamRepository.updateCaptainByTeamName("MI","Rohit sharma");
//  teamRepository.deleteTeamByName("GT");
 //teamRepository.countTotalNoOfMatches();
//teamRepository.matchesBetweenRange(10,20);
     //   teamRepository.minMatchPlayed();
       // teamRepository.countBasedOnCategoryType();
     //   teamRepository.fetchTeamDetailsByCreteria();
      //  teamRepository.fetchCaptainByCriteria();
        teamRepository.fetchTeamByNameCriteria("MI");
    }

}
