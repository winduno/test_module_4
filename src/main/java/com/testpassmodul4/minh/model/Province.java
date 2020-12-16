package com.testpassmodul4.minh.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "province")
public class Province {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int provinceId;

    @Column(name = "provinceName")
    private String provinceName;

    @Column(name = "area")
    private int area;

    @Column(name = "population")
    private int population;

    @Column(name = "GDP")
    private float gdp;

    @Column(name = "description")
    private String description;

    @Column(name = "nation")
    private String nation;

    public Province() {
    }

    public int getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(int provinceId) {
        this.provinceId = provinceId;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public float getGdp() {
        return gdp;
    }

    public void setGdp(float gdp) {
        this.gdp = gdp;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public Province(int provinceId, String provinceName, int area, int population, float gdp, String description, String nation) {
        this.provinceId = provinceId;
        this.provinceName = provinceName;
        this.area = area;
        this.population = population;
        this.gdp = gdp;
        this.description = description;
        this.nation = nation;
    }
}
