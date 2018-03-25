package com.example.demo.entity;
import java.io.Serializable;


public class BabyGrowthPK implements Serializable{

	private int babyid;
	private String recordingdate;
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
}
