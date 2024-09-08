package Unit3;

import java.net.*;
import java.io.*;
class RetrievingData{
	public static void main(String[]args) throws Exception{
		URL url = new URL("https://www.kcmit.edu.np/index.php");
		URLConnection connection = url.openConnection();
		BufferedReader in = new BufferedReader(new
		InputStreamReader(connection.getInputStream()));
		String line;
		while((line=in.readLine())!= null){
			System.out.println(line);
		}
		in.close();
	}
}