package com.museo.api.museo_api.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "webimages")
public class WebImage {  
    
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long idWebImage;

  @NotNull
  private Integer width;

  @NotNull
  private Integer height;

  @NotBlank
  @Pattern(regexp = "^(http|https)://.*", message = "La URL debe ser válida.")
  private String url;

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "idartobject", referencedColumnName = "id", unique = true)
  private ArtObject artObject;
  
  public Long getId() { return idWebImage; }
  public void setId(Long id) { this.idWebImage = id; }
  public Integer getWidth() { return width; }
  public void setWidth(Integer width) { this.width = width; }
  public Integer getHeight() { return height; }
  public void setHeight(Integer height) { this.height = height; }
  public String getUrl() { return url; }
  public void setUrl(String url) { this.url = url; }
  public ArtObject getArtObject() { return artObject; }
  public void setArtObject(ArtObject artObject) { this.artObject = artObject; }  
}
