
public class Main
{
	public static void main(String[] args)
	{
		FenetreGraphe fenetre = new FenetreGraphe();
		Graphe graphe = new Graphe();
		
		Courbe courbe = new Courbe("courbe 1");
		double values[][] =  new double[2][101];
		
		Double x = -5.0;
		for( int i = 0 ; x <= 5.0; i++,x+=0.1)
		{
			if(x < 0.0)
			{
				values[0][i] = x;
				values[1][i] = Math.exp(-Math.pow(x, 2));
			}
			else
			{
				values[0][i] = x;
				values[1][i] = Math.cos(x);
			}
		}
		
		courbe.setValues(values);
		
		graphe.addCourbe(courbe);
		
		fenetre.addGraphe(graphe);
	}
}
