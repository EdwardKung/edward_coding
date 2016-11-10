package IO;

import java.io.File;
import java.io.IOException;

import com.csvreader.CsvWriter;

import dataStruture.Matrix;
import dataStruture.Set;

public class CSVWriter  {

	String path;
	String fileName;
	Set input;
	public CSVWriter(String path, String fileName,Set input)
	{
		this.path=path;
		this.fileName=fileName;
		this.input=input;
	}
	
	public void execute() throws IOException{
		CsvWriter writer=new CsvWriter(path+fileName+".csv");
		File file = new File(path);
		if(!file.exists()) file.mkdirs();
		
		
		writer.writeRecord(input.getTitleArray());
		for(int i=0;i<input.getAttribtueNum();i++)
		{
			String[] record = new String[input.getAttribtueNum()];
			for(int j=0;j<input.getAttribtueNum();j++)
			{
				record[j]=Float.toString((Float)input.get(i, j).get());
			}
			writer.writeRecord(record);
		}
		
		
		writer.close();
	}
}
