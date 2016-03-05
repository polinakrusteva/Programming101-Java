package monday;

public class Pair<K, V> {
	private K key;
	private V value;
	
	public Pair(K key, V value){
		this.key = key;
		this.value = value;
	}
	
	public K getKey() {
		return key;
	}
	
	public void setKey(K newKey){
		key = newKey;
	}
	
	public V getValue(){
		return value;
	}
	
	public void setValue(V newValue){
		value = newValue;
	}

}
