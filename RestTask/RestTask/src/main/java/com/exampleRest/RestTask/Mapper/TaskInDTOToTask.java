package com.exampleRest.RestTask.Mapper;
import com.exampleRest.RestTask.Dto.TaskInDTO;
import com.exampleRest.RestTask.Models.Task;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
public class TaskInDTOToTask implements IMapper<TaskInDTO , Task> {


    @Override
    public Task map(TaskInDTO in) {
        Task task= new Task();
        task.setTitulo(in.getTitulo());
        task.setDescripcion(in.getDescripcion());
        task.setFet(in.getFet());
        task.setCreatedDate(LocalDate.now());
        task.setFinished(false);
        task.setEstado(false);
        return task;
    }
}
