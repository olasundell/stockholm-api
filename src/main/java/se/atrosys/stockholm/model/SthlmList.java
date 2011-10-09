package se.atrosys.stockholm.model;

import java.net.URI;
import java.util.ArrayList;

/**
* Created by IntelliJ IDEA.
* User: ola
* Date: 10/9/11
* Time: 9:48 PM
* To change this template use File | Settings | File Templates.
*/
public class SthlmList extends ArrayList {
	private String name;
	private String uri;

	public void setName(String name) {
		this.name = name;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getName() {
		return name;
	}

	public String getUri() {
		return uri;
	}
}
