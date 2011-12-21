import javax.swing.JFrame;


public class FenetreGraphe extends JFrame 
{
	protected Graphe graphe;
	protected Courbe courbeInitiale;
	protected Courbe newtonCourbe;
	protected Courbe erreurNewtonCourbe;
	protected Courbe persoCourbe;
	protected Courbe tchebycheffCourbe;
	protected Courbe erreurTchebycheffCourbe;
	protected Courbe splineCourbe;
	protected Courbe erreurSplineCourbe;
	protected Newton newton;
	protected Tchebycheff tchebycheff;
	protected SplineCubique spline;
	protected double points[][];
	
	public FenetreGraphe(int width, int height)
	{
		setSize(width,height);
		setResizable(false);
		setVisible(true);
		
		newton = new Newton();
		tchebycheff = new Tchebycheff();
		spline = new SplineCubique();
		
		Outils outils = new Outils(this,0,height-150,width,150);
		add(outils);
		
		graphe = new Graphe(0,0,width,height - 150);
		
		courbeInitiale = new Courbe("Initial");
		newtonCourbe = new Courbe("Newton");
		persoCourbe = new Courbe("Perso");
		tchebycheffCourbe = new Courbe("Tchebycheff");
		splineCourbe = new Courbe("Spline");
		erreurNewtonCourbe = new Courbe("Erreur N");
		erreurTchebycheffCourbe = new Courbe("Erreur T");
		erreurSplineCourbe = new Courbe("Erreur S");
		
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
		graphe.removeCourbe(newtonCourbe);
		graphe.removeCourbe(erreurNewtonCourbe);
		removeGraphe();
		addGraphe(graphe);
	}
	
	public void addNewtonCourbe(int nbPoint)
	{
		
		graphe.removeCourbe(newtonCourbe);
		graphe.removeCourbe(erreurNewtonCourbe);
		
		double newtonPoints[][] = new double[2][nbPoint];
		
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
		erreurNewtonCourbe.setValues(newton.erreur(courbeInitiale.getValues(), newtonCourbe.getValues()));
		graphe.addCourbe(newtonCourbe);
		graphe.addCourbe(erreurNewtonCourbe);
		removeGraphe();
		addGraphe(graphe);
		
	}
	
	public void removePersoCourbe()
	{
		graphe.removeCourbe(persoCourbe);
		removeGraphe();
		addGraphe(graphe);
	}
	
	public void addPersoCourbe(double points[][])
	{
		graphe.removeCourbe(persoCourbe);
		persoCourbe.setValues(newton.Calculer(points));
		graphe.addCourbe(persoCourbe);
		removeGraphe();
		addGraphe(graphe);
	}
	
	public void removeTchebycheffCourbe()
	{
		graphe.removeCourbe(tchebycheffCourbe);
		graphe.removeCourbe(erreurTchebycheffCourbe);
		removeGraphe();
		addGraphe(graphe);
	}
	
	public void addTchebycheffCourbe(int nbPoints)
	{
		graphe.removeCourbe(tchebycheffCourbe);
		graphe.removeCourbe(erreurTchebycheffCourbe);
		
		double pointsTche[] = tchebycheff.Calculer(nbPoints);
		double values[][] = new double[2][nbPoints];
		
		for( int i = 0 ; i < pointsTche.length; i++)
		{
			double x = pointsTche[i];
			
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
			
			System.out.println("points " + i + " : " + x + " ; " + values[1][i]);
			
		}
		
		tchebycheffCourbe.setValues(newton.Calculer(values));
		erreurTchebycheffCourbe.setValues(newton.erreur(courbeInitiale.getValues(), tchebycheffCourbe.getValues()));
		graphe.addCourbe(tchebycheffCourbe);
		graphe.addCourbe(erreurTchebycheffCourbe);
		removeGraphe();
		addGraphe(graphe);
	}
	
	public void removeSplineCourbe()
	{
		graphe.removeCourbe(erreurSplineCourbe);
		graphe.removeCourbe(splineCourbe);
		removeGraphe();
		addGraphe(graphe);
	}
	
	public void addSplineCourbe(int nbPoints)
	{
		graphe.removeCourbe(erreurSplineCourbe);
		graphe.removeCourbe(splineCourbe);
		
		double splinePoints[][] = new double[2][nbPoints];
		
		int j = 0;
		for(int i = 0 ; i < points[0].length; i++)
		{
			if(i%(20/(nbPoints-1)) == 0)
			{
				splinePoints[0][j] = points[0][i];
				splinePoints[1][j] = points[1][i];
				//System.out.println("points "+ i + " : [" + splinePoints[0][j] +";" + splinePoints[1][j] + "]");
				j++;
			}
		}
		
		splineCourbe.setValues(spline.Calculer(splinePoints));
		erreurSplineCourbe.setValues(newton.erreur(courbeInitiale.getValues(), splineCourbe.getValues()));
		graphe.addCourbe(splineCourbe);
		graphe.addCourbe(erreurSplineCourbe);
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
