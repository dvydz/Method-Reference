package com.methodreference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;

class Numbers {
	
	  public static boolean isMoreThanFifty(int n1, int n2) {
	    return (n1 + n2) > 50;
	  }
	  /* We have BiPredicate pointing to isMoreThanFifty
	   * When the function findNumbers is called from main, one argument passed, Numbers::isMoreThanFifty is pointing to BiPredicate<Integer,Integer>
	   * BiPredicate is a functional interface, and this p.test will point to isMoreThanFifty because of method reference.
	   */
	  public static List<Integer> findNumbers(List<Integer> l, BiPredicate<Integer, Integer> p) {
	      List<Integer> newList = new ArrayList<>();
	      for(Integer i : l) {
	        if(p.test(i, i + 10)) { 
	          newList.add(i);
	        }
	      }
	      return newList;
	  }
	} 
public class MethodReference{
	public static void main(String [] args) {
		List<Integer> list = Arrays.asList(12,5,45,18,33,24,40);
	
		/*  Using an anonymous class
			BiPredicate is an functional interface and that needs to be implemented in a class if we need to use it
			Either in a separate class,or an anonymous class. The bottom is an anonymous class.
			We are only calling findNumbers using anonymous class as an argument associated with BiPredicate */
		System.out.println(
			Numbers.findNumbers(list, new BiPredicate<Integer, Integer>() { 
			    public boolean test(Integer i1, Integer i2) {
			    return Numbers.isMoreThanFifty(i1, i2);
			  }
			})
		);
		
		//Using Lambda Expression
		System.out.println(Numbers.findNumbers(list, (i1,i2) -> Numbers.isMoreThanFifty(i1, i2)));
		
		//Using Method Reference
				System.out.println(Numbers.findNumbers(list, Numbers::isMoreThanFifty));
		
	}	
}


//For non-static method just use objects instead of class name.