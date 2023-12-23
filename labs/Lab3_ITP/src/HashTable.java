import java.util.LinkedList;

public class HashTable<K, V> {
    private final LinkedList<Entry<K, V>>[] table;

    private static class Entry<K, V> {
        private final K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }

    private int size;

    private int tableSize;

    public HashTable(int tableSize) {
        this.table = new LinkedList[tableSize];
        this.tableSize = tableSize;
        this.size = 0;

        for (int i = 0; i < tableSize; i++) {
            table[i] = new LinkedList<>();
        }
    }


    // Метод put(key, value)
    public void put(K key, V value) {
        int index = hash(key);

        for (Entry<K, V> entry : table[index]) {
            if (entry.getKey().equals(key)) {
                entry.setValue(value);
                return;
            }
        }

        table[index].add(new Entry<K, V>(key, value));
        size++;
    }


    // Метод get(key)
    public V get(K key) {
        int index = hash(key);

        for (Entry<K, V> entry : table[index]) {
            if (entry.getKey().equals(key)) {
                return entry.getValue();
            }
        }
        return null;
    }


    // Метод remove(key)
    public void remove(K key){
        int index = hash(key);

        for (Entry<K, V> entry : table[index]) {
            if (entry.getKey().equals(key)) {
                table[index].remove(entry);
                size--;
                return;
            }
        }
    }

    // Метод для вычисления индекса
    private int hash(K key) {
        int hash = key.hashCode();
        return hash % tableSize;
    }


    // Метод size()
    public int size() {
        return size;
    }


    // Метод isEmpty()
    public boolean isEmpty() {
        return size == 0;
    }
}
