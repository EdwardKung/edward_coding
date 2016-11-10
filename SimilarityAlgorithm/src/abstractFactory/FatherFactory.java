package abstractFactory;

import processAlgorithm.processInterface;
import processAlgorithm.Similarity.AlgorithmSelection;

public abstract class FatherFactory implements AlgorithmSelection {
	public abstract processInterface getProcess(Algorithm input);


}
