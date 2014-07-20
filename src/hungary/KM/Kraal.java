package hungary.KM;

import java.util.ArrayList;
import java.util.List;

public class Kraal {
	private String name;
	private int weight;
	private List<Cow> cows = new ArrayList<Cow>();
	private List<Edge> edges = new ArrayList<Edge>();
	private boolean used = false;

	public Kraal(String name) {
		this.name = name;
	}

	public Kraal(String name, int weight) {
		this(name);
		this.weight = weight;
	}

	public List<Edge> getEdges() {
		return edges;
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

	public List<Cow> getCows() {
		return cows;
	}

	public void setCows(List<Cow> cows) {
		this.cows = cows;
	}

	public boolean isUsed() {
		return used;
	}

	public void setUsed(boolean used) {
		this.used = used;
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
		Kraal other = (Kraal) obj;
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
