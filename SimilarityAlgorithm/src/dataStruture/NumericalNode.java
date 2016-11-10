package dataStruture;

public class NumericalNode implements NodeInterface<Float> {

	Float value= null;
	
	@Override
	public Float get() {
		// TODO Auto-generated method stub
		return value;
	}

	@Override
	public void put( String input)  {
		// TODO Auto-generated method stub
		try{
		value=Float.parseFloat(input);
		}catch( NumberFormatException e)
		{
			
			value=null;
		}
	
	}

	@Override
	public void put( Float input) {
		// TODO Auto-generated method stub
		value=input;
		
	}

	

}
