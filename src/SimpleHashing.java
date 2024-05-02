public class SimpleHashing {
    private String[] hashTable;
    private int capacity;
    private int size;

    public SimpleHashing(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.hashTable = new String[capacity];
    }

    private int hashFunction(String key) {
        return key.length() % capacity;
    }

    public void insert(String key) {
        if (size == capacity) {
            System.out.println("Хэш-таблица заполнена.");
            return;
        }

        int index = hashFunction(key);

        while (hashTable[index] != null) {
            index = (index + 1) % capacity;
        }

        hashTable[index] = key;
        size++;
    }

    public int search(String key) {
        int index = hashFunction(key);

        while (hashTable[index] != null && !hashTable[index].equals(key)) {
            index = (index + 1) % capacity;
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
        SimpleHashing hashTable = new SimpleHashing(10);

        hashTable.insert("Kurush");
        hashTable.insert("Isfandiyor");
        hashTable.insert("Nabi");

        System.out.println("Результат поиска: " + hashTable.search("Kurush"));

        hashTable.delete("Kurush");
    }
}
