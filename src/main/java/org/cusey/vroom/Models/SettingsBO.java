package org.cusey.vroom.Models;

/**
* The Setting implements an application that
* 
*
* @author  Cusey,John
* @version 1.0
* @since   2018-06-08 
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import static org.cusey.vroom.Models.Constants.*;

@Component
public class SettingsBO {
	
    private final static Logger slf4jLogger = LoggerFactory.getLogger(SettingsBO.class);
	
    private String successMessage = "";
    private String dangerMessage = "";
	
    @Value("C:" + BACKSLASH  + "Vroom")
    private String directory;
    @Value("Input")
    private String folderIn;
    @Value("Output")
    private String folderOut;
	
    private File[] files;
	
    private String currentLine = "";
    private BufferedReader br = null;
    private FileReader fr = null; 
    
    private File flatFile;
	private FileWriter fw = null;
    
	
	public SettingsBO() {
	}
	
	/**
    * This method reads file in the C:\Vroom\Input folder and stores 
    * the data in object called Dictionary. Input is the default folder 
    * name.
    * @return List<Dictionary> Contains the list of dictionary entry.
    */
	public List<Dictionary> populateDictionary(){
		
		List<Dictionary> dicList = new ArrayList<Dictionary>();
		
		files = new File(directory + BACKSLASH + folderIn).listFiles();
		
		String path = directory + BACKSLASH  +  folderIn;
		
        try {
        	
        	if(files != null ){

	            for(File file : files){
	
	                fr = new FileReader(  path + BACKSLASH  + file.getName() );
	                br = new BufferedReader(fr);
	
	                while ((currentLine = br.readLine()) != null) {
	
	                    if (currentLine.length() > 0) {
	                    	slf4jLogger.debug(currentLine);
	                    	
	                    	Dictionary dic = new Dictionary();
	                    	
	                    	if(currentLine.indexOf(DELIMITER) == -1){
	                    		dic.setWord(currentLine);
	                    		
	                    	}else{
	                           	String[] items = currentLine.split(BACKSLASH +DELIMITER);
		                    	
		                    	if(items.length > 4){
		                    		dic.setWord(items[1]);
		                    		dic.setPartOfSpeech(items[2]);
		                    		dic.setDefinition(items[3]);
		                    		dic.setWordUsage(items[4]);
		                    		
		                    		dicList.add(dic);
		                    		
		                    	}
	                    		
	                    	}

	                    }
	                }
	            }
        	}else{
        		slf4jLogger.debug("Check the file(s) in folder " + path);
            }
       	 

        } catch (IOException e) {
        	slf4jLogger.error(e.getMessage());
        } finally {

            try {

                if (br != null)
                    br.close();

                if (fr != null)
                    fr.close();

            } catch (IOException e) {
            	slf4jLogger.error(e.getMessage());
            }
        }
		
		return dicList;
	}
	
	/** 
	*  This method writes Dictionary object to flat file the
	*  methods uses the first letter of the word as the file 
	*  name.
	*  and puts the file in C:\Vroom\Output 
	* @param dic Is list of Dictionary objects which contains 
	* the entries. 
	* @return int Number row added to the file in the 
	* folder C:\Vroom\Output. Output is the default folder name.
	*/
	public int populateFlatFile(List<Dictionary> dic){
		
		String lastFirstLetter = " ";
		int rowCount = 0;
		
		try {
		
		
		for( Dictionary element :dic){
			
			if(element.getWord() != null){
				
				String wordFirstLetter  = element.getWord().substring(0,1);
				
			
					if( ! wordFirstLetter.equals(lastFirstLetter) ){
						
						createFile(wordFirstLetter);
						lastFirstLetter = wordFirstLetter;
					}
				
					String line = DELIMITER + element.getWord() + 
							      DELIMITER + element.getPartOfSpeech() + 
							      DELIMITER + element.getDefinition() + 
							      DELIMITER + element.getWordUsage() +
							      DELIMITER ;
					
					slf4jLogger.debug(line);
				
					 fw.write(line + "\n");
					 rowCount++;

	      }
	   }

		} catch (IOException e) {
			slf4jLogger.error( e.getMessage() );
		}finally{
			try {
				fw.flush();
				
				if(fw != null){
				    fw.close();
				}
			} catch (IOException e) {
				slf4jLogger.error( e.getMessage() );
			}
			
			
		}

		return rowCount;
		
	}
	
	private void createFile(String fileName){
		
		try {
		    flatFile = new File(directory + BACKSLASH + folderOut + BACKSLASH + fileName.toUpperCase() + ".txt");
		    
		    if (flatFile.createNewFile()){
		        System.out.println(fileName + ".txt is created!");
		     }else{
		        System.out.println("The file " + fileName + ".txt already exists.");
		     }
		    
		    fw =  new FileWriter(flatFile);
		    
		    
		} catch (IOException e) {
			slf4jLogger.error(e.getMessage());
	    }
		
	}
	
	
	public String getSuccessMessage() {return successMessage;}
	public void setSuccessMessage(String successMessage) {this.successMessage = successMessage;}

	public String getDangerMessage() {return dangerMessage;}
	public void setDangerMessage(String dangerMessage) {this.dangerMessage = dangerMessage;}

	public String getDirectory() {return directory;}
	public void setDirectory(String directory) {this.directory = directory;}

	public String getFolderOut() { return folderOut; }
	public void setFolderOut(String folderOut) { this.folderOut = folderOut; }

	public String getFolderIn() { return folderIn; }
	public void setFolderIn(String folderIn) { this.folderIn = folderIn; }

	public File[] getFiles() {return files;}
	public void setFiles(File[] files) {this.files = files;}
	
}
