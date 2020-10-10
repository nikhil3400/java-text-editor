package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		// TODO: Implement this method
		head = new LLNode<E>();
		tail = new LLNode<E>();
		this.size = 0;
		head.next = tail;
		tail.prev = head;
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) 
	{
		// TODO: Implement this method
		if(element == null) {
			throw new NullPointerException("Cannot add null data");
		}
		
		LLNode<E> newNode = new LLNode<E>(element);
		if(head.next == tail) {
			head.next = newNode;
			newNode.prev = head;
			newNode.next = tail;
			tail.prev= newNode;
		}
		else {
			tail.prev.next = newNode;
			newNode.prev = tail.prev;
			newNode.next = tail;
			tail.prev = newNode;
		}
		this.size++;
		
		return true;
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) 
	{
		// TODO: Implement this method.
		if(index < 0 || index >= this.size) {
			throw new IndexOutOfBoundsException("OUt of bound: get");
		}
		
		LLNode<E> current = head.next;
		int point = 0;
		while(current != tail) {
			if(index == point) {
				return current.data;
			}
			current = current.next;
			point++;
		}

		return null;
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		// TODO: Implement this method
		if(element == null) {
			throw new NullPointerException("Cannot set null");
		}

		if(this.size != 0) {
			if(index < 0 || index >= this.size) {
				throw new IndexOutOfBoundsException("OUt of bound: add");
			}
		}
		
		int point = 0;
		LLNode<E> current = head.next;
		LLNode<E> newNode1 = new LLNode<E>(element);
		
		while(current != tail) {
			if(point == index) {
				break;
			}
			current = current.next;
			point++;
		}
		
		newNode1.prev = current.prev;
		newNode1.next = current;
		current.prev.next = newNode1;
		current.prev = newNode1;
		this.size++;
		
	}


	/** Return the size of the list */
	public int size() 
	{
		// TODO: Implement this method
		return this.size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
		// TODO: Implement this method
		if(index < 0 || index >= this.size) {
			throw new IndexOutOfBoundsException("OUt of bound: remove");
		}
		
		int point = 0;
		E rem;
		LLNode<E> current = head.next;
		
		while(current != tail) {
			if(point == index) {
				rem = current.data;
				current.prev.next = current.next;
				current.next.prev = current.prev;
				this.size--;
				return rem;
			}
			current = current.next;
			point++;
		}

		
		return null;
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) 
	{
		// TODO: Implement this method
		if(element == null) {
			throw new NullPointerException("Cannot set null");
		}
		
		if(index < 0 || index >= this.size) {
			throw new IndexOutOfBoundsException("OUt of bound: set");
		}
		
		int point = 0;
		LLNode<E> current = head.next;
		
		while(current != tail) {
			if(point == index) {
				current.data = element;
				return current.data;
			}
			current = current.next;
			point++;
		}
		
		return null;
	}   
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor
	
	public LLNode() {
		this.data = null;
	}

	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}

}
