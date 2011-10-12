package se.atrosys.stockholm.factory;

import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import se.atrosys.stockholm.model.GeographicalArea;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: ola
 * Date: 10/11/11
 * Time: 4:52 PM
 * To change this template use File | Settings | File Templates.
 */
public class GeographicalAreaListFactory {
	public List<GeographicalArea> geographicalAreaListFactory(HierarchicalStreamReader reader) {
		List<GeographicalArea> list = new ArrayList<GeographicalArea>();

		while (reader.hasMoreChildren()) {
			reader.moveDown();

			GeographicalArea e = new GeographicalAreaFactory().geographicalAreaFactory(reader);
			list.add(e);

			reader.moveUp();
		}

		return list;
	}
}
