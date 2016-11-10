package IO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import com.csvreader.CsvReader;

import dataStruture.DataSet;
import dataStruture.NodeInterface;
import dataStruture.Set;


public class DataSetReader implements readerInterface<DataSet> {

	protected String path=null;
	protected DataSet data;
	public DataSetReader(String path, Set data)
	{
		this.path=path;
		this.data=(DataSet) data;
	}
	
	
	public DataSet execute() throws IOException{
		CsvReader reader =new CsvReader(path);
		
		if(reader.readRecord()) data.putTitle( reader.getRawRecord().split(","));
		while (reader.readRecord()){
			data.addRecord(reader.getRawRecord().split(","));
		}
		
		
		
		return data;
	}
}
