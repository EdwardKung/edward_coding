package dataStruture;



public class TreeNode {

	public TreeNode parent;
	public float value;
	public int keyValue;
	public TreeNode left=null;
	public TreeNode right=null;
	public int level;
	public TreeNode testTreeNode=null;
	public TreeNode(int key,float value){
		
		this.value=value;
		this.keyValue=key;
		this.level=0;
		this.parent=this;
		
	};
	public TreeNode(float value){
		
		this.value=value;
		this.keyValue=-1;
		this.level=0;
		
	};
	
	public TreeNode combine(TreeNode t1, TreeNode t2){
		int big;
		this.left=t1;
		this.right=t2;
		t1.parent=this;
		t2.parent=this;
		if(t1.level<t2.level)big=t2.level; else big=t1.level;
		this.level=big+1;
		return this;
	}
	
	public TreeNode findComon(int k1, int k2){
		int flag=1;
		
		TreeNode input= this;
		inorder(input,k1);
		TreeNode t1=testTreeNode;
		inorder(input,k2);
		TreeNode t2=testTreeNode;
		if(k1!=k2){
		while(flag==1)
		{
			if ((t1.level==t2.level && t1.value!=t2.value)||(t1.value==0 && t2.value==0)){t1=t1.parent;t2=t2.parent;}
			if(t1.level<t2.level)t1=t1.parent;
			else if(t1.level>t2.level)t2=t2.parent;
			
			if(t1.value==t2.value) flag=0;
		}
		}
		return t1;
	}

	
	public void inorder(TreeNode input,int key)
	{
		if(input!= null) {  
	        inorder(input.left,key);    /*¨«³X¥ª¤l¾ð*/  
	      if(input.keyValue==key)testTreeNode =input; /*¨«³X¦C¦L¾ð®Ú*/  
	        inorder(input.right,key);  /*¨«³X¥k¤l¾ð*/  
	    }  
	}
	
}