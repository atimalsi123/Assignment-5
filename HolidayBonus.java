/**
 * 
 * @author Alisha Timalsina
 * Holiday Bonus calculates the Holiday bonus and the total holiday Bonus
 *
 */
public class HolidayBonus {

  public static double[] calculateHolidayBonus(double[][] data, double high, double low, double other){
	  int highest = 0;
	  double[] bonus = new double[data.length];
	  for (int a = 0; a < data.length; a++){
		  if (highest < data[a].length){
			  highest = data[a].length;
		  }
	  }
    
	  for (int b = 0; b < highest; b++){
		  int highestBonus = TwoDimRaggedArrayUtility.getHighestInColumnIndex(data, b);
		  int lowestBonus = TwoDimRaggedArrayUtility.getLowestInColumnIndex(data, b);
      
		  if ((TwoDimRaggedArrayUtility.getLowestInColumn(data, b)) > 0 && (highestBonus != lowestBonus) ){
			  bonus[lowestBonus] += low;
		  }
		  if (0 < TwoDimRaggedArrayUtility.getHighestInColumn(data, b)){  
			  bonus[highestBonus] += high;
		  }
		  for (int c = 0; c < data.length; c++){
			  if (c == lowestBonus || c == highestBonus || b >= data[c].length || 0 >= data[c][b]) {
				  continue;
			  } 
			  else{
				  bonus[c] += other;
			  } 
		  }
	  }   
	  return bonus;
  	}

  	public static double calculateTotalHolidayBonus(double[][] data, double high, double low, double other) {
  		double total = 0;
  		double[] bonus = calculateHolidayBonus(data, high, low, other);
  		for (int a = 0; a < bonus.length; a++) {
  			total += bonus[a];
  		}
  		return total;
  	}
  	

}
