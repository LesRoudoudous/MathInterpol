
public class Newton {

	public double[][] Calculer(double points[][])
	{
		int nbPoint = points[0].length;
		double valeur[][] = new double [nbPoint][nbPoint+1];
		double poly[] = new double [nbPoint];
		
		System.out.println("nbPoint  - "+ nbPoint);
		
		for(int i = 0 ; i < nbPoint ; i++)
		{
			valeur[i][0] = points[1][i];
			System.out.println("valeur[i][0] - "+ valeur[i][0]);
		} 
		
		System.out.println(" ************************************** ");
		
		for(int j = 1 ; j < nbPoint ; j++)
		{
			for(int i = 0 ; i < nbPoint - j ; i++)
			{
				System.out.println("i - " + i);
				System.out.println("j - " + j);
				valeur[i][j] = (valeur[i+1][j-1] - valeur[i][j-1])/(points[0][j+i] - points[0][i]);
				System.out.println("valeur[i][j-1]  - "+ valeur[i+1][j]);
				System.out.println("valeur[i-1][j-1] - "+ valeur[i][j]);
				System.out.println("points[0][i-1]  - "+ points[0][i+1]);
				System.out.println(" points[0][i-j] - "+  points[0][i]);
			}
		}
		
		System.out.println(" ==================================== ");
		
		for(int i = 0 ; i < nbPoint ; i++)
		{
			poly[i] = valeur[0][i];
			System.out.println("a" + i + " = " + poly[i]);
		}
		
		double pointsPoly[][] =  new double[2][101];
		
		Double x = -5.0;
		for( int i = 0 ; x <= 5.0; i++,x+=0.1)
		{
			pointsPoly[0][i] = x;
			double Somme =0;
			for (int j =0 ; j<nbPoint ; j++)
			{
				double val = poly[j];
				
				for (int k=0; k<j; k++)
				{
					val *= x - points[0][k];
				}
				Somme += val;
			}
			pointsPoly[1][i] = Somme;		
		}
		
		return pointsPoly;
	}
	
}
