package com.example.demo3.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.PositiveOrZero;

@Entity
public class Form {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @NotEmpty
    String town;
    @NotEmpty
    String skiarea;
    @NotEmpty @Pattern(regexp = "^[0-9]*$")
    String sizeskiarea;
    @NotEmpty @Pattern(regexp = "^[0-9]*$")
    String snowheight;
    @NotEmpty
    String mapskiarea;
    @NotEmpty @Pattern(regexp = "^[0-9,/]*$")
    String liftsopened;
    @NotEmpty
    String foto;

    public Form() {
    }

    public Form(int id, String town, String skiarea, String sizeskiarea, String snowheight,String mapskiarea, String liftsopened, String foto) {
        this.id = id;
        this.town = town;
        this.skiarea = skiarea;
        this.sizeskiarea = sizeskiarea;
        this.snowheight = snowheight;
        this.mapskiarea = mapskiarea;
        this.liftsopened = liftsopened;
        this.foto = foto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getSkiarea() {
        return skiarea;
    }

    public void setSkiarea(String skiarea) {
        this.skiarea = skiarea;
    }

    public String getSizeskiarea() {
        return sizeskiarea;
    }

    public void setSizeskiarea(String sizeskiarea) {
        this.sizeskiarea = sizeskiarea;
    }

    public String getSnowheight() {
        return snowheight;
    }

    public void setSnowheight(String snowheight) {
        this.snowheight = snowheight;
    }

    public String getMapskiarea() {
        return mapskiarea;
    }

    public void setMapskiarea(String mapskiarea) {
        this.mapskiarea = mapskiarea;
    }

    public String getLiftsopened() {
        return liftsopened;
    }

    public void setLiftsopened(String liftsopened) {
        this.liftsopened = liftsopened;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    @Override
    public String toString() {
        return "Form{" +
                "id=" + id +
                ", town='" + town + '\'' +
                ", skiarea='" + skiarea + '\'' +
                ", sizeskiarea='" + sizeskiarea + '\'' +
                ", snowheight='" + snowheight + '\'' +
                ", mapskiarea='" + mapskiarea + '\'' +
                ", liftsopened='" + liftsopened + '\'' +
                ", foto='" + foto + '\'' +
                '}';
    }
}
