package dataStruture;

public class CategoricalNode implements NodeInterface<String> {

	String value=null;
	@Override
	public String get() {
		// TODO Auto-generated method stub
		
		return value;
	}

	@Override
	public void put(String input) {
		// TODO Auto-generated method stub
		if(!input.equals("?"))
			value=input;
		else value=null;
	
		
	}

	@Override
	public void put(Float input) {
		// TODO Auto-generated method stub
		value=Float.toString(input);
	}



}
