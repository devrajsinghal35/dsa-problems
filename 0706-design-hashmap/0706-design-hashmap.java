class MyHashMap {

    int[] map;

    public MyHashMap() {
        map = new int[1000001];

        // -1 means key does not exist
        Arrays.fill(map, -1);
    }

    public void put(int key, int value) {
        map[key] = value;
    }

    public int get(int key) {
        return map[key];
    }

    public void remove(int key) {
        map[key] = -1;
    }
}