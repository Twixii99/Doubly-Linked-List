package let;

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
       if(index > size || index <0) return;
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
    
    public void add(Object element,char poly) {
        Node newnode = new Node(element);
        newnode.name = poly;
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
	
	public Object get(char poly) {
		Node pointer = head;
		for(int i = 0; i < size; i++) {
			if(pointer.name == poly) return pointer.data;
			else pointer = pointer.next;
		}
		return null;
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
	
	public void remove(char poly) {
		Node pointer = head;
		if(pointer.name == poly) {
			head = head.next;
			return;
		}
		Node i = null;
		int counter = 0;
		while(counter < size-1) {
			if(pointer.next.name == poly){
                            i = pointer;
                            break;
                        }
			counter++;
			pointer = pointer.next;
		}
		i.next = i.next.next;
		size--;	
	}
        
        public void modify(char poly , Object element){
            Node i = head;
            while(i!= null){
                if(i.name == poly) {
                    i.data = element;
                    break;
                }
                i=i.next;
            }
        }
	
	public int size() {
		return size;
	}
	
	public int size() {
		return size;
	}
	
	public ILinkedList sublist(int fromindex , int toindex){
        singlyLinkedList l1 = new singlyLinkedList();
        for(int i=fromindex ; i<=toindex ; i++){
            l1.add(this.get(i));
        }
        return l1;
    	}
	
	public boolean contains(Object o) {
		for(Node pointer = head; pointer != null; pointer = pointer.next){
			if(pointer.data == o)
				return true;
		}
		return false;
	}
	
	public boolean contains(char poly) {
		for(Node pointer = head; pointer != null; pointer = pointer.next){
			if(pointer.name == poly)
				return true;
		}
		return false;
	}
}
