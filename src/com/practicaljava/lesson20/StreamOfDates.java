package com.practicaljava.lesson20;

import java.time.LocalDateTime;
import java.util.stream.Stream;

/**
 * Generates a steam of the current time, limited to 5 outputs.
 * @author David Lall
 *
 */

public class StreamOfDates {
   
  public static LocalDateTime myStopWatchFunction() {
	  try {
	       Thread.sleep(1000);
      } 
	  catch (InterruptedException e){
          e.printStackTrace();
	  }
	  
	 return LocalDateTime.now(); // get the current time  
  }	
	
  public static void main(String[] args){

    	   
     // Generating a stream 	   
     Stream<LocalDateTime> timeStream = Stream
    		 .generate(StreamOfDates::myStopWatchFunction)
    		 .limit(5); 	   
    	   
     timeStream.forEach(System.out::println);   	   
   }
}