package com.codegym.repository.impl;

import com.codegym.repository.IDictionaryRepository;

import java.util.ArrayList;
import java.util.List;

public class DictionaryRepository implements IDictionaryRepository {

    static List<String> list = new ArrayList<>();

    static {
        list.add("one");
        list.add("two");
        list.add("three");
    }

    @Override
    public String list(String dictionary) {
        String result = "";
        String mess = "Not found";
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(dictionary)) {
                int index = list.indexOf(dictionary);
                List<String> listViet = new ArrayList<>();
                listViet.add("một");
                listViet.add("hai");
                listViet.add("ba");
                result = listViet.get(index);
                break;
            } else result = mess;
        } return result;
    }
}
