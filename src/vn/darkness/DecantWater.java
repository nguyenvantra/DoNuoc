package vn.darkness;

import java.util.ArrayList;

public class DecantWater {
    ArrayList<Node> nodes = new ArrayList<>();
	public ArrayList<Node> nodesExtended(Node node) {
		if (node.equals(Rule.START)) {
			nodes.add(new Node(Node.binh1, 0, 0, node));
			nodes.add(new Node(0, Node.binh2, 0, node));
			nodes.add(new Node(0, 0, Node.binh3, node));
		} else {
			decantNew(node);
			decantFormCansToOtherCans(node);
		}
		return nodes;
	}
	
	public ArrayList<Node> getNodes() {
		return nodes;
	}
	public void decantNew(Node node) {
		int cansThree = node.getCansThree();
		int cansFive = node.getCansFive();
		int cansNine = node.getCansNine();
		if(cansThree < node.binh1){
			nodes.add(new Node(decantNew(cansThree, node.binh1), cansFive, cansNine, node));
		}if(cansFive < node.binh2){
			nodes.add(new Node(cansThree,decantNew(cansFive, node.binh2), cansNine, node));
		}if(cansNine < Node.binh3){
			nodes.add(new Node(cansThree,cansFive, decantNew(cansNine, node.binh3), node));
		}
	}

	public void decantFormCansToOtherCans(Node node) {
		int cansThree = node.getCansThree();
		int cansFive = node.getCansFive();
		int cansNine = node.getCansNine();
		if(cansThree != 0){
			if(cansFive < Node.binh2){
				int index = decantFormCansToOtherCans(cansFive, Node.binh2, cansThree);
				nodes.add(new Node(cansThree-index, cansFive+index, cansNine, node));
			}if(cansNine < Node.binh3){
				int index = decantFormCansToOtherCans(cansNine, Node.binh3, cansThree);
				nodes.add(new Node(cansThree-index, cansFive, cansNine+index, node));
			}
		}if(cansFive != 0){
			if(cansThree < Node.binh1){
				int index = decantFormCansToOtherCans(cansThree, Node.binh1, cansFive);
				nodes.add(new Node(cansThree+index, cansFive-index, cansNine, node));
			}if(cansNine < Node.binh3){
				int index = decantFormCansToOtherCans(cansNine, Node.binh3, cansFive);
				nodes.add(new Node(cansThree, cansFive-index, cansNine+index, node));
			}
		}if(cansNine != 0){
			if(cansFive < Node.binh2){
				int index = decantFormCansToOtherCans(cansFive, Node.binh2, cansNine);
				nodes.add(new Node(cansThree, cansFive+index, cansNine-index, node));
			}if(cansThree < Node.binh1){
				int index = decantFormCansToOtherCans(cansThree, Node.binh1, cansNine);
				nodes.add(new Node(cansThree+index, cansFive, cansNine-index, node));
			}
		}
	}
	public int decantNew(int first, int second){
		while(first < second){
			first++;
		}
		return first;
	}
	public int decantFormCansToOtherCans(int first, int second, int index) {
		int count = 0;
		while(first < second){
			if(index == 0) break;
			first++;
			count++;
			index--;
		}
		
		return count;
	}
}
