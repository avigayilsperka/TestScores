/*Avigayil Marcus
* Program7
* 3/2/22 */
import java.util.*;
import java.io.*;

public class Program7 {

	public static void main(String args[]) throws IOException {		
		//open file, connect scanner.
		File file =new File ("TestScoresWithNames.txt");              
		Scanner InputFile = new Scanner (file);
			
		//new arrayList initialized from first item
		int initialize = InputFile.nextInt();
		ArrayList <Double> scores = new ArrayList<Double>(initialize);
		ArrayList <String> names= new ArrayList<String>(initialize);
			
		//fill in array
		for (int x = 0; x<initialize; x++) {
			scores.add(InputFile.nextDouble());
			InputFile.nextLine();
			names.add(InputFile.nextLine());
		}
			
		//calculate and return top score
		double best = bestScore(scores);
			
		//calculate letter grade and display
		for (int x=0; x<scores.size(); x++) {
			char grade = calculateGrade(scores.get(x),best);
			System.out.printf("%s:\n\tScore: %.0f\n\tGrade: %c\n\n",names.get(x), scores.get(x),grade);
		}
			
		//display names and corresponding scores
		namesAndScores(names,scores);
			
		//determine and display average score
		double average= averageScore(scores);
		System.out.printf("\nThe Average score is %.2f.\n",average);
			
		//determine and display above average scores
		int aboveAvg = aboveAverage(scores, average);
		System.out.println (aboveAvg +" scores are above the average.");
			
		//determine and display below average scores
		int belowAvg = belowAverage(scores, average);
		System.out.println (belowAvg +" scores are below the average.");
			
		InputFile.close();
	}
		
	public static double bestScore(ArrayList <Double> scores) {
		
		double max = scores.get(0); 
		for (int x=1; x<scores.size(); x++) {
			if (scores.get(x)>max)
				max = scores.get(x);	
		}
		return max;	
	}
		
	public static char calculateGrade(double n, double best) {
		if (n >= best-10) 
			return 'A';
		else if (n >= best-20)
			return 'B';
		else if (n >= best-30)
			return 'C';
		else if (n >= best-40)
			return 'D';
		else
			return 'F';
	}
		
	public static void namesAndScores(ArrayList<String> names, ArrayList <Double> scores) {
		System.out.println("Student's Names and Corresponding Scores:");
		for (int x=0; x<scores.size(); x++) {
			System.out.printf("%s: %.0f\n", names.get(x),scores.get(x));
		}
	}
	public static double averageScore(ArrayList <Double> scores) {
		double sum=0;
		for (int x=0; x<scores.size();x++) 
			sum +=  scores.get(x);
		return sum /scores.size();	
	}
		
	public static int aboveAverage(ArrayList <Double>scores, double average) {
		int ctr=0;
		for (int x=0; x<scores.size(); x++) {
			if (scores.get(x)>average)
				ctr++;
		}
		return ctr;
	}
		
	public static int belowAverage (ArrayList <Double> scores, double average) {
		int ctr = 0;
		for (int x=0; x<scores.size(); x++) {
			if (scores.get(x)<average)
				ctr++;
		}
		return ctr;
	}

}
