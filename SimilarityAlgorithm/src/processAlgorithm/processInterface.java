package processAlgorithm;

import java.io.IOException;

import dataStruture.Set;

public interface processInterface<E> {

	public void putData(String input,Set data)throws IOException;
	public E  processAlgorithm();
	public void printData(E input,String path)throws IOException;
	
	
}
