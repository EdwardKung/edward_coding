package statistic;

import java.util.ArrayList;

import dataStruture.Matrix;

public class RMSE extends statisticFather implements statisticInterface<Float> {

	public RMSE (Matrix input){
		super(input);
	}
	@Override
	public Float get() {
		Double result=0.0;
		Float average=0f;
		int count=0;
		Integer range = this.input.getAttribtueNum();
		//compute Average 
			for(int i=0;i<range-1;i++)
				for(int j =i+1;j<range;j++)
				{
					average+=(Float)this.input.get(i, j).get();
					count++;
				}
		average=((Float)average/count);
		//System.out.println("average:"+average);
		//compute RMSE
		count=0;
		for(int i=0;i<range-1;i++)
			for(int j =i+1;j<range;j++)
			{
				result+=Math.pow(((Float)this.input.get(i, j).get()-average), 2);
			//	System.out.println("result:"+result);
				count++;
			}
	if(count-1>0)
		result=Math.sqrt((result/(count-1)));
	else
		result=Math.sqrt((result/(count)));
		
		return Float.parseFloat(result.toString());
	}

}
