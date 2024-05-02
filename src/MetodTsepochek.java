import java.util.LinkedList;

public class MetodTsepochek {
    private LinkedList<String>[] hashTable;
    private int capacity;

    public MetodTsepochek(int capacity) {
        this.capacity = capacity;
        this.hashTable = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            hashTable[i] = new LinkedList<>();
        }
    }

    private int hashFunction(String key) {
        return key.length() % capacity;
    }

    public void insert(String key) {
        int index = hashFunction(key);
        hashTable[index].add(key);
    }

    public boolean search(String key) {
        int index = hashFunction(key);
        return hashTable[index].contains(key);
    }

    public void delete(String key) {
        int index = hashFunction(key);
        hashTable[index].remove(key);
    }

    public static void main(String[] args) {
        MetodTsepochek hashTable = new MetodTsepochek(10);

        hashTable.insert("apple");
        hashTable.insert("banana");
        hashTable.insert("orange");

        System.out.println("Результат поиска 'banana': " + hashTable.search("banana"));

        hashTable.delete("banana");
    }
}
