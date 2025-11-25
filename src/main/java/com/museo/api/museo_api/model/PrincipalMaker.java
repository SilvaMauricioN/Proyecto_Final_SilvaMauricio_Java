package com.museo.api.museo_api.model;
import java.time.LocalDate;
import jakarta.persistence.*;

@Entity
@Table(name = "principalMaker")
public class PrincipalMaker {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long IdPrincipalMaker;
  private String name;
  private String placeOfBirth;
  private LocalDate dateOfBirth;
  private LocalDate dateOfDeath;
  private String placeOfDeath;
  private String nationality;

  public PrincipalMaker (){};
  @Override

  public String toString() {
      return "PrincipalMaker{" +
              "IdPrincipalMaker=" + IdPrincipalMaker +
              ", name='" + name + '\'' +
              ", placeOfBirth='" + placeOfBirth + '\'' +
              ", dateOfBirth=" + dateOfBirth +
              ", dateOfDeath=" + dateOfDeath +
              ", placeOfDeath='" + placeOfDeath + '\'' +
              ", nationality='" + nationality + '\'' +              
              '}';
  }  
}
