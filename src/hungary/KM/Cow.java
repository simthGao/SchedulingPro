package hungary.KM;

import java.util.ArrayList;
import java.util.List;

public class Cow {
	private String name;
	private int weight;
	private boolean used = false;
	private List<Kraal> kraals = new ArrayList<Kraal>();
	private List<Edge> edges = new ArrayList<Edge>();

	public Cow(String name) {
		this.name = name;
	}
	
	public Cow(String name, int weight){
		this(name);
		this.weight = weight;
	}

	public List<Edge> getEdges() {
		return edges;
	}

	public int getEdgeWeight(Edge e) {
		if (edges.contains(e)) {// 这里不好查找edge的权值
			return e.getWeight();
		}
		return -1;
	}

	public boolean isUsed() {
		return used;
	}

	public void setUsed(boolean used) {
		this.used = used;
	}

	public void setEdges(List<Edge> edges) {
		this.edges = edges;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Kraal> getKraals() {
		return kraals;
	}

	public void setKraals(List<Kraal> kraals) {
		this.kraals = kraals;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		final int prime = 13;
		int result = 1;
		result = prime * result
				+ ((this.getName() == null) ? 0 : this.getName().hashCode());
		result = prime * result + this.weight;
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
		Cow other = (Cow) obj;
		if (this.getName() == null) {
			if (other.getName() != null)
				return false;
		} else if (!this.getName().equals(other.getName()))
			return false;
		if (this.getWeight() != other.getWeight())
			return false;

		return true;
	}
}
