package com.example.demo3.controllers;


import com.example.demo3.model.Form;
import com.example.demo3.model.Search;
import com.example.demo3.services.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class SearchController {

    @Autowired
    FormService formService;

    @PostMapping("/search")
    Iterable<Form> recieveForm(@RequestBody Search search) {
        System.out.println(search);
        return formService.findByTown(search.getSearch());
    }


}
