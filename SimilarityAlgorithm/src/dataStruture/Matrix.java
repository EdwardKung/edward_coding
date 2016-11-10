package dataStruture;

import java.util.ArrayList;

public class Matrix extends Set {
	int matrixSize = 0;
	
	public Matrix (int input){
		
		this.dataType = new int[input];
		for(int i=0;i<input;i++)
			this.dataType[i]=0;
		matrixSize = this.getAttribtueNum();
		createMatrix();
			
	}

	public void createMatrix(){
	
		
		for(int i=0;i<matrixSize;i++)
		{	ArrayList<NodeInterface> node= new ArrayList<NodeInterface>();
			for(int j=0;j<matrixSize;j++)
				node.add(this.getNodeType(dataType[j]));
			
			
			this.data.add(node);
		}
		
	}
	public void initialAllZero(){
		for(int i=0;i< matrixSize;i++)
			for(int j=0;j< matrixSize;j++)
			{
				
				 put(i,j,0f);
			}
	}
	public void initialSimilairty(){
		
		for(int i=0;i< matrixSize;i++)
			for(int j=0;j< matrixSize;j++)
			{
				if(i==j) put(i,j,1f);
				else put(i,j,0f);
			}
		
	}
	public NodeInterface getSimilarity(String A1, String A2)
	{
		int x=-99;
		int y=-99;
		for(int i=0;i<matrixSize;i++)
			{if(this.getTitle(i).equals(A1))x=i;
			if (this.getTitle(i).equals(A2))y=i;}
		
		return this.get(x, y);
	}
	/**
	 * �N�Ȱ��Z���P�ۦ��ת��ഫ�A�e���O�n���W�ƨ�0-1����
	 * @return Matrix
	 */
	public Matrix reverseMatrix(){
		for(int i=0;i<matrixSize;i++)
			for(int j=0;j<matrixSize;j++)
				put(i,j, (Float)(1-(Float)this.get(i, j).get()));
				
		return this;
	}
	
	
	/**
	 * ��ٯx�����x�s
	 * @param i
	 * @param j
	 * @param input
	 */
	public void putI(int i,int j, Float input)
	{
		
		this.get(i, j).put(input);
		this.get(j, i).put(input);
	}
	public void put(int i,int j, Float input)
	{
		
		this.get(i, j).put(input);
		
	}
}
