package Unit3;

import java.net.*;
import java.io.*;
class RetrievingData{
	public static void main(String[]args){
        URL url = null;
        try {
            url = new URL("http://www.kcmit.edu.np/index.php");
			URLConnection connection = url.openConnection();
			BufferedReader in = new BufferedReader(new
					InputStreamReader(connection.getInputStream()));
			String line;
			while((line=in.readLine())!= null){
				System.out.println(line);
			}
			in.close();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}