package se.atrosys.stockholm.factory;

import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import se.atrosys.stockholm.model.GeographicalPosition;
import se.atrosys.stockholm.model.ServiceUnit;

public class ServiceUnitFactory {
	public ServiceUnit serviceUnitFactory(HierarchicalStreamReader reader) {
		ServiceUnit unit = new ServiceUnit();
		unit.setId(reader.getAttribute("id"));
		unit.setName(reader.getAttribute("name"));
		unit.setTimeCreated(reader.getAttribute("timeCreated"));

		reader.moveDown();

		GeographicalPosition position = new GeographicalPosition();

		position.setX(reader.getAttribute("x"));
		position.setY(reader.getAttribute("y"));

		unit.setGeographicalPosition(position);

		reader.moveUp();

		return unit;
	}
}