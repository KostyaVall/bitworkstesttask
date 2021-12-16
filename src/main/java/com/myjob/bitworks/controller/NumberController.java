package com.myjob.bitworks.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.myjob.bitworks.model.Number;
import com.myjob.bitworks.service.NumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class NumberController {

    private final NumberService numberService;

    @Autowired
    public NumberController(NumberService numberService) {
        this.numberService = numberService;
    }

    @GetMapping(value = "/{number}")
    public ResponseEntity<String> read(@PathVariable(name = "number") int numberRec) throws JsonProcessingException {
        final Number number = numberService.read(numberRec);

        ObjectMapper mapper = new ObjectMapper();

        return number != null
                ? new ResponseEntity<>(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(number), HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
