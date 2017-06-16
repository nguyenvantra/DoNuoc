package vn.darkness;

public class Rule {

	private Node end;
	public static final Node START = new Node(0, 0, 0, null);

	public Rule(Node end) {
		this.end = end;
	}

	public boolean isEnd(Node node) {
		if(node.getCansNine() == end.getCansNine()){
			return true;
		}
		return false;
	}

	public boolean isRemoveNode(Node node) {
		if (node.getCansFive() == 6 && node.getCansThree() == 3
				&& node.getCansNine() == 9) {
			return true;
		}if(node.equals(START)){
			return true;
		}if(node.equals(node.getNodeParent().getNodeParent())){
			return true;
		}
		return false;
	}
	public boolean isStart(Node node) {
		return node.equals(START);
	}
}
