package it.univaq.disim.crossminer.matrix;

import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealMatrix;

public class testHeapOverflow {

	public static void main(String[] args) {
		
		RealMatrix mFinal = MatrixUtils.createRealMatrix(580, 200000);
		
		for(int i=0; i<mFinal.getRowDimension(); i++)
		{
			for(int j=0; j<mFinal.getColumnDimension(); j++)
			{
				mFinal.setEntry(i, j, 25.0);
			}
		}

	}

}
