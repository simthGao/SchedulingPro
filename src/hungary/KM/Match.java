package hungary.KM;

public class Match {
	private Cow cow;
	private Kraal kraal;

	public Match(Cow cow, Kraal kraal) {
		this.cow = cow;
		this.kraal = kraal;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + this.cow.hashCode();
		result = prime * result + this.kraal.hashCode();
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
		Match other = (Match) obj;
		if(!this.cow.equals(other.cow))
			return false;
		if(!this.kraal.equals(other.kraal))
			return false;

		return true;
	}

	@Override
	public String toString() {
		return this.cow.getName() + "--->" + this.kraal.getName();
	}
}
