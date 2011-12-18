
public class Main
{
	public static void main(String[] args)
	{
		FenetreGraphe fenetre = new FenetreGraphe();
		Graphe graphe = new Graphe();
		
		Courbe courbe = new Courbe("courbe 1");
		Courbe courbe2 = new Courbe("courbe 2");
		double values[][] =  new double[2][101];
		double points[][] =  new double[2][5];
		
		int j = 0;
		
		Double x = -5.0;
		for( int i = 0 ; x <= 5.0; i++,x += 0.1)
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
			
			System.out.println(x);
			if((int)(x * 10)%25 == 0){
				
				points[0][j] = values[0][i];
				points[1][j] = values[1][i];
				
				System.out.println("points[0][j] - "+ points[0][j] +"  " + "points[i][j] - "+ points[1][j] );
				j++;
			}
		}
		
		courbe.setValues(values);
		
		
		
		Newton MonNewton = new Newton();
		courbe2.setValues(MonNewton.Calculer(points));
		
		graphe.addCourbe(courbe);
		graphe.addCourbe(courbe2);
		fenetre.addGraphe(graphe);
	}
}
