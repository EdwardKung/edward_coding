

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;

import processAlgorithm.processInterface;
import processAlgorithm.LinkageAlgorithm.AverageLinkage;
import processAlgorithm.LinkageAlgorithm.LinkageProcess;
import processAlgorithm.Similarity.AlgorithmSelection;
import processAlgorithm.Similarity.SimilarityProcess;
import processAlgorithm.Similarity.AlgorithmSelection.Algorithm;

import abstractFactory.DistanceHierarchy;

import typeSimilalrityFormula.DILCAForCategorical;
import typeSimilalrityFormula.DISCForNumerical;
import typeSimilalrityFormula.FormulaInterface;


import dataStruture.DataSet;
import dataStruture.Matrix;
import dataStruture.NodeInterface;
import dataStruture.NumericalNode;
import dataStruture.Set;
import dataStruture.TreeNode;



public class test implements AlgorithmSelection {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args)   {
		// TODO Auto-generated method stub
		/*
		try {
			ObjectInputStream io = new ObjectInputStream(new FileInputStream("test.tmp"));
			DatasetInfor a=(DatasetInfor) io.readObject();
			System.out.println(a.get(0));
			io.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
	/*	
		DatasetInfor di=new DatasetInfor();
		di.save(100);
		di.save(200);
		try {
			FileOutputStream io = new FileOutputStream("test.tmp");
			ObjectOutputStream foo = new ObjectOutputStream(io);
			foo.writeObject(di);
			foo.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Statlog("11StatlogAllbyDISC_test3", Algorithm.DISC);
 catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
		//TTTAll("11TTTAllbyCOFC",Algorithm.COFC);
		//DrinkAll("11Drink4gbyCOFC",Algorithm.COFC);
		//MO();
		//DermatologyAll("11DermatologyAllbyDISC",Algorithm.DISC);
		//DermatologyAll("DermatologyAllbyDILCA",Algorithm.DILCA);
		//DermatologyAll("DermatologyAllbymDILCA",Algorithm.mDILCA);
		//DermatologyAll("DermatologyAllbyCOFC",Algorithm.COFC);
		//adultAll("AdultAllbyCOFC",Algorithm.COFC);
		//adultAll("AdultAllbyDISC",Algorithm.DISC);
	//	adultAll("AdultAllbyDILCA",Algorithm.DILCA);
		//adultAll("AdultAllbymDILCA",Algorithm.mDILCA);
		//Statlog("11statlogbyDISC2",Algorithm.DISC2);
		//soybeanAll("SoybeanAllbyDISC",Algorithm.DISC);
		//soybeanAll("SoybeanAllbyDILCA",Algorithm.DILCA);
		//soybeanAll("SoybeanAllbymDILCA",Algorithm.mDILCA);
		//soybeanAll("SoybeanbyCOFC",Algorithm.COFC);
		//Nursery("NuseryAllbyDILCA",Algorithm.DILCA);
		//Nursery("NuseryAllbymDILCA",Algorithm.mDILCA);
		//Nursery("NuserybyCOFC",Algorithm.COFC);
		//lymphographyAll("lymphographyAllbyDISC",Algorithm.DISC);
		//lymphographyAll("lymphographyAllbyDILCA",Algorithm.DILCA);
		//lymphographyAll("lymphographyAllbymDILCA",Algorithm.mDILCA);
		//lymphographyAll("lymphographybyCOFC",Algorithm.COFC);
		//balanceAll("BalanceAllbyDISC",Algorithm.DISC);
		//balanceAll("BalanceAllbyDILCA",Algorithm.DILCA);
		//balanceAll("BalanceAllbymDILCA",Algorithm.mDILCA);
		//balanceAll("BalancebyCOFC",Algorithm.COFC);
		
		Algorithm[] batch=new Algorithm[]{Algorithm.DISC4};
		for(int i =0; i<batch.length;i++)
			{ZooAll("ZooAllby"+batch[i],batch[i]);
			Car("CarAllby"+batch[i],batch[i]);
			Nursery("NurseryAllby"+batch[i],batch[i]);
			CMC("CMCAllby"+batch[i],batch[i]);
			Statlog("StatlogAllby"+batch[i],batch[i]);
			adultAll("AdultAllby"+batch[i],batch[i]);
			adultPart("AdultPartby"+batch[i],batch[i]);
			balanceAll("balanceAllby"+batch[i],batch[i]);
			lymphographyAll("lymphographyAllby"+batch[i],batch[i]);
			soybeanAll("SoybeanAllby"+batch[i],batch[i]);
			DermatologyAll("DermatologyAllby"+batch[i],batch[i]);
			TTTAll("TTTAllby"+batch[i],batch[i]);
			MushroomAll("MushroomAllby"+batch[i],batch[i]);
			TAEAll("TAEAllby"+batch[i],batch[i]);
			votingAll("votingAllby"+batch[i],batch[i]);
			australianAll("AustralianAllby"+batch[i],batch[i]);
			}
		
		
		
	}
	public static void balanceAll(String folderName, Algorithm input){
		DistanceHierarchy DH=new DistanceHierarchy();
		DH.setInput("D:\\Research\\Dataset\\Datasets\\Experiment_in_BalanceScale\\balanceScale.csv");
		DH.setOutput("D:\\Research\\test\\"+folderName+"\\");
		DH.setDataSetType(new DataSet(new int[]{1,1,1,1,9}));
		DH.setLinkageAlgoritm(Algorithm.AverageLinkage);
		DH.setSimilarityAlgorithm(input);
		DH.start();
	}
	public static void lymphographyAll(String folderName, Algorithm input){
		DistanceHierarchy DH=new DistanceHierarchy();
		DH.setInput("D:\\Research\\Dataset\\EdwardDataset\\lymphography\\lymphography.csv");
		DH.setOutput("D:\\Research\\test\\"+folderName+"\\");
		DH.setDataSetType(new DataSet(new int[]{1,1,1,1,1,1,1,1,0,0,1,1,1,1,1,1,1,0,9}));
		DH.setLinkageAlgoritm(Algorithm.AverageLinkage);
		DH.setSimilarityAlgorithm(input);
		DH.start();
	}
	public static void soybeanAll(String folderName,Algorithm input){
		DistanceHierarchy DH=new DistanceHierarchy();
		DH.setInput("D:\\Research\\Dataset\\Datasets\\Experiment_in_Soybean\\Soybean\\SoybeanSmall.csv");
		DH.setOutput("D:\\Research\\test\\"+folderName+"\\");
		DH.setDataSetType(new DataSet(new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,9}));
		DH.setLinkageAlgoritm(Algorithm.AverageLinkage);
		DH.setSimilarityAlgorithm(input);
		DH.start();
	}
	public static void postoperativeAll(String folderName,Algorithm input){
		DistanceHierarchy DH=new DistanceHierarchy();
		DH.setInput("D:\\Research\\Dataset\\UCI\\uci\\postoperative\\postoperative.csv");
		DH.setOutput("D:\\Research\\test\\"+folderName+"\\");
		DH.setDataSetType(new DataSet(new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,9}));
		DH.setLinkageAlgoritm(Algorithm.AverageLinkage);
		DH.setSimilarityAlgorithm(input);
		DH.start();
	}
	public static void DermatologyAll(String folderName,Algorithm input){
		DistanceHierarchy DH=new DistanceHierarchy();
		DH.setInput("D:\\Research\\Dataset\\EdwardDataset\\dermatology\\dermatology(nonvaluev1).csv");
		DH.setOutput("D:\\Research\\test\\"+folderName+"\\");
		DH.setDataSetType(new DataSet(new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,9}));
		DH.setLinkageAlgoritm(Algorithm.AverageLinkage);
		DH.setSimilarityAlgorithm(input);
		DH.start();
	}
	public static void DrinkAll(String folderName,Algorithm input){
		DistanceHierarchy DH=new DistanceHierarchy();
		DH.setInput("D:\\Research\\Dataset\\Datasets\\drink4mix.csv");
		DH.setOutput("D:\\Research\\test\\"+folderName+"\\");
		DH.setDataSetType(new DataSet(new int[]{9,1,0,0,9,9}));
		DH.setLinkageAlgoritm(Algorithm.AverageLinkage);
		DH.setSimilarityAlgorithm(input);
		DH.start();
	}
	public static void Drink9gAll(String folderName,Algorithm input){
		DistanceHierarchy DH=new DistanceHierarchy();
		DH.setInput("D:\\Research\\Dataset\\Datasets\\Experiment_in_Drink\\Drink9g\\NomOrdNum9g1300.csv");
		DH.setOutput("D:\\Research\\test\\"+folderName+"\\");
		DH.setDataSetType(new DataSet(new int[]{9,1,0,0,9}));
		DH.setLinkageAlgoritm(Algorithm.AverageLinkage);
		DH.setSimilarityAlgorithm(input);
		DH.start();
	}
	public static void Drink9mixAll(String folderName,Algorithm input){
		DistanceHierarchy DH=new DistanceHierarchy();
		DH.setInput("D:\\Research\\Dataset\\Datasets\\Experiment_in_Drink\\Drink9mix\\Drink9mix.csv");
		DH.setOutput("D:\\Research\\test\\"+folderName+"\\");
		DH.setDataSetType(new DataSet(new int[]{9,1,1,0,9}));
		DH.setLinkageAlgoritm(Algorithm.AverageLinkage);
		DH.setSimilarityAlgorithm(input);
		DH.start();
	}
	public static void TTTAll(String folderName,Algorithm input){
		DistanceHierarchy DH=new DistanceHierarchy();
		DH.setInput("D:\\Research\\Dataset\\Datasets\\Experiment_in_TTT\\Tic_Tac_Toe\\TTT.csv");
		DH.setOutput("D:\\Research\\test\\"+folderName+"\\");
		DH.setDataSetType(new DataSet(new int[]{1,1,1,1,1,1,1,1,1,9}));
		DH.setLinkageAlgoritm(Algorithm.AverageLinkage);
		DH.setSimilarityAlgorithm(input);
		DH.start();
	}
	public static void MushroomAll(String folderName,Algorithm input){
		DistanceHierarchy DH=new DistanceHierarchy();
		DH.setInput("D:\\Research\\Dataset\\Datasets\\Experiment_in_Mushroom\\Mushroom.csv");
		DH.setOutput("D:\\Research\\test\\"+folderName+"\\");
		DH.setDataSetType(new DataSet(new int[]{1,1,1,0,1,1,1,0,1,0,1,1,1,1,1,9,1,1,1,1,1,1,9}));
		DH.setLinkageAlgoritm(Algorithm.AverageLinkage);
		DH.setSimilarityAlgorithm(input);
		DH.start();
	}
	
	public static void TAEAll(String folderName,Algorithm input){
		DistanceHierarchy DH=new DistanceHierarchy();
		DH.setInput("D:\\Research\\Dataset\\Datasets\\Experiment_in_Teaching_Assistant_Evaluation\\Teaching_Assistant_Evaluation.csv");
		DH.setOutput("D:\\Research\\test\\"+folderName+"\\");
		DH.setDataSetType(new DataSet(new int[]{0,1,1,0,0,9}));
		DH.setLinkageAlgoritm(Algorithm.AverageLinkage);
		DH.setSimilarityAlgorithm(input);
		DH.start();
	}
	public static void votingAll(String folderName,Algorithm input){
		DistanceHierarchy DH=new DistanceHierarchy();
		DH.setInput("D:\\Research\\Dataset\\EdwardDataset\\Voting\\voting.csv");
		DH.setOutput("D:\\Research\\test\\"+folderName+"\\");
		DH.setDataSetType(new DataSet(new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,9}));
		DH.setLinkageAlgoritm(Algorithm.AverageLinkage);
		DH.setSimilarityAlgorithm(input);
		DH.start();
	}
	public static void australianPart(String folderName,Algorithm input){
		DistanceHierarchy DH= new DistanceHierarchy();
		DH.setInput("D:\\Research\\Australia\\australian.csv");
		DH.setOutput("D:\\Research\\test\\"+folderName+"\\");
		DH.setDataSetType(new DataSet(new int[]{9,0,0,1,1,1,0,0,0,0,9,9,0,0,9}));
		DH.setLinkageAlgoritm(Algorithm.AverageLinkage);
		DH.setSimilarityAlgorithm(input);
		DH.start();
	}
	public static void australianOnlyCate(String folderName,Algorithm input){
		DistanceHierarchy DH= new DistanceHierarchy();
		DH.setInput("D:\\Research\\Australia\\australian.csv");
		DH.setOutput("D:\\Research\\test\\"+folderName+"\\");
		DH.setDataSetType(new DataSet(new int[]{9,9,9,1,1,1,9,9,9,9,9,9,9,9,9,9}));
		DH.setLinkageAlgoritm(Algorithm.AverageLinkage);
		DH.setSimilarityAlgorithm(input);
		DH.start();
	}
	public static void ZooAll(String folderName,Algorithm input){
		DistanceHierarchy DH= new DistanceHierarchy();
		DH.setInput("D:\\Research\\Dataset\\Datasets\\Experiment_in_Zoo\\Zoo.csv");
		DH.setOutput("D:\\Research\\test\\"+folderName+"\\");
		DH.setDataSetType(new DataSet(new int[]{9,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,9}));
		DH.setLinkageAlgoritm(Algorithm.AverageLinkage);
		DH.setSimilarityAlgorithm(input);
		DH.start();
	}
	public static void Car(String folderName,Algorithm similarity){
		DistanceHierarchy DH= new DistanceHierarchy();
		DH.setInput("D:\\Research\\Dataset\\Datasets\\Experiment_in_Car_Evaluation\\CarEvaluation(experimentversion).csv");
		DH.setOutput("D:\\Research\\test\\"+folderName+"\\");
		DH.setDataSetType(new DataSet(new int[]{1,1,1,1,1,1,9}));
		DH.setLinkageAlgoritm(Algorithm.AverageLinkage);
		DH.setSimilarityAlgorithm(similarity);
		DH.start();
	}	
	public static void Nursery(String folderName,Algorithm similarity){
		DistanceHierarchy DH= new DistanceHierarchy();
		DH.setInput("D:\\Research\\Dataset\\Datasets\\Experiment_in_Nursery\\Nursery(experimentver1).csv");
		DH.setOutput("D:\\Research\\test\\"+folderName+"\\");
		DH.setDataSetType(new DataSet(new int[]{1,1,1,1,1,1,1,1,9}));
		DH.setLinkageAlgoritm(Algorithm.AverageLinkage);
		DH.setSimilarityAlgorithm(similarity);
		DH.start();
	}
	public static void CMC(String folderName, Algorithm similarity){
		DistanceHierarchy DH= new DistanceHierarchy();
		DH.setInput("D:\\Research\\Dataset\\Datasets\\Experiment_in_Contraceptive_Method_Choice\\ContraceptiveMethodChoice(experiment).csv");
		DH.setOutput("D:\\Research\\test\\"+folderName+"\\");
		DH.setDataSetType(new DataSet(new int[]{0,1,1,0,0,0,1,1,0,9}));
		DH.setLinkageAlgoritm(Algorithm.AverageLinkage);
		DH.setSimilarityAlgorithm(similarity);
		DH.start();
	}
	public static void Statlog(String folderName, Algorithm similarity){
		DistanceHierarchy DH= new DistanceHierarchy();
		DH.setInput("D:\\Research\\Dataset\\Datasets\\Experiment_in_Statlog\\Statlog.csv");
		DH.setOutput("D:\\Research\\test\\"+folderName+"\\");
		DH.setDataSetType(new DataSet(new int[]{1,0,1,1,0,1,1,0,1,1,0,1,0,1,1,0,1,0,1,1,9}));
		DH.setLinkageAlgoritm(Algorithm.AverageLinkage);
		DH.setSimilarityAlgorithm(similarity);
		DH.start();
	}
	public static void australianAll(String folderName,Algorithm input){
		DistanceHierarchy DH= new DistanceHierarchy();
		DH.setInput("D:\\Research\\Australia\\australian.csv");
		DH.setOutput("D:\\Research\\test\\"+folderName+"\\");
		DH.setDataSetType(new DataSet(new int[]{0,0,0,1,1,1,0,0,0,0,0,0,0,0,9}));
		DH.setLinkageAlgoritm(Algorithm.AverageLinkage);
		DH.setSimilarityAlgorithm(input);
		
		DH.start();
	}
	
	
	public static void Drink(){
		DistanceHierarchy DH= new DistanceHierarchy();
		DH.setInput("D:\\Research\\Dataset\\Datasets\\drink4mix.csv");
		DH.setOutput("D:\\Research\\test\\DrinkAllbyDISC\\");
		DH.setDataSetType(new DataSet(new int[]{9,1,0,0,9,9}));
		DH.setLinkageAlgoritm(Algorithm.AverageLinkage);
		DH.setSimilarityAlgorithm(Algorithm.DISC);
		DH.start();
	}
	
	public static void Drink4g(){
		DistanceHierarchy DH= new DistanceHierarchy();
		DH.setInput("D:\\Research\\Dataset\\Datasets\\Drink4g.csv");
		DH.setOutput("D:\\Research\\test\\Drink4gAllbymDILCA\\");
		DH.setDataSetType(new DataSet(new int[]{9,1,1,0,0,9,9}));
		DH.setLinkageAlgoritm(Algorithm.AverageLinkage);
		DH.setSimilarityAlgorithm(Algorithm.mDILCA);
		DH.start();
	}
	public static void MO(){
		DistanceHierarchy DH= new DistanceHierarchy();
		DH.setInput("D:\\Research\\Dataset\\Datasets\\MO.csv");
		DH.setOutput("D:\\Research\\test\\11MOVIEAllbyCOFC\\");
		DH.setDataSetType(new DataSet(new int[]{1,9}));
		DH.setLinkageAlgoritm(Algorithm.AverageLinkage);
		DH.setSimilarityAlgorithm(Algorithm.COFC);
		DH.start();
	}
	
	public static void MOVIE2(){
		DistanceHierarchy DH= new DistanceHierarchy();
		DH.setInput("D:\\Research\\Dataset\\Datasets\\MOVIE2.csv");
		DH.setOutput("D:\\Research\\test\\MOVIE2AllbymDILCA\\");
		DH.setDataSetType(new DataSet(new int[]{1,1}));
		DH.setLinkageAlgoritm(Algorithm.AverageLinkage);
		DH.setSimilarityAlgorithm(Algorithm.mDILCA);
		DH.start();
	}
	public static void MOAll(){
		DistanceHierarchy DH= new DistanceHierarchy();
		DH.setInput("D:\\Research\\Dataset\\Datasets\\MO.csv");
		DH.setOutput("D:\\Research\\test\\MObyDILCA\\");
		DH.setDataSetType(new DataSet(new int[]{1,1,1,0}));
		DH.setLinkageAlgoritm(Algorithm.AverageLinkage);
		DH.setSimilarityAlgorithm(Algorithm.DILCA);
		DH.start();
	}
	
	public static void adultAll(String folderName,Algorithm input) {
		DistanceHierarchy DH= new DistanceHierarchy();
		DH.setInput("D:\\Research\\Dataset\\Datasets\\Experiment_in_Adult\\Adult(nonMissingValue).csv");
		DH.setOutput("D:\\Research\\test\\"+folderName+"\\");
		DH.setDataSetType(new DataSet(new int[]{0,1,0,1,0,1,1,1,1,1,0,0,0,1,9}));
		DH.setLinkageAlgoritm(Algorithm.AverageLinkage);
		DH.setSimilarityAlgorithm(input);
		
			DH.start();
	
	}
	
	public static void adultPart(String folderName,Algorithm input) {
		DistanceHierarchy DH= new DistanceHierarchy();
		DH.setInput("D:\\Research\\Dataset\\Datasets\\Experiment_in_Adult\\Adult.csv");
		DH.setOutput("D:\\Research\\test\\"+folderName+"\\");
		DH.setDataSetType(new DataSet(new int[]{0,9,9,1,9,1,9,1,9,9,0,0,0,9,9}));
		DH.setLinkageAlgoritm(Algorithm.AverageLinkage);
		DH.setSimilarityAlgorithm(input);
		
			DH.start();
	
	}

}
