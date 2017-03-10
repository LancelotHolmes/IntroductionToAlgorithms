package dynamic_programming;

public class RodCutting {
	public static void main(String[] args) {
		int[] prices={0,1,5,8,9,10,17,17,20,24,30};
		new RodCutting();
		System.out.println(rodCutting3(prices,7));
//		for(int i=0;i<gain.length;i++){
//			System.out.print(gain[i]+", ");
//		}
	}
	// recursive top-down implementation
	public static int rodCutting(int[] p,int n){
		if(n==0){
			return 0;
		}
		int q=0;
		for(int i=1;i<=n;i++){
			q=Math.max(q, p[i]+rodCutting(p,n-i));
		}
		return q;
	}
	// dp1:top-down Memoization solution with an auxiliary array
	static int[] gain=new int[11];
	public RodCutting(){
		for(int i=0;i<gain.length;i++){
			gain[i]=0;
		}
	}
	public static int rodCutting2(int[] p,int n){
		if(n==0){
			return 0;
		}
		if(gain[n]!=0){
			return gain[n];
		}
		int q=0;
		for(int i=1;i<=n;i++){
			q=Math.max(q, p[i]+rodCutting(p,n-i));
//			q=Math.max(q, p[i]+gain[n-i]);	//why I cannot use gain[]
		}
		gain[n]=q;
		return q;
	}
	// dp2: bottom-up solution
	public static int rodCutting3(int[] p,int n){
		int[] rev=new int[n+1];
		rev[0]=0;
		for(int i=1;i<=n;i++){
			for(int j=1;j<=i;j++){
				rev[i]=Math.max(rev[i-j]+p[j], rev[i]);
			}
		}
		return rev[n];
	}
}
