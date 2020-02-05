import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MainProgram 
{
	 public static void main(String[] args)
	 {
		    final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
		    executorService.scheduleAtFixedRate(new Runnable()
		    {
		        @Override
		        public void run() 
		        {
		        	_Excute();
		        }
		    }, 0, 5, TimeUnit.SECONDS);
		    
	 }
	 
	 public static void _Excute()
	 {
		 FileToMove("jpg", "C:\\Users\\Anwar\\Downloads", "C:\\Users\\Anwar\\Downloads\\Pictures");
		 FileToMove("JPG", "C:\\Users\\Anwar\\Downloads", "C:\\Users\\Anwar\\Downloads\\Pictures");
		 FileToMove("png", "C:\\Users\\Anwar\\Downloads", "C:\\Users\\Anwar\\Downloads\\Pictures");

		 FileToMove("pdf", "C:\\Users\\Anwar\\Downloads", "C:\\Users\\Anwar\\Downloads\\Text");
		 FileToMove("docx", "C:\\Users\\Anwar\\Downloads", "C:\\Users\\Anwar\\Downloads\\Text");
		 FileToMove("java", "C:\\Users\\Anwar\\Downloads", "C:\\Users\\Anwar\\Downloads\\Text");
		 FileToMove("rtf", "C:\\Users\\Anwar\\Downloads", "C:\\Users\\Anwar\\Downloads\\Text");

		 FileToMove("wav", "C:\\Users\\Anwar\\Downloads", "C:\\Users\\Anwar\\Downloads\\Audio");
		 FileToMove("mp3", "C:\\Users\\Anwar\\Downloads", "C:\\Users\\Anwar\\Downloads\\Audio");
		 
		 
		 FileToMove("zip", "C:\\Users\\Anwar\\Downloads", "C:\\Users\\Anwar\\Downloads\\Zip");
		 FileToMove("exe", "C:\\Users\\Anwar\\Downloads", "C:\\Users\\Anwar\\Downloads\\EXE");
		 
		 FileToMove("html", "C:\\Users\\Anwar\\Downloads", "C:\\Users\\Anwar\\Downloads\\HTML");

		 FileToMove("torrent", "C:\\Users\\Anwar\\Downloads", "C:\\Users\\Anwar\\Downloads\\Torrents");
	 }
	 
	 public static void FileToMove(String type, String Where, String MoveTo) 
	 {
		  Path _target = new File(MoveTo).toPath();
		  File dir = new File(Where);
		  File[] directoryListing = dir.listFiles();
		  if (directoryListing != null) 
		  {
		    for (File child : directoryListing) 
		    {
		    	int i = child.getName().lastIndexOf(".");		    	
		    	if (i >= 0) 
		    	{		   		    		
		    	    if(type.equals(child.getName().substring(i+1))) 
		    	    {	    	
		    	    	if(Files.exists(_target) == false) 
		    	    	{
		    	    		new File(MoveTo).mkdir();	
		    	    	}
		    	    	
	    	    		child.renameTo(new File(MoveTo, "." + child.getName()));
		    	    }
		    	}
		    }
		  }
	 }
	 
}
