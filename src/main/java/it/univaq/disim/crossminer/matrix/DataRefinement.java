package it.univaq.disim.crossminer.matrix;

import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.RealVector;

public class DataRefinement {
	
	public void refine (RealMatrix m)
	{
		
		for(int i=0; i<m.getRowDimension(); i++)
		{	
			RealVector vector = m.getRowVector(i);
			for(int j=0; j<m.getRowDimension(); j++)
			{
				if(vector.getEntry(j)>0.5 && i!=j)
				{
					System.out.println(i+" - "+j+" : "+vector.getEntry(j));
				}
			}
		}
		
	}

}
