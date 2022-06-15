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
		int hash = this.hashFunc.Hash(x) + (int) Math.pow(-1,i) * (int) Math.pow(i,2);
		hash = hash % this.getTableLenght();
		if (hash < 0){
			hash += this.getTableLenght();
		}
		return hash;
	}
}
