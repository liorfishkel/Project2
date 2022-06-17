
public abstract class OAHashTable implements IHashTable {
	
	private HashTableElement [] table;
	
	public OAHashTable(int m) {
		this.table = new HashTableElement[m];
	}
	
	
	@Override
	public HashTableElement Find(long key) {
		int j;
		int m = this.table.length;
		for(int i = 0; i < m; i++){
			j = this.Hash(key, i);
			if(table[j] == null){
				return null;
			}
			else{
				if(table[j].GetKey() == key){
					return table[j];
				}
			}
		}
		return null;
	}
	
	@Override
	public void Insert(HashTableElement hte) throws TableIsFullException,KeyAlreadyExistsException {
		int currIndex = -1;
		int j;
		int m = this.table.length;
		long key = hte.GetKey();
		for(int i = 0; i < m; i++){
			j = this.Hash(key, i);
			if(this.table[j] == null){
				if (currIndex >= 0){
					this.table[currIndex] = hte;
					return;
				}
				else {
					this.table[j] = hte;
					return;
				}
			}
			else {
				if(this.table[j].GetKey() == key) {
					if (currIndex >= 0){
						this.table[currIndex] = this.table[j];
						this.table[j] = new HashTableElement(-1,0);
					}
					throw new KeyAlreadyExistsException(hte);
				}
				if (this.table[j].GetKey() < 0) {
					if (currIndex < 0){
						currIndex = j;
					}
				}
			}
		}
		if (currIndex > 0){
			this.table[currIndex] = hte;
			return;
		}
		throw new TableIsFullException(hte);
	}
	
	@Override
	public void Delete(long key) throws KeyDoesntExistException {
		int j;
		int m = this.table.length;
		for(int i = 0; i < m; i++){
			j = Hash(key, i);
			if(this.table[j] == null){
				throw new KeyDoesntExistException(key);
			}
			else {
				if (this.table[j].GetKey() == key){
					this.table[j] = new HashTableElement(-1,0);
					return;
				}
			}
		}
		throw new KeyDoesntExistException(key);
	}
	
	/**
	 * 
	 * @param x - the key to hash
	 * @param i - the index in the probing sequence
	 * @return the index into the hash table to place the key x
	 */
	public abstract int Hash(long x, int i);

	public int getTableLenght(){
		return this.table.length;
	}
}
