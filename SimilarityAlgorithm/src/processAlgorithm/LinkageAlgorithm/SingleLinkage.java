package processAlgorithm.LinkageAlgorithm;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;

public class SingleLinkage extends LinkageProcess {
	Float lowestMin=null;
	@Override
	public HashMap<String, Float> chkCombine(
			ArrayList<ArrayList<Integer>> input) {
		// TODO Auto-generated method stub
		Float nowMin=null;
		Point nowPosition = null;
		HashMap<String,Float> record=new HashMap<String,Float>();
		for(int i=0;i<this.data.getAttribtueNum()-1;i++)
			for(int j=i+1;j<this.data.getAttribtueNum();j++)
				if((nowMin==null||(nowMin>(Float)this.data.get(i, j).get()))&&(lowestMin==null||((Float)this.data.get(i, j).get()>lowestMin)))
				{	nowPosition=getPosition(input,i,j);
					nowMin=(Float)this.data.get(i, j).get();
					
				}
		if(nowPosition.x==nowPosition.y)record.put("critical", 0f);
		else {
			record.put("critical", 1f);
			record.put("i", Float.parseFloat( String.valueOf( nowPosition.x)));
			record.put("j",Float.parseFloat( String.valueOf( nowPosition.y)));
			record.put("distance", nowMin);
			
			
		}
		this.lowestMin=nowMin;
		
		return record;
	}
	
	public Point getPosition(ArrayList<ArrayList<Integer>> set,int x,int y){
		Point position =new Point();
		
		for(int i=0;i<set.size();i++)
			for(int j=0;j<set.get(i).size();j++)
				if(set.get(i).get(j)==x)position.x=i;
				else if(set.get(i).get(j)==y)position.y=i;
				
		
		return position;
		
	}

}
