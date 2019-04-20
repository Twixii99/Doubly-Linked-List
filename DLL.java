package eg.edu.alexu.csd.datastructure.linkedList;

public class DlinkedList {
	private Dnode head = null;
	private int size = 0;
	
	public void print(){
        if(head == null) return;
        Dnode i = head;
        while(i!= null){
            System.out.println(i.data);
            i = i.next;
        }
    }
     
   public void add(int index, Object element) {
        if(index >= size || index < 0) return;
        DNode newnode = new DNode(element);
        if(head==null){
            head = newnode;
            size++;
        }
        else if(index == 0){
            newnode.next = head;
            head.prev = newnode;
            head = newnode;
            size++;
        }
        else if(index == size  ){
            this.add(element);
        }else{
            DNode i = head;
            int counter =0;
            while(counter < index-1){
                i = i.next;
                counter++;
            }
            newnode.next = i.next;
            i.next.prev = newnode;
            i.next = newnode;
            newnode.prev =i;
            size++;
        }
    }
    
    
    
      @Override
    public void add(Object element) {
         DNode newnode = new DNode(element);
        if(head == null){
           head = newnode;
           size++;
        }else{
            DNode i = head;
            while(i.next != null) i = i.next;
            i.next = newnode;
            newnode.prev = i;
            size++;
        }
    }
	
	public void set(int index, Object element) {
		if(index >= size) return;
		Dnode pointer = head;
		for(int i = 0; i < index; i++) 
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
		Dnode pointer = head;
		for(int i = 0; i < index-1; i++)
			pointer = pointer.next;
		pointer.next = pointer.next.next;
		pointer.next.prev = pointer;
		size--;
	}
	
	public int size() {
		return size;
	}
	
	public Dnode sublist(int fromIndex, int toIndex) {
		if(fromIndex >= size & toIndex >= size) return null;
		Dnode pointer = head;
		int i;
		for(i = 0; i < fromIndex; i++) 
			pointer = pointer.next;
		Dnode pointer2 = pointer;
		for(int j = i; j < toIndex; j++)
			pointer2 = pointer2.next;
		pointer2.next = null;
		return pointer;
	}
	
	public boolean contains(Object o) {
		for(Dnode pointer = head; pointer != null; pointer = pointer.next){
			if(pointer.data == o)
				return true;
		}
		return false;
	}
	
}
