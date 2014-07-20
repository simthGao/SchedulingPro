package hungary.optimalMatchingAlgorithm;

public class TestKM {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		KuhnMunkres kMunkres = new KuhnMunkres(3);
		double[][] weight = {
				{1.0,3.0,2.0},
				{4.0,3.0,5.0},
				{2.0,4.0,4.0}
		};
		for(double[] w:weight){
			System.out.print(w[0]+"  ");
			System.out.print(w[1]+"  ");
			System.out.println(w[2]);
			System.out.println();


		}
		
		double[] result = new double[3];
		int[][] res=kMunkres.getMaxBipartie(weight, result);
		for(int[] r:res){
			System.out.println(r[0]+"----"+kMunkres.getWeights()[r[0]][r[1]]+"--->"+r[1]);
			System.out.println();
		}
		
		System.out.println("最大权值："+result[0]);
	}

}
