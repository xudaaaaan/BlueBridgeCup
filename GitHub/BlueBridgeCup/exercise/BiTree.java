//搜索树
public class BiTree {
	protected int v;
	protected BiTree l;
	protected BiTree r;
	
	public BiTree(int v){
		this.v = v;
	}
	
	public void add(BiTree the){
		if(the.v < v){
			if(l == null){l = the;}
				else{l.add(the);}
		}else{
			if(r == null){r = the;}
				else{r.add(the);}
		}
	}
	
	public void mid_trav(){
		l.mid_trav();
		System.out.println(v);
		r.mid_trav();
	}

}
