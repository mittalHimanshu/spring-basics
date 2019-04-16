package com.example.elasticsearch.repository;

import com.example.elasticsearch.model.User;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface UserRepository extends ElasticsearchRepository<User, String> {

    List<User> findByDocTitleEndsWith(String name);
    List<User> findByDocTitleStartsWith(String name);
    List<User> findByDocTypeEndsWith(String name);
    List<User> findByDocTypeStartsWith(String name);

}
