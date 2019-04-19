public class LinkedList {
	public Node head = null;
	private int size = 0;
	
	public void print(){
        if(head == null) return;
        Node i = head;
        while(i!= null){
            System.out.println(i.data);
            i = i.next;
        }
    }
	
    public void add(int index, Object element) {
       if(index >= size) return;
       if(index == 0){
           Node newnode = new Node(element);
           newnode.next = head;
           head = newnode; 
           size++;
       }
       else{
         int counter =0;
         Node i = head;
         while(counter < index-1){
            i = i.next;
            counter++;
         }
         Node newnode = new Node(element);
         newnode.next = i.next;
         i.next = newnode;
         size++;
       }
    }

    public void add(Object element) {
        Node newnode = new Node(element);
        if(head == null){
            head = newnode;
            size++;
        }else{
        Node i = head;
        while(i.next != null) i = i.next;
        i.next = newnode;
        size++;
        }
    }
	
	public Object get(int index) {
		if(index >= size) return null;
		Node pointer = head;
		for(int i = 0; i < index; i++)
			pointer = pointer.next;
		return pointer.data;
	}
	
	public void set(int index, Object element) {
		if(index >= size) return;
		Node pointer = head;
		for(int i = 0; i < index-1; i++) 
			pointer = pointer.next;
		pointer.data = element;
	}
	
	public void clear() {
		head = null;
	}
	
	public boolean isEmpty() {
		if(head == null)
			return true;
		return false;
	}
	
	public void remove(int index) {
		if(head == null & index >= size) return;
		if(index == 0) {
			head = head.next;
			return;
		}
		Node pointer = head;
		for(int i = 0; i < index-1; i++)
			pointer = pointer.next;
		pointer.next = pointer.next.next;
		size--;
	}
	
	public int size() {
		return size;
	}
	
	public Node sublist(int fromIndex, int toIndex) {
		if(fromIndex >= size & toIndex >= size) return null;
		Node pointer = head;
		int i;
		for(i = 0; i < fromIndex; i++) 
			pointer = pointer.next;
		Node pointer2 = pointer;
		for(int j = i; j < toIndex; j++)
			pointer2 = pointer2.next;
		pointer2.next = null;
		return pointer;
	}
	
	public boolean contains(Object o) {
		for(Node pointer = head; pointer != null; pointer = pointer.next){
			if(pointer.data == o)
				return true;
		}
		return false;
	}
}
