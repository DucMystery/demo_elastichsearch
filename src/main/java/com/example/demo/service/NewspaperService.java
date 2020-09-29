package com.example.demo.service;

import com.example.demo.models.Newspaper;

import java.util.List;

public interface NewspaperService {

    Newspaper createNewspaper(Newspaper newspaper);

    List<Newspaper> findAll();

    Newspaper findById(String id);

    void deleteById(String id);

    List<Newspaper> search(String keyword);

    Newspaper updateNewspaper(Newspaper newspaper);
}
