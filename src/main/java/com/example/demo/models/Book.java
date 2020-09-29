package com.example.demo.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

@Data
@Document(indexName = "store-book",type = "book")
public class Book {
    @Id
    private Long id;

    @Field(name = "name")
    private String name;

    @Field(name = "author")
    private String author;
}
