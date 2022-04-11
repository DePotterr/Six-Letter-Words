package com.robin.sollicitatie.controllers;

import java.util.List;

import com.robin.sollicitatie.models.Combination;
import com.robin.sollicitatie.services.CombinationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api")
public class CombinationController {

    @Autowired
    CombinationService combinationService;

    @GetMapping("/file")
    public List<Combination> test() {
        return combinationService.getCombinations();
    }

    @PostMapping("/file")
    public List<Combination> postFile(@RequestBody String input) {
        return combinationService.findAndSaveCombinations(input);
    }
}
