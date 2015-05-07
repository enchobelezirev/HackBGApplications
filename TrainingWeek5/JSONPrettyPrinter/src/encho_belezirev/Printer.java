package encho_belezirev;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringReader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpClientParams;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;

/**
 * Servlet implementation class Printer
 */
@WebServlet("/Printer")
public class Printer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public Printer() {
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		StringBuilder jsonBuilder = new StringBuilder();
		String line = null;
		try(BufferedReader readerJSON = new BufferedReader(new InputStreamReader(new FileInputStream(new File("C:\\Users\\Belezirev\\Desktop\\checkins.json")), "UTF8"))){
			while((line = readerJSON.readLine()) != null){
				jsonBuilder.append(line);
			}
		}
		JsonReader reader = new JsonReader(new StringReader(new String(jsonBuilder.toString())));
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		JsonParser jp = new JsonParser();
		JsonElement je = jp.parse(reader);

		String prettyJsonString = gson.toJson(je);
		PrintWriter out = response.getWriter();
		out.println(prettyJsonString);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String uglyJSON = request.getParameter("json");
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		JsonParser jp = new JsonParser();
		JsonElement je = jp.parse(uglyJSON);

		String prettyJsonString = gson.toJson(je);
		PrintWriter out = response.getWriter();
		out.println(prettyJsonString);
	}

}
