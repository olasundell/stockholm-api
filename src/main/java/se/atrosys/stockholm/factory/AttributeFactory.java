package se.atrosys.stockholm.factory;

import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import se.atrosys.stockholm.model.Attribute;
import se.atrosys.stockholm.model.FileInfo;
import se.atrosys.stockholm.model.ServiceUnitTypeInfo;
import se.atrosys.stockholm.model.Values;
import sun.java2d.SunGraphicsEnvironment;


/**
 * Created by IntelliJ IDEA.
 * User: ola
 * Date: 10/10/11
 * Time: 10:45 PM
 * To change this template use File | Settings | File Templates.
 */
public class AttributeFactory {
	Logger logger = LoggerFactory.getLogger(this.getClass());

	public Attribute attributeFactory(HierarchicalStreamReader reader) {
		reader.moveDown();

		if (reader.getNodeName().equals("String")) {
			return createAttribute(new Attribute<String>(), reader.getValue(), reader);
		} else if (reader.getNodeName().equals("Integer")) {
			return createAttribute(new Attribute<Integer>(), Integer.valueOf(reader.getValue()), reader);
		} else if (reader.getNodeName().equals("FileInfo")) {
			return createAttribute(new Attribute<FileInfo>(), new FileInfoFactory().fileInfoFactory(reader.getValue()), reader);
		} else if (reader.getNodeName().equals("Values")) {
			return createAttribute(new Attribute<Values>(), new ValuesFactory().valuesFactory(reader.getValue()), reader);
		} else if (reader.getNodeName().equals("ServiceUnitTypeInfo")) {
			return createAttribute(new Attribute<ServiceUnitTypeInfo>(), new ServiceUnitTypeInfoFactory().serviceUnitTypeInfoFactory(reader.getValue()), reader);
		} else {
			logger.error(String.format("An error occurred while trying to create an attribute, NodeName is %s", reader.getNodeName()));
		}

		return null;

	}

	private <T> Attribute<T> createAttribute(Attribute<T> attribute, T value, HierarchicalStreamReader reader) {
		reader.moveUp();

		attribute.setValue(value);
		attribute.setGroup(reader.getAttribute("group"));
		attribute.setGroupDescription(reader.getAttribute("groupdescription"));
		attribute.setId(reader.getAttribute("id"));
		attribute.setName(reader.getAttribute("name"));


		return attribute;
	}
}
