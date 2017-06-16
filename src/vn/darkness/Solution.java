package vn.darkness;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution {
	private Rule rule;
	private DecantWater decantWater;
	
	public Solution(Rule rule){
		this.rule = rule;
		decantWater = new DecantWater();
	}
	public void solutionBFS(){
		System.out.println("---BFS---");
		Queue<Node> nodes = new LinkedList<>();
		int countNodeExtended = 0;
		Node node = Rule.START;
		nodes.add(node);
		while(true){
			node = nodes.poll();
			if(rule.isEnd(node)){
				pathSolution(node);
				break;
			}else{
				ArrayList<Node> list = decantWater.nodesExtended(node);
				
				for(Node n : list){
					if(!rule.isRemoveNode(n) && !nodes.contains(n)){
						nodes.add(n);
						countNodeExtended++;
					}
				}
			}
		}
		System.out.println("Tong so node tao ra: "+ countNodeExtended);
		System.out.println("---Ket thuc---");
	}
	public void solutionDFS(){
		decantWater.getNodes().clear();
		System.out.println("---DFS---");
		Stack<Node> nodes = new Stack<Node>();
		Stack<Node> contains = new Stack<Node>();
		int countNodeExtended = 0;
		Node node = Rule.START;
		nodes.add(node);
		while(true){
			node = nodes.pop();
			if(rule.isEnd(node)){
				pathSolution(node);
				break;
			}else{
				ArrayList<Node> list = decantWater.nodesExtended(node);
				for(Node n : list){
					if(!rule.isRemoveNode(n) && !nodes.contains(n) && !contains.contains(n)){
						nodes.add(n);
						contains.add(n);
						countNodeExtended++;
					}
				}
			}
		}
		System.out.println("Tong so node tao ra: "+ countNodeExtended);
		System.out.println("---Ket thuc---");
	}
	public void pathSolution(Node node){
		Stack<Node> nodes = new Stack<>();
		int deepSearch = 0;
		while(true){
			nodes.add(node);
			if(rule.isStart(node)) break;
			node  = node.getNodeParent();
		}
		deepSearch = nodes.size();
		while(!nodes.isEmpty()){
			System.out.println(nodes.pop());
		}
		
		System.out.println("Do sau tim thay:" + deepSearch);
	}
}
