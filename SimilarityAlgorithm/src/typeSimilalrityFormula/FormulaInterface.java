package typeSimilalrityFormula;

import dataStruture.DataSet;

public interface FormulaInterface {
	/**
	 * 
	 * @param input  ��l���
	 * @param targetIndex �ؼк���
	 * @param compareIndex �Q�������
	 * @return
	 */
	//public Float execute(DataSet input,int targetIndex,int compareIndex,String A1, String A2);
	public Float getDistanceExecute(DataSet input,int targetIndex,int compareIndex,String A1, String A2);
	public Float getSimilarityExecute(DataSet input,int targetIndex,int compareIndex,String A1, String A2);
}
