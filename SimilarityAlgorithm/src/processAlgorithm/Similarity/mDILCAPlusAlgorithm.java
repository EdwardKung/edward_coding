package processAlgorithm.Similarity;

import normalization.DISCNormalization;
import normalization.normalizationInterface;
import typeSimilalrityFormula.DILCAForCategorical;
import typeSimilalrityFormula.DISCForNumerical;
import typeSimilalrityFormula.FormulaInterface;
import typeSimilalrityFormula.mDILCAForCategorical;

public class mDILCAPlusAlgorithm extends TemplateAlgorithm {

	@Override
	public FormulaInterface getCategoricalFormula() {
		// TODO Auto-generated method stub
		return new mDILCAForCategorical();
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
