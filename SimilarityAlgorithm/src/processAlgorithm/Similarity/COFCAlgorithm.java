package processAlgorithm.Similarity;

import java.util.TreeMap;


import typeSimilalrityFormula.COFCForCategorical;

import dataStruture.Matrix;
import dataStruture.Set;

public class COFCAlgorithm extends SimilarityProcess {

	@Override
	public TreeMap processAlgorithm() {
		// TODO Auto-generated method stub
		TreeMap<Integer,Matrix> categoricalSimilarity = null;
		Integer compareIndex= this.data.getAttribtueNum()-1;
		//build the initial matrix for categorical value\
				if(categoricalSimilarity==null)
				{
					categoricalSimilarity=new TreeMap<Integer,Matrix>();
					for(int i=0; i<this.data.getAttribtueNum();i++)
						if(this.data.getType(i)==1)
						{	
							String[] categoricalArray= this.data.setToArray(this.data.getAttribtueSet(i));
						
							Matrix tmp= new Matrix(categoricalArray.length);
							//tmp.createMatrix();
							tmp.putTitle(categoricalArray);
						
							tmp.initialSimilairty();
							categoricalSimilarity.put(i, tmp);
					}
				
				}
				
			
				for(int targetIndex=0; targetIndex<this.data.getAttribtueNum();targetIndex++)
				{	
					if((this.data.getType(targetIndex)==9|| targetIndex==compareIndex)||this.data.getType(targetIndex)==0)continue;
					String[] categoricalValue= this.data.setToArray(this.data.getAttribtueSet(targetIndex));
					Matrix tmpMatrix =new Matrix(categoricalValue.length);
					tmpMatrix.putTitle(categoricalValue);
					tmpMatrix.initialSimilairty();
					tmpMatrix.reverseMatrix();
					for(int i=0;i<categoricalValue.length-1;i++)
						for(int j =i+1;j<categoricalValue.length;j++)
						{
							
							tmpMatrix.putI(i, j, new COFCForCategorical().getDistanceExecute(data, targetIndex, compareIndex, categoricalValue[i], categoricalValue[j]));
							
						}
					tmpMatrix.putTableName(this.data.getTableName()+"_"+this.data.getTitle(targetIndex));
					categoricalSimilarity.put(targetIndex, tmpMatrix);
				}
				
			//System.out.println(categoricalSimilarity);
		return categoricalSimilarity;
	}

}
