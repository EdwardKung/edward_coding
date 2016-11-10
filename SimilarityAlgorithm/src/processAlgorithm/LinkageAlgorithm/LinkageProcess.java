package processAlgorithm.LinkageAlgorithm;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import processAlgorithm.processInterface;

import com.csvreader.CsvReader;



import IO.CSVWriter;
import IO.MatrixReader;

import dataStruture.Matrix;
import dataStruture.Set;
import dataStruture.TreeNode;

public abstract class LinkageProcess implements processInterface<TreeNode> {
	 protected Matrix data;
	
	@Override
	public void putData(String input, Set data) throws IOException {
		// TODO Auto-generated method stub
		
		// this.data=new MatrixReader(input,(Matrix)data).execute();
		this.data=(Matrix)data;
		
	}

	
	public abstract HashMap<String, Float> chkCombine(ArrayList<ArrayList<Integer>> input);
	
	public TreeNode processAlgorithm(){
		ArrayList<ArrayList<Integer>> stateNo= new ArrayList<ArrayList<Integer>>();
		ArrayList<TreeNode> stateTree=new ArrayList<TreeNode>();
		
		int size= this.data.getAttribtueNum();
		//初始化
		for(int i=0;i<size;i++)
		{
			ArrayList<Integer> sub= new ArrayList<Integer>();
			sub.add(i);
			stateNo.add(sub);
			stateTree.add(new TreeNode(i,0f));
		}
		//走訪與合併
		
	do{
		HashMap<String,Float> stateRecord=new HashMap<String,Float>();
		ArrayList<Integer> sub= new ArrayList<Integer>();
		
		//these records critical(if the critical is supported return True) ,i,j,distance four values.
		stateRecord=chkCombine(stateNo);
		
		if(stateRecord.get("critical")==1f)
		{	
			
			int compare1=(int)((float)stateRecord.get("i"));
			int compare2=(int)((float)stateRecord.get("j"));
			if(compare1<compare2){
				int tmp=compare1;
				compare1=compare2;
				compare2=tmp;
			}

			sub.addAll(stateNo.get(compare1));
			sub.addAll(stateNo.get(compare2));
							
			stateNo.remove(stateNo.get(compare1));
			stateNo.remove(stateNo.get(compare2));
			stateNo.add(sub);
			
			stateTree.add(new TreeNode(stateRecord.get("distance")).combine(stateTree.get(compare1), stateTree.get(compare2)));
			stateTree.remove(stateTree.get(compare1));
			stateTree.remove(stateTree.get(compare2));
			
		}
			
			
		System.out.println(stateNo);
	//	System.out.println(stateRecord.get("distance"));
		
		
	}while(stateNo.size()>1 );
	
		return stateTree.get(0);
	}
	@Override
	public void printData(TreeNode input, String path) throws IOException {
		// TODO Auto-generated method stub
		
		
		new CSVWriter(path, data.getTableName()+"_CPM", CPM(input)).execute();
		
		
	}
	
		
	
	public Matrix CPM(TreeNode input){
		float maxDist= input.value;
		int size=data.getAttribtueNum();
		Matrix newOutput = new Matrix(size);
		newOutput.initialAllZero();
		newOutput.putTitle(data.getTitleArray());
		
		if(maxDist!=0)
		for(int i=0;i<size;i++)
			for(int j = i;j<size;j++)
			{
				try{
					newOutput.putI(i, j, (float) ((float)((maxDist -input.findComon(i, j).value)/maxDist)*0.5));

				}catch(java.lang.NullPointerException e){
					System.out.println("ERROR at CPM!");
					
				}
				
			}
		else
			for(int i=0;i<size;i++)
			{
				for(int j = i;j<size;j++)
					newOutput.putI(i, j, 0f);
				
				newOutput.put(i, i, 0.5f);
				
			}
		return newOutput;
	}
	
	
	
	}


