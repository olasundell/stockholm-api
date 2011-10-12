package se.atrosys.stockholm;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import se.atrosys.stockholm.model.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.testng.Assert.*;

/**
 * Created by IntelliJ IDEA.
 * User: ola
 * Date: 10/8/11
 * Time: 10:21 PM
 * To change this template use File | Settings | File Templates.
 */
public class ApiTest {
	private Api api;

	@BeforeMethod
	public void before() throws IOException {
		api = new Api();
	}

	@Test
	public void fromXmlShouldReturnInstance() throws ClassNotFoundException, IOException {
		List<SthlmList> sthlmLists = api.retrieveTopLevel();
		assertNotNull(sthlmLists);
		assertNotEquals(sthlmLists.size(), 0);
	}

	@Test
	public void retrieveSubLevelsShouldReturnList() throws IOException {
		ArrayList<SthlmList> sthlmLists = new ArrayList<SthlmList>();

		SthlmList e = new SthlmList();
		e.setName("ServiceUnits");
		e.setUri("ServiceUnits");
		sthlmLists.add(e);

/*		e = new SthlmList();
		e.setName("ServiceUnitInfos");
		e.setUri("ServiceUnitInfos");
		sthlmLists.add(e);*/

		Map<SthlmList, List> map = api.getSubLevels(sthlmLists);

		assertNotNull(map);
		assertNotEquals(map.size(), 0, "Map is empty");
		assertEquals(map.size(), sthlmLists.size());
		assertEquals(map.keySet(), sthlmLists);
		for (SthlmList l: sthlmLists) {
			assertNotNull(map.get(l));
			assertNotEquals(map.get(l).size(), 0, String.format("List for %s is empty", l.getName()));
		}
	}

	@Test
	public void getDetailedServiceUnitShouldReturnInstance() throws IOException {
		ServiceUnit unit = new ServiceUnit();
		unit.setId("f06a6e42-573f-4e8d-b84f-8401fe350214");

		DetailedServiceUnit detailedServiceUnit = api.getDetailedServiceUtil(unit);
		assertNotNull(detailedServiceUnit);

		assertAttributeList(detailedServiceUnit.getAttributes());

		List<GeographicalArea> geographicalAreas = detailedServiceUnit.getGeographicalAreas();

		assertNotNull(geographicalAreas);
//		assertNotEquals(geographicalAreas.size(), 0, "List is empty");
	}

	private void assertAttributeList(List<Attribute> attributes) {
		assertNotNull(attributes);
		assertNotEquals(attributes.size(), 0, "List is empty");
		assertTrue(attributes.size() > 5, "List is too small");

		for (Attribute attribute: attributes) {
			assertAttribute(attribute);
		}
	}

	private void assertAttribute(Attribute attribute) {
		assertNotNull(attribute);
//		assertNotNull(attribute.getValue());
		assertNotNull(attribute.getId());
		assertFalse(attribute.getId().isEmpty());
	}
}
