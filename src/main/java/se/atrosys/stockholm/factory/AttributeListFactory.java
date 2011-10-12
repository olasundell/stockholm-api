package se.atrosys.stockholm.factory;

import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import se.atrosys.stockholm.model.Attribute;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: ola
 * Date: 10/10/11
 * Time: 9:05 PM
 * To change this template use File | Settings | File Templates.
 */
public class AttributeListFactory {
	Logger logger = LoggerFactory.getLogger(this.getClass());

	public Collection<Attribute> attributeListFactory(HierarchicalStreamReader reader) {
		if (!reader.getNodeName().equals("Attributes")) {
			// TODO throw an exception
			logger.error("Trying to create an attribute list without a properly positioned reader");
		}
		List<Attribute> list = new ArrayList<Attribute>();


		while (reader.hasMoreChildren()) {
			reader.moveDown();

			Attribute e = new AttributeFactory().attributeFactory(reader);
			list.add(e);

			reader.moveUp();
		}


		return list;
	}
}
