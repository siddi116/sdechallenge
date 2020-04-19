# sdechallenge
1. This project is an implementation of Moving Average of the last N elements.
2. We have included the following files to build this solution out.
	a. MovingAverage interface
	b. MovingAverage implementation class
	c. MovingAverage main class to run the project
	d. MovingAverage exception class
	e. MovingAverage test class - JUnit

3. The MovingAverage Interface is of type generic so it can be decided by the user of what type the implementation would be. It includes 5 functions
namely:
	a. public T calculateMovingAverage() throws MovingAverageException;
	b. public void insertElement(T element) throws MovingAverageException;
	c. public T getElement(Integer index) throws MovingAverageException;
	d. public List<T> getAllElements();
	e. public Integer getDataStructSize();

4. The MovingAverage implementation class defines the functions from the interface. We have decided to use an ArrayList here as compared to a LinkedList
for the following purposes:
	a. It has less overhead compared to LinkedList
	b. It is faster to obtain an element by a given index
	c. It is also faster to use an ArrayList for the way we have calculated out average.
		i. We keep adding element value to our sum variable, each time it is inserted. If the size of the ArrayList gets 
		larger than N, we keep removing the last element from the sum after we add the new element to sum. This allows us O(1)
		sum calculation.

5. The Exception class sets the message to the super class accordingly. It can be extended to multiple functions as required.

6. The MovingAverage test class is implemented using JUnit test suite and covers a range of tests including some edge cases. It can also be 
scaled as required.

7. To run this application, create an object of type MovingAverageImpl class and pass in the value of N into the constructor. 
	a. Add elements using the insertElement function
	b. Calculate Average using the calculateMovingAverage function
	c. Get a particular element, providing an index in the function parameter
	d. Get all elements using getAllElements function
	e. Get data structure size using the getDataStructSize function
