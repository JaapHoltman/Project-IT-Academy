package com.example.demo3.controllers;


import com.example.demo3.model.Form;
import com.example.demo3.services.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class FormController {

    @Autowired
    FormService formService;

//    zonder fout afhandeling
//    @PostMapping("/form")
//    void recieveForm(@RequestBody Form form){
//        System.out.println(form);
//        formService.save(form);
//    }

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    Form save(@Valid @RequestBody Form form)
        throws MethodArgumentNotValidException {
        return formService.save(form);
    }
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<FieldError> handler(MethodArgumentNotValidException ex) {
        BindingResult result = ex.getBindingResult();
        List<FieldError> fieldErrors = result.getFieldErrors();
        return fieldErrors;
    }

//    optie 1 responseEntidy
//    @RequestMapping(value = "/form", method = RequestMethod.POST)
//    ResponseEntity<?> save(@RequestBody Form form) {
//        if (form.getId() == 0 && form.getTown() != null)
//            return new ResponseEntity<>(formService.save(form), HttpStatus.OK);
//        else return new ResponseEntity<>("can not save", HttpStatus.BAD_REQUEST);
//    }

//    optie 2 @ExeptionHandler
//    @RequestMapping(value = "/form", method = RequestMethod.POST)
//    Form save( @RequestBody Form todo) throws Exception{
//        if (todo.getId() == 0 && todo.getTown() != null )
//            return formService.save(todo);
//        else
//            throw new Exception("town is empty");
//    }
//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<String> exceptionHandler(Exception ex) {
//        return new ResponseEntity<>("exception: " + ex.getMessage(),
//                HttpStatus.BAD_REQUEST);
//    }



    @GetMapping("/form")
    Iterable<Form> getForm() {
        return formService.findAll();
    }

    @DeleteMapping("/form/{id}")
    void deleteForm(@PathVariable int id){
        System.out.println("id " + id);

        formService.deleteById(id);
    }
//    oude versie zonder fout afhandeling
//    @GetMapping("/form/{id}")
//    Optional<Form> formFindById(@PathVariable int id) {
//        return formService.findById(id);
//    }

    @GetMapping("/form/{id}")
    ResponseEntity formFindById(@PathVariable int id) {
        if (formService.findById(id).isPresent())
            return new ResponseEntity( formService.findById(id).get(), HttpStatus.OK);
        else return new ResponseEntity("id bestaat niet", HttpStatus.NOT_FOUND);

    }








}
