package org.example.lld1.collections;

import java.util.*;

public class AnagramGrouper {
    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }

        Map<String, List<String>> hm = new LinkedHashMap<>();

        for(String str : strs){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortedStr = new String(chars);

            if(hm.containsKey(sortedStr)){
                List<String> list = hm.get(sortedStr);
                list.add(str);
                hm.put(sortedStr, list);
            } else{
                List<String> list = new ArrayList<>();
                list.add(str);
                hm.put(sortedStr, list);
            }
        }

        List<List<String>> result = new ArrayList<>();
        for(List<String> list : hm.values()){
            result.add(list);
        }
        return result;
    }

    public static void main(String[] args) {
        String strs[] = {"eat", "tea", "tan"};
        List<List<String>> result = groupAnagrams(strs);

        for(List<String> ans:result){
            System.out.println(ans);
        }
    }
}

//Problem Statement
/*
You are given an array of strings, you need to group the anagrams together
and store them in a list of strings.  Write a function in Java that takes
an array of strings as input and returns a List<List<String>> where each
inner list contains the strings that are grouped together i.e. the anagrams.
 */