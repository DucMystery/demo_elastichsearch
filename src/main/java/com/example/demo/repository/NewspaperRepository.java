package com.example.demo.repository;

import com.example.demo.models.Newspaper;
import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewspaperRepository extends ElasticsearchRepository<Newspaper,String> {

}
