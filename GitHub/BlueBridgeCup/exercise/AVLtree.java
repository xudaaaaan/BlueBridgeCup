//平衡二叉树
public class AVLtree {
	protected int v;
	protected AVLtree l;
	protected AVLtree r;
	protected int balance = 0;
	
	public AVLtree(int v){
		this.v = v;
	}
	
	public int getHeight(){
		int h = 1;
		int hl = (l == null) ? 0 : l.getHeight();
		int hr = (r == null) ? 0 : r.getHeight();
		return h + Math.max(hl, hr);
	}
	public void calcu_balance(){
		int hl = (l == null) ? 0 : l.getHeight();
		int hr = (r == null) ? 0 : r.getHeight();
		int balance = hl - hr;
	}
	
	public int getBalance(){
		return balance;
	}
	
	public AVLtree add(AVLtree the){
		AVLtree root = this;
		
		if(the.v < v){
			if(l == null){l = the;}
			else{l = l.add(the);} //不是l.add(the)了
		}else{
			if(r == null){r = the;}
			else{r = r.add(the);}
		}
		calcu_balance();
		
		if(balance > 1){
			if(l.getBalance() > 0){root = adjustLL();}//LL
			else{root = adjustLR();} //LR
		}else{
			if(r.getBalance() < 0){root = adjustRR();}//RR
			else{root = adjustRL();} //RL
		}
		calcu_balance();
		return root;
	}
	
	public AVLtree adjustLL(){
		AVLtree root = l;
		l = root.r;
		root.r = this;
		return root;
	}
	
	public AVLtree adjustRR(){
		AVLtree root = r;
		r = root.l;
		root.l = this;
		return root;
	}
	
    public AVLtree adjustLR(){
		l = l.adjustRR();
		return adjustLL();//this.adjustLL()
	}
    
    public AVLtree adjustRL(){
		r = r.adjustLL();
		return adjustRR();
	}
	
}
