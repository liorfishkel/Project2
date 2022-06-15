import java.util.Random;

public class DoubleHashTable extends OAHashTable {
	private ModHash firstHashFunc;
	private ModHash secondHashFunc;

	public DoubleHashTable(int m, long p) {
		super(m);
		this.firstHashFunc = ModHash.GetFunc(m,p);
		this.secondHashFunc = ModHash.GetFunc(m,p);
		// TODO Complete hash table constructor.
	}
	
	@Override
	public int Hash(long x, int i) {
		// TODO implement hash function
		int hash = this.firstHashFunc.Hash(x) + this.secondHashFunc.Hash(x) * i;
		hash = hash % this.getTableLenght();
		if (hash < 0){
			hash += this.getTableLenght();
		}
		return hash;
	}
	
}
