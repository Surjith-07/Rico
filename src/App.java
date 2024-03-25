import java.io.ObjectInputFilter.Config;
import java.net.URI;
import javax.naming.directory.SearchResult;
import java.awt.Desktop;
import edu.cmu.sphinx.api.*;

public class App {
    
    public static void main(String[] args) throws Exception {
    	
        Configuration config = new Configuration();
        
        config.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
       
        config.setDictionaryPath("src\\dic.dic");
        
        config.setLanguageModelPath("src\\lm.lm");
        
        try {
        	
            LiveSpeechRecognizer rec = new LiveSpeechRecognizer(config);
            
            rec.startRecognition(true);
            
            Desktop desk = Desktop.getDesktop();
            
            SpeechResult speechResult = null;
            
            while ((speechResult = rec.getResult()) != null) {
            	
                String result = speechResult.getHypothesis();
                
                if (result.equalsIgnoreCase("open chrome")) {
                	System.out.println("Opening: "+result);
                	URI uri=new URI("http://google.com");
                	desk.browse(uri);
                }
                
                else if(result.equalsIgnoreCase("open youtube")) {
                    System.out.println("Opening: "+result);
                    URI uri = new URI("http://youtube.com/");
                    desk.browse(uri);
                }
                
                else if(result.equalsIgnoreCase("open zomato")) {
                	System.out.println("Opening: "+result);
                	URI uri=new URI("http://zomato.com/");
                	desk.browse(uri);
                }
                
                else if(result.equalsIgnoreCase("open amazon")) {
                	System.out.println("Opening: "+result);
                	URI uri=new URI("http://amazon.com/");
                	desk.browse(uri);
                }
                
                else if(result.equalsIgnoreCase("open map")) {
                	System.out.println("Opening: "+result);
                	URI uri=new URI("https://maps.google.com/");
                	desk.browse(uri);
                }
                
                else if(result.equalsIgnoreCase("close all")) {
                  	System.out.println("Closing: "+result);
                  	Runtime.getRuntime().exec("cmd.exe /c TASKKILL /IM chrome.exe");
                  	
                  }
                
               else if(result.equalsIgnoreCase("shutdown system")) {
               	System.out.println("Closing: "+result);
               	Runtime.getRuntime().exec("cmd.exe /c shutdown /s");
               }
                
               else if(result.equalsIgnoreCase("restart system")) {
                 	System.out.println("Closing: "+result);
                 	Runtime.getRuntime().exec("cmd.exe /c shutdown /r");
                 }
                
            }
            
        } catch(Exception e){
        	
            System.out.println(e);
            
        }
    }
}