package it.univaq.disim.crossminer.clan.main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.math3.linear.RealMatrix;

import it.univaq.disim.crossminer.matrix.CosineSimilarity;
import it.univaq.disim.crossminer.matrix.LSA;

public class GenerateSimilarityMatrix {
	
	public void generate(ArrayList<String> path_list, String operation) throws IOException
	{
		
		MatrixManager manager = new MatrixManager();
		LSA lsa = new LSA();
		ArrayList<ArrayList<Double>> occurrencies_list = new ArrayList<ArrayList<Double>>();
		
		/*
		 * parsing
		 */
		occurrencies_list = manager.createFiles(path_list, operation);
		
		RealMatrix m = manager.createMatrix(occurrencies_list);

		System.out.println("Numero di Termini: "+m.getRowDimension());
		
		/*
		 * LSA
		 */
		m = lsa.algorithm(m);
		
		/*
		 * Similarit�
		 */
		CosineSimilarity csm = new CosineSimilarity();
		m = csm.CS(m);
		
		/*
		 * scrittura su file
		 */
		File file = new File("results"+operation+".txt");
		FileWriter fileWriter = new FileWriter(file);
		for(int i=0; i<m.getRowDimension(); i++)
		{
			fileWriter.write(m.getRowMatrix(i).toString()+"\n");
		}
		fileWriter.flush();
		fileWriter.close();
	}

}