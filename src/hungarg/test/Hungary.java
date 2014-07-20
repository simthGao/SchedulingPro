package hungarg.test;

import java.util.HashSet;
import java.util.Set;

public class Hungary {
	private Set<Match> matchs=new HashSet<Match>();//匹配集合
	private Set<Match> path=new HashSet<Match>();
	public int findMatch(){
		for(Cow cow:DateSource2.getCows()){//遍历二分图的子图cow，不妨称其为cow1
			if(hasAugmentPath(cow)){
				for(Match match:path){//对于path里的每一条路径
					if(matchs.contains(match)){//有增广路径作取反操作，即将原来的匹配取反
						matchs.remove(match);//在的删除
					}else{
						matchs.add(match);//不在的添加进来，保证取反
					}
				}
			}
			path.clear();//清空增广路径信息,便于下一次遍历
		}
		return matchs.size();
	}
	public void printMatchInfo(){
		System.out.println("匹配信息："+matchs);
	}
	/**
	 * 获取cow的增广路径
	 */
	private boolean hasAugmentPath(Cow cow){
		for(Kraal kraal:cow.getKraals()){//从cow出发的没一条边
			Match match=new Match(cow.getName(),kraal.getName());//构成一个新匹配
			if(matchs.contains(match)){//在匹配集合里且从cow出发只有一条边，则没有增广路径，返回false
				if(cow.getKraals().size()==1){
					return false;
				}else{
					continue;//边数大于1继续找其他边
				}
			}else{//直到找到一条边不再匹配集合里
				path.add(match);//开始尝试从这条边出发找下去
				if(!kraal.isUsed()){//kraal没有被使用（即不再任何一条路径中）
					kraal.setUsed(true);//加入当前路径
					return true;
				}else{//kraal已经被使用了，即kraal已经在匹配集合的路径中
					for(Cow c:kraal.getCows()){//从kraal继续找增广路径去，新找的点必须都是在路径中的，否则就成功找到一条增广路径。
												//找到的cow又是一个新的轮回,不妨叫其cow2
						Match m=new Match(c.getName(),kraal.getName());
						if(path.contains(m)){//这里是怕找着找着cow3，4，5最后又回到原来的cow2
							if(kraal.getCows().size()==1){//如果真的回来了且从cow2出去只有一条路，原来已经占了，所以找不到增广路径了
								return false;
							}else{
								continue;//如果找回来了，由于增广路径中的点不能重复，所以换一个cow3
							}
						}else if(matchs.contains(m)){//match不再原来的路径中且match在匹配集合中，原来的一个匹配，接下来走完一轮，开始找，
							path.add(m);//将match加入path
							if(hasAugmentPath(c)){//cl增广路径
								return true;
							}else{//c没有增广路径
								path.remove(m);
								continue;
							}
						}else{//match不在匹配集合中，此时不构成交替
							continue;
						}
					}
					//遍历下一个kraal,采用DFS遍历
					path.remove(match);//从kraal出去所有cow都找不到一条增光路径，则从match这条路径出去行不通
					continue;
				}
			}
		}
		return false;
	}
}
