package com.example.demo.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import com.example.demo.dao.BabyDao;
import com.example.demo.entity.Baby;
import com.example.demo.entity.BabyGrowth;

@RestController
public class BabyController {

    @Autowired
    private BabyDao babyDao;

    @RequestMapping(value="api/babylist",method = RequestMethod.GET)
    public List<Baby> list(Model model) {    // d
        List<Baby> babys = babyDao.findAll();
        return babys;    // f
    }
    @RequestMapping(value="api/babyget",method=RequestMethod.POST)    // g
    public Baby postBabyGet(@RequestBody Baby baby) {
    	Baby retBaby = babyDao.findOne(baby.getBabyid());
    	//List<Baby> babys = babyDao.findByBabyid(baby.getBabyid());    	
    	return retBaby;
    }
    @RequestMapping(value="api/babynextbabyid",method=RequestMethod.POST)    // g
    public long getNextBabyid() {
    	long nextBabyid = babyDao.count();
    	return nextBabyid;
    }
    @RequestMapping(value="api/babyinsupd",method=RequestMethod.POST)    // g
    public Baby postBabyInsUpd(@RequestBody Baby baby) {
    	if(baby.getDefaultselect() == 1)
    	{
        	babyDao.updateDefaultselectOff(baby.getBabyid());
    	}
        return babyDao.save(baby);
    }
    @RequestMapping(value="api/babydel",method=RequestMethod.POST)    // g
    public Baby postBabyDel(@RequestBody Baby baby) {
    	babyDao.delete(baby);
    	return baby;
    }

    @RequestMapping(value="api/babybabyidfromdefaultselect",method=RequestMethod.POST)    // g
    public int getBabyidFromDefaultSelect() {
    	int babyid = babyDao.findBydefaultSelect();
    	return babyid;
    }

    
}
