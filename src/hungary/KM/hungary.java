package hungary.KM;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class hungary {
	private Set<Edge> matchs = new HashSet<Edge>();// 匹配集合
	private Set<Edge> path = new HashSet<Edge>();
	private Set<Edge> lastPath = new HashSet<Edge>();
	private Set<Edge> edges = new HashSet<Edge>();

	public int findWMatch() {
		for (Cow cow : DateSource.getCows()) {// 初始化，使得cow为其关联边的最大值
			int maxW = -1;
			for (Edge edge : cow.getEdges()) {
				edges.add(edge);
				if (edge.getWeight() > maxW)
					maxW = edge.getWeight();
			}
			cow.setWeight(maxW);
		}
		
		System.out.println(edges);
		while (!findMatch()) {
			// find match again,but before finding ,we should reset the status
			// of Cows and Kraals,and lastPath,path,matchs
			for (Cow cow : DateSource.getCows()) {
				cow.setUsed(false);
			}
			for (Kraal kraal : DateSource.getKraals()) {
				kraal.setUsed(false);
			}
			lastPath.clear();
			path.clear();
			matchs.clear();
		}

		return this.matchs.size();
	}

	public void printMatchInfo() {
		for(Edge edge:matchs){
			Cow cow = edge.getCow();
			Kraal kraal = edge.getKraal();
			for(Edge edge2 : cow.getEdges()){
				if(edge2.getKraal().equals(kraal)){
					edge.setWeight(edge2.getWeight());
				}
			}
		}
		System.out.println("匹配信息：" + matchs);
	}

	public boolean findMatch() {
		int times = DateSource.getCows().size();
		for (Cow cow : DateSource.getCows()) {// 遍历二分图的子图cow，不妨称其为cow1

			if (hasAugmentPath(cow)) {
				for (Edge match : path) {// 对于path里的每一条路径
					if (matchs.contains(match)) {// 有增广路径作取反操作，即将原来的匹配取反
						matchs.remove(match);// 在的删除
					} else {
						matchs.add(match);// 不在的添加进来，保证取反
					}
				}
			}
			path.clear();// 清空增广路径信息,便于下一次遍历
			times--;// to record the times to find ,最后一次不成功的寻找交错路的DFS
			if (times == 0) {
				resetLastPath(path);
			}
		}
		return matchs.size() == DateSource.getCows().size();
	}

	/**
	 * 获取cow的增广路径
	 */
	private boolean hasAugmentPath(Cow cow) {
//		HashSet<Edge> cowEdges = new HashSet<Edge>();
//		cowEdges.addAll(cow.getEdges());
		for (Kraal kraal : cow.getKraals()) {// 从cow出发的没一条边
			Edge match = new Edge(cow, kraal);// 构成一个新匹配,这里要给Edge加权重，不然无法统计
			if (matchs.contains(match)) {// 在匹配集合里且从cow出发只有一条边，则没有增广路径，返回false
				if (cow.getKraals().size() == 1) {
					return false;
				} else {
					continue;// 边数大于1继续找其他边
				}
			} else {// 直到找到一条边不再匹配集合里
				path.add(match);// 开始尝试从这条边出发找下去
				if (!kraal.isUsed()) {// kraal没有被使用（即不再任何一条路径中）
					kraal.setUsed(true);// 加入当前路径
					cow.setUsed(true);// cow is used at this time
					return true;
				} else {// kraal已经被使用了，即kraal已经在匹配集合的路径中
					for (Cow c : kraal.getCows()) {// 从kraal继续找增广路径去，新找的点必须都是在路径中的，否则就成功找到一条增广路径。
													// 找到的cow又是一个新的轮回,不妨叫其cow2
						Edge m = new Edge(c, kraal);// 这里需要加权重
						if (path.contains(m)) {// 这里是怕找着找着cow3，4，5最后又回到原来的cow2
							if (kraal.getCows().size() == 1) {// 如果真的回来了且从cow2出去只有一条路，原来已经占了，所以找不到增广路径了
								return false;
							} else {
								continue;// 如果找回来了，由于增广路径中的点不能重复，所以换一个cow3
							}
						} else if (matchs.contains(m)) {// match不再原来的路径中且match在匹配集合中，原来的一个匹配，接下来走完一轮，开始找，
							path.add(m);// 将match加入path
							if (hasAugmentPath(c)) {// cl增广路径
								return true;
							} else {// c没有增广路径
								path.remove(m);
								continue;
							}
						} else {// match不在匹配集合中，此时不构成交替
							continue;
						}
					}
					// 遍历下一个kraal,采用DFS遍历
					path.remove(match);// 从kraal出去所有cow都找不到一条增光路径，则从match这条路径出去行不通
					continue;
				}
			}
		}
		return false;
	}

	public void resetLastPath(Set<Edge> path) {// 如果没有找到增广路径，则将最后一次不成功寻找的交错路的DFS返回
		lastPath.clear();
		Iterator<Edge> iterator = path.iterator();
		while (iterator.hasNext()) {
			lastPath.add(iterator.next());
		}

		adjustWeight();

	}

	public void adjustWeight() {
		// 调整的方法是：根据最后一次不成功的寻找交错路的DFS，取所有i被访问到而j没被访问到的边(i,j)的lx[i]+ly[j]-w[i][j]的最小值d
		int minD = -1;
		for (Cow cow : DateSource.getCows()) {
			for (Edge edge : cow.getEdges()) {
				if (edge.getCow().isUsed() && !edge.getKraal().isUsed()) {
					if ((edge.getCow().getWeight()
							+ edge.getKraal().getWeight() - edge.getWeight()) < minD) {
						minD = edge.getCow().getWeight()
								+ edge.getKraal().getWeight()
								- edge.getWeight();
					}
				}
			}
		}

		// 将交错树中的所有左端点的顶标减小d，右端点的顶标增加d
		for (Edge edge : lastPath) {
			edge.getCow().setWeight(edge.getCow().getWeight() - minD);
			edge.getKraal().setWeight(edge.getKraal().getWeight() + minD);
		}
	}

}
