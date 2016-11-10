package dataStruture;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeMap;
import java.util.TreeSet;

import javax.swing.text.html.HTMLDocument.Iterator;

public class DataSet extends Set {

	
/**
 * 
 * @param m 維度
 * @param n 型態
 */
public DataSet(int m, int n){
	dataType= new int[m];
	
	for(int i=0;i<dataType.length;i++){
		dataType[i]=n;
		
		
	}
}

public DataSet(int[] input){
	
	dataType=input;
	
}

public void addRecord(String[] input){
	ArrayList<NodeInterface> record= new ArrayList<NodeInterface>();
	
	for(int i=0;i<input.length;i++)
		{
			NodeInterface node = this.getNodeType(dataType[i]);
			node.put(input[i]);
			record.add(node);
		}
	data.add(record);
}

public void addRecord(ArrayList<NodeInterface> input)
{
	data.add(input);
}
public int getDataCount(){
	return data.size();
}
public TreeSet<String> getAttribtueSet(int inputIndex){
	TreeSet<String> result= new TreeSet<String>();

	for(int i=0;i<getDataCount();i++)
		{result.add((String)this.get(i, inputIndex).get());
		
		}
	return result;
}

/**
 * P(target|compare)
 * @param targetIndex
 * @param compareIndex
 * @param targetValue
 * @param compareValue
 * @return
 */




/**
 * 
 * @param targetIndex 計算該維度下的最大最小值
 * @return Float[]{max,min}
 */
public Float[] getMaxAndMin(int targetIndex){
	Float max=null;
	Float min=null;
	for(int i=0;i<getDataCount();i++)
	{
		if(max==null || ((Float)get(i,targetIndex).get() > max)) max=(Float)get(i,targetIndex).get();
		if(min==null || ((Float)get(i,targetIndex).get() <min)) min=(Float)get(i,targetIndex).get();
	}
	
	return new Float[]{max,min};
	
	
}
/*
public int getCountAtAttribtue(int targetIndex,String value)
{	int result=0;
	
	for(int i=0;i<this.getDataCount();i++)
		if(this.get(i,targetIndex).get().equals(value) )result++;
	return result;
	
}
*/
/**
 * 輸入的inputvalue，是以這些值當計算的索引!!
 * @param inputIndex
 * @param inputValue
 * @return
 */
public TreeMap<String,Integer> getCountAtAttribtue(int inputIndex,String[] inputValue){
	TreeMap<String,Integer> result =new TreeMap<String,Integer>();
	
	for(int i=0;i<inputValue.length;i++)
		result.put(inputValue[i], 0);

	for(int i=0; i< this.getDataCount();i++)
		result.put((String) this.get(i,inputIndex).get(), (result.get((String)this.get(i,inputIndex).get())+1));
	
	
	
	return result;
	
}
public ArrayList<NodeInterface> getRecord(int i){
	return this.data.get(i);	
}
/**
 * 
 * @return true=無空值，false=有空值
 */
public boolean chkMissingValue(){
	for(int i=0;i<this.getDataCount();i++)
		for(int j=0;j<this.getAttribtueNum();j++)
		{
			if( this.get(i, j).get()==null) 
				{System.out.println("有空值!!"); return false;}
			
			
		}
	
	System.out.println("無空值");
	return true;
}

public void removeMissValue()
{
	System.out.println("執行去空值功能!!原始資料為:"+getDataCount());
	for(int i=getDataCount()-1;i>=0;i--)
		for(int j=0;j< this.getAttribtueNum();j++)
		{
			if(this.get(i, j).get()==null) {this.data.remove(i);break;}
		}
	
	System.out.println("執行完畢，現有資料為:"+getDataCount());
}

public String[] setToArray(TreeSet<String>input){
	int size=input.size();
	String[] result=new String[size];
	int tmpCount=0;
	
	for(String a:input)
	{
		result[tmpCount]=a;
		tmpCount++;
	}
	return result;
	
}
}
