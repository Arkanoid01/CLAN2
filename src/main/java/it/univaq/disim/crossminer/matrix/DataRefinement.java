package it.univaq.disim.crossminer.matrix;

import java.io.File;
import java.util.ArrayList;

import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.RealVector;

public class DataRefinement {
	
	public void refine (RealMatrix m)
	{
		/*
		 * recupero il nome delle repository
		 */
		ArrayList<String> path_list = new ArrayList<String>();
		File folder_path = new File("C:/repos");
		File[] listOfRepos = folder_path.listFiles();
		
		for(File elem:listOfRepos)
		{
			path_list.add(elem.toString());
		}
		
		
		for(int i=0; i<m.getRowDimension(); i++)
		{	
			RealVector vector = m.getRowVector(i);
			for(int j=0; j<m.getRowDimension(); j++)
			{
				if(vector.getEntry(j)>0.75 && i!=j)
				{
					System.out.println(path_list.get(i)+" - "+path_list.get(j)+" : "+vector.getEntry(j));
				}
			}
		}
		
	}

}
