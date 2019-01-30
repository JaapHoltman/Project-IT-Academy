package com.example.demo3.services;

import com.example.demo3.model.Form;
import org.springframework.data.repository.CrudRepository;

public interface FormService extends CrudRepository<Form, Integer> {
    Iterable<Form> findByTown(String town);
}
