import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Calendar;
import java.text.SimpleDateFormat;

public class PearsonProduct {
	
	static double sum(double[] table) {
	
		double result = 0;
		
		for (int i = 0; i < table.length; i++)
			
			result += table[i];
		
		return result;
	}
	
	static int counter = 0;
	static void printPearsonTable(double[] xt, double[] yt, float scale) {
		
		counter += 1; System.out.println("\n\tCORRELATION COEFFICIENT TABLE #" + counter + "\n");
		
		DecimalFormat df = new DecimalFormat("#.##");
		
		/*
		INSTRUCTIONS: 	1.	The variable 'df' denotes how many 
							decimal places to round to. (e.g.:
							'#.###' rounds up to three places)
		*/
		
		if (xt.length != yt.length) {
			
			System.out.println("WARNING: 'x' AND 'y' differ by " + Math.abs(yt.length - xt.length) + " elements, recheck your inputs!");
			return;
			
		}
		
		int n = xt.length;
		
		//Arrays.sort(xt);
		//Arrays.sort(yt);
		
		System.out.println("\tX\tY\tXX\tYY\tXY");
		
		double[] xy = new double[n];
		double[] xx = new double[n];
		double[] yy = new double[n];
		
		for (int i = 0; i < n; i++) {
			
			double x	= xt[i];
			double y	= yt[i];
			
			xy[i] = x * y;
			xx[i] = x * x;
			yy[i] = y * y;
			
			
			System.out.println(
			(i + 1) + "."		+ "\t" 
			+ df.format(x) 		+ "\t" 
			+ df.format(y) 		+ "\t" 
			+ df.format(xx[i]) 	+ "\t" 
			+ df.format(yy[i]) 	+ "\t" 
			+ df.format(xy[i]) 	+ "\t"
			);
			
			
		}
		
		double nxy 	= n * sum(xy);
		double nxx 	= n * sum(xx);
		double nyy 	= n * sum(yy);
		
		double sx 	= sum(xt);
		double sy 	= sum(yt);
		
		double res	= (nxy - (sx * sy)) / Math.sqrt((nxx - (sx * sx)) * (nyy - (sy * sy)));
		
		String deg = "";
		
		switch ((int) Math.abs(Math.round(4 * res))) {
			
			case 0	: 	deg = "NONE.";
						break;
						
			case 1	: 	deg = "LOW.";
						break;
						
			case 2	: 	deg = "MED.";
						break;
						
			case 3	: 	deg = "HIGH.";
						break;
						
			case 4	: 	deg = "VERY HIGH.";
						break;			
			
		}
		
		System.out.print(
		
		"\t"			+ "------"					+ "\t"
						+ "------"					+ "\n"
		+ "\t"			+ df.format(sum(xt))		+ "\t"
						+ df.format(sum(yt))		+ "\t"
		+ "ΣXY\t"		+ df.format(sum(xy)) + "\n" + "\t"
		+ "\t\tΣX²\t"	+ df.format(sum(xx)) + "\n" + "\t"
		+ "\t\tΣY²\t"	+ df.format(sum(yy))		+ "\n"
		+ "\n"			+ "CORR.:"					+ "\t"
						+ df.format(res)			+ "\t"
		+ "\t"			+ "DEGREE: " 				+ deg
		+ " ("			+ (int) Math.round(2 * res)	+ ") "
		+ "\n"										+ "\n"
		
		);
		
		Plotter pl = new Plotter(xt, yt, scale, Double.valueOf(df.format(res)), counter, deg);
		
	}
	
	public static void main (String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("""
				
				WRITTEN BY GABRIEL, OCT. 28
						
		(PEARSON-PRODUCT) Prints a table, measures the linear
		correlation between two sets of data; it is the ratio
		between the covariance of two variables and the prod-
		-uct of their standard deviations.
		
		(i) Datasets changed in-code.
		
		TYPE 'YES' TO PROCEED:\t""");
		
		String ans = sc.nextLine();
		
		if (!ans.equals("YES")) {
			
			return;
			
		}
		
		long t1 = System.nanoTime();
		
		printPearsonTable(
			new double[]
			{
				35.5,
				30.6,
				30.0,
				32.3,
				23.9,
				27.7,
				28.8,
				21.8,
				22.9,
				20.8,
				
				25.9,
				31.3,
				23.0,
				26.3,
				23.7,
				27.1,
				28.1,
				22.9,
				21.7,
				36.2,
				
				35.9,
				25.4,
				24.6,
				28.1,
				25.9,
				28.8,
				31.4,
				28.5,
				27.5,
				37.1
				
				
			}, 
			
			new double[]
			{
				16.5,
				17.3,
				27.5,
				19.8,
				40.7,
				24.8,
				22.0,
				33.4,
				24.9,
				36.8,
				
				32.5,
				27.5,
				31.0,
				37.4,
				22.6,
				23.1,
				18.5,
				24.9,
				34.4,
				16.4,
				
				20.2,
				27.8,
				32.8,
				36.5,
				32.3,
				29.1,
				37.0,
				33.7,
				22.7,
				15.0
				
				
			},
			
			10

			
		);
		
		long t2 = (System.nanoTime() - t1)/1_000_000;
		
		System.out.print(
		
		"\t\t" 	+ "DONE PRINTING, ENJOY." + "\n" 	+
		"\t" 	+ "Finished printing in " + t2		+ " milliseconds!" 	+ "\n"
		
		);
		
		
	}
	
	
}

class Plotter extends JPanel {
	
	JFrame frame;
	
	int WIDTH 	= 500;
	int HEIGHT 	= 500;
	
	double[] xt, yt; 
	
	float 	scale;
	double 	r;
	String 	msg;
	
	Plotter(double[] xt, 	double[] yt, 
			float scale, 	double 	r, 
			int 	num, 	String msg) {	
	
		this.xt 	= xt;
		this.yt 	= yt;
		this.r 		= r;
		this.msg 	= msg;
		this.scale 	= scale;
	
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		
		frame = new JFrame();
		
		frame.setTitle("Pearson Coefficient, #" + num);
		
		frame.setSize(WIDTH, HEIGHT);
		frame.setResizable(false);
		frame.setUndecorated(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		frame.add(this);
		frame.pack();
		
	}
	
	public static String now() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat();
		return sdf.format(cal.getTime());
	}
	
	public void paint(Graphics g) {
		
		int SIZE = 5;
		
		String displDeg = "";
		
		switch ((int) Math.round(4 * r)) {
			
			case -4	: 	displDeg = "Very Highly Negative";
						break;
						
			case -3	: 	displDeg = "Highly Negative";
						break;
						
			case -2	: 	displDeg = "Moderately Negative";
						break;
			
			case -1	: 	displDeg = "Low Negative";
						break;
					 
			case 0	: 	displDeg = "No correlation.";
						break;
						
			case 1	: 	displDeg = "Low Positive";
						break;
						
			case 2	: 	displDeg = "Moderately Positive";
						break;
						
			case 3	: 	displDeg = "Highly Positive";
						break;

			case 4	: 	displDeg = "Very Highly Positive";
						break;
			
		}
		
		g.drawString("Written by: Gabriel", WIDTH - 125, 25);
		g.drawString(displDeg + ", "+ r, 	25, HEIGHT - 25);			
		g.drawString(now(), 				25, 		 25);	
		
		for (int i = 0; i < xt.length; i++) {
			
			switch (i % 2) {
				
				case 0:	g.fillRect(
				
						WIDTH 	- (int) (xt[i] * scale), 
						HEIGHT 	- (int) (yt[i] * scale),
						
						SIZE, SIZE	// Dimensions
						
						);
						
						break;
					
				case 1: g.drawRect(
				
						WIDTH 	- (int) (xt[i] * scale), 
						HEIGHT 	- (int) (yt[i] * scale),
						
						SIZE, SIZE
						
						);
						
						break;
					
			}
			
			
			
		}
		
		
		
	}
	
	
	
}
