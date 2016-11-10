package typeSimilalrityFormula;

import java.util.ArrayList;

import dataStruture.DataSet;
import dataStruture.NodeInterface;

public class DISCForNumerical implements FormulaInterface {

	@Override
	public Float getSimilarityExecute(DataSet input, int targetIndex, int compareIndex,
			String A1, String A2) {
		// TODO Auto-generated method stub
		Float result=0f;
		Float[] MaxMin= input.getMaxAndMin(compareIndex);
		
		result =1-(Math.abs(getAverage(input,targetIndex,compareIndex,A1)-getAverage(input,targetIndex,compareIndex,A2))/Math.abs(MaxMin[0]-MaxMin[1])); 
		
		return result;
	}

	public Float getAverage(DataSet input, int targetIndex,int compareIndex,String A1)
	{
		Float result=0f;
		ArrayList<NodeInterface> resultSet = new ArrayList<NodeInterface>();
		for(int i=0;i<input.getDataCount();i++)
			if(input.get(i, targetIndex).get().equals(A1)) resultSet.add(input.get(i, compareIndex));
		
		for(int i=0;i<resultSet.size();i++)
			result+=(Float) resultSet.get(i).get();
		
		result=result/resultSet.size();
		
		return result;
	}

	@Override
	public Float getDistanceExecute(DataSet input, int targetIndex,
			int compareIndex, String A1, String A2) {
		// TODO Auto-generated method stub
		return (1-getSimilarityExecute(input,targetIndex,compareIndex,A1,A2));
	}
	

}
