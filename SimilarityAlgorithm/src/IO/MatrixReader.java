package IO;

import java.io.IOException;

import com.csvreader.CsvReader;

import dataStruture.Matrix;

public class MatrixReader implements readerInterface<Matrix> {

	Matrix data;
	String path;
	String fileName;
	public MatrixReader(String input,Matrix data){
		this.data=data;
		this.path=input;
		
	}
	@Override
	public Matrix execute() throws IOException {
		// TODO Auto-generated method stub
		CsvReader reader =new CsvReader(path);
		if(reader.readRecord()) data.putTitle( reader.getRawRecord().split(","));
		for(int i=0;reader.readRecord();i++)
		{
			String[] tmp=reader.getRawRecord().split(",");
			for(int j=0;j<tmp.length;j++)
				this.data.put(i, j, Float.parseFloat(tmp[j]));
		}
		
		
		return data;
	}

}
