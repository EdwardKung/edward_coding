package dataStruture;

import java.util.ArrayList;

public class Set {

 protected ArrayList<ArrayList<NodeInterface>> data=new ArrayList<ArrayList<NodeInterface>>();
 protected int[] dataType;
 public String tableName;
 protected String[] title;
 protected int index;
 
 public void putTableName(String input){
		this.tableName=input;
	}
	public String getTableName(){
		return this.tableName;
	}
public NodeInterface get(int i,int j)
{
	return (NodeInterface) data.get(i).get(j);
}

public int getType(int input)
{
	return dataType[input];
}
public int[] getTypeArray(){
	
	return dataType;
}
public String getTitle(int input)
{
	return title[input];
}
public String[] getTitleArray()
{
	return this.title;
}

public void putTitle(String[] input)
{
	this.title=input;
}

public void putIndex(int input){
	this.index=input;
}
public int getAttribtueNum(){
	return dataType.length;
}
public NodeInterface getNodeType(int dataType){
	switch (dataType){
	case 1:
		return new CategoricalNode();
	case 0:
		return new NumericalNode();
	default:
		return new CategoricalNode();
	}
	
}

public int getIndex(){
	return this.index;
}
}
