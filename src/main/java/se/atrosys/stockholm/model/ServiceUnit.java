package se.atrosys.stockholm.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * Created by IntelliJ IDEA.
 * User: ola
 * Date: 10/9/11
 * Time: 10:10 PM
 * To change this template use File | Settings | File Templates.
 */

@XStreamAlias("ServiceUnit")
public class ServiceUnit {
	private String id;
	private String name;
	private String timeCreated;
	@XStreamAlias("GeographicalPosition")
	GeographicalPosition geographicalPosition;

	public ServiceUnit() {};

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setTimeCreated(String timeCreated) {
		this.timeCreated = timeCreated;
	}

	public void setGeographicalPosition(GeographicalPosition position) {
		this.geographicalPosition = position;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getTimeCreated() {
		return timeCreated;
	}

	public GeographicalPosition getGeographicalPosition() {
		return geographicalPosition;
	}
}
