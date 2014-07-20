package com.thesispro.algorithm;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class HungarianAlgorithm {
	public static void main(String args[]) {

	}

	private HashMap<Node, List<Node>> runAlgorithm(
			HashMap<Node, List<Node>> relationships) {
		Set<Node> matchedNodes = new HashSet<Node>();
		Set<Node> nonMatchedNodes = new HashSet<Node>();
		List<Node> staggeredWay = new LinkedList<Node>();
		Iterator<Entry<Node, List<Node>>> it = relationships.entrySet().iterator();
		while(it.hasNext()){
			nonMatchedNodes.add(it.next().getKey());
		}
		return null;
	}
}
