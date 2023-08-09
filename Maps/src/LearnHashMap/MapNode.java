package LearnHashMap;

public class MapNode<K , V> {
	K key; //key  store the value K
	V Value; // store the value V
	
	MapNode<K ,V> next;  // next node initially null
	

	public MapNode(K key , V value){  //constructor
		this.key = key;
		this.Value = value;
	}


	public MapNode<K, V> next() {
		// TODO Auto-generated method stub
		return null;
	}
}
