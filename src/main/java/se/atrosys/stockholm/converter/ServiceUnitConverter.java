package se.atrosys.stockholm.converter;


import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import se.atrosys.stockholm.factory.ServiceUnitFactory;
import se.atrosys.stockholm.model.GeographicalPosition;
import se.atrosys.stockholm.model.ServiceUnit;

/**
 * Created by IntelliJ IDEA.
 * User: ola
 * Date: 10/9/11
 * Time: 10:11 PM
 * To change this template use File | Settings | File Templates.
 */
public class ServiceUnitConverter implements Converter {
	private final ServiceUnitFactory serviceUnitFactory = new ServiceUnitFactory();

	@Override
	public void marshal(Object o, HierarchicalStreamWriter hierarchicalStreamWriter, MarshallingContext marshallingContext) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public Object unmarshal(HierarchicalStreamReader hierarchicalStreamReader, UnmarshallingContext unmarshallingContext) {
		ServiceUnit unit = serviceUnitFactory.serviceUnitFactory(hierarchicalStreamReader);

		return unit;
	}

	@Override
	public boolean canConvert(Class aClass) {
		return aClass.equals(ServiceUnit.class);
	}
}
