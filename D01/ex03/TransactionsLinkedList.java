public class TransactionsLinkedList implements TransactionsList {
	
	private Node first;
	private Node last;

	public TransactionsLinkedList() {
		first = null;
	}

	public String addTransaction(User payee, User sender, int amount, CategoryOfTranslation translation) {
		Transaction transaction = new Transaction(payee, sender, amount, translation);
		Node node = new Node(transaction);
		if (first == null) {
			first = node;
			last = node;
		}
		else {
			last.next = node;
			last = node;
		}
		return transaction.getId();
	}

	public void printTransactions() {
		if (first != null) {
			Node tmp = first;
			tmp.printNode();
			while (tmp.next != null) {
				tmp = tmp.next;
				tmp.printNode();
			}
		}
	}

	public void removeTransaction(String id) {
		if (first != null) {
			Node tmp = first;
			if (tmp.isFind(id)) {
				if (tmp.next == null) {
					tmp.removeNode(first);
					first = null;
					return ;
				}
				tmp.removeNode(null);
				first = tmp.next;
				
				return ;
			}
			while (tmp.next != null) {
				Node prev = tmp;
				tmp = tmp.next;
				if (tmp.isFind(id)) {
					tmp.removeNode(prev);
					return ;
				}
			} 
		}
		throw new TransactionNotFoundException("Transaction with id=" + id + " not found!");
	}

	private class Node {
		Transaction transaction;
		Node next;

		Node(Transaction transaction)
		{
			this.transaction = transaction;
			this.next = null;
		}

		void printNode() {
			System.out.println(transaction.getPayee().getName() + "->" +
				transaction.getSender().getName() + ", " + 
				transaction.getStringAmount() + ", " + 
				transaction.getTranslation() + ", " + transaction.getId());
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