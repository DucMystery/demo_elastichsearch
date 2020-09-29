package com.example.demo.controller;

import com.example.demo.models.Newspaper;
import com.example.demo.service.NewspaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class NewspaperController {

    @Autowired
    private NewspaperService newspaperService;

    @RequestMapping(value = "/newspapers",method = RequestMethod.POST)
    public ResponseEntity<Newspaper> createNewspaper(@RequestBody Newspaper newspaper){
        Newspaper currentNewspaper = newspaperService.createNewspaper(newspaper);
        return new ResponseEntity<>(currentNewspaper, HttpStatus.OK);

    }

    @RequestMapping(value = "/newspapers",method = RequestMethod.GET)
    public ResponseEntity<List<Newspaper>> getAll(){
        List<Newspaper> newspaperList = newspaperService.findAll();
        return new ResponseEntity<>(newspaperList,HttpStatus.OK);
    }

    @RequestMapping(value = "/newspapers/search",method = RequestMethod.POST)
    public ResponseEntity<List<Newspaper>> searchNewspaperByKeyword(@RequestBody String keyword){
        List<Newspaper> newspaperList = newspaperService.search(keyword);
        return new ResponseEntity<>(newspaperList,HttpStatus.OK);
    }
}
