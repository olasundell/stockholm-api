package se.atrosys.stockholm.model;

/**
* Created by IntelliJ IDEA.
* User: ola
* Date: 10/9/11
* Time: 11:02 PM
* To change this template use File | Settings | File Templates.
*/
public class Attribute<T> {
	String id;
	String name;
	String group;
	String groupDescription;
	T value;

	public String getGroupDescription() {
		return groupDescription;
	}

	public void setGroupDescription(String groupDescription) {
		this.groupDescription = groupDescription;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}
}
