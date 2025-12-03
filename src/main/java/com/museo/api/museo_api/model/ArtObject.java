package com.museo.api.museo_api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;


@Entity
@Table(name = "artobjects")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArtObject {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "idartobject")
  private Integer idArtObject;

  @Column(name = "objectnumber", nullable = false, unique = true)
  private String objectNumber;

  @Column(name = "title", columnDefinition = "TEXT")
  private String title;

  @Column(name = "longtitle", columnDefinition = "TEXT")
  private String longTitle;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "idprincipalmaker", referencedColumnName = "idprincipalmaker")
  private PrincipalMaker principalMaker;

  @Column(name = "hasimage")
  private Boolean hasImage;

  @Column(name = "productionplaces", columnDefinition = "TEXT[]")
  private String[] productionPlaces;

  @Column(name = "description", columnDefinition = "TEXT")
  private String description;

  @Column(name = "plaquedescription", columnDefinition = "TEXT")
  private String plaqueDescription;

  @Column(name = "materials", columnDefinition = "TEXT[]")
  private String[] materials;

  @Column(name = "techniques", columnDefinition = "TEXT[]")
  private String[] techniques;

  @Column(name = "physicalmedium", columnDefinition = "TEXT")
  private String physicalMedium;

  @Column(name = "sclabelline", columnDefinition = "TEXT")
  private String scLabelLine;

  @Column(name = "historicaldescription", columnDefinition = "TEXT")
  private String historicalDescription;

  @OneToMany(mappedBy = "artObject", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private List<WebImage> webImages;
  
  // --- Getters y Setters y Constructores (Omitidos por brevedad) ---
  public Integer getId() { return idArtObject; }
  public void setId(Integer id) { this.idArtObject = id; }
  public String getTitle() { return title; }
  public void setTitle(String title) { this.title = title; }
  public String getLongTitle() { return longTitle; }
  public void setLongTitle(String longTitle) { this.longTitle = longTitle; }
  public boolean isHasImage() { return hasImage; }
  public void setHasImage(boolean hasImage) { this.hasImage = hasImage; }
  public String getDescription() { return description; }
  public void setDescription(String description) { this.description = description; }
  public String getHistoricalDescription() { return historicalDescription; }
  public void setHistoricalDescription(String historicalDescription) { this.historicalDescription = historicalDescription; }
  public String [] getMaterials() { return materials; }
  public void setMaterials(String [] materials) { this.materials = materials; }
  public String getPhysicalMedium() { return physicalMedium; }
  public void setPhysicalMedium(String physicalMedium) { this.physicalMedium = physicalMedium; }
  public PrincipalMaker getPrincipalMaker() { return principalMaker; }
  public void setPrincipalMaker(PrincipalMaker principalMaker) { this.principalMaker = principalMaker; }
}
