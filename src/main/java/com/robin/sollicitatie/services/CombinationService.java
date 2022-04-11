package com.robin.sollicitatie.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.robin.sollicitatie.models.Combination;
import com.robin.sollicitatie.repositories.CombinationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CombinationService {
    public static final int DEFAULT_LIMIT_WORD = 6;

    @Autowired
    private CombinationRepository combinationRepository;

    public List<Combination> findAndSaveCombinations(String input) {
        // Cleaning
        List<String> cleanInput = new ArrayList<String>();
        input.lines().forEach(line -> cleanInput.add(line.strip()));

        // Split
        List<String> words = cleanInput.stream().filter(line -> line.length() == DEFAULT_LIMIT_WORD).toList();
        List<String> pieces = cleanInput.stream().filter(line -> line.length() < DEFAULT_LIMIT_WORD).toList();

        // Algorithm
        List<Combination> foundCombinations = new ArrayList<Combination>();
        for (int i = 0; i < pieces.size(); i++) {
            String piece1 = pieces.get(i);
            for (int j = 1; j < pieces.size(); j++) {
                String piece2 = pieces.get(j);
                String combinationString = piece1 + "+" + piece2;
                String word = piece1 + piece2;
                Combination combination = new Combination(combinationString, word);
                if (combination.getWord().length() == DEFAULT_LIMIT_WORD
                        && words.contains(combination.getWord())
                        && !foundCombinations.contains(combination)) {
                    foundCombinations.add(combination);
                }
            }
        }

        // Save combinations
        for (Combination combination : foundCombinations) {
            combinationRepository.save(combination);
        }
        return foundCombinations;
    }

    public List<Combination> getCombinations() {
        return combinationRepository.findAll();
    }
}
