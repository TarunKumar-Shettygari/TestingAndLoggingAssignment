package com.accolite.au.FizzBuzz_Logging;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {
	
	public List<String> play(int limit){
		List<String> list=new ArrayList<String>();
		for(int num=1;num<=limit;num++) {
			if(num%15==0) {
				list.add("FizzBuzz");
			}
			else if(num%3==0) {
				list.add("Fizz");
			}
			else if(num%5==0) {
				list.add("Buzz");
			}
			else {
				list.add(num+"");
			}
		}	
		return list;	
	}

}