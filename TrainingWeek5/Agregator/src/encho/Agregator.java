package encho;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.FeedException;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;

/**
 * Servlet implementation class Agregator
 */
@WebServlet("/Agregator")
public class Agregator extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public Agregator() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter responseWriter = response.getWriter();
		responseWriter.append("<h1>Последни новини от днес:</h1> <br/><br/>");
		responseWriter.append("<h1>Спорт:</h1> <br/>");
		getRSS("http://www.sportal.bg/uploads/rss_category_2.xml",responseWriter);

		responseWriter.append("<h1>Технологии:</h1> <br/>");
		getRSS("http://www.dnevnik.bg/rss/?rubrid=1660",responseWriter);
		responseWriter.append("<h1>Всичко от България:</h1> <br/>");
		getRSS("http://www.dnevnik.bg/rss/?rubrid=1657",responseWriter);
		
	}
	
	private void getRSS(String urlString, PrintWriter responseWriter) throws IOException{
		URL url = new URL(urlString);
		HttpURLConnection urlConn = (HttpURLConnection) url.openConnection();
		SyndFeedInput inputSports = new SyndFeedInput();
		try {
			SyndFeed feedSport = inputSports
					.build(new XmlReader(urlConn));
			List entriesSport = feedSport.getEntries();
			Iterator sportsIterator = entriesSport.iterator();
			

			while (sportsIterator.hasNext()) {
				SyndEntry entry = (SyndEntry) sportsIterator.next();
				responseWriter.append("<a href='" + entry.getLink() + "'>"
						+ entry.getTitle() + "</a>" + "<br/>");
				responseWriter.append(entry.getDescription().getValue()
						+ "<br/>");
				responseWriter.append("<br/><br/>");
			}
			responseWriter.flush();
		} catch (IllegalArgumentException | FeedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
