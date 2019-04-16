package com.example.elasticsearch.controller;

import com.example.elasticsearch.model.User;
import com.example.elasticsearch.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @DeleteMapping("/delete")
    public String deleteAllDocuments() {
        userRepository.deleteAll();
        return "documents deleted successfully!";
    }

    @PostMapping("/save")
    public String saveAllDocuments() {
        userRepository.saveAll(Arrays.asList(new User("1", "pdf","Java Dev Zone"),
                new User("2", "msg", "subject:reinvetion"),
                new User("3", "pdf", "Spring boot sessions"),
                new User("4", "docx", "meeting agenda"),
                new User("5", "docx", "Spring boot + Elastic Search")));
        return "5 documents saved!!!";
    }

    @GetMapping("/getAll")
    public List<User> getAllDocs() {
        List<User> documents = new ArrayList<>();
        for (User doc : this.userRepository.findAll()) {
            documents.add(doc);
        }
        return documents;
    }

}
