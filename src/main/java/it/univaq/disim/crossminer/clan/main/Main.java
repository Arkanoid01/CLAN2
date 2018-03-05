package it.univaq.disim.crossminer.clan.main;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) throws IOException {
		
		long startTime = System.currentTimeMillis(); //elapsed time
		
		ArrayList<String> path_list = new ArrayList<String>();
		
		File folder_path = new File("C:/repos");
		File[] listOfRepos = folder_path.listFiles();
		
		for(File elem:listOfRepos)
		{
			path_list.add(elem.toString());
		}
		
		
		GenerateSimilarityMatrix generator = new GenerateSimilarityMatrix();
		String operation = "packages"; //specifica se fare analisi dei package o dei metodi
		
		/*
		 * data la lista delle repository da analizzare e il tipo di analisi da fare
		 * torna la matrice di similarità n X n (n repository)
		 */
		generator.generate(path_list,operation);

		long estimatedTime = System.currentTimeMillis() - startTime;

		System.out.println(String.format("%d min, %d sec", 
			    TimeUnit.MILLISECONDS.toMinutes(estimatedTime),
			    TimeUnit.MILLISECONDS.toSeconds(estimatedTime) - 
			    TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(estimatedTime))
			));
		
	}

}
