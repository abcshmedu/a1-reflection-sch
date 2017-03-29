package edu.hm.cs.schnitzel.reflection;

public class Renderer {

	private final Object object;
	
	public Renderer(Object object) {
		this.object = object;
	}

	public String render() {
		
		getObject(); // TODO: do sth with this object
		
		return "";
	}
	
	private Object getObject() {
		return object;
	}
}
