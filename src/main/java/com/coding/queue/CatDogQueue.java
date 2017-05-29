package com.coding.queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/** 猫狗队列
 * 实现一个队列，具有如下方法： add, pollAll, pollDog, pollCat, isEmpty, isDogEmpty, isCatEmpty
 * @author snailfast
 *
 */
public class CatDogQueue {
	
	/**宠物的基类，已指定，不允许修改
	 * @author snailfast
	 *
	 */
	private class Pet{
		private String type;
		
		public Pet(String type){
			this.type = type;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		
	}
	
	
	/**狗类，已指定，不允许修改
	 * @author snailfast
	 *
	 */
	private class Dog extends Pet{
		public Dog(){
			super("dog");
		}
	}
	
	
	/**猫类，已指定，不允许修改
	 * @author snailfast
	 *
	 */
	private class Cat extends Pet{
		public Cat(){
			super("cat");
		}
	}
	
	/**创建带有时间戳的实体类
	 * @author snailfast
	 *
	 */
	private class PetEntry{
		private Pet pet;
		private long num;
		public PetEntry(Pet pet, long num){
			this.pet = pet;
			this.num = num;
		}
		public Pet getPet() {
			return pet;
		}
		public long getNum() {
			return num;
		}
	}
	
	private Queue<PetEntry> dogQueue;
	private Queue<PetEntry> catQueue;
	private long count;
	
	public CatDogQueue(){
//		猫队列
		this.dogQueue = new LinkedList<PetEntry>();
		
//		狗队列
		this.catQueue = new LinkedList<PetEntry>();
		
//		猫狗时间戳
		this.count = 0;
	}
	
	public void add(Pet pet){
		long num = this.getCount();
		PetEntry petEntry = new PetEntry(pet, num);
		if(pet instanceof Cat){
			catQueue.add(petEntry);
		}
		if(pet instanceof Dog){
			dogQueue.add(petEntry);
		}
	}
	
	public void incrCount(){
		this.count ++;
	}
	
	public long getCount(){
		return count;
	}
	public List<Pet> pollAll(){
		List<Pet> res = new ArrayList<Pet>();
		if(isEmpty()){
			return res;
		}else if(isDogEmpty() && !isCatEmpty()){
			res = this.pollCat();
			return res;
		}else if(!isDogEmpty() && isCatEmpty()){
			res = this.pollDog();
			return res;
		}else{
			while(isDogEmpty() && isCatEmpty()){
				PetEntry dogEntry = this.dogQueue.peek();
				PetEntry catEntry = this.catQueue.peek();
				if(null == dogEntry){
					res.add(catEntry.getPet());
				}else if(null == catEntry){
					res.add(dogEntry.getPet());
				}else if(null != dogEntry && null != catEntry){
					long dogNum = dogEntry.getNum();
					long catNum = catEntry.getNum();
					PetEntry petEntry = dogNum < catNum ? dogEntry : catEntry;
					res.add(petEntry.getPet());
				}
			}
		}
		return res;
	}
	
	public List<Pet> pollDog(){
		List<Pet> res = new ArrayList<Pet>();
		while(!dogQueue.isEmpty()){
			PetEntry petEntry = this.dogQueue.poll();
			res.add(petEntry.getPet());
		}
		return res;
	}
	
	public List<Pet> pollCat(){
		List<Pet> res = new ArrayList<Pet>();
		while(!catQueue.isEmpty()){
			PetEntry petEntry = catQueue.poll();
			res.add(petEntry.getPet());
		}
		return res;
	}
	
	public boolean isEmpty(){
		return catQueue.isEmpty() && dogQueue.isEmpty();
	}
	
	public boolean isDogEmpty(){
		return dogQueue.isEmpty();
	}
	
	public boolean isCatEmpty(){
		return catQueue.isEmpty();
	}
}
