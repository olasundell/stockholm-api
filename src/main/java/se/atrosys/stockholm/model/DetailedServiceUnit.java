package se.atrosys.stockholm.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: ola
 * Date: 10/9/11
 * Time: 10:40 PM
 * To change this template use File | Settings | File Templates.
 */
public class DetailedServiceUnit {
	ServiceUnit unit;
	List<Attribute> attributes = new ArrayList<Attribute>();
	List<GeographicalArea> geographicalAreas = new ArrayList<GeographicalArea>();
	List<ServiceUnit> relatedServiceUnits = new ArrayList<ServiceUnit>();

	public ServiceUnit getUnit() {
		return unit;
	}

	public void setUnit(ServiceUnit unit) {
		this.unit = unit;
	}

	public boolean addAttribute(Attribute attribute) {
		return attributes.add(attribute);
	}

	public boolean addGeographicalArea(GeographicalArea geographicalArea) {
		return geographicalAreas.add(geographicalArea);
	}

	public boolean addRelatedServiceUnit(ServiceUnit serviceUnit) {
		return relatedServiceUnits.add(serviceUnit);
	}

	public List<Attribute> getAttributes() {
		return attributes;
	}

	public List<GeographicalArea> getGeographicalAreas() {
		return geographicalAreas;
	}

	public List<ServiceUnit> getRelatedServiceUnits() {
		return relatedServiceUnits;
	}
}
