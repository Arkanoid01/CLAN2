package scan;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import org.apache.commons.io.FilenameUtils;

import it.univaq.disim.mudablue.models.Repositories;



public class FolderNavigator 
{
	//funzione ricorsiva che data una directory, naviga tutti i file di tutte le sotto-directory
	public Repositories Files_List(File folder_path, ArrayList<String> main_list, ArrayList<String> raw_main_list, Repositories repository_object) throws FileNotFoundException
	{
		File[] listOfFiles = folder_path.listFiles();
		
		ListManager manager = new ListManager();
		
		//System.out.println(list);
		
		
	    for (File file : listOfFiles) {
	        
	    	if (file.isDirectory())//directory 
	        {
	            Files_List(file,main_list,raw_main_list,repository_object); // Calls same method again.
	        } 
	    	
	        else //file 
	        {
		    	String ext = FilenameUtils.getExtension(file.getName());
		    	if (ext.equals("java"))
		    	{	
		    		manager.create_main_list(main_list, manager.create_local_list(file));
		    		repository_object.setMain_list(main_list);
		    		repository_object.setTerms(manager.create_raw_main_list(raw_main_list, manager.create_local_list(file)));
		    	}
	        }
	    }
	
		return repository_object;
	}

}
