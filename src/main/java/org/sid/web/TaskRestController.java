package org.sid.web;

import java.util.List;

import org.sid.dao.ITaskRepository;
import org.sid.entities.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskRestController {
	
	@Autowired
	public ITaskRepository taskRepo;
	
	@GetMapping(value = "/tasks")
	public List<Task> getTask(){
		return taskRepo.findAll();
	}
	
	@PostMapping(value = "/save-task")
	public Task saveTask(@RequestBody Task task){
		return taskRepo.save(task);
	}
}
