package webScraper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


import com.opencsv.CSVWriter;

public class focusedCrawler {

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
			document = Jsoup.connect("https://pec.ac.in/faculty-index").ignoreContentType(true).userAgent("Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:25.0) Gecko/20100101 Firefox/25.0")
		               .referrer("http://www.google.com").ignoreHttpErrors(true).get();

			Element table = document.select("table").get(0); //select the first table.
			Elements rows = table.select("tr");
			
			
			// Using open CSV
			File file = new File("faculty.csv"); 
			
		    // create FileWriter object with file as parameter and true parameter so that this CSV file gets appended on repeated calls
		    FileWriter outputfile = new FileWriter(file, true); 
		  
		    // create CSVWriter object file writer object as parameter 
		    CSVWriter writer = new CSVWriter(outputfile); 
		     
		    // adding header to CSV 
		    String[] header = { "Title", "Profile Link",  "Department", "Designation", "Qualification", "Research Interests", "Profile Image"}; 
		    writer.writeNext(header); 
		  
		    // add data to CSV
		    for (int i=1; i < rows.size(); i++) 
		    {	
		    	Element row = rows.get(i);
		        Elements cols = row.select("td");
		        
		        Elements images = cols.select("img[src~=(?i)\\.(png|jpe?g|gif)]");
		        Elements links = cols.select("a[href]");
		
		        String[] data = {cols.get(1).text(),links.get(0).attr("abs:href"), cols.get(2).text(),cols.get(3).text(),cols.get(4).text(),cols.get(5).text(),cols.get(6).text(), images.get(0).attr("src")};
			    writer.writeNext(data);
		    }
		    
		    // closing writer connection 
		    writer.close(); 		    	
		}
		// catching various exceptions
		catch (NullPointerException e) 
		{
	        // TODO Auto-generated catch block
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
