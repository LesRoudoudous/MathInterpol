
import java.util.ArrayList;


import  org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import  org.jfree.chart.JFreeChart;
import org.jfree.data.xy.DefaultXYDataset;
import org.jfree.chart.plot.PlotOrientation;

public class Graphe {

	protected ArrayList<Courbe> courbes;
	protected ChartPanel graphePanel;
	
	protected int x;
	protected int y;
	protected int width;
	protected int height;
	
	public Graphe(int _x, int _y, int _width, int _height)
	{
		courbes = new ArrayList<Courbe>();
		x = _x;
		y = _y;
		width = _width;
		height = _height;
	}
	
	public void addCourbe (Courbe courbe)
	{
		courbes.add(courbe);
	}
	
	public void removeCourbe (Courbe courbe)
	{
		courbes.remove(courbe);
	}
	
	public void tracer ()
	{
		DefaultXYDataset data = new DefaultXYDataset();
		
		for (int i = 0 ; i < courbes.size() ; i++)
		{
			Courbe c = courbes.get(i);
			//System.out.println(c.getName() + " " + c.getValues()[0][0]);
			data.addSeries(c.getName(), c.getValues());
		}
		
		JFreeChart chart=ChartFactory.createXYLineChart("Interpolation", "x", "y", data, PlotOrientation.VERTICAL, true, false, false);
		graphePanel = new ChartPanel(chart);
		graphePanel.setBounds(x,y,width,height);
	}
	
	public ChartPanel getPanel()
	{
		return graphePanel;
	}
	
}
