package com.coding.lru;

import java.util.LinkedHashMap;

public class LRUCache1<K, V>  extends LinkedHashMap<K, V>{
	
	private int cacheSize;
	
	
	/** true：按照访问顺序来判断元素的新旧
	 * false：按照插入顺序来判断元素的新旧
	 */
	private boolean accessOrder;
	
	public LRUCache1(int cacheSize, boolean accessOrder){
//		 根据cacheSize和加载因子计算hashmap的capactiy，+1确保当达到cacheSize上限时不会触发hashmap的扩容，
		super((int)Math.ceil(cacheSize / 0.75f) + 1, 0.75f, accessOrder);
		this.cacheSize = cacheSize;
	}

	@Override
	protected boolean removeEldestEntry(java.util.Map.Entry<K, V> eldest) {
		return size() > this.cacheSize;
	}
	
	 public static void main(String[] args) {
		 LRUCache1<String, String> cache = new LRUCache1<String, String>(3, true);
		 cache.put("a", "1");
		 cache.put("b", "2");
		 cache.put("c", "3");
		 cache.get("a");
		 cache.get("b");
		 cache.put("d", "4");
		 System.out.println(cache);
	}
}
