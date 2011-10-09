package se.atrosys.stockholm.model;

/**
* Created by IntelliJ IDEA.
* User: ola
* Date: 10/9/11
* Time: 11:02 PM
* To change this template use File | Settings | File Templates.
*/
public class GeographicalArea {
	String id;
	String friendlyId;
	String name;
	boolean isCityArea;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFriendlyId() {
		return friendlyId;
	}

	public void setFriendlyId(String friendlyId) {
		this.friendlyId = friendlyId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isCityArea() {
		return isCityArea;
	}

	public void setCityArea(boolean cityArea) {
		isCityArea = cityArea;
	}
}
