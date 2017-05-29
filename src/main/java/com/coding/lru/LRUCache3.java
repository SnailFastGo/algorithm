package com.coding.lru;

import java.util.HashMap;

public class LRUCache3<K, V> {
	private final int MAX_CACHE_SIZE;
	
//	双向链表的头节点
	private Entry first;
	
//	双向链表的尾节点，指向最近最少使用的节点
	private Entry last;

	private HashMap<K, Entry<K, V>> hashMap;

	public LRUCache3(int cacheSize) {
		MAX_CACHE_SIZE = cacheSize;
		hashMap = new HashMap<K, Entry<K, V>>();
	}

	public void put(K key, V value) {
		Entry entry = getEntry(key);
		if (entry == null) {
//			当hashMap中存储的元素个数达到了缓存的阀值，则需要把最近最少访问的元素删除掉
			if (hashMap.size() >= MAX_CACHE_SIZE) {
				hashMap.remove(last.key);
//				双向链表last指向的节点就是最近最少使用的节点
				removeLast();
			}
			entry = new Entry();
			entry.key = key;
		}
		entry.value = value;
		moveToFirst(entry);
		hashMap.put(key, entry);
	}

	public V get(K key) {
		Entry<K, V> entry = getEntry(key);
		if (entry == null)
			return null;
		moveToFirst(entry);
		return entry.value;
	}

//	public void remove(K key) {
//		Entry entry = getEntry(key);
//		if (entry != null) {
//			if (entry.pre != null)
//				entry.pre.next = entry.next;
//			if (entry.next != null)
//				entry.next.pre = entry.pre;
//			if (entry == first)
//				first = entry.next;
//			if (entry == last)
//				last = entry.pre;
//		}
//		hashMap.remove(key);
//	}

	/**
	 * @param entry 将最新的节点移动到双向链表头，
	 * 				最新的节点有可能是新插入的节点，
	 * 				有可能是原先双向链表的头节点，
	 * 				有可能是原先双向链表的尾节点，
	 * 				也有可能是原先双向链表的中间节点
	 */
	private void moveToFirst(Entry entry) {
		if (entry == first)
			return;
		if (entry.pre != null)
			entry.pre.next = entry.next;
		if (entry.next != null)
			entry.next.pre = entry.pre;
		if (entry == last)
			last = last.pre;

		if (first == null || last == null) {
			first = last = entry;
			return;
		}
		
//		把entry插入到双向链表的头部
		entry.next = first;
		first.pre = entry;
		first = entry;
		
//		如果entry是原先双向链表的中间节点，则把entry插入到双向链表头部之后，要切断entry与之前节点前驱的联系
		entry.pre = null;
	}

	private void removeLast() {
//		删除双向链表的尾部节点，则把last往前移动一下就可以
		if (last != null) {
			last = last.pre;
//			如果last指针前移之后指向了null，说明原先双向链表中只有一个节点，删除之后last和first都应该指向null
			if (last == null)
				first = null;
			else
//				切断last与后继节点的联系
				last.next = null;
		}
	}

	private Entry<K, V> getEntry(K key) {
		return hashMap.get(key);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Entry entry = first;
		while (entry != null) {
			sb.append(String.format("%s:%s ", entry.key, entry.value));
			entry = entry.next;
		}
		return sb.toString();
	}

	class Entry<K, V> {
		public Entry pre;
		public Entry next;
		public K key;
		public V value;
	}
	
	public static void main(String[] args) {
		LRUCache3<String, String> cache = new LRUCache3<String, String>(3);
		cache.put("a", "1");
		cache.put("b", "1");
		cache.put("c", "1");
		cache.put("a", "1");
	}
}
