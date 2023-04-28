package com.codegym.service.impl;

import com.codegym.repository.IDictionaryRepository;
import com.codegym.repository.impl.DictionaryRepository;
import com.codegym.service.IDictionaryService;

public class DictionaryService implements IDictionaryService {
    private IDictionaryRepository iDictionaryRepository = new DictionaryRepository();

    @Override
    public String list(String dictionary) {
        return iDictionaryRepository.list(dictionary);
    }
}

