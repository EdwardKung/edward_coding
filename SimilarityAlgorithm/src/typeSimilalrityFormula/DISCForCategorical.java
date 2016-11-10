package typeSimilalrityFormula;

import java.util.ArrayList;
import java.util.TreeMap;

import dataStruture.DataSet;
import dataStruture.Matrix;
import dataStruture.NodeInterface;

public class DISCForCategorical implements FormulaInterface {
	TreeMap<Integer,Matrix> preSimilarity;
	public DISCForCategorical(TreeMap<Integer,Matrix> preSimilarity){
		this.preSimilarity= preSimilarity;
	}
	@Override
	public Float getSimilarityExecute(DataSet input, int targetIndex, int compareIndex,
			String A1, String A2) {
		// TODO Auto-generated method stub
		
		Float numerator=0f;
		Float denominator=0f;
		DataSet setA1= new DataSet(input.getTypeArray());
		DataSet setA2= new DataSet(input.getTypeArray());
		ArrayList<Integer> A1CountList=new ArrayList<Integer>();
		ArrayList<Integer> A2CountList=new ArrayList<Integer>();
		
		String[] compareSet;
		
		
	
		
		
		
		for(int i=0;i<input.getDataCount();i++)
			if(input.get(i, targetIndex).get().equals(A1)) setA1.addRecord(input.getRecord(i));
			else if (input.get(i, targetIndex).get().equals(A2))setA2.addRecord(input.getRecord(i));
		
		compareSet=input.setToArray(input.getAttribtueSet(compareIndex));
		
		for(int i=0;i<compareSet.length;i++)
		{
			A1CountList.add(i, setA1.getCountAtAttribtue(compareIndex,compareSet).get( compareSet[i]));
			A2CountList.add(i,setA2.getCountAtAttribtue(compareIndex,compareSet).get( compareSet[i]));

		}
		
		
		
		for(int i=0;i<compareSet.length;i++)
		{
			for(int j=0;j<compareSet.length;j++)
			{
				
				numerator+=A1CountList.get(i)*A2CountList.get(j)*(Float)preSimilarity.get(compareIndex).getSimilarity(compareSet[i], compareSet[j]).get();
				
			}
		}
		
		denominator=normalVector(compareSet,A1CountList,compareIndex)*normalVector(compareSet,A2CountList,compareIndex);
		
		
		if(denominator==0f) return 0f;
		else return (Float) numerator/denominator;
		
		
	}
	
	public Float normalVector(String[] compareSet, ArrayList<Integer> input, int compareIndex){
		Float result=0f;
		for(int i=0;i<compareSet.length;i++)
		{
			for(int j=0;j<compareSet.length;j++)
			{
				result += input.get(i)*input.get(j)*(Float)preSimilarity.get(compareIndex).getSimilarity(compareSet[i], compareSet[j]).get();
				
			}
		}
		
		return (float) Math.sqrt(result);
		
	}
	@Override
	public Float getDistanceExecute(DataSet input, int targetIndex,
			int compareIndex, String A1, String A2) {
		// TODO Auto-generated method stub
		return (1-getSimilarityExecute(input,targetIndex,compareIndex,A1,A2));
	}



	}
	


