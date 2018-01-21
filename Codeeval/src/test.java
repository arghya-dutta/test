import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class test {
	public static void main(String[] args) {
		URL myURL;
		try {
			String data = URLEncoder.encode("frm_dy", "UTF-8") + "="
					+ URLEncoder.encode("01", "UTF-8") + "&"
					+ URLEncoder.encode("frm_mth", "UTF-8") + "="
					+ URLEncoder.encode("01", "UTF-8") + "&"
					+ URLEncoder.encode("frm_yr", "UTF-8") + "="
					+ URLEncoder.encode("2014", "UTF-8") + "&"
					+ URLEncoder.encode("to_dy", "UTF-8") + "="
					+ URLEncoder.encode("01", "UTF-8") + "&"
					+ URLEncoder.encode("to_mth", "UTF-8") + "="
					+ URLEncoder.encode("01", "UTF-8") + "&"
					+ URLEncoder.encode("to_yr", "UTF-8") + "="
					+ URLEncoder.encode("2015", "UTF-8") + "&"
					+ URLEncoder.encode("x", "UTF-8") + "="
					+ URLEncoder.encode("19", "UTF-8") + "&"
					+ URLEncoder.encode("y", "UTF-8") + "="
					+ URLEncoder.encode("8", "UTF-8") + "&"
					+ URLEncoder.encode("hdn", "UTF-8") + "="
					+ URLEncoder.encode("daily", "UTF-8");

			myURL = new URL(
					"http://www.moneycontrol.com/stocks/hist_stock_result.php?ex=N&sc_id=JKC&mycomp=JK%20Lakshmi%20Cement");
			URLConnection myURLConnection = myURL.openConnection();
			myURLConnection.setDoOutput(true);
			OutputStreamWriter wr = new OutputStreamWriter(
					myURLConnection.getOutputStream());
			wr.write(data);
			wr.flush();
			// myURLConnection.connect();
			BufferedReader in = new BufferedReader(new InputStreamReader(
					myURLConnection.getInputStream()));
			String inputLine;
			while ((inputLine = in.readLine()) != null)
				System.out.println(inputLine);
			in.close();
			wr.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
