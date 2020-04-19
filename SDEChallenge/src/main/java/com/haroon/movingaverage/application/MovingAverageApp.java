package com.haroon.movingaverage.application;

import java.util.*;
import java.util.logging.Logger;

import com.haroon.movingaverage.impl.MovingAverageImpl;
import com.haroon.movingaverage.exception.MovingAverageException;

/*
 * 
 * @Author: Haroon Siddiqui
 * @Created: April 14, 2020
 *
 */

/*
 * Application Start class
 * This is an implementation of the SDEChallenge - Moving Average
 * It was required to output an average of the last N stored elements.
 */
public class MovingAverageApp {
	
	//Defining a logger variable to store info and waring for the application.
	private static final Logger LOGGER = Logger.getLogger(MovingAverageApp.class.getName());
	
	public static void main(String[] args) {
		
		//Welcome message to the program for user friendly purpose.
		System.out.println("Welcome to Haroon\'s Moving Average Solution");
		System.out.println();
		
		//windowSize here defines the last N elements that will be used for calculating average.
		Integer windowSize = 4;
		
		try {
			//Instantiating object for the data structure
			MovingAverageImpl movingAvgStruct = new MovingAverageImpl(windowSize);
			
			//adding elements of type Double object into our data structure.
			movingAvgStruct.insertElement(3.0);
			movingAvgStruct.insertElement(4.0);
			movingAvgStruct.insertElement(5.0);
			movingAvgStruct.insertElement(-6.0);
			
			//Printing data struct size to the console.
			System.out.println("The current size of the data struct is: " + movingAvgStruct.getDataStructSize());
			
			//Printing current moving average to the console.
			System.out.println("The requested moving average is: " + movingAvgStruct.calculateMovingAverage());
			
			movingAvgStruct.insertElement(7.0);
			
			System.out.println("The requested moving average is: " + movingAvgStruct.calculateMovingAverage());
			
			//Printing the element at the requested index to the console.
			System.out.println("The requested element is: " + movingAvgStruct.getElement(2));
			
			//Printing the full list of elements in our data struct.
			System.out.println("The current full element list is: " + movingAvgStruct.getAllElements());
		}
		catch (MovingAverageException ex) {
			LOGGER.warning(ex.getMessage());
		}
	}
}
