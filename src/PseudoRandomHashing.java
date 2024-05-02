import java.util.Random;

public class PseudoRandomHashing {
    private String[] hashTable;
    private int capacity;
    private int size;
    private Random random;

    public PseudoRandomHashing(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.hashTable = new String[capacity];
        this.random = new Random();
    }

    private int hashFunction(String key, int attempt) {
        int hash1 = key.length() % capacity;
        int hash2 = 1 + (key.length() % (capacity - 1));
        return (hash1 + attempt * hash2) % capacity;
    }
    public void insert(String key) {
        if (size == capacity) {
            System.out.println("Хэш-таблица заполнена.");
            return;
        }

        int attempt = 0;
        int index = hashFunction(key, attempt);

        while (hashTable[index] != null) {
            attempt++;
            index = hashFunction(key, attempt);
        }

        hashTable[index] = key;
        size++;
    }

    public int search(String key) {
        int attempt = 0;
        int index = hashFunction(key, attempt);

        while (hashTable[index] != null && !hashTable[index].equals(key)) {
            attempt++;
            index = hashFunction(key, attempt);
        }

        if (hashTable[index] != null && hashTable[index].equals(key)) {
            return index;
        } else {
            return -1;
        }
    }

    public void delete(String key) {
        int index = search(key);

        if (index != -1) {
            hashTable[index] = null;
            size--;
            System.out.println("Элемент " + key + " удален из хэш-таблицы.");
        } else {
            System.out.println("Элемент " + key + " не найден в хэш-таблице.");
        }
    }

    public static void main(String[] args) {
        PseudoRandomHashing hashTable = new PseudoRandomHashing(10);

        hashTable.insert("apple");
        hashTable.insert("banana");
        hashTable.insert("orange");

        System.out.println("Результат поиска: " + hashTable.search("banana"));

        hashTable.delete("banana");
    }
}
