package monday;

public class GenericBackpack<T> {
	private T obj;

	public GenericBackpack(T obj) {
		this.obj = obj;
	}
	
	public T getObj() {
		return obj;
	}

	public void setObj(T newObj) {
		obj = newObj;
	}

}
