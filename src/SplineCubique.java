
public class SplineCubique 
{
	public double[][] Calculer(double points[][])
	{
		double coef[][] = getCoef(points);
		double pointsPoly[][] =  new double[2][101];
		
		Double x = -5.0;
		for( int i = 0 ; x <= 5.0; i++,x+=0.1)
		{
			for (int j = 0 ; j < points[0].length ; j++)
			{
				if(x <= points[0][j+1])
				{
					pointsPoly[0][i] = x;
					pointsPoly[1][i] = coef[0][j] + (x - points[0][j]) * (coef[1][j] + (x - points[0][j]) * (coef[2][j] + ((x - points[0][j]) * coef[3][j]))) ;
					break;
				}
			}
			
		}
		
		return pointsPoly;
	}
	
	protected double[][] getCoef(double points[][])
	{
		int nbPoints = points[0].length;
		
		double h[] = new double[nbPoints];
		double b[] = new double[nbPoints];
		double u[] = new double[nbPoints];
		double v[] = new double[nbPoints];
		double z[] = new double[nbPoints];
		
		for(int i = 0; i < nbPoints - 1 ; i++)
		{
			h[i] = points[0][i+1] - points[0][i];
			b[i] =(points[1][i+1] - points[1][i]) / h[i];
		}
		
		u[1] = 2 * (h[0] + h[1]);
		v[1] = 6 * (b[1] - b[0]);
		
		for (int i = 2; i < nbPoints - 1 ; i++)
		{
			u[i] = (2 * (h[i-1] + h[i])) - (Math.pow(h[i-1],2) / u[i-1]);
			v[i] = (6 * (b[i] - b[i-1])) - ((h[i-1] * v[i-1]) / u[i-1]);
		}
		
		z[nbPoints-1] = 0;
		
		for(int i = nbPoints - 2; i > 0 ; i-- )
		{
			z[i] = (v[i] -(h[i] * z[i+1])) / u[i];
		}
		
		z[0] = 0;
		

		double coef[][] = new double[4][nbPoints];
		
		for (int i = 0 ; i < nbPoints-1 ; i++)
		{
			coef[0][i] = points[1][i];
			coef[1][i] = (-(h[i] / 6) * z[i+1]) - (((h[i]) / 3) * z[i]) + ((points[1][i+1] - points[1][i]) / h[i]);
			coef[2][i] = z[i] / 2;
			coef[3][i] = (z[i+1] - z[i]) / (6 * h[i]);
		}
		
		return coef;
	}
	
}
