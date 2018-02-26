package it.univaq.disim.crossminer.matrix;

import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.SingularValueDecomposition;

public class LSA {

	public RealMatrix algorithm (RealMatrix m)
	{
		
		RealMatrix mFinal = MatrixUtils.createRealMatrix(m.getRowDimension(), m.getColumnDimension());
		
		SingularValueDecomposition svd = new SingularValueDecomposition(m);
		
		RealMatrix U = svd.getU();
		RealMatrix S = svd.getS();
		RealMatrix Vt = svd.getVT();
		
		RealMatrix Saux =  MatrixUtils.createRealMatrix(S.getRowDimension(), S.getColumnDimension());
		RealMatrix Uaux =  MatrixUtils.createRealMatrix(U.getRowDimension(), U.getColumnDimension());
		RealMatrix Vtaux =  MatrixUtils.createRealMatrix(Vt.getRowDimension(), Vt.getColumnDimension());
		
		
		int value=m.getColumnDimension()/2;
		//int value = 300;
		System.out.println(value);
		if(m.getColumnDimension()<value)
		{
			value = m.getColumnDimension();
		}
		
		for(int i=0; i<=value; i = i+1)
		{
				
				/*if(i<Uaux.getColumnDimension())
				{
					Uaux.setColumnMatrix(i, U.getColumnMatrix(i));
				}
				
				if(i<Vtaux.getRowDimension())
				{
					Vtaux.setRowMatrix(i, Vt.getRowMatrix(i));
				}*/
				
				if(i<Saux.getRowDimension())
				{
					Saux.setRowMatrix(i, S.getRowMatrix(i));
				}
		}
		
		mFinal = U.multiply(Saux.multiply(Vt));
		

		return mFinal;
	}
	
}
