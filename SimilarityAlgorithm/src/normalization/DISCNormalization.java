package normalization;

import java.util.Iterator;
import java.util.TreeMap;



import dataStruture.Matrix;

public class DISCNormalization implements normalizationInterface {

	@Override
	public Matrix execute(TreeMap input, String[] categoricalArray) {
		// TODO Auto-generated method stub
		int[] setArray=new int[input.keySet().size()];//將集合轉換成陣列使用
		Iterator treeKeySet = input.keySet().iterator();
		Matrix resultMatrix = new Matrix(categoricalArray.length);
		resultMatrix.initialAllZero();
		resultMatrix.putTitle(categoricalArray);
		
		for(int i=0;i<input.keySet().size();i++)
		{
			setArray[i]=(int)treeKeySet.next();
		}
		
		for(int iterator=0;iterator<setArray.length;iterator++)
		{
			Matrix iteratorMatrix = (Matrix) input.get(setArray[iterator]);
			for(int i=0;i<iteratorMatrix.getAttribtueNum();i++)
				for(int j=0;j<iteratorMatrix.getAttribtueNum();j++)
				{
					//System.out.println(i+" "+j+" "+(Float)iteratorMatrix.get(i, j).get());
					resultMatrix.put(i, j, (Float)resultMatrix.get(i, j).get()+(Float)iteratorMatrix.get(i, j).get()) ;
				
				}
			
			//System.out.println();
		}
		
		
		for(int i=0;i<resultMatrix.getAttribtueNum();i++)
			for(int j=0;j<resultMatrix.getAttribtueNum();j++)
				resultMatrix.put(i, j, (Float)((Float)resultMatrix.get(i, j).get()/setArray.length)) ;
		
		return resultMatrix;
	}

}
