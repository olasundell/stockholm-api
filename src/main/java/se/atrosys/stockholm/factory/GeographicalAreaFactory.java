package se.atrosys.stockholm.factory;

import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import se.atrosys.stockholm.model.GeographicalArea;

/**
 * Created by IntelliJ IDEA.
 * User: ola
 * Date: 10/11/11
 * Time: 8:51 PM
 * To change this template use File | Settings | File Templates.
 */
public class GeographicalAreaFactory {
	public GeographicalArea geographicalAreaFactory(HierarchicalStreamReader reader) {
		GeographicalArea area = new GeographicalArea();

		area.setCityArea(Boolean.parseBoolean(reader.getAttribute("isCityArea")));
		area.setId(reader.getAttribute("id"));
		area.setFriendlyId(reader.getAttribute("friendlyId"));
		area.setName(reader.getAttribute("name"));

		return area;
	}
}
