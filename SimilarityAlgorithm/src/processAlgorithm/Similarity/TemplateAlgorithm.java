package processAlgorithm.Similarity;

import java.text.NumberFormat;
import java.util.Iterator;
import java.util.TreeMap;

import normalization.DISCNormalization;
import normalization.normalizationInterface;

import statistic.RMSE;
import typeSimilalrityFormula.DISCForCategorical;
import typeSimilalrityFormula.DISCForNumerical;
import typeSimilalrityFormula.FormulaInterface;

import dataStruture.DataSet;
import dataStruture.Matrix;

public abstract class TemplateAlgorithm extends SimilarityProcess {
	TreeMap<Integer,Matrix> categoricalSimilarity = null;
	FormulaInterface similarityFormula = null;
	TreeMap<Integer, Matrix> outPutSimilarity=new TreeMap<Integer,Matrix>();
	
	public abstract FormulaInterface getCategoricalFormula();
	public abstract FormulaInterface getNumericalFormula();
	public abstract normalizationInterface getNormalization();
	

	public TreeMap processAlgorithm() {
		// TODO Auto-generated method stub
		
		
		//build the initial matrix for categorical value\
		initialMatrix();
		
		//for(int training=0;training <3;training++)
	
	
		trainLearning();
		
		setResult();
		
		
		
		
		
		
		return outPutSimilarity;
	}
	protected void setResult() {
		// TODO Auto-generated method stub
Iterator it= categoricalSimilarity.keySet().iterator();
		
		for(int i=0;i<categoricalSimilarity.keySet().size();i++)
		{
			Integer keyValue=(Integer) it.next();
			
			outPutSimilarity.put(keyValue, categoricalSimilarity.get(keyValue).reverseMatrix());
		}
	}
	protected void trainLearning() {
		// TODO Auto-generated method stub
		for(int targetIndex=0;targetIndex<this.data.getAttribtueNum();targetIndex++)
		{
			
			if(this.data.getType(targetIndex)==9 || this.data.getType(targetIndex)==0) continue;//Ignored this attribute
			
			String[] categoricalValue= categoricalSimilarity.get(targetIndex).getTitleArray();
			TreeMap<Integer,Matrix>  tmpResult= new TreeMap<Integer,Matrix>();
			System.out.println("這是第"+(targetIndex+1)+"個維度");
			
			for(int compareIndex=0;compareIndex<this.data.getAttribtueNum();compareIndex++)
			{		
				
					if(this.data.getType(compareIndex)==9|| targetIndex==compareIndex)continue;//Ignored this attribute
					System.out.println("這是第"+(compareIndex+1)+"個比較維度:"+this.data.getTitle(compareIndex));
					Matrix tmpMatrix =new Matrix(categoricalValue.length);
					tmpMatrix.putTitle(categoricalValue);
					tmpMatrix.initialSimilairty();
					if(this.data.getType(compareIndex)==1)similarityFormula=getCategoricalFormula();// new DISCForCategorical(categoricalSimilarity);
					else if(this.data.getType(compareIndex)==0) similarityFormula=getNumericalFormula();//new DISCForNumerical();
					
					
					for(int i=0;i<categoricalValue.length-1;i++)
						for(int j =i+1;j<categoricalValue.length;j++)
						{
							tmpMatrix.putI(i, j, similarityFormula.getSimilarityExecute(data, targetIndex, compareIndex, categoricalValue[i], categoricalValue[j]));
							
						}
					
					//print test value
					
					NumberFormat nf = NumberFormat.getInstance();
					nf.setMaximumFractionDigits( 4 ); 
					for(int i=0;i<categoricalValue.length;i++)
						{for(int j =0;j<categoricalValue.length;j++)
						{
							System.out.print(nf.format(tmpMatrix.get(i,j).get())+"\t");
							
						}
						System.out.print("\n");
						}
					
					//
				
				tmpResult.put(compareIndex, tmpMatrix);
			}
			
			//11仍然在target迴圈內
			
			
			
			Matrix result=getNormalization().execute(tmpResult,categoricalValue);//new DISCNormalization().exectue(tmpResult, categoricalValue);
		
			result.putTableName(this.data.getTableName()+"_"+this.data.getTitle(targetIndex));
			System.out.println(this.data.getTitle(targetIndex)+" : "+new RMSE(result).get());
			categoricalSimilarity.put(targetIndex,result);
			
			
			
		
			
			//11end
		}
	}
	protected void initialMatrix() {
		// TODO Auto-generated method stub
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
	}

	
}
