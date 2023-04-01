package com.chatweb.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Lambda {

    public static void main(String args[]) {
        List<String> lines = Arrays.asList("spring", "node", "mkyong");


        List<String> result1 = lines.stream().filter(line -> !"mkyong".equals(line)).collect(Collectors.toList());

        result1.forEach(System.out::println); // output "spring", "node"
    }



}
