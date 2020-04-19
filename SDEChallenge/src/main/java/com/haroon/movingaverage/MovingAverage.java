package com.haroon.movingaverage;

import java.util.*;

import com.haroon.movingaverage.exception.MovingAverageException;

/*
 * Interface Definition for the Moving Average Implementation.
 */

public interface MovingAverage<T> {
	
	//Function definition to calculate average of the requested number of elements in the data struct.
	public T calculateMovingAverage() throws MovingAverageException;
	
	//Function definition to add an element to the data structure.
	public void insertElement(T element) throws MovingAverageException;
	
	//Function definition to get a particular element from the data structure.
	public T getElement(Integer index) throws MovingAverageException;
	
	//Function definition to get all elements in the list.
	public List<T> getAllElements();
	
	//Function definition to get the current data struct size.
	public Integer getDataStructSize();

}
