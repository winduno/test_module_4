package com.testpassmodul4.minh.model;

import javax.persistence.*;

@Entity
@Table(name = "nation")
public class Nation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int nationId;

    @Column(name = "nation")
    private String nationName;

    public Nation() {
    }

    public Nation(int nationId, String nationName) {
        this.nationId = nationId;
        this.nationName = nationName;
    }

    public int getNationId() {
        return nationId;
    }

    public void setNationId(int nationId) {
        this.nationId = nationId;
    }

    public String getNationName() {
        return nationName;
    }

    public void setNationName(String nationName) {
        this.nationName = nationName;
    }
}
