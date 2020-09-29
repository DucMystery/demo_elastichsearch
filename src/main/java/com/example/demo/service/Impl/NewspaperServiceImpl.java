package com.example.demo.service.Impl;

import com.example.demo.exception.NewspaperAlreadyExistException;
import com.example.demo.exception.NewspaperNotFoundException;
import com.example.demo.models.Newspaper;
import com.example.demo.repository.NewspaperRepository;
import com.example.demo.service.NewspaperService;
import org.elasticsearch.index.query.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.elasticsearch.index.query.QueryBuilders.boolQuery;

@Service
public class NewspaperServiceImpl implements NewspaperService {

    @Autowired
    private NewspaperRepository newspaperRepository;

    @Override
    public Newspaper createNewspaper(Newspaper newspaper) {
        Optional<Newspaper> current = newspaperRepository.findById(newspaper.getId());
        if (current.isPresent()){
            throw new NewspaperAlreadyExistException("Newspaper already exist");
        }

        Newspaper newspaper1 = newspaperRepository.save(newspaper);
        return newspaper1;
    }

    @Override
    public List<Newspaper> findAll() {
        Iterable<Newspaper> newspapers = newspaperRepository.findAll();
        List<Newspaper> newspaperList = StreamSupport.stream(newspapers.spliterator(),false).collect(Collectors.toList());
        return newspaperList;
    }

    @Override
    public Newspaper findById(String id) {
        Optional<Newspaper> newspaper = newspaperRepository.findById(id);
        if (!newspaper.isPresent()){
            throw new NewspaperNotFoundException("Newspaper not found");
        }

        return newspaper.get();
    }

    @Override
    public void deleteById(String id) {
        Optional<Newspaper> newspaper = newspaperRepository.findById(id);
        if (!newspaper.isPresent()){
            throw new NewspaperNotFoundException("Newspaper not found");
        }
        newspaperRepository.deleteById(id);
    }

    @Override
    public List<Newspaper> search(String keyword) {

        MatchQueryBuilder queryBuilder = QueryBuilders.matchQuery("contents",keyword);

        Iterable<Newspaper> newspaperIterable =  newspaperRepository.search(queryBuilder);
        List<Newspaper> newspaperList = StreamSupport.stream(newspaperIterable.spliterator(),false).collect(Collectors.toList());
        return newspaperList;
    }

    @Override
    public Newspaper updateNewspaper(Newspaper newspaper) {
        return null;
    }
}
