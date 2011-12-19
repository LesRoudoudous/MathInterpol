import javax.swing.JFrame;


public class FenetreGraphe extends JFrame 
{
	protected Graphe graphe;
	protected Courbe courbeInitiale;
	protected Courbe newtonCourbe;
	protected Newton newton;
	protected double points[][];
	
	public FenetreGraphe(int width, int height)
	{
		setSize(width,height);
		setResizable(false);
		setVisible(true);
		
		newton = new Newton();
		
		Outils outils = new Outils(this,0,height-115,width,115);
		add(outils);
		
		graphe = new Graphe(0,0,width,height - 115);
		
		courbeInitiale = new Courbe("Initial");
		
		double values[][] =  new double[2][101];
		points =  new double[2][21];
		
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
			
			if(i%5 == 0){
				
				points[0][j] = values[0][i];
				points[1][j] = values[1][i];
				
				System.out.println("points "+ i + " : [" + points[0][j] +";" + points[1][j] + "]");
				j++;
			}
		}
		
		courbeInitiale.setValues(values);
		
		 
		//courbe2.setValues(MonNewton.Calculer(points));
		
		graphe.addCourbe(courbeInitiale);
		//graphe.addCourbe(courbe2);
		
		addGraphe(graphe);
	}
	
	public void removeNewtonCourbe()
	{
		System.out.println("2");
		graphe.removeCourbe(newtonCourbe);
		removeGraphe();
		addGraphe(graphe);
	}
	
	public void addNewtonCourbe(int nbPoint)
	{
		
		graphe.removeCourbe(newtonCourbe);
		
		double newtonPoints[][] = new double[2][nbPoint];
		newtonCourbe = new Courbe("Newton");
		
		int j = 0;
		for(int i = 0 ; i < points[0].length; i++)
		{
			if(i%(20/(nbPoint-1)) == 0)
			{
				newtonPoints[0][j] = points[0][i];
				newtonPoints[1][j] = points[1][i];
				System.out.println("points "+ i + " : [" + newtonPoints[0][j] +";" + newtonPoints[1][j] + "]");
				j++;
			}
		}
		
		newtonCourbe.setValues(newton.Calculer(newtonPoints));
		graphe.addCourbe(newtonCourbe);
		removeGraphe();
		addGraphe(graphe);
		
	}
	
	public void removeGraphe()
	{
		remove(graphe.getPanel());
	}
	
	public void addGraphe(Graphe graphe)
	{
		graphe.tracer();
		add(graphe.getPanel());
		this.repaint();
	}
	
}
