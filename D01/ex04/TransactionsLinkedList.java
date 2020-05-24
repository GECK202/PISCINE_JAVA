public class TransactionsLinkedList implements TransactionsList {
	
	private Node first;
	private Node last;
	private int count;

	public TransactionsLinkedList() {
		first = null;
		last = null;
		count = 0;
	}

	public void addTransaction(Transaction transaction) {
		Node node = new Node(transaction);
		if (first == null) {
			first = node;
			last = node;
		}
		else {
			last.next = node;
			last = node;
		}
		++count;
	}

	public void removeTransaction(String id) {
		if (first != null) {
			Node tmp = first;
			if (tmp.isFind(id)) {
				if (tmp.next == null) {
					tmp.removeNode(first);
					first = null;
					--count;
					return ;
				}
				tmp.removeNode(null);
				first = tmp.next;
				--count;
				return ;
			}
			while (tmp.next != null) {
				Node prev = tmp;
				tmp = tmp.next;
				if (tmp.isFind(id)) {
					tmp.removeNode(prev);
					--count;
					return ;
				}
			} 
		}
		throw new TransactionNotFoundException("Transaction with id=" + id + " not found!");
	}

	public Transaction[] toArray() {
		Transaction[] array = new Transaction[count];
		int iterator = 0;
		if (first != null) {
			array[0] = first.transaction;
			System.out.println("-" + iterator + " " + array[0].getId());
			Node tmp = first.next;
			while(tmp != null) {
				array[++iterator] = tmp.transaction;
				System.out.println("-" + iterator + " " + array[0].getId());
				if (first.next != null) {					
					tmp = tmp.next;
				}
			}
		}
		return array;
	}

	private class Node {
		Transaction transaction;
		Node next;

		Node(Transaction transaction)
		{
			this.transaction = transaction;
			this.next = null;
		}

		boolean isFind(String id) {
			return (transaction.getId().equals(id));
		}

		void removeNode(Node prev) {
			if (prev != null && prev.next != null) {
				prev.next = next;
			}
			transaction = null;
		}
	}
}