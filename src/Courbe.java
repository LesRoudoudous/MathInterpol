
public class Courbe {
	protected String name;
	protected double values[][];
	
	public Courbe(String _name)
	{
		name = _name;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String _name)
	{
		 name = _name;
	}
	
	public void setValues(double _values[][])
	{
		values = _values;
	}
	
	public double[][] getValues()
	{
		return values;
	}
	
}
