import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JPanel;


public class Outils extends JPanel implements ActionListener{
	
	protected JCheckBox cinqPointsCheck;
	protected JCheckBox onzePointsCheck;
	protected JCheckBox vingtEtUnPointsCheck;
	
	protected JCheckBox newtonCheck;
	protected JCheckBox TchebytchevCheck;
	
	protected FenetreGraphe fenetre;
	
	public Outils (FenetreGraphe _fenetre,int x, int y, int width, int height)
	{
		setBounds(x,y,width,height);
		//setBackground(Color.BLUE);
		
		fenetre = _fenetre;
		
		cinqPointsCheck = new JCheckBox("5 points");
		cinqPointsCheck.setBounds(0, 0, 200, 30);
		
		onzePointsCheck = new JCheckBox("11 points");
		onzePointsCheck.setBounds(0, 30, 200, 30);
		
		vingtEtUnPointsCheck = new JCheckBox("21 points");
		vingtEtUnPointsCheck.setBounds(0, 60, 200, 30);
		
		newtonCheck = new JCheckBox("Newton");
		newtonCheck.setBounds(200, 0, 200, 30);
		
		TchebytchevCheck = new JCheckBox("Tchebytchev");
		TchebytchevCheck.setBounds(200, 30, 200, 30);
	
		cinqPointsCheck.addActionListener(this);
		onzePointsCheck.addActionListener(this);
		vingtEtUnPointsCheck.addActionListener(this);
		newtonCheck.addActionListener(this);
		TchebytchevCheck.addActionListener(this);
		
		add(cinqPointsCheck);
		add(onzePointsCheck);
		add(vingtEtUnPointsCheck);
		add(newtonCheck);
		add(TchebytchevCheck);
	}
	
	public void actionPerformed(ActionEvent actionEvent) 
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
			}
			else if(checkBox == onzePointsCheck)
			{
				cinqPointsCheck.setSelected(false);
				vingtEtUnPointsCheck.setSelected(false);
				if(newtonCheck.isSelected())
					fenetre.addNewtonCourbe(11);
			}
			else if(checkBox == vingtEtUnPointsCheck)
			{
				onzePointsCheck.setSelected(false);
				cinqPointsCheck.setSelected(false);
				if(newtonCheck.isSelected())
					fenetre.addNewtonCourbe(21);
			}
			else if(checkBox == newtonCheck)
			{
				if(cinqPointsCheck.isSelected())
					fenetre.addNewtonCourbe(5);
				else if(onzePointsCheck.isSelected())
					fenetre.addNewtonCourbe(5);
				else if(vingtEtUnPointsCheck.isSelected())
					fenetre.addNewtonCourbe(5);
			}
		}
		else
		{
			if(checkBox == newtonCheck)
			{
				fenetre.removeNewtonCourbe();
			}
			else if (checkBox == TchebytchevCheck)
			{
				System.out.println("TchebytchevCheck");
			}
			else if(newtonCheck.isSelected())
			{
				fenetre.removeNewtonCourbe();
			}
			
		}
	}
	
}
