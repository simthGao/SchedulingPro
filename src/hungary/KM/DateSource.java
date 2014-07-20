package hungary.KM;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class DateSource {
	static Map<String,Cow> cows=new HashMap<String,Cow>();
	static Map<String,Kraal> kraals=new HashMap<String,Kraal>();
	static{
		Cow cowA=new Cow("A");
		Cow cowB=new Cow("B");
		Cow cowC=new Cow("C");
		Kraal kraal1=new Kraal("1");
		Kraal kraal2=new Kraal("2");
		Kraal kraal3=new Kraal("3");
		
		// A ------->1
		cowA.getKraals().add(kraal1);
		kraal1.getCows().add(cowA);
		Edge edge11 = new Edge(cowA, kraal1,3);
		cowA.getEdges().add(edge11);
		kraal1.getEdges().add(edge11);
		
		//A-------->2
		cowA.getKraals().add(kraal2);
		kraal2.getCows().add(cowA);
		Edge edge12 = new Edge(cowA, kraal2,3);
		cowA.getEdges().add(edge12);
		kraal2.getEdges().add(edge12);

		//A-------->3
		cowA.getKraals().add(kraal3);
		kraal3.getCows().add(cowA);
		Edge edge13 = new Edge(cowA, kraal3,2);
		cowA.getEdges().add(edge13);
		kraal3.getEdges().add(edge13);
		
		//B-------->1
		cowB.getKraals().add(kraal1);
		kraal1.getCows().add(cowB);
		Edge edge21 = new Edge(cowB, kraal1,4);
		cowB.getEdges().add(edge21);
		kraal1.getEdges().add(edge21);
		
		//B-------->2
		cowB.getKraals().add(kraal2);
		kraal2.getCows().add(cowB);
		Edge edge22 = new Edge(cowB, kraal2,3);
		cowB.getEdges().add(edge22);
		kraal2.getEdges().add(edge22);
		
		//B--------->3
		cowB.getKraals().add(kraal3);
		kraal3.getCows().add(cowB);
		Edge edge23 = new Edge(cowB, kraal3,5);
		cowB.getEdges().add(edge23);
		kraal3.getEdges().add(edge23);

		
		//C--------->2
		cowC.getKraals().add(kraal1);
		kraal1.getCows().add(cowC);
		Edge edge31 = new Edge(cowC, kraal1,0);
		cowC.getEdges().add(edge31);
		kraal1.getEdges().add(edge31);
		
		//C-------->2
		cowC.getKraals().add(kraal2);
		kraal2.getCows().add(cowC);
		Edge edge32 = new Edge(cowC, kraal2,4);
		cowC.getEdges().add(edge32);
		kraal2.getEdges().add(edge32);
		
		//C-------->3
		cowC.getKraals().add(kraal3);
		kraal3.getCows().add(cowC);
		Edge edge33 = new Edge(cowC, kraal3,4);
		cowC.getEdges().add(edge33);
		kraal3.getEdges().add(edge33);
		
	
		
		cows.put("A", cowA);
		cows.put("B", cowB);
		cows.put("C", cowC);
		kraals.put("1", kraal1);
		kraals.put("2", kraal2);
		kraals.put("3", kraal3);
		
	}
	public static Cow getCowByName(String name){
		return cows.get(name);
	}
	public static Kraal getKraalByName(String name){
		return kraals.get(name);
	}
	public static Collection<Cow> getCows(){
		return cows.values();
	}
	public static Collection<Kraal> getKraals(){
		return kraals.values();
	}
}
