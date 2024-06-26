package com.xworkz.DTO;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@ToString
@Entity
@Table(name = "team")
@NamedQuery(name = "updateCaptain",query = "update Team set captain=:captain where name=:teamName")
@NamedQuery(name = "deleteTeam",query = "delete from Team where name=:name")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String captain;
    @Column(name = "category_type")
    private String categoryType;
    private int noOfPlayers;
    private int noOfMatches;
}
