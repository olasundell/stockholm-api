package se.atrosys.stockholm.converter;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import se.atrosys.stockholm.model.SthlmList;

/**
 * Created by IntelliJ IDEA.
 * User: ola
 * Date: 10/9/11
 * Time: 9:47 PM
 * To change this template use File | Settings | File Templates.
 */
public class SthlmListConverter implements Converter {
	@Override
	public void marshal(Object o, HierarchicalStreamWriter hierarchicalStreamWriter, MarshallingContext marshallingContext) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public Object unmarshal(HierarchicalStreamReader hierarchicalStreamReader, UnmarshallingContext unmarshallingContext) {
		SthlmList list = new SthlmList();

		list.setName(hierarchicalStreamReader.getAttribute("name"));
		list.setUri(hierarchicalStreamReader.getAttribute("uri"));

		return list;
	}

	@Override
	public boolean canConvert(Class aClass) {
		return aClass.equals(SthlmList.class);
	}
}
