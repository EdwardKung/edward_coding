package typeSimilalrityFormula;

import dataStruture.DataSet;

public interface FormulaInterface {
	/**
	 * 
	 * @param input  原始資料
	 * @param targetIndex 目標維度
	 * @param compareIndex 被比較維度
	 * @return
	 */
	//public Float execute(DataSet input,int targetIndex,int compareIndex,String A1, String A2);
	public Float getDistanceExecute(DataSet input,int targetIndex,int compareIndex,String A1, String A2);
	public Float getSimilarityExecute(DataSet input,int targetIndex,int compareIndex,String A1, String A2);
}
