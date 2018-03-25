package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Baby;

@Transactional
public interface BabyDao extends JpaRepository <Baby,Integer> {
	@Query(value = "select babyid ,birthdate ,firstname ,lastname ,sex ,userid ,defaultselect  from baby s where s.babyid = :babyid ",
	        nativeQuery = true)
    public List<Baby> findByBabyid(@Param("babyid")Integer babyid);

	@Query(value = "select babyid from baby s where s.defaultselect = 1 ",
	        nativeQuery = true)
    public int findBydefaultSelect();

    @Modifying //Updateに必要
    @Query("update Baby h set  h.defaultselect = 0  where h.babyid <> :babyid ")
    public Integer updateDefaultselectOff( @Param("babyid") Integer babyid);
}
