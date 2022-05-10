package com.psjw.springbootpractice.service;

import com.psjw.springbootpractice.logic.Sort;
import com.psjw.springbootpractice.properties.CustomProperties;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SortService {

    private Sort<String> sort;

    public SortService(@Qualifier("bubbleSort") Sort<String> sort, CustomProperties customProperties) {
        System.out.println("프로퍼티: " + customProperties.getDuration().toMillis() + " ms");
        System.out.println("구현체: " + sort.getClass().getName());
        this.sort = sort;
    }

    public List<String> doSort(List<String> list) {
        return sort.sort(list);
    }
}
