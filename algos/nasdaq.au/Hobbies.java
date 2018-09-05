package com.nasdaq.au;

import java.util.*;
import java.util.stream.Collectors;

public class Hobbies {
    
    private final HashMap<String, String[]> hobbies = new HashMap<String, String[]>();
    
    public void add(String hobbyist, String... hobbies) {
        this.hobbies.put(hobbyist, hobbies);
    }
    
    public List<String> findHobbyists(String hobby) {
        List < String > hobbyist = new ArrayList<>();
        
        hobbyist = this.hobbies.entrySet().stream().filter(map -> {
        	if (map.getValue() != null) {
        		for (String hoby: map.getValue()) {
        			if (hoby.equalsIgnoreCase(hobby)) {
        				return true;
        			}
        		}
        	}
        	return false;
        }).map(entry -> entry.getKey()).collect(Collectors.toList());
        return hobbyist;
    }
    
    public static void main(String[] args) {
        Hobbies hobbies = new Hobbies();
        hobbies.add("John", "Piano", "Puzzles", "Yoga");
        hobbies.add("Adam", "Drama", "Fashion", "Pets");
        hobbies.add("Mary", "Magic", "Pets", "Reading");
        
        System.out.println(Arrays.toString(hobbies.findHobbyists("Pets").toArray()));
    }
}