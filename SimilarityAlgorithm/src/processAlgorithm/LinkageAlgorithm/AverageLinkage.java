package processAlgorithm.LinkageAlgorithm;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;

public class AverageLinkage extends LinkageProcess {

	@Override
	public HashMap<String, Float> chkCombine(ArrayList<ArrayList<Integer>> input) {
		// TODO Auto-generated method stub
		
		Float nowDist=null;
		HashMap<String,Float> record=new HashMap<String,Float>();
		Float nowMin =null;
		Point nowPosition = new Point();
		for(int i=0;i<input.size()-1;i++)
			for(int j=i+1;j<input.size();j++ )
			{
				nowDist=walkAround(input.get(i),input.get(j));
				if(nowMin==null||nowMin>nowDist)
				{nowMin=nowDist;
				 nowPosition.x=i;
				 nowPosition.y=j;
				 
				}
			}
		
		record.put("critical", 1f);
		record.put("i", Float.parseFloat( String.valueOf( nowPosition.x)));
		record.put("j",Float.parseFloat( String.valueOf( nowPosition.y)));
		record.put("distance", nowMin);
		return record;
	}
	private float walkAround(ArrayList<Integer> one,ArrayList<Integer> two){
		float result=0f;
		
		for(int i=0;i<one.size();i++)
			for(int j=0;j<two.size();j++)
			{
				//System.out.print((Float)this.data.get(one.get(i),two.get(j)).get());
				result+=(Float)this.data.get(one.get(i),two.get(j)).get();
			}
	
		result=result/(one.size()*two.size());
		//System.out.println("result:"+result+"one*two:"+one.size()*two.size());
		return result;
		
	}

}
