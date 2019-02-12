package com.frame;

import java.util.ArrayList;

import org.springframework.transaction.annotation.Transactional;

public interface Biz2<K,V,A,B> {
	@Transactional
	public void register(V v) throws Exception;
	@Transactional
	public void remove(K k) throws Exception;
	@Transactional
	public void modify(V v) throws Exception;
	public ArrayList<V> get(K k,A a,B b) throws Exception;
	public ArrayList<V> get() throws Exception;
}
