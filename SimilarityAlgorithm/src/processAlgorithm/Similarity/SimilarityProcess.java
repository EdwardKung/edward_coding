package processAlgorithm.Similarity;

import java.io.IOException;
import java.util.Iterator;
import java.util.TreeMap;

import processAlgorithm.processInterface;


import IO.CSVWriter;
import IO.DataSetReader;

import dataStruture.DataSet;
import dataStruture.Set;

public abstract class SimilarityProcess implements
		processInterface<TreeMap<String, Set>> {
	public DataSet data;
	@Override
	public void putData(String path, Set data) throws IOException {
		// TODO Auto-generated method stub
		 this.data= new DataSetReader(path, data).execute();
		 if(!this.data.chkMissingValue()) this.data.removeMissValue();//¥hmisingvalue
		 this.data.putTableName(path.substring(path.lastIndexOf("\\")+1, path.lastIndexOf(".")));
	}

	@Override
	public abstract  TreeMap<String, Set> processAlgorithm() ;

	@Override
	public void printData(TreeMap<String, Set> input, String path) throws IOException {
		// TODO Auto-generated method stub
		
		Iterator it= input.keySet().iterator();
		
		for(int i=0;i<input.keySet().size();i++)
			{  Integer keyValue=(Integer)it.next();
				String keyName= data.getTitle(keyValue);
			  new CSVWriter(path, this.data.getTableName()+"_"+keyName, (Set) input.get(keyValue)).execute();

			}
		
	}

}
