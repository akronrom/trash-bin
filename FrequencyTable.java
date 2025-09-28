import java.text.DecimalFormat;

public class FrequencyTable {
	
	static double sum(double[] table) {
	
		double result = 0;
		
		for (int i = 0; i < table.length; i++) {
			
			result += table[i];
			
		}
		
		return result;
	}
	
	static int counter = 0;
	static void printTable(double[] xt, double[] ft) {
		
		counter += 1; System.out.println("\n\tSTANDARD DEVIATION & FREQ. TABLE #" + counter + "\n");
		
		DecimalFormat df = new DecimalFormat("#.###");
		
		/*
		INSTRUCTIONS: 	1.	The variable 'df' denotes how many 
							decimal places to round to. (e.g.:
							'#.###' rounds up to three places)
							
						2.	Change only the 'xt' and 'ft' vars
							to manipulate the dataset.
							
							'xt' stands for the X component of
							the table, or simply COLUMN X. The
							second array stands for frequency.
							
						3.	It will let you know if the length
							of each array does not line up.
		
		*/
		
		if (xt.length != ft.length) {
			
			System.out.println("WARNING: 'f' AND 'x' differ by " + Math.abs(ft.length - xt.length) + " elements, recheck your inputs!");
			return;
			
		}
		
		int e = xt.length;
		
		double n = sum(ft);
		
		System.out.println("\tX\tF\tF(X)\t-M\tMM\tF(M)");
		
		double[] fxt = new double[e];
		double[] mut = new double[e];
		double[] mmt = new double[e];
		double[] fmt = new double[e];
		
		for (int i = 0; i < e; i++) fxt[i] = ft[i] * xt[i]; 
		
		double mean = sum(fxt)/n;
		for (int i = 0; i < e; i++) {
			
			mut[i] = xt[i] 	- 	mean; 
			mmt[i] = mut[i] * 	mut[i];
			fmt[i] = ft[i] 	* 	mmt[i]; 
			
		}
		
		for (int i = 0; i < e; i++) {
			
			double x 	= xt[i]; 
			double f 	= ft[i];
			double fx 	= fxt[i];
			double mu	= mut[i];
			double mm	= mmt[i];
			double fm	= fmt[i];
			
			System.out.println(
			(i + 1) 			+ "\t" 
			+ df.format(x) 		+ "\t" 
			+ df.format(f) 		+ "\t" 
			+ df.format(fx) 	+ "\t" 
			+ df.format(mu) 	+ "\t" 
			+ df.format(mm) 	+ "\t" 
			+ df.format(fm));
			
		}
		
		double vrn = sum(fmt)/(n-1);
		double std = Math.sqrt(vrn);
		
		System.out.println(
		"\t"				+ "------"					+ "\t"
		+ "\t"				+ "------"					+ "\t"
		+ "\t\t"			+ "------"					+ "\n"
		+ "\t"		 		+ df.format(sum(xt))		+ "\t"
		+ "\t"		 		+ df.format(sum(fxt))		+ "\t"
		+ "\t\t"			+ df.format(sum(fmt))		+ "\n"
		+ "\nVARIANCE.:\t"	+ df.format(vrn)			+ "\t"
		+ "MEAN:\t"			+ df.format(mean)			+ "\t"
		+ "RANGE:\t"		+ df.format(xt[e-1]-xt[0])	+ "\t"
		+ "\nSTD. DEV.:\t" 	+ df.format(std) 			+ "\t"
		+ "MIN:\t"			+ xt[0]						+ "\t"
		+ "MAX:\t"			+ xt[e-1]					+ "\n"
		);
		
	}

	public static void main(String[] args) {
		
		printTable(
			new double[]
			{
				18.0,			
				19.0,			
				20.0,			
				21.0,
				23.0,
				24.0,
				25.0,
				31.0,
				
			}, 
			new double[]
			{
				2.0,
				1.0,
				2.0,
				4.0,
				2.0,
				2.0,
				1.0,
				1.0,
			}
			
			
		);
		
		printTable(
			new double[]
			{
				51.89,
				53.25,
				53.98,
				54.75,
				54.85,
				55.23,
				55.64,
				55.75,
				56.17,
				
			}, 
			new double[]
			{
				1,
				1,
				1,
				1,
				1,
				1,
				1,
				2,
				1,
				
			}
			
			
		);
		
		
	}
	
	
}
