package vn.darkness;


public class Run {
	public static void main(String[] args) {
		Node end = new Node(0, 0, 6, null);
		Rule r = new Rule(end);
		Solution s = new Solution(r);
		 s.solutionBFS();
		 s.solutionDFS();
	}
}
