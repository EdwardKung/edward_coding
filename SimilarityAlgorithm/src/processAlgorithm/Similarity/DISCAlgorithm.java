package processAlgorithm.Similarity;

import java.util.TreeMap;

import normalization.DISCNormalization;
import normalization.normalizationInterface;
import typeSimilalrityFormula.DISCForCategorical;
import typeSimilalrityFormula.DISCForNumerical;
import typeSimilalrityFormula.FormulaInterface;

public class DISCAlgorithm extends TemplateAlgorithm {

	Integer iteration =1;
	public DISCAlgorithm(int input){
		this.iteration=input;
	}
	public DISCAlgorithm(){}
	public TreeMap processAlgorithm(){
		this.initialMatrix();
		
		for(int i=0;i<this.iteration;i++)
		{
			this.trainLearning();
		}
		
		this.setResult();
		return outPutSimilarity;
		
	}
	@Override
	public FormulaInterface getCategoricalFormula() {
		// TODO Auto-generated method stub
		return new DISCForCategorical(categoricalSimilarity);
	}

	@Override
	public FormulaInterface getNumericalFormula() {
		// TODO Auto-generated method stub
		return new DISCForNumerical();
	}

	@Override
	public normalizationInterface getNormalization() {
		// TODO Auto-generated method stub
		return new DISCNormalization();
	}
	
	

}
