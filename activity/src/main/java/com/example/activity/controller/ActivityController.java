package com.example.activity.controller;

import com.example.activity.repository.ActivityRepository;
import com.example.activity.model.Activity;
import java.util.*;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/poc")
public class ActivityController{
  @Autowired
    ActivityRepository repo;
    
	    @GetMapping("/activities")
	    public List<Activity> getAllActivities(){
		return repo.findAll();
		}
	
	@GetMapping("/activityid/{id}")
	public Activity getActivity1(@PathVariable("id") long id)
	{
	 return repo.findById(id).orElse(null);
	}
	@GetMapping("/activitytitle/{title}")
	public List<Activity> getActivity2(@PathVariable("title") String title)
	{
	return repo.findByTitleContaining(title);
	}
	@PostMapping("/addactivity")
	public Activity setactivity(@RequestBody Activity act)
	{
	return repo.save(act);
	}
	@PutMapping("/updateactivity/{id}")
	public Activity updateact(@PathVariable("id") long id,@RequestBody Activity act)
	{
	Activity newact=repo.findById(id).orElse(null);
			newact.setTitle(act.getTitle());
			newact.setDescription(act.getDescription());
			newact.setcompleted(act.iscompleted());
		
	return repo.save(newact);
	}
	@DeleteMapping("/delete/{id}")
	public String deleteactivity(@PathVariable("id") long id)
	{
	repo.deleteById(id);
	return "successfully deleted";
	}	
}
