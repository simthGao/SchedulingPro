package com.thesispro.algorithm;

import java.util.*;

public class MachineNode extends Node{
	public MachineNode(Node from, List<Node> to, NodeType type){
		for(Node node:to){
			if(node.type!=NodeType.TaskNode)
				return;
		}
		this.from = from;
		this.to = to;
		this.type = type;
	}
	
}
