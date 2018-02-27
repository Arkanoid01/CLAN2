package it.univaq.disim.crossminer.clan.main;

import java.io.File;
import java.io.IOException;

import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealMatrix;

import it.univaq.disim.crossminer.matrix.LoadSave;

public class testPart2 {

	public static void main(String[] args) throws IOException {
		
		LoadSave ls = new LoadSave();
		File f = new File("resultsp.txt");
		RealMatrix mp = ls.Load(f);
		
		f = new File("resultsm.txt");
		RealMatrix mm = ls.Load(f);
		mm = mm.scalarMultiply(0.5);
		mp = mp.scalarMultiply(0.5);
		RealMatrix mr = mp.add(mm);
		
		for(int i=0; i<mr.getRowDimension(); i++)
		{
			System.out.println(mp.getRowMatrix(i));
		}
		
		for(int i=0; i<mr.getRowDimension(); i++)
		{
			System.out.println(mm.getRowMatrix(i));
		}
		
		for(int i=0; i<mr.getRowDimension(); i++)
		{
			System.out.println(mr.getRowMatrix(i));
		}
		
	}

}
