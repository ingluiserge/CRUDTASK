package com.exampleRest.RestTask.Services;


import com.exampleRest.RestTask.Dto.TaskInDTO;
import com.exampleRest.RestTask.Exceptions.ToDoException;
import com.exampleRest.RestTask.Mapper.TaskInDTOToTask;
import com.exampleRest.RestTask.Models.Task;
import com.exampleRest.RestTask.Repositorys.TaskRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Service
public class TaskService {


    private final TaskRepository repository;
    private final TaskInDTOToTask mapper;

    public TaskService(TaskRepository repository, TaskInDTOToTask mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public Task createTask(TaskInDTO taskInDTO){
        Task task = mapper.map(taskInDTO);
        return  this.repository.save(task);

    }

    public List<Task> allTask() {
        return this.repository.findAll();
    }
    public List<Task> findAllStatus(boolean estado){
        return this.repository.findAllByEstado(estado);

    }

  @Transactional
    public void updateTaskFinish(Long id){

      Optional<Task> optionalTask = this.repository.findById(id);
       if(optionalTask.isEmpty()){
           throw  new ToDoException("task no exist",HttpStatus.NOT_FOUND);
     }

        this.repository.markTaskFinished(id);

    }

    public void deleteByID(Long id){

        Optional<Task> optionalTask = this.repository.findById(id);
        if(optionalTask.isEmpty()){
            throw  new ToDoException("task no exist",HttpStatus.NOT_FOUND);
        }

        this.repository.deleteById(id);

    }



}

