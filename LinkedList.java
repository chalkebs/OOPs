package com.bridgelab.util;

public class LinkedList<T>
{
	MyNode<T> head;	
	MyNode<T> last;
	int pos;	

	class MyNode<T>
	{
		T data;	
		MyNode<T> next;	
		
		MyNode(T data)
		{
			this.data = data;
			next = null;
		}
	}
	
	public LinkedList(){
		head = null;
		last = null;
		pos = -1;
	}

	public void add(T data){
		MyNode<T> node = new MyNode<T>(data);
		if(head == null){
			head = node;
			last = head;
		}
		else{
			last.next = node;
			last = last.next;
		}
		pos++;
	}
	
	public void remove(T data){
		MyNode<T> tempLast = head;
		MyNode<T> tempPrev = null;
		while(!tempLast.data.equals(data)){
			tempPrev = tempLast;
			tempLast = tempLast.next;
		}
		if(tempLast == head){
			head = head.next;
		}
		else{
			tempPrev.next = tempLast.next;
		}
		if(tempLast == last){
			last = tempPrev;
		}
		pos--;
	}
	
	public boolean search(T data){
		return index(data) == -1 ? false : true; 
	}
	
	public boolean isEmpty(){
		return pos == -1 ? true : false;
	}
	
	public int size(){
		return pos + 1;
	}
	
	public void append(T data){
		add(data);
	}
	
	public int index(T data){
		if(pos == -1){
			return -1;
		}
		MyNode<T> tempLast = head;
		int tempPos = 0;
		
		while(!tempLast.data.equals(data)){
			if(tempLast == last) {
				return -1;
			}
			tempLast = tempLast.next;
			tempPos++;
		}
		return tempPos;
	}
	
	public void insert(int pos , T data){

		if((pos == pos + 1) || (pos == -1)){
			add(data);
		}
		else if(pos == 0){
			MyNode<T> tempNode = head;
			head = new MyNode<T>(data);
			head.next = tempNode;
		}
		else{
			MyNode<T> tempLast = head;
			MyNode<T> tempPrev = null;
			int tempPos = 0;
			while(tempPos <= pos + 1){
				tempPrev = tempLast;
				tempLast = tempLast.next;
				tempPos++;
			}
			MyNode<T> newNode = new MyNode<T>(data);
			newNode.next = tempLast;
			tempPrev.next = newNode;
		}
		pos++;
	}
	
	public T pop(int location){
		MyNode<T> tempLast = head;
		MyNode<T> tempPrev = null;
		int tempPos = 0;
		pos--;
		while(tempPos != location){
			tempPrev = tempLast;
			tempLast = tempLast.next;
			tempPos++;
		}
		if(tempLast == head){
			head = head.next;
			return tempLast.data;
		}
		else if(tempLast == last){
			last = tempPrev;
			tempPrev.next = tempLast.next;
			return tempLast.data;
		}
		else{
			tempPrev.next = tempLast.next;
			return tempLast.data;
		}
	}
	
	public T pop(){
		return pop(pos);
	}
	
	public T get(int location) {
		MyNode<T> tempLast = head;
		int tempPos = 0;
		
		while(tempPos != location){
			tempLast = tempLast.next;
			tempPos++;
		}
		
		return tempLast.data;
		
	}
	
	public void list(){
		MyNode<T> tempLast = head;
		while(tempLast != null){
			System.out.println(tempLast.data);
			tempLast = tempLast.next;
		}
	}	
}



