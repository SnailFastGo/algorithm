package com.coding.lru;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class LRUCache2<K, V> {
	private final int cacehSize;
	
	private final float DEFAULT_LOAD_FACTOR = 0.75f;
	
	/** true：按照访问顺序来判断元素的新旧
	 * false：按照插入顺序来判断元素的新旧
	 */
	private boolean accessOrder;
	
	LinkedHashMap<K, V> map;

	@SuppressWarnings("unchecked")
	public LRUCache2(int cacheSize, boolean accessOrder) {
		this.cacehSize = cacheSize;
//		 根据cacheSize和加载因子计算hashmap的capactiy，+1确保当达到cacheSize上限时不会触发hashmap的扩容，
		int capacity = (int) Math.ceil(cacehSize / DEFAULT_LOAD_FACTOR);
		map = new LinkedHashMap(capacity, DEFAULT_LOAD_FACTOR, accessOrder) {
			@Override
			protected boolean removeEldestEntry(Map.Entry eldest) {
				return size() > cacehSize;
			}
		};
	}

	public synchronized void put(K key, V value) {
		map.put(key, value);
	}

	public synchronized V get(K key) {
		return map.get(key);
	}

	public synchronized void remove(K key) {
		map.remove(key);
	}

	public synchronized Set<Map.Entry<K, V>> getAll() {
		return map.entrySet();
	}

	public synchronized int size() {
		return map.size();
	}

	public synchronized void clear() {
		map.clear();
	}
}
