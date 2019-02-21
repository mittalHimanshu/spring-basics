package com.frontend.reactjs.web;

import com.frontend.reactjs.domain.ProjectTask;
import com.frontend.reactjs.service.ProjectTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/board")
@CrossOrigin
public class ProjectTaskController {

    @Autowired
    private ProjectTaskService projectTaskService;

    @PostMapping("")
    public ResponseEntity<?> addPTToBoard(@Valid @RequestBody ProjectTask projectTask, BindingResult result){

        if(result.hasErrors()){
            Map<String, String> errorMap = new HashMap<>();
            for(FieldError err: result.getFieldErrors()){
                errorMap.put(err.getField(), err.getDefaultMessage());
            }
            return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
        }

        ProjectTask newPT = projectTaskService.saveOrUpdateProjectTask(projectTask);
        return new ResponseEntity<ProjectTask>(newPT, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public Iterable<ProjectTask> getAllPTs(){
        return projectTaskService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPTByid(@PathVariable Long id){
        ProjectTask projectTask = projectTaskService.findById(id);
        return new ResponseEntity<ProjectTask>(projectTask, HttpStatus.OK);
    }
}
