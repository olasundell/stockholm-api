package se.atrosys.stockholm.converter;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import se.atrosys.stockholm.factory.ServiceUnitFactory;
import se.atrosys.stockholm.model.DetailedServiceUnit;
import se.atrosys.stockholm.model.GeographicalPosition;

/**
 * Created by IntelliJ IDEA.
 * User: ola
 * Date: 10/9/11
 * Time: 10:49 PM
 * To change this template use File | Settings | File Templates.
 */
public class DetailedServiceUnitConverter implements Converter {
	@Override
	public void marshal(Object source, HierarchicalStreamWriter writer, MarshallingContext context) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
		DetailedServiceUnit detailedServiceUnit = new DetailedServiceUnit();

		detailedServiceUnit.setUnit(new ServiceUnitFactory().serviceUnitFactory(reader));

		reader.moveDown();

		Object o = reader.getValue();

		return detailedServiceUnit;
	}

	@Override
	public boolean canConvert(Class type) {
		return type.equals(DetailedServiceUnit.class);
	}
}
