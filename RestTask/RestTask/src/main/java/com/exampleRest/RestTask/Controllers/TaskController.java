package com.exampleRest.RestTask.Controllers;

import com.exampleRest.RestTask.Dto.TaskInDTO;
import com.exampleRest.RestTask.Models.Task;
import com.exampleRest.RestTask.Services.TaskService;
import org.aspectj.bridge.IMessageContext;
import org.aspectj.bridge.Message;
import org.springframework.http.HttpCookie;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;

@RestController
@RequestMapping("/tasks")

public class TaskController {

    private  final TaskService taskService;


    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public Task createTask(@RequestBody TaskInDTO taskInDTO) {
       return this.taskService.createTask(taskInDTO);
    }

    @GetMapping
    public List<Task> allTasks(){
        return this.taskService.allTask();
    }

    @GetMapping("/status/{estado}")
    public List<Task> finAllStatus (@PathVariable("estado")boolean estado){
        return this.taskService.findAllStatus(estado);
    }

    @PatchMapping("/mark_finished/{id}")
    public ResponseEntity<Void> markFinisheds(@PathVariable("id")Long id){
      this.taskService.updateTaskFinish(id);
      return ResponseEntity.noContent().build();

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteID(@PathVariable("id")Long id){
        this.taskService.deleteByID(id);
        return ResponseEntity.noContent().build();

    }


}
