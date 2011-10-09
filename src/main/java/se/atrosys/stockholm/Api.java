package se.atrosys.stockholm;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import se.atrosys.stockholm.converter.DetailedServiceUnitConverter;
import se.atrosys.stockholm.converter.ServiceUnitConverter;
import se.atrosys.stockholm.converter.SthlmListConverter;
import se.atrosys.stockholm.model.DetailedServiceUnit;
import se.atrosys.stockholm.model.GeographicalPosition;
import se.atrosys.stockholm.model.ServiceUnit;
import se.atrosys.stockholm.model.SthlmList;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: ola
 * Date: 10/8/11
 * Time: 10:09 PM
 * To change this template use File | Settings | File Templates.
 */
public class Api {

	private final String HOST = "http://api.stockholm.se/";
	private String apikey;
	private String service;

	public Api() throws IOException {
		service = "ServiceGuideService";

		if (System.getProperties().contains("apikey") && !System.getProperty("apikey").isEmpty()) {
			apikey = String.format("apikey=%s", System.getProperty("apikey"));
		} else {
			File apikey = new File("apikey");
			if (apikey.exists() && apikey.isFile()) {
				BufferedReader reader = new BufferedReader(new FileReader(apikey));
				this.apikey = String.format("apikey=%s",reader.readLine());
			}
		}
	}

	public List<SthlmList> retrieveTopLevel() throws IOException, ClassNotFoundException {
		XStream xstream = new XStream(new DomDriver());

		String spec = createUrlSpec(service, "");
		InputStreamReader reader = createInputStreamReader(spec);
		xstream.alias("Lists", ArrayList.class);

		xstream.registerConverter(new SthlmListConverter());
		xstream.alias("List", SthlmList.class);

		List<SthlmList> sthlmLists = (List<SthlmList>) xstream.fromXML(reader);

		return sthlmLists;
	}

	private InputStreamReader createInputStreamReader(String spec) throws IOException {
		URL url = new URL(spec);
		URLConnection conn = url.openConnection(new Proxy(Proxy.Type.HTTP,  new InetSocketAddress("localhost", 3128)));
		conn.connect();

		return new InputStreamReader(conn.getInputStream());
	}

	private String createUrlSpec(String service, String subservice) {
		return String.format("%s%s/%s?%s", HOST, service, subservice, apikey);
	}

	public Map<SthlmList, List> getSubLevels(List<SthlmList> list) throws IOException {
		XStream xstream = new XStream(new DomDriver());

		Map<SthlmList, List> map = new HashMap<SthlmList, List>();

		for (SthlmList l: list) {
			InputStreamReader reader = createInputStreamReader(createUrlSpec(service, l.getUri()));
			xstream.alias("ServiceUnits", ArrayList.class);
			xstream.alias("ServiceUnit", ServiceUnit.class);
			xstream.alias("GeographicalPosition", GeographicalPosition.class);
			xstream.registerConverter(new ServiceUnitConverter());
			List o = (List) xstream.fromXML(reader);
			map.put(l, o);
		}

		return map;
	}

	public DetailedServiceUnit getDetailedServiceUtil(ServiceUnit unit) throws IOException {
		XStream xstream = new XStream(new DomDriver());
		InputStreamReader reader = createInputStreamReader(createUrlSpec(service, "DetailedServiceUnits/"+unit.getId()));
		xstream.alias("DetailedServiceUnit", DetailedServiceUnit.class);
		xstream.registerConverter(new DetailedServiceUnitConverter());
		return (DetailedServiceUnit) xstream.fromXML(reader);
	}
}
