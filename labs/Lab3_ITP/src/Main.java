public class Main {
    public static void main(String[] args) {
        Contact c1 = new Contact("Роман", "roman@mail.ru", "г. Королев, Заречный пер., д. 9, кв. 53");
        Contact c2 = new Contact("Наталья", "natalia@mail.ru", "г. Москва, Цветочная ул., д. 23, кв. 66");
        Contact c3 = new Contact("Евгений", "evgeni@mail.ru", "г. Самара, Дружная ул., д. 5, кв. 21");

        HashTable<Integer, Contact> hashtable = new HashTable<>(10);

        hashtable.put(152022, c1);
        hashtable.put(751553, c2);
        hashtable.put(715714, c3);

        System.out.println("Table size: " + hashtable.size());
        System.out.println((hashtable.get(152022)));
        hashtable.remove(152022);
        System.out.println("Table size: " + hashtable.size());
        System.out.println("Is empty: " + hashtable.isEmpty());
        hashtable.remove(751553);
        hashtable.remove(715714);
        System.out.println("Is empty: " + hashtable.isEmpty());
    }
}
