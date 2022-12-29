/*Avigayil Marcus
 * Program4
 * 3/2/22 */
import java.util.*;
import java.io.*;

public class Program4 {
	
	public static void main(String args[]) throws IOException {
		
		//open file, connect scanner.
		File file =new File ("TestScoresWithNames.txt");               
		Scanner InputFile = new Scanner (file);
		
		//new array initialized from first item
		int initialize = InputFile.nextInt();
		double []scores = new double[initialize];
		String []names= new String[initialize];
		
		//fill in array
		for (int x = 0; x<initialize; x++) {
			scores [x] = InputFile.nextDouble();
			InputFile.nextLine();
			names [x] = InputFile.nextLine();
		}
		
		//calculate and return top score
		double best = bestScore(scores);
		
		//calculate letter grade and display
		for (int x=0; x<scores.length; x++) {
			char grade = calculateGrade(scores[x],best);
			System.out.printf("%s:\n\tScore: %.0f\n\tGrade: %c\n\n",names[x], scores[x],grade);
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
	
	public static double bestScore(double []scores) {
	
		double max = scores[0];
		for (int x=1; x<scores.length; x++) {
			if (scores[x]>max)
				max = scores[x];	
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
	
	public static void namesAndScores(String []names, double []scores) {
		System.out.println("Student's Names and Corresponding Scores:");
		for (int x=0; x<scores.length; x++) {
			System.out.printf("%s: %.0f\n", names[x],scores[x]);
		}
	}
	public static double averageScore(double []scores) {
		double sum=0;
		for (int x=0; x<scores.length;x++) 
			sum +=  scores [x];
		return sum /scores.length;	
	}
	
	public static int aboveAverage(double []scores, double average) {
		int ctr=0;
		for (int x=0; x<scores.length; x++) {
			if (scores[x]>average)
				ctr++;
		}
		return ctr;
	}
	
	public static int belowAverage (double []scores, double average) {
		int ctr = 0;
		for (int x=0; x<scores.length; x++) {
			if (scores[x]<average)
				ctr++;
		}
		return ctr;
	}

}
