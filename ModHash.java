import java.util.Random;

public class ModHash {
	private int a, b, m;
	private long p;
	public ModHash(int a, int b, int m, long p){
		this.a = a;
		this.b = b;
		this.m = m;
		this.p = p;
	}
	public static ModHash GetFunc(int m, long p){
		Random rnd = new Random();
		return new ModHash(rnd.nextInt(), rnd.nextInt(), m, p);
	}
	
	public int Hash(long key) {
		return ((a*(int)key + b)%(int)p)%m;
	}
}
