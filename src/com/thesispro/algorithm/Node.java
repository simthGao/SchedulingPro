package com.thesispro.algorithm;

import java.util.*;

public abstract class Node {
	public Node from;
	public List<Node> to;
	public NodeType type;

	public  List<Node> next(){
		return this.to;
	}
}
