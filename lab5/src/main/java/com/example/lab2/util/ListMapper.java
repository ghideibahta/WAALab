package com.example.lab2.util;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ListMapper<T, E>{

    @Autowired
    ModelMapper modelmapper;

    public List<?> mapList(List<T> list, E convertTo){
        List<?> ret =
                list.stream()
                        .map(e -> modelmapper.map(e, convertTo.getClass()))
                        .collect(Collectors.toList());

        return ret;
    }
}
