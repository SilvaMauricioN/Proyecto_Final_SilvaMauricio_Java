package com.museo.api.museo_api.model;
import java.time.LocalDate;
import jakarta.persistence.*;

@Entity
@Table(name = "principalmaker")
public class PrincipalMaker {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long IdPrincipalMaker;
  private String name;
  private String placeOfBirth;
  private LocalDate dateOfBirth;
  private LocalDate dateOfDeath;
  private String placeOfDeath;
  private String nationality;

  public PrincipalMaker (){}; 

  public PrincipalMaker(long idPrincipalMaker, String name, String placeOfBirth, LocalDate dateOfBirth,
      LocalDate dateOfDeath, String placeOfDeath, String nationality) {
    IdPrincipalMaker = idPrincipalMaker;
    this.name = name;
    this.placeOfBirth = placeOfBirth;
    this.dateOfBirth = dateOfBirth;
    this.dateOfDeath = dateOfDeath;
    this.placeOfDeath = placeOfDeath;
    this.nationality = nationality;
  }

  public long getIdPrincipalMaker() {
    return IdPrincipalMaker;
  }

  public void setIdPrincipalMaker(long idPrincipalMaker) {
    IdPrincipalMaker = idPrincipalMaker;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPlaceOfBirth() {
    return placeOfBirth;
  }

  public void setPlaceOfBirth(String placeOfBirth) {
    this.placeOfBirth = placeOfBirth;
  }

  public LocalDate getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(LocalDate dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  public LocalDate getDateOfDeath() {
    return dateOfDeath;
  }

  public void setDateOfDeath(LocalDate dateOfDeath) {
    this.dateOfDeath = dateOfDeath;
  }

  public String getPlaceOfDeath() {
    return placeOfDeath;
  }

  public void setPlaceOfDeath(String placeOfDeath) {
    this.placeOfDeath = placeOfDeath;
  }

  public String getNationality() {
    return nationality;
  }

  public void setNationality(String nationality) {
    this.nationality = nationality;
  }
  
  
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
