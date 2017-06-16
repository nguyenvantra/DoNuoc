package vn.darkness;

public class Node {

	public static final int binh1 = 4;
	public static final int binh2 = 7;
	public static final int binh3 = 12;
	
	private int cansThree;
	private int cansFive;
	private int cansNine;
	private Node nodeParent;
	
	public Node(int cansThree, int cansFive, int cansNine, Node nodeParent){
		this.cansThree = cansThree;
		this.cansFive = cansFive;
		this.cansNine = cansNine;
		this.nodeParent = nodeParent;
	}

	public int getCansThree() {
		return cansThree;
	}

	public int getCansFive() {
		return cansFive;
	}

	public int getCansNine() {
		return cansNine;
	}

	public Node getNodeParent() {
		return nodeParent;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cansFive;
		result = prime * result + cansNine;
		result = prime * result + cansThree;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node other = (Node) obj;
		if (cansFive != other.cansFive)
			return false;
		if (cansNine != other.cansNine)
			return false;
		if (cansThree != other.cansThree)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Node [Binh1= " + cansThree + ", Binh2= " + cansFive
				+ ", Binh3= " + cansNine + "]";
	}
	
}
