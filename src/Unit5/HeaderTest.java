package Unit5;

import java.net.*;
import java.util.*;
class HeaderTest{
	public static void main(String[] args) throws Exception{
		URL url = new URL("https://fohss.tu.edu.np/index.php");
		HttpURLConnection con=(HttpURLConnection)url.openConnection();
		Map<String,List<String>>headers = con.getHeaderFields();
	   System.out.println(headers.size());
		for (String key : headers.keySet()) {
			System.out.println(key + ": " +headers.get(key));
		}
	}
}