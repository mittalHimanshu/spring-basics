package com.example.elasticsearch.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@Document(indexName = "employee", type = "employee")
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    private String id;
    private String docType;
    private String docTitle;

}
