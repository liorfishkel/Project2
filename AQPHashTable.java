import java.util.Random;

public class AQPHashTable extends OAHashTable {
	private ModHash hashFunc;

	public AQPHashTable(int m, long p) {
		super(m);
		this.hashFunc = ModHash.GetFunc(m,p);
		// TODO Complete hash table constructor.
	}
	
	@Override
	public int Hash(long x, int i) {
		// TODO implement hash function
		int pow;
		if (i % 2 == 0){
			pow = 1;
		}
		else {
			pow = -1;
		}
		int hash = this.hashFunc.Hash(x) + pow * (int) Math.pow(i,2);
		hash = hash % this.getTableLenght();
		if (hash < 0){
			hash += this.getTableLenght();
		}
		return hash;
	}
}
