
import java.util.ArrayList;


import  org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import  org.jfree.chart.JFreeChart;
import org.jfree.data.xy.DefaultXYDataset;
import org.jfree.chart.plot.PlotOrientation;

public class Graphe {

	protected ArrayList<Courbe> courbes;
	protected ChartPanel graphePanel;
	
	public Graphe()
	{
		courbes = new ArrayList<Courbe>();
	}
	
	public void addCourbe (Courbe courbe)
	{
		courbes.add(courbe);
	}
	
	public void tracer ()
	{
		DefaultXYDataset data = new DefaultXYDataset();
		
		for (int i = 0 ; i < courbes.size() ; i++)
		{
			Courbe c = courbes.get(i);
			System.out.println(c.getName() + " " + c.getValues()[0][0]);
			data.addSeries(c.getName(), c.getValues());
		}
		
		JFreeChart chart=ChartFactory.createXYLineChart("XYLineChart", "x", "y", data, PlotOrientation.VERTICAL, true, false, false);
		graphePanel = new ChartPanel(chart);		
		graphePanel.setSize(600,400);
	}
	
	public ChartPanel getPanel()
	{
		return graphePanel;
	}
	
}
