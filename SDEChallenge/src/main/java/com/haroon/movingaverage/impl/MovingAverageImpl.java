package com.haroon.movingaverage.impl;

import java.util.*;
import java.util.logging.Logger;

import com.haroon.movingaverage.MovingAverage;
import com.haroon.movingaverage.exception.MovingAverageException;

/*
 * This is an implementation of the interface.
 * 
 * Code has been divided into several functions to increase readability and testability.
 */
public class MovingAverageImpl implements MovingAverage<Double>{

	private Integer windowSize;
	private Double windowSum;
	private static final Logger LOGGER = Logger.getLogger(MovingAverageImpl.class.getName());
	
	private List<Double> numberList;
	
	/*Class construction to set initial working conditions of the application.
	 * 
	 * Using ArrayList for faster element accessibility via
	 * the use of an index.
	 */
	public MovingAverageImpl(Integer windowSize) {
		super();
		
		if (windowSize == null || windowSize < 0) {
			LOGGER.warning("Provided Window Size needs to be a number and greater than 0.");
			throw new IllegalArgumentException("Provided Window Size needs to be a number and greater than 0.");
		}
		
		this.windowSize = windowSize;
		this.numberList = new ArrayList<Double>();
		this.windowSum = 0.0;
	}

	public void insertElement(Double element) throws MovingAverageException {
			
		//Checking for exception if the user inputs a null element.
		if (element == null) {
			LOGGER.warning("Incorrect value for the element was inserted");
			throw new MovingAverageException("Incorrect value for the element was inserted");
		}
		//adding element to the list and logging it.
		numberList.add(element);
		LOGGER.info("Added Element " + element + " to the data structure");
		
		
		/*
		 * In the section of the code, we update the sum each time we add a new element.
		 * 
		 * The if condition makes sure that we have sum of the last N elements 
		 * at any given time.
		 */
		windowSum += element;
		if (numberList.size() > windowSize) {
			windowSum -= numberList.get((numberList.size() - windowSize - 1));
			LOGGER.info("Adjusted sum to reflect latest elements within window size");
		}
	}
	
	/*Simple function to return moving average.
	 * 
	 * We have used another function in here 
	 * to get the working window size in the case 
	 * when list size is less than our window size,
	 * we will just return the average of the whole list.
	 */
	public Double calculateMovingAverage() throws MovingAverageException {
		
		int usableWindowSize = Math.min(windowSize, numberList.size());
		
		if (windowSize == 0)
			return 0.0;
		else if (usableWindowSize == 0) {
			LOGGER.info("Add atleast one element to the list first.");
			throw new MovingAverageException("Add atleast one element to the list first.");
		}
		
		return windowSum/getUsableWindowSize();
	}
	
	/*
	 * This function adjusts the working window size in the case 
	 * when the list size is less than the requested window size.
	 * 
	 * Eg: We only added 2 elements but requesting average of 3 elements,
	 * then we would just want to return the average of the 2 elements.
	 * 
	 * It also throws an exception if list is empty
	 * 
	 * Logging is done here as well.
	 */
	private int getUsableWindowSize() {
		int usableWindowSize = Math.min(windowSize, numberList.size());
		
		if (usableWindowSize == numberList.size()) {
			LOGGER.info("Data Struct is smaller than default Window Size,"
					+ " hence adjusting usable window size to whole Data Struct.");
		}
		return usableWindowSize;
	}
	
	//Returns the list of all elements in our list.
	public List<Double> getAllElements() {
		return numberList;
	}

	/*Returns a particular element from our list and if the index is out of bound,
	 *it throws an exception.
	*/
	public Double getElement(Integer index) throws MovingAverageException {
		
		if (index < 0 || index >= numberList.size()) {
			LOGGER.info("Provided index is out of bound");
			throw new MovingAverageException("Provided index is out of bound");
		}
		
		return numberList.get(index);
	}
	
	//Function if user would like to get current list size.
	public Integer getDataStructSize() {
		LOGGER.info("Current Struct Size: " + numberList.size());
		return numberList.size();
	}
}
