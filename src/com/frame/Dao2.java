package com.frame;

import java.util.ArrayList;

import com.vo.WorkHistory;

public interface Dao2<K,V,A,B> {
	public void insert(V v);
	public void delete(K k);
	public void update(V v);
	public ArrayList<V> select(K k,A a,B b);
	public ArrayList<V> select();
	
}
