import java.util.Random;
import java.lang.Math;

public class QPHashTable extends OAHashTable {
	private ModHash hashFunc;

	public QPHashTable(int m, long p) {
		super(m);
		this.hashFunc = ModHash.GetFunc(m,p);
		// TODO Complete hash table constructor.
	}
	
	@Override
	public int Hash(long x, int i) {
		// TODO implement hash function
		int hash = this.hashFunc.Hash(x) + (int) Math.pow(i,2);
		hash = hash % this.getTableLenght();
		if (hash < 0){
			hash += this.getTableLenght();
		}
		return hash;
	}
}
