
public class Tchebycheff 
{
	public double[] Calculer (int nbPoint)
	{
		double pointsX[] = new double[nbPoint];
		
		for(int i = 0; i < nbPoint ; i++)
		{
			pointsX[i] = 5*Math.cos(((double)((2*(i+1)) - 1)/(double)(2*nbPoint)) * Math.PI);
			System.out.println("point tchebycheff " + i + " : " + pointsX[i]);
		}

		return pointsX;
	}
}
