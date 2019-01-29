package com.frame;

import java.util.ArrayList;

public interface Dao<K,V> {
	public void insert(V v);
	public void delete(K k);
	public void update(V v);
	public V select(K k);
	public ArrayList<V> select();
	
}
