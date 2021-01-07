package lab08;


// modified version of Chapter 16 LinkedIntList class (page 990)
public class LinkedIntList {
	public ListNode front; // first value in the list

	// post: constructs an empty list
	public LinkedIntList(){
		front = null;
	}

	public LinkedIntList(int[] arr){
		this();

		for (int i = 0; i < arr.length; i++)
			add(arr[i]);
	}

	// post: returns the current number of elements in the lists
	public int size(){
		int count = 0;
		ListNode current = front;
		while (current != null){
			current = current.next;
			count++;
		}
		return count;
	}

	// post: return comma-separated, bracketed version of the list
	public String toString(){
		if (front == null){
			return "[]";
		}else{
			String result = "[" + front.data;
			ListNode current = front.next;
			while (current != null){
				result += ", " + current.data;
				current = current.next;
			}
			result += "]";
			return result;
		}
	}

	// post: appends the given value to the end of the list
	public void add(int value){
		if (front == null){
			front = new ListNode(value);
		}else{
			ListNode current = front;
			while(current.next != null){
				current = current.next;
			}
			current.next = new ListNode(value);
		}
	}


	// pre: 0 <= index < size()
	// post: returns a reference to the node at the given index
	private ListNode nodeAt(int index){
		ListNode current = front;
		for (int i = 0; i < index; i++){
			current = current.next;
		}
		return current;
	}

	// pre: 0 <= index <= size()
	// post: inserts the given value at the given index
	public void add(int index, int value){
		if (index == 0){
			front = new ListNode(value, front);
		}else if (index == size()){
			add(value);
		}else if (index > size()){
			return;
		}else{
			ListNode current = nodeAt(index-1);
			current.next = new ListNode(value, current.next);
		}
	}

	//*************************************************

	// This method accepts an integer value as a parameter and returns the index in the list of
	// the last occurrence of that value, or -1 if the value is not found in the list.
	public int lastIndexOf(int value){
		//* FILL IN - DO NOT RETURN -1
		int lastIndex =-1;
		int index=0;
		ListNode current = front;
	
		while(current!=null) {
			if(current.data == value) {
			lastIndex=index;
		    }
			index++;
			current=current.next;
		}
		return lastIndex;
	}
			
//make sure when you remove an element, the previous will point to current value that you want to removes next v
// This method should remove all occurrence of a particular value.
//nodes previous will have to equal next
	public void removeAll(int value){
		//int index=0;
		ListNode current = front;
		ListNode previous=null;
		//if value is the front node
		while(current.data==value) {
			previous=current;
			current=current.next;
			previous.next=null;
			
		}
		front=current;
		
		while(current!=null) {
			if(current.data==value) {
			previous.next=current.next;
			current.next=null;
			}
			else {
				previous = current;
			}
			current=previous.next;
			
		}
		
	}

	
	// This method will rearrange the elements of a list of integers by moving to the end of the list all
	// values that are in odd-numbered positions and otherwise preserving list order. Remember, it does not
	// matter whether the value itself is odd or even; what matters is whether the value appears in an odd
	// index. Also, the original order of the elements of the list should otherwise be preserved.
	// You may not construct any new nodes nor use any auxiliary data structures to solve this problem.
	// You also may not change any data fields of the nodes; you must solve this problem by rearranging the
	// links of the list.
	public void shift(){
		//* FILL IN
		//move all odd indexes to end of list
		if(front == null) {
			return;
		}
		else {

		 if (front != null) {

		        int size = 1;

		        ListNode current = front;
		        while (current.next != null) {
		            current = current.next;
		            size++;
		        }
		        	ListNode prev = current;
		        	current = front;

		        	for (int i = 0; i < size / 2; i++) {
		        		prev.next = current.next;
		        		prev = prev.next;
		        		current.next = current.next.next;
		        		current = current.next;

		        	}
		        		prev.next = null;

		 
		 }
		}
		
	}

	// This method will double the size of the list by replacing every integer
	// in the list with two of that integer.
	// if the list is empty simply return
	public void stutter(){
		 ListNode current = front;
		
		 if (current==null){
			 return;
		 }
		     while (current != null) {
		       current.next = new ListNode(current.data, current.next);
		    	 current = current.next.next;
		    	 
		    } 
	
		
	}


}
