package hungary.KM;

public class Edge {


	private Cow cow;
	private Kraal kraal;
	private int weight;
	
	public Edge(Cow cow, Kraal kraal) {
		this.cow = cow;
		this.kraal = kraal;
	}

	
	
	public Edge(Cow cow, Kraal kraal, int weight) {
		this(cow, kraal);
		this.weight = weight;
	}

	public Cow getCow() {
		return cow;
	}

	public void setCow(Cow cow) {
		this.cow = cow;
	}

	public Kraal getKraal() {
		return kraal;
	}

	public void setKraal(Kraal kraal) {
		this.kraal = kraal;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		final int prime = 13;
		int result = 1;
		result = prime * result + this.cow.hashCode();
		result = prime * result + this.kraal.hashCode();
		result = prime * result + this.weight;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Edge other = (Edge) obj;
		if (this.weight != other.weight)
			return false;
		if (!this.cow.equals(other.cow))
			return false;
		if (!this.kraal.equals(other.kraal))
			return false;

		return true;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.cow.getName() + "---" + this.getWeight() + "--->"
				+ this.kraal.getName();
	}

}
