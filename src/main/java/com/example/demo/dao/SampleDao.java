package com.example.demo.dao;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Sample;
 
public interface SampleDao extends JpaRepository <Sample, Integer> {
 
}
