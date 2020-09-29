package com.example.demo.repository;

import com.example.demo.models.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BookRepository extends ElasticsearchRepository<Book,Long> {
}
