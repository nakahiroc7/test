package com.example.demo.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.IdClass;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name="babygrowth")
@IdClass(value=BabyGrowthPK.class)
public class BabyGrowth {
 
	@Id
    @Column(name="babyid")
    private int babyid;
 
	@Id
    @Column(name="recordingdate")
    private String recordingdate;
 
    @Column(name="height")
    private Double height;
 
    @Column(name="weight")
    private Double weight;

    public int getBabyid() {
        return babyid;
    }
 
    public void setBabyid(int babyid) {
        this.babyid = babyid;
    }

    public String getRecordingdate() {
        return recordingdate;
    }
 
    public void setRecordingdate(String recordingdate) {
        this.recordingdate = recordingdate;
    }
 
    public Double getHeight() {
        return height;
    }
 
    public void getHeight(Double height) {
        this.height = height;
    }
    public Double getWeight() {
        return weight;
    }
 
    public void getWeight(Double weight) {
        this.weight = weight;
    }
}

