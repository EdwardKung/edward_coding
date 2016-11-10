package abstractFactory;



import java.io.IOException;
import java.util.Iterator;
import java.util.TreeMap;

import dataStruture.DataSet;
import dataStruture.Matrix;

import processAlgorithm.*;
import processAlgorithm.LinkageAlgorithm.*;
import processAlgorithm.Similarity.*;



public class DistanceHierarchy extends FatherFactory {
	
	
	private Algorithm linkageAlgorithm ;
	Algorithm similarityAgorithm;
	private String input,output;
	private DataSet data;
	
	TreeMap totalResult =null;
	public void setInput(String input){
		this.input=input;
	}
	public void setOutput(String output){
		this.output=output;
	}
	public void setLinkageAlgoritm(Algorithm linkageAlgorithm ){
		this.linkageAlgorithm=linkageAlgorithm;
	}
	public void setDataSetType(DataSet data)
	{
		this.data=data;
	}
	public void setSimilarityAlgorithm(Algorithm similarityAlgorithm)
	{
		this.similarityAgorithm=similarityAlgorithm;
	}
	
	public void start() {
		
		try {
		System.out.println("Start");
		processInterface test=getProcess(similarityAgorithm);
		
			test.putData(input, data);
	
		 totalResult=(TreeMap) test.processAlgorithm();
	
		
		test.printData(totalResult, output);
		
		
		Iterator it = totalResult.keySet().iterator();
		while(it.hasNext())
		{test=getProcess(linkageAlgorithm);
			test.putData(output, (Matrix) totalResult.get(it.next()));
		
			test.printData(test.processAlgorithm(), output);
		}
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("END");
	}
	
	@Override
	public processInterface getProcess(Algorithm input) {
		// TODO Auto-generated method stub
		switch(input)
		{
		case SingleLinkage: return new SingleLinkage();
		case AverageLinkage: return new AverageLinkage();
		case CompleteLinkage: return null;
		case DISC: return new DISCAlgorithm();
		case DILCA: return new DILCAPlusAlgorithm();
		case COFC: return new COFCAlgorithm();
		case OneOfK: return null;
		case mDILCA: return new mDILCAPlusAlgorithm();
		case DISC2: return new DISCAlgorithm(2);
		case DISC3: return new DISCAlgorithm(3);
		case DISC4: return new DISCAlgorithm(4);
		default: return null;
		}
		
	}
	

	
	
}
