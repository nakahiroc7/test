package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.example.demo.entity.BabyGrowth;
import com.example.demo.entity.BabyGrowthPK;

 
public interface BabyGrowthDao extends JpaRepository <BabyGrowth, BabyGrowthPK> {
	@Query(value = "select s.babyid,s.recordingdate,s.height,s.weight from babygrowth s inner join baby b on b.babyid = s.babyid where s.recordingdate = :recordingdate ",
	        nativeQuery = true)
    public List<BabyGrowth> findByRecDate(@Param("recordingdate")String recordingdate);

	@Query(value = "select s.babyid,s.recordingdate,s.height,s.weight from babygrowth s inner join baby b on b.babyid = s.babyid where b.defaultselect  = 1 ",
	        nativeQuery = true)
    public List<BabyGrowth> findByBaby();

}
