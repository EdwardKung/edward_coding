package typeSimilalrityFormula;

import java.util.TreeMap;

import dataStruture.DataSet;

public class mDILCAForCategorical implements FormulaInterface {

	@Override
	public Float getDistanceExecute(DataSet input, int targetIndex,
			int compareIndex, String A1, String A2) {
		// TODO Auto-generated method stub
		Float result =0f;
		String [] compareSet =input.setToArray(input.getAttribtueSet(compareIndex));
		String [] targetSet=input.setToArray(input.getAttribtueSet(targetIndex));
		
		DataSet A1Set = new DataSet(input.getTypeArray());
		DataSet A2Set=new DataSet(input.getTypeArray());
		
		
		for(int i=0;i<input.getDataCount();i++)
		{
			if(input.get(i, targetIndex).get().equals(A1))A1Set.addRecord(input.getRecord(i));
			else if(input.get(i, targetIndex).get().equals(A2))A2Set.addRecord(input.getRecord(i));
		}
		
		
		TreeMap<String,Integer> A1ConditionEvent =A1Set.getCountAtAttribtue(compareIndex, compareSet);
		TreeMap<String,Integer>A2ConditionEvent=A2Set.getCountAtAttribtue(compareIndex, compareSet);
		//System.out.print(A1Set.getDataCount());
			for(int j =0;j<compareSet.length;j++)
			{
				//System.out.println("A1:P("+A1+"|"+compareSet[j]+")="+A1ConditionEvent.get(compareSet[j])+"/"+compareAllEventCount.get(compareSet[j]));
				//System.out.println("A2:P("+A2+"|"+compareSet[j]+")="+A2ConditionEvent.get(compareSet[j])+"/"+compareAllEventCount.get(compareSet[j]));
				
				result+=(float)Math.pow((((float)A1ConditionEvent.get(compareSet[j])/A1Set.getDataCount())
								-((float)A2ConditionEvent.get(compareSet[j])/A2Set.getDataCount())), 2);
			}
		result=(float) Math.sqrt(result/compareSet.length);
		
			
		
		return result;
	}

	@Override
	public Float getSimilarityExecute(DataSet input, int targetIndex,
			int compareIndex, String A1, String A2) {
		// TODO Auto-generated method stub
		return (1-getDistanceExecute(input,targetIndex,compareIndex,A1,A2));
	}

}
