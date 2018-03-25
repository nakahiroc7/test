package com.example.demo.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import com.example.demo.dao.BabyGrowthDao;
import com.example.demo.entity.BabyGrowth;

@RestController
public class BabyGrowthController {

    @Autowired
    private BabyGrowthDao babyGrowthDao;

    @RequestMapping(value="api/babygrowthlist",method = RequestMethod.GET)
    public List<BabyGrowth> list(Model model) {    // d
    	
        List<BabyGrowth> babyGrowths = babyGrowthDao.findByBaby();
        model.addAttribute("babyGrowths", babyGrowths);    // e
        return babyGrowths;    // f
    }
    @RequestMapping(value="api/babygrowthinsupd",method=RequestMethod.POST)    // g
    public BabyGrowth postBabyGrowthInsUpd(@RequestBody BabyGrowth babyGrowth) {
        return babyGrowthDao.save(babyGrowth);
    }
    @RequestMapping(value="api/babygrowthdel",method=RequestMethod.POST)    // g
    public BabyGrowth postBabyGrowthDel(@RequestBody BabyGrowth babyGrowth) {
    	babyGrowthDao.delete(babyGrowth);
    	return babyGrowth;
    }

    @RequestMapping(value="api/babygrowthget",method=RequestMethod.POST)    // g
    public List<BabyGrowth> postBabyGrowthGet(@RequestBody BabyGrowth babyGrowth) {
    	List<BabyGrowth> babyGrowths = babyGrowthDao.findByRecDate(babyGrowth.getRecordingdate());
    	
    	return babyGrowths;
    }
    
}
