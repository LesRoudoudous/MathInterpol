import javax.swing.JFrame;


public class FenetreGraphe extends JFrame 
{
	
	public FenetreGraphe()
	{
		setSize(600,600);
		setResizable(false);
		setVisible(true);
	}
	
	public void addGraphe(Graphe graphe)
	{
		graphe.tracer();
		add(graphe.getPanel());
		this.repaint();
	}
	
}
