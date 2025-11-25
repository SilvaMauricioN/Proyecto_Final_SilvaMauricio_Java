package com.museo.api.museo_api.model;
import jakarta.persistence.*;

@Entity
@Table(name = "principalmakers")
public class PrincipalMaker {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long idPrincipalMaker;
  private String name;
  @Column(name = "placeofbirth")
  private String placeOfBirth;
  @Column(name = "dateofbirth")
  private String dateOfBirth;
  @Column(name = "dateofdeath")
  private String dateOfDeath;
  @Column(name = "placeofdeath")
  private String placeOfDeath;
  private String nationality;

  public PrincipalMaker (){}; 

  public PrincipalMaker(long idPrincipalMaker, String name, String placeOfBirth, String dateOfBirth,
      String dateOfDeath, String placeOfDeath, String nationality) {
    this.idPrincipalMaker = idPrincipalMaker;
    this.name = name;
    this.placeOfBirth = placeOfBirth;
    this.dateOfBirth = dateOfBirth;
    this.dateOfDeath = dateOfDeath;
    this.placeOfDeath = placeOfDeath;
    this.nationality = nationality;
  }

  public long getIdPrincipalMaker() {
    return idPrincipalMaker;
  }

  public void setIdPrincipalMaker(long idPrincipalMaker) {
    this.idPrincipalMaker = idPrincipalMaker;
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

  public String getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(String dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  public String getDateOfDeath() {
    return dateOfDeath;
  }

  public void setDateOfDeath(String dateOfDeath) {
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
              "IdPrincipalMaker=" + idPrincipalMaker +
              ", name='" + name + '\'' +
              ", placeOfBirth='" + placeOfBirth + '\'' +
              ", dateOfBirth=" + dateOfBirth +
              ", dateOfDeath=" + dateOfDeath +
              ", placeOfDeath='" + placeOfDeath + '\'' +
              ", nationality='" + nationality + '\'' +              
              '}';
  }  
}
