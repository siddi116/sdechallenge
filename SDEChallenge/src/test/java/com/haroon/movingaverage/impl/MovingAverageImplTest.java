package com.haroon.movingaverage.impl;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.haroon.movingaverage.exception.MovingAverageException;
/*
 * JUnit test cases for Moving Average Application
 * 
 * @author: Haroon Siddiqui
 */

public class MovingAverageImplTest {
	
	private MovingAverageImpl movingAvgStruct;
	private Integer windowSize = 4;
	
	//Initializing test conditions.
	@Before
	public void init() {	
		movingAvgStruct = new MovingAverageImpl(windowSize);
	}
	
	//Test 1: Checking Elements are entered correctly.
	@Test
	public void insertElementTest() throws MovingAverageException {
		movingAvgStruct.insertElement(1.0);
		movingAvgStruct.insertElement(1.0);
		movingAvgStruct.insertElement(-1.0);
		movingAvgStruct.insertElement(7.0);
		movingAvgStruct.insertElement(8.0);
		assertEquals(-1.0, movingAvgStruct.getElement(2),0.1);
	}
	
	//Test 2: Calculate Moving Average when window size > list size
	@Test
	public void calculateMovingAverageWindowSizeGreaterThanListSizeTest() throws MovingAverageException {
		movingAvgStruct.insertElement(1.0);
		movingAvgStruct.insertElement(2.0);
		movingAvgStruct.insertElement(3.0);
		assertEquals(2.0, movingAvgStruct.calculateMovingAverage(),0.1);
	}
	
	//Test 3: Calculate Moving Average when window size == list size
	@Test
	public void calculateMovingAverageWindowSizeEqualsListSizeTest() throws MovingAverageException {
		movingAvgStruct.insertElement(1.0);
		movingAvgStruct.insertElement(2.0);
		movingAvgStruct.insertElement(3.0);
		movingAvgStruct.insertElement(4.0);
		assertEquals(2.5, movingAvgStruct.calculateMovingAverage(),0.1);
	}
	
	//Test 4: Calculate Moving Average when window size is quite less than list size
	@Test
	public void calculateMovingAverageWindowSizeLessThanListSizeTest() throws MovingAverageException {
		movingAvgStruct.insertElement(1.0);
		movingAvgStruct.insertElement(2.0);
		movingAvgStruct.insertElement(3.0);
		movingAvgStruct.insertElement(4.0);
		movingAvgStruct.insertElement(5.0);
		movingAvgStruct.insertElement(6.0);
		movingAvgStruct.insertElement(7.0);
		movingAvgStruct.insertElement(8.0);
		assertEquals(6.5, movingAvgStruct.calculateMovingAverage(),0.1);
	}
	
	//Test 5: Calculate Moving Average with all negative elements
	@Test
	public void calculateMovingAverageNegativeInputTest() throws MovingAverageException {
		movingAvgStruct.insertElement(1.0);
		movingAvgStruct.insertElement(-2.0);
		movingAvgStruct.insertElement(-3.0);
		movingAvgStruct.insertElement(4.0);
		movingAvgStruct.insertElement(-5.0);
		assertEquals(-1.5, movingAvgStruct.calculateMovingAverage(),0.1);
	}
	
	//Test 6: Calculate Moving Average with window Size = 0
	@Test
	public void calculateMovingAverageWindowSizeZeroTest() throws MovingAverageException {
		windowSize = 0;
		init();
		assertEquals(0,movingAvgStruct.calculateMovingAverage(),0.1);
	}
	
	//Test 7: Calculate Moving Average with window Size = 0, list size > 0
	@Test
	public void calculateMovingAverageWindowSizeZeroListSizeNotZeroTest() throws MovingAverageException {
		windowSize = 0;
		init();
		movingAvgStruct.insertElement(1.0);
		movingAvgStruct.insertElement(-2.0);
		movingAvgStruct.insertElement(-3.0);
		assertEquals(0,movingAvgStruct.calculateMovingAverage(),0.1);
	}
	
	//Test 8: Calculate Moving Average with window Size < 0
	@Test(expected=IllegalArgumentException.class)
	public void calculateMovingAverageWindowSizeNegativeTest() throws MovingAverageException {
		windowSize = -2;
		init();
	}
	
	//Test 9: Calculate Moving Average with window Size = null
	@Test(expected=IllegalArgumentException.class)
	public void calculateMovingAverageWindowSizeNullTest() throws MovingAverageException {
		windowSize = null;
		init();
	}
	
	//Test 10: Handling null input exception
	@Test(expected=MovingAverageException.class)
	public void excpetionHandlingNullElementInsertTest() throws MovingAverageException {
		movingAvgStruct.insertElement(null);
	}
	
	//Test 11: Handling Empty List exception
	@Test(expected=MovingAverageException.class)
	public void excpetionHandlingAverageOfEmptyListTest() throws MovingAverageException {
		movingAvgStruct.calculateMovingAverage();
	}
	
	//Test 12: Get list size
	@Test
	public void getDataStructSizeTest() throws MovingAverageException {
		assertEquals(0,movingAvgStruct.getDataStructSize(),0.1);
	}
	
	//Test 13: Test to get element within the list.
	@Test
	public void getElementCorrectIndexTest() throws MovingAverageException {
		movingAvgStruct.insertElement(1.0);
		movingAvgStruct.insertElement(2.0);
		movingAvgStruct.insertElement(-3.0);
		assertEquals(2.0,movingAvgStruct.getElement(1),0.1);
	}
	
	//Test 14: Test to get element outside the list.
	@Test(expected=MovingAverageException.class)
	public void getElementInCorrectIndexTest() throws MovingAverageException {
		movingAvgStruct.insertElement(1.0);
		movingAvgStruct.getElement(1);
	}
	
	//Test 15: Test to get all elements of the list.
	@Test
	public void getAllElementsTest() throws MovingAverageException {
		movingAvgStruct.insertElement(1.0);
		movingAvgStruct.insertElement(2.0);
		List<Double> temp = new ArrayList<Double>();
		temp.add(1.0);
		temp.add(2.0);
		assertEquals(temp, movingAvgStruct.getAllElements());
	}

}