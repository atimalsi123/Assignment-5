/**
 * 
 * @author Alisha Timalsina
 * This utility works with 2 dimensional ragged arrays with a maximum of 10 rows and 10 columns
 * This utility works with negative and positive numbers
 * This is a utility class - there are no private data members
 * 
 */

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class TwoDimRaggedArrayUtility {

		public static double[][] readFile(File file) throws FileNotFoundException {
		double array[][] = null;
		int row = 0, index = 0;
		Scanner sc = new Scanner(file);
		
		while (sc.hasNextLine()) {	
			row++; 
			sc.nextLine(); 
		}
		sc.close();
		
		array = new double[row][];
		Scanner sc2 = new Scanner(file);
		
		while (sc2.hasNextLine()) {
			String col[] = sc2.nextLine().split(" ");
			array[index] = new double[col.length];
			for (int a = 0; a < col.length; a++) {
				array[index][a] = Double.parseDouble(col[a]);
			}
			index++;
		}
		sc2.close();

		return array;
	}
	
		public static void writeToFile(double[][] data, File outputFile) throws FileNotFoundException {
		    PrintWriter file = new PrintWriter(outputFile);
		    StringBuilder builder = new StringBuilder();
		    for (int a = 0; a < data.length; a++) {
		      for (int b = 0; b < data[a].length; b++) {
		        builder.append(data[a][b]+ " ");
		      }
		      builder.append("\n");
		    }
		    file.print(builder.toString());
		    file.close();
		  }

		


		public static double getTotal(double[][] data) {
			double sum = 0;
			for(int a = 0; a < data.length; a++) {
				for(int b = 0; b < data[a].length; b++) {
					sum = sum + data[a][b];				
					}
			}
			return sum;
		}
	
		public static double getAverage(double[][] data) {
			int element1 = 0;
			double element2 = 0;
			for(int a = 0; a < data.length; a++) {
				for(int b = 0; b < data[a].length; b++) {
					element2 = element2 + data[a][b];	
					element1++;
					}
			}
			return (element2 / element1);
		}
		
		public static double getRowTotal(double[][] data, int row) {
			double total = 0;
			for(int a = 0; a < data[row].length; a++) {
				total = total + data[row][a];
			}
			return total;
		}
		
		public static double getColumnTotal(double[][] data, int col) {
			double total = 0;
			for(int a = 0; a < data.length; a++) {
				if ( col >= data[a].length || col < 0 ) {
					continue;
				}
				total = total + data[a][col];
			}
			return total;
		}
		
		public static double getHighestInRow(double[][] data, int row) {
			double highest = 0;
			for(int a = 0; a < data[row].length; a++) {
				if(data[row][a] > highest) {
					highest = highest + data[row][a];
				}
			}
			return highest;
		}
		
		public static int getHighestInRowIndex(double[][] data, int row) {
			double highest = 0;
			int index = 0;
			if(0 > row || data.length < row) {
				return 0;
			}
			for(int a = 0; a < data[row].length; a++) {
				if(data[row][a] > highest) {
					highest = data[row][a];
					index = a;
				}
			}
			return index;
		}
		
		public static double getLowestInRow(double[][] data, int row) {
			double lowest = 0;
			if(0 > row || data.length < row) {
				return 0;
			}
			for(int a = 0; a < data[row].length; a++) {
				if(data[row][a] < lowest || lowest == 0) {
					lowest = data[row][a];
				}
			}
			return lowest;
		}
		
		public static int getLowestInRowIndex(double[][] data, int row) {
			double lowest = 0;
			int index = 0;
			for(int a = 0; a < data[row].length; a++) {
				if(data[row][a] < lowest || lowest == 0) {
					lowest = data[row][a];
					index = a;
				}
			}
			return index;
		}
		
		public static double getHighestInColumn(double[][] data, int col) {
			double highest = 0;
			for(int a = 0; a < data.length; a++) {
				if ( col >= data[a].length) {
					continue;
				}
				if(data[a][col] > highest) {
					highest = data[a][col];
				}
			}
			return highest;
		}
		
		public static int getHighestInColumnIndex(double[][] data, int col) {
			double highest = 0;
			int index = 0;
			for(int a = 0; a < data.length; a++) {
				if ( col >= data[a].length) {
					continue;
				}
				if(data[a][col] > highest) {
					highest = data[a][col];
					index = a;
				}
			}
			return index;
		}
		
		public static double getLowestInColumn(double[][] data, int col) {
			double lowest = 0;
			for(int a = 0; a < data.length; a++) {
				if ( col >= data[a].length) {
					continue;
				}
				if(data[a][col] < lowest || lowest == 0) {
					lowest = data[a][col];
				}
			}
			return lowest;
		}
		
		
		public static int getLowestInColumnIndex(double[][] data, int col) {
			double lowest = 0;
			int index = 0;
			for(int a = 0; a < data.length; a++) {
				if ( col >= data[a].length) {
					continue;
				}
				if(data[a][col] < lowest || lowest == 0) {
					lowest = data[a][col];
					index = a;
				}
			}
			return index;
		}
		
		
		public static double getHighestInArray(double[][] data) {
			double highest = 0;
			for(int a = 0; a < data.length; a++) {
				for(int b = 0; b < data[a].length; b++) {
				if(data[a][b] > highest) {
					highest = data[a][b];
				}
			}
			}
			return highest;
		}
		
		public static double getLowestInArray(double[][] data) {
			double lowest = 0;
			for(int a = 0; a < data.length; a++) {
				for(int b = 0; b < data[a].length; b++) {
				if(data[a][b] < lowest || lowest == 0) {
					lowest = data[a][b];
				}
			}
			}
			return lowest;
		
		}

		
		
}
