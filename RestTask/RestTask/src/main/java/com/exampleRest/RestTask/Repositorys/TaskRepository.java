package com.exampleRest.RestTask.Repositorys;


import com.exampleRest.RestTask.Models.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface TaskRepository  extends JpaRepository<Task, Long> {


   public List<Task> findAllByEstado(boolean estado);


  @Modifying
  @Query(value="update task set finished=true where id=:id",nativeQuery = true)
  public void markTaskFinished(@Param("id")Long id);

}
