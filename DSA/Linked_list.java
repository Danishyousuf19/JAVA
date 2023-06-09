package extra;	

public class Linked_list {
node head;
private int size;
Linked_list(){
	this.size=0;
}
	class node{
		
		String data;
		node next;
		node(String d){
			data=d;size++;
			this.next=null;
		}
	}
	
	public  void addFirst(String data) {
		node newnode=new node(data);
		if(head==null) {
			head =newnode;
			return;
		}
		newnode.next=head;
		head=newnode;
		
	}
	public  void addLast(String data) {
		node newnode=new node(data);
		if(head==null) {
			head =newnode;
			return;
		}
		node current=head;
		while(current.next!=null) {
			current=current.next;}
			current.next=newnode;
		}
		public  void print() {
			
			if(head==null) {
				System.out.println("empty linkedlist");
				return;
			}
			node current=head;
			while(current!=null) {
				System.out.print(current.data+"-->");
				current=current.next;
			}
			System.out.println("null");
	}
		public  void DeleteFirst() {
			if(head==null){
				System.out.println("Empty list");
				return;
			}
			size--;
			head=head.next;
		}
		public  void DeleteLast() {
			if(head==null){
				System.out.println("Empty list");
				return;
			}
			size--;
			if(head.next==null) {
				head=null;
				return;
			}
			node secondLast=head;
			node last=head.next;
			while(last.next!=null) {
				last=last.next;
				secondLast=secondLast.next;
			}
			secondLast.next=null;
		}
		public  int getsize() {
			return size;
		}
		public   void reverse() {
			if(head==null||head.next==null) {
				return;
			}
			node prev=head;
			node current =head.next;
			while(current!=null) {
				node next=current.next;
				current.next=prev;
				//update
				prev=current;
				current=next;
						
			}
			head.next=null;
			head=prev;
		}
		public   node rev_recurssion(node head) {
			if(head==null||head.next==null) {
				return head;
			}
			node newhead=rev_recurssion(head.next);
			head.next.next=head;
			head.next=null;
			return newhead;
		}
//		//only logic
//		public static Linked_list find_element_from_end_and_delete(Linked_list head,int n) {
//			if(head.next==null) {
//			return head;}
//			int size=0;
//			Linked_list current =head;
//			while(current !=null) {
//				current=current.next;
//				size++;
//			}
//			if(n==size) {
//				return head.next;
//			}
//			int next_to_search=size-n;
//			int i=1;
//			Linked_list prev=head;
//			while(i<next_to_search) {
//				prev=prev.next;i++;}
//				prev.next=prev.next.next;
//			
//		return head;
//			
//		}
		
	public static void main(String[] args) {
		Linked_list list=new Linked_list();
		list.addFirst("a");
		list.addFirst("is");
		list.print();
		list.addLast("book");
		list.print();
		list.addFirst("This");
		list.print();
		//list.reverse();
      //  list.print();
        list.head =list.rev_recurssion(list.head);
        list.print();
		System.out.println("size = "+list.getsize());
        list.DeleteFirst();
        list.DeleteLast();
        list.print();
        System.out.println("size = "+list.getsize());
      
	}

}
/*/is-->a-->null
is-->a-->book-->null
This-->is-->a-->book-->null
size = 4
is-->a-->null
size = 2*/