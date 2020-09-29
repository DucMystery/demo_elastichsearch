package com.example.demo.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

import java.util.List;

@Data
@Document(indexName = "store-newspaper",type ="newspaper")
public class Newspaper {

    @Id
    private String id;

    @Field(name = "title")
    private String title;

    private String author;
    private List<String> contents;
}
