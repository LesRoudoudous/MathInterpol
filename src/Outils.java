import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.BadLocationException;


public class Outils extends JPanel implements ActionListener{
	
	protected JCheckBox cinqPointsCheck;
	protected JCheckBox onzePointsCheck;
	protected JCheckBox vingtEtUnPointsCheck;
	
	protected JCheckBox newtonCheck;
	protected JCheckBox TchebycheffCheck;
	
	protected JCheckBox persoCheck;
	protected JLabel xLabel;
	protected JLabel yLabel;
	protected JLabel pointsLabel;
	protected NumericTextField xField;
	protected NumericTextField yField;
	protected JTextArea pointsArea;
	protected JScrollPane scrollPane;
	protected JButton ajoutPointBtn;
	protected JButton supPointsBtn;
	protected JButton validerBtn;
	
	protected FenetreGraphe fenetre;
	
	public Outils (FenetreGraphe _fenetre,int x, int y, int width, int height)
	{
		setBounds(x,y,width,height);
		
		fenetre = _fenetre;
		
		cinqPointsCheck = new JCheckBox("5 points");
		onzePointsCheck = new JCheckBox("11 points");
		vingtEtUnPointsCheck = new JCheckBox("21 points");
		newtonCheck = new JCheckBox("Newton");
		TchebycheffCheck = new JCheckBox("Tchebycheff");
		persoCheck = new JCheckBox("Points Perso");
		xLabel = new JLabel("x :");
		yLabel = new JLabel("y :");
		pointsLabel = new JLabel("points :");
		xField = new NumericTextField();
		yField = new NumericTextField();
		pointsArea = new JTextArea();
		pointsArea.setEditable(false);
		scrollPane = new JScrollPane(pointsArea);
		ajoutPointBtn = new JButton("Ajouter");
		supPointsBtn = new JButton("Vider");
		validerBtn = new JButton("Valider");
	
		cinqPointsCheck.addActionListener(this);
		onzePointsCheck.addActionListener(this);
		vingtEtUnPointsCheck.addActionListener(this);
		newtonCheck.addActionListener(this);
		TchebycheffCheck.addActionListener(this);
		persoCheck.addActionListener(this);
		ajoutPointBtn.addActionListener(this);
		supPointsBtn.addActionListener(this);
		validerBtn.addActionListener(this);
		
		add(cinqPointsCheck);
		add(onzePointsCheck);
		add(vingtEtUnPointsCheck);
		add(newtonCheck);
		add(TchebycheffCheck);
		add(persoCheck);
		add(xField);
		add(yField);
		add(scrollPane);
		add(xLabel);
		add(yLabel);
		add(ajoutPointBtn);
		add(supPointsBtn);
		add(pointsLabel);
		add(validerBtn);
	}
	
	public void actionPerformed(ActionEvent actionEvent) 
	{
		if(actionEvent.getSource().getClass() == JCheckBox.class)
		{
			JCheckBox checkBox = (JCheckBox)actionEvent.getSource();
			if(checkBox.isSelected())
			{
				if(checkBox == cinqPointsCheck)
				{
					onzePointsCheck.setSelected(false);
					vingtEtUnPointsCheck.setSelected(false);
					if(newtonCheck.isSelected())
						fenetre.addNewtonCourbe(5);
					if(TchebycheffCheck.isSelected())
						fenetre.addTchebycheffCourbe(5);
				}
				else if(checkBox == onzePointsCheck)
				{
					cinqPointsCheck.setSelected(false);
					vingtEtUnPointsCheck.setSelected(false);
					if(newtonCheck.isSelected())
						fenetre.addNewtonCourbe(11);
					if(TchebycheffCheck.isSelected())
						fenetre.addTchebycheffCourbe(11);
				}
				else if(checkBox == vingtEtUnPointsCheck)
				{
					onzePointsCheck.setSelected(false);
					cinqPointsCheck.setSelected(false);
					if(newtonCheck.isSelected())
						fenetre.addNewtonCourbe(21);
					if(TchebycheffCheck.isSelected())
						fenetre.addTchebycheffCourbe(21);
				}
				else if(checkBox == newtonCheck)
				{
					if(cinqPointsCheck.isSelected())
						fenetre.addNewtonCourbe(5);
					else if(onzePointsCheck.isSelected())
						fenetre.addNewtonCourbe(11);
					else if(vingtEtUnPointsCheck.isSelected())
						fenetre.addNewtonCourbe(21);
				}
				else if(checkBox == TchebycheffCheck)
				{
					if(cinqPointsCheck.isSelected())
						fenetre.addTchebycheffCourbe(5);
					else if(onzePointsCheck.isSelected())
						fenetre.addTchebycheffCourbe(11);
					else if(vingtEtUnPointsCheck.isSelected())
						fenetre.addTchebycheffCourbe(21);
				}
				else if(checkBox == persoCheck)
				{
					addCourbePerso();
				}
			}
			else
			{
				if(checkBox == newtonCheck)
				{
					fenetre.removeNewtonCourbe();
				}
				else if(checkBox == persoCheck)
				{
					fenetre.removePersoCourbe();
				}
				else if (checkBox == TchebycheffCheck)
				{
					fenetre.removeTchebycheffCourbe();
				}
				else if(newtonCheck.isSelected())
				{
					fenetre.removeNewtonCourbe();
				}
				else if(TchebycheffCheck.isSelected())
				{
					fenetre.removeTchebycheffCourbe();
				}
			}
		}
		else
		{
			JButton btn = (JButton)actionEvent.getSource();
			if(btn == ajoutPointBtn)
			{
				if(!xField.getText().isEmpty() && !yField.getText().isEmpty())
				{
					pointsArea.append(xField.getText() + ";" + yField.getText() + "\n");
					xField.setText(null);
					yField.setText(null);
				}
			}
			else if(btn == validerBtn)
			{
				addCourbePerso();
			}
			else if(btn == supPointsBtn)
			{
				pointsArea.setText(null);
			}
		}
	}
	
	protected void addCourbePerso()
	{
		if(!pointsArea.getText().isEmpty() && persoCheck.isSelected())
		{
			int i = 0;
			double points[][] = new double[2][pointsArea.getLineCount()-1];
			for(String ligne : pointsArea.getText().split("\n"))
			{
				String values[] = ligne.split(";");
				NumberFormat myFormatter = NumberFormat.getInstance();
 		    	 try 
 		    	 {
 		    		points[0][i]  = myFormatter.parse(values[0]).doubleValue();
 		    		points[1][i]  = myFormatter.parse(values[1]).doubleValue();
 		    		i++;

 		    	 } catch (ParseException e) {
 		    		 e.printStackTrace();
 		    	 }
			}
			fenetre.addPersoCourbe(points);
		}
	}
	
	public void paint (Graphics g) {
	    super.paint(g);
	    setBounds(0,400,610,150);
		cinqPointsCheck.setBounds(0, 0, 150, 30);
		onzePointsCheck.setBounds(0, 30, 150, 30);
		vingtEtUnPointsCheck.setBounds(0, 60, 150, 30);
		newtonCheck.setBounds(150, 0, 150, 30);
		TchebycheffCheck.setBounds(150, 30, 150, 30);
		persoCheck.setBounds(300, 0, 150, 30);
		xField.setBounds(340, 30, 80, 30);
		yField.setBounds(440, 30, 80, 30);
		scrollPane.setBounds(375,65,140,55);
		xLabel.setBounds(320, 30, 20, 30);
		yLabel.setBounds(420, 30, 20, 30);
		ajoutPointBtn.setBounds(525,35,75,20);
		supPointsBtn.setBounds(525,95,75,20);
		pointsLabel.setBounds(320, 60, 50, 30);
		validerBtn.setBounds(525,65,75,20);
	 }
	
}
