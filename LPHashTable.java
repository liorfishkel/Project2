import java.util.Random;

public class LPHashTable extends OAHashTable {
	private ModHash hashFunc;

	public LPHashTable(int m, long p) {
		super(m);
		this.hashFunc = ModHash.GetFunc(m,p);
		// TODO Complete hash table constructor.
	}
	
	@Override
	public int Hash(long x, int i) {
		// TODO implement hash function
		int hash = this.hashFunc.Hash(x) + i;
		hash = hash % this.getTableLenght();
		if (hash < 0){
			hash += this.getTableLenght();
		}
		return hash;
	}
	
}
