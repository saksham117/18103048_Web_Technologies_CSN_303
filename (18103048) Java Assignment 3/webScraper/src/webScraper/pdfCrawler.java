package webScraper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.opencsv.CSVWriter;

public class pdfCrawler {
	
	// setting the max_depth for depth first crawling of the web sites
		private static final int MAX_DEPTH = 10;
		
		private static int count= 1;
		// creating a set which contains a list of all the links that have been visited till now so that they are not visited again
	    static Set<String> pagesVisited = new HashSet<String>();
	    static Set<String> pdfVisited = new HashSet<String>();
	    
	    
	    // this is the recursive function for crawling
	    public static void crawl_next(String url, int depth) 
	    {
	    	// used by JSoup for storing the contents of the Web page it has crawled
	    	Document document;
			
			try {
				
				// if current depth exceeds max_depth set by us
				if(depth > MAX_DEPTH)
				{
					return;
				}
				
				//Get Document object after parsing the HTML from given URL.
				// we are ignoring the file types that cannot be parsed by JSoup
				// we are using userAgent and referrer to make the server believe we are not a bot
				// we are ignoring the web pages which are showing 404 error
				document = Jsoup.connect(url).ignoreContentType(true).userAgent("Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:25.0) Gecko/20100101 Firefox/25.0")
			               .referrer("http://www.google.com").ignoreHttpErrors(true).get();

				
				Elements links = document.select("a[href]");
				Elements iframe = document.select("iframe");
				
			
				 // now making recursive calls to the crawl_next function and visiting only those pages which have not been visited once
			    for(int i = 0; i < links.size(); i++)
			    {	
			    	String path = links.get(i).attr("abs:href");
			    	if(!pagesVisited.contains(path))
			    	{	
			    		pagesVisited.add(path);
			    		
			    		if(path.endsWith(".pdf") && !pdfVisited.contains(path))
			    		{
			    			pdfVisited.add(path);
			    			File file2 = new File("pdf_links.csv"); 
			    			
			    		    // create FileWriter object with file as parameter and true parameter so that this CSV file gets appended on repeated calls
			    		    FileWriter outputfile2 = new FileWriter(file2, true); 
			    		  
			    		    // create CSVWriter object file writer object as parameter 
			    		    CSVWriter writer2 = new CSVWriter(outputfile2); 
			    		     
			    		    String[] data = { Integer.toString(count++), path};
					    	writer2.writeNext(data);
					    	
			    		    // closing writer connection 
			    		    writer2.close(); 
			    		}
			    		
			    		if(path.length() > 18 && path.substring(0,18).equals("https://pec.ac.in/"))
			    		{	
			    			crawl_next(path, depth + 1);
			    		}
			    			
			    	}
			    }	
			    
			    for(int i = 0; i < iframe.size(); i++)
			    {	
			    	String path = iframe.get(i).attr("data-src");
			    	
			    	if(!pagesVisited.contains(path))
			    	{	
			    		pagesVisited.add(path);
			    		
			    		if(path.endsWith(".pdf") && !pdfVisited.contains(path))
			    		{
			    			pdfVisited.add(path);
			    			File file2 = new File("pdf_links.csv"); 
			    			
			    		    // create FileWriter object with file as parameter and true parameter so that this CSV file gets appended on repeated calls
			    		    FileWriter outputfile2 = new FileWriter(file2, true); 
			    		  
			    		    // create CSVWriter object file writer object as parameter 
			    		    CSVWriter writer2 = new CSVWriter(outputfile2); 
			    		     
			    		    String[] data = { Integer.toString(count++), path};
					    	writer2.writeNext(data);
					    	
			    		    // closing writer connection 
			    		    writer2.close(); 
			    		}
			    		
			    		if(path.length() > 18 && path.substring(0,18).equals("https://pec.ac.in/"))
			    		{	
			    			crawl_next(path, depth + 1);
			    		}
			    	}
			    }	  	
			}
			// catching various exceptions
			catch (NullPointerException e) 
			{
		        e.printStackTrace();
		    } 
			catch (HttpStatusException e) 
			{
		        e.printStackTrace();
			}
			catch (IOException e) 
			{
				e.printStackTrace();
			}
	    }
	    

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("running...");
		
		Document document;
		
		// in main file we are scraping the home page
		try {
			//Get Document object after parsing the HTML from given URL.
			// we are ignoring the file types that cannot be parsed by JSoup
			// we are using userAgent and referrer to make the server believe we are not a bot
			// we are ignoring the web pages which are showing 404 error
			document = Jsoup.connect("https://pec.ac.in/").ignoreContentType(true).userAgent("Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:25.0) Gecko/20100101 Firefox/25.0")
		               .referrer("http://www.google.com").ignoreHttpErrors(true).get();

			
			Elements links = document.select("a[href]");
			Elements iframe = document.select("iframe");
			
			// Using open CSV
			File file = new File("pdf_links.csv"); 
			
		    // create FileWriter object with file as parameter and true parameter so that this CSV file gets appended on repeated calls
		    FileWriter outputfile = new FileWriter(file, true); 
		  
		    // create CSVWriter object file writer object as parameter 
		    CSVWriter writer = new CSVWriter(outputfile); 
		     
		    // adding header to CSV 
		    String[] header = { "PDF Number", "Link"}; 
		    writer.writeNext(header); 
		    
		    // closing writer connection 
		    writer.close(); 

			 // now making recursive calls to the crawl_next function and visiting only those pages which have not been visited once
		    for(int i = 1; i < links.size(); i++)
		    {	
		    	String path = links.get(i).attr("abs:href");
		    	if(!pagesVisited.contains(path))
		    	{	
		    		pagesVisited.add(path);
		    		
		    		if(path.endsWith(".pdf") && !pdfVisited.contains(path))
		    		{
		    			pdfVisited.add(path);
		    			// Using open CSV
		    			File file2 = new File("pdf_links.csv"); 
		    			
		    		    // create FileWriter object with file as parameter and true parameter so that this CSV file gets appended on repeated calls
		    		    FileWriter outputfile2 = new FileWriter(file2, true); 
		    		  
		    		    // create CSVWriter object file writer object as parameter 
		    		    CSVWriter writer2 = new CSVWriter(outputfile2); 
		    		     
		    		    String[] data = { Integer.toString(count++), path};
				    	writer2.writeNext(data);
				    	
		    		    // closing writer connection 
		    		    writer2.close(); 
		    			
		    		}
		    		
		    		if(path.length() > 18 && path.substring(0,18).equals("https://pec.ac.in/"))
		    		{	
		    			crawl_next(path, 0);
		    		}
		    			
		    	}
		    }	
			
		    
		    for(int i = 0; i < iframe.size(); i++)
		    {	
		    	String path = iframe.get(i).attr("data-src");
		    	
		    	if(!pagesVisited.contains(path))
		    	{	
		    		pagesVisited.add(path);
		    		
		    		if(path.endsWith(".pdf") && !pdfVisited.contains(path))
		    		{
		    			pdfVisited.add(path);
		    			
		    			File file2 = new File("pdf_links.csv"); 
		    			
		    		    // create FileWriter object with file as parameter and true parameter so that this CSV file gets appended on repeated calls
		    		    FileWriter outputfile2 = new FileWriter(file2, true); 
		    		  
		    		    // create CSVWriter object file writer object as parameter 
		    		    CSVWriter writer2 = new CSVWriter(outputfile2); 
		    		     
		    		    String[] data = { Integer.toString(count++), path};
				    	writer2.writeNext(data);
				    	
		    		    // closing writer connection 
		    		    writer2.close(); 
		    		}
		    		
		    		if(path.length() > 18 && path.substring(0,18).equals("https://pec.ac.in/"))
		    		{	
		    			crawl_next(path, 0);
		    		}
		    			
		    	}
		    }	
	  
		  

		}
		// catching various exceptions
		catch (NullPointerException e) 
		{
	        e.printStackTrace();
	    } 
		catch (HttpStatusException e) 
		{
	        e.printStackTrace();
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		System.out.println("Done.");
	}

}
