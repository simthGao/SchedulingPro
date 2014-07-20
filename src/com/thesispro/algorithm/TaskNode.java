package com.thesispro.algorithm;

import java.util.List;

public class TaskNode extends Node {
	public TaskNode(Node from, List<Node> to, NodeType type) {
		for (Node node : to) {
			if (node.type != NodeType.MachineNode)
				return;
		}
		this.from = from;
		this.to = to;
		this.type = type;
	}	
}
