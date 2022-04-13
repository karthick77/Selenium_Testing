package com.rash.testing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class JavaStream_Examples1 {

	public static void main(String[] args) {

		ArrayList<String> names = new ArrayList<String>();
		names.add("Arun");
		names.add("Tarun");
		names.add("Varun");
		names.add("Ramesh");
		names.add("Suresh");
		names.add("Aron");
		names.add("Naresh");
		names.add("Mahesh");
		names.add("Vignesh");
		
		long c = names.stream().filter(s->s.startsWith("A")).count();
		System.out.println(c);
		long d = names.stream().filter(s->s.endsWith("esh")).count();
		System.out.println(d);
		names.stream().filter(s->s.length()<=5).forEach(s->System.out.println(s));
		System.out.println();
		names.stream().filter(s->s.length()<=5).limit(1).forEach(s->System.out.println(s));
		System.out.println();
		names.stream().filter(s->s.length()<=5).map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		System.out.println();
		List<String> myList = Arrays.asList("Kamal","Rajini","Ajith","Vijay","Vikram","Suriya");
		myList.stream().filter(s->s.contains("a")).sorted().map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		System.out.println();
		Stream<String> finalCon = Stream.concat(names.stream(), myList.stream());
		finalCon.sorted().forEach(s->System.out.println(s));
		
		System.out.println();
		Stream<String> s2 = Stream.concat(names.stream(), myList.stream());
		boolean match1 = s2.anyMatch(s->s.equalsIgnoreCase("Mahesh"));
		if(match1) {
			System.out.println("Value found");
		}else {
			System.out.println("Value not found");
		}
		System.out.println();
		Stream<String> col1 = Stream.concat(names.stream(), myList.stream());
		List<String> col2 = col1.filter(s->s.startsWith("R")).sorted().map(s->s.toUpperCase()).collect(Collectors.toList());
		System.out.println(col2);
		System.out.println(col2.get(0));
		
		System.out.println("****************");
		List<Number> list1 = Arrays.asList(8, 7, 6,1,3,1,5,3,1,7,3,5,9,9);
		list1.stream().distinct().sorted().forEach(s->System.out.println(s));
	}

}
