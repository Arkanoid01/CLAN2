package it.univaq.disim.crossminer.clan.main;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) throws IOException, URISyntaxException {
		
		long startTime = System.currentTimeMillis(); //elapsed time
		
		ArrayList<String> path_list = new ArrayList<String>();
		
		
		String path= "C:/repos/Nuova";
		
		File folder_path = new File(path);
		File[] listOfRepos = folder_path.listFiles();
		
		for(File elem:listOfRepos)
		{
			path_list.add(elem.toString());
		}
		
		GenerateSimilarityMatrix generator = new GenerateSimilarityMatrix();
		String operation = "packages"; //specifica se fare analisi dei package o dei metodi
		
		/*
		 * caricamento jdk
		 */
		File jdk_file = new File("jdk.txt");
		Jdk jdk = new Jdk();
		ArrayList jdk_list = new ArrayList();
		jdk_list = jdk.load(jdk_file);
		
		/*
		 * data la lista delle repository da analizzare e il tipo di analisi da fare
		 * torna la matrice di similarity n X n (n repository)
		 */
		generator.generate(path_list,operation, jdk_list);

		long estimatedTime = System.currentTimeMillis() - startTime;

		System.out.println(String.format("%d min, %d sec", 
			    TimeUnit.MILLISECONDS.toMinutes(estimatedTime),
			    TimeUnit.MILLISECONDS.toSeconds(estimatedTime) - 
			    TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(estimatedTime))
			));
		
	}

}
