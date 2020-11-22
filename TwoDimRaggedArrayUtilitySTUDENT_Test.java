import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TwoDimRaggedArrayUtilitySTUDENT_Test {
	private double[][] dataset1 = {{5,10,15}, {20,25,30}};
	private double[][] dataset2 = {{10,20}, {30,40,50}};
	
	private File inputFile,outputFile;

	@Before
	public void setUp() throws Exception {
		outputFile = new File("TestOut.txt");
	}

	@After
	public void tearDown() throws Exception {
		dataset1 = dataset2 = null;
		inputFile = outputFile = null;
	}

	/**
	 * Student Test getTotal method
	 * Return the total of all the elements in the two dimensional array
	 */
	@Test
	public void testGetTotal() {
		assertEquals(105.0, TwoDimRaggedArrayUtility.getTotal(dataset1), .001);
		assertEquals(150.0, TwoDimRaggedArrayUtility.getTotal(dataset2), .001);
	}

	/**
	 * Student Test getAverage method
	 * Return the average of all the elements in the two dimensional array
	 */
	@Test
	public void testGetAverage() {
		assertEquals(17.5, TwoDimRaggedArrayUtility.getAverage(dataset1), .001);
		assertEquals(30.0, TwoDimRaggedArrayUtility.getAverage(dataset2), .001);
	}

	/**
	 * Student Test getRowTotal method
	 * Return the total of all the elements of the row.
	 * Row 0 refers to the first row in the two dimensional array
	 */
	@Test
	public void testGetRowTotal() {
		assertEquals(30.0, TwoDimRaggedArrayUtility.getRowTotal(dataset1, 0), .001);
		assertEquals(120.0, TwoDimRaggedArrayUtility.getRowTotal(dataset2, 1), .001);
	}


	/**
	 * Student Test getColumnTotal method
	 * Return the total of all the elements in the column. If a row in the two dimensional array
	 * doesn't have this column index, it is not an error, it doesn't participate in this method.
	 * Column 0 refers to the first column in the two dimensional array
	 */
	@Test
	public void testGetColumnTotal() {
		assertEquals(25.0, TwoDimRaggedArrayUtility.getColumnTotal(dataset1, 0), .001);
		assertEquals(60.0, TwoDimRaggedArrayUtility.getColumnTotal(dataset2, 1), .001);
	}


	/**
	 * Student Test getHighestInArray method
	 * Return the largest of all the elements in the two dimensional array.
	 */
	@Test
	public void testGetHighestInArray() {
		assertEquals(30.0, TwoDimRaggedArrayUtility.getHighestInArray(dataset1), .001);
		assertEquals(50.0, TwoDimRaggedArrayUtility.getHighestInArray(dataset2), .001);
	}
	

	/**
	 * Test the writeToFile method
	 * write the array to the outputFile File
	 * then read it back to make sure formatted correctly to read
	 * @throws FileNotFoundException 
	 * 
	 */
	@Test
	public void testWriteToFile() throws FileNotFoundException {
		try {
			TwoDimRaggedArrayUtility.writeToFile(dataset2, outputFile);
		} catch (Exception e) {
			fail("This should not have caused an Exception");
		}
		double[][] array = TwoDimRaggedArrayUtility.readFile(outputFile);
		assertEquals(10, array[0][0],.001);
		assertEquals(20, array[0][1],.001);
		assertEquals(30, array[1][0],.001);
		assertEquals(40, array[1][1],.001);
		assertEquals(50, array[1][2],.001);
		
	}
	
}
