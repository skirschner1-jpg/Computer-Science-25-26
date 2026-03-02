public class ChocolateHashMapTester {
    public static void main(String[] args) {
        ChocolateHashMap map = new ChocolateHashMap();
        map.put("MLKCHCLT", null);
        map.put("WHTCHCLT", "khsfgkjhgkhj khjsdgkhjsgdkhj kjsdghjg hdgs");
        map.put("DRKCHCLT", "kjsdgjh hjdhkjgs kjhsdghkjdsg kjsdghkjdsghjk");
        System.out.println(map.get("MLKCHCLT"));
        System.out.println(map.containsKey("MLKCHCLT"));
        System.out.println(map.toString());
        System.out.println(map.isEmpty());
        System.out.println(map.size());
        System.out.println(map.currentLoadFactor());
        System.out.println(map.containsKey("MLKCHCLT"));
        System.out.println(map.containsValue(null));
        map.remove("MLKCHCLT");
        map.remove("WHTCHCLT");
        System.out.println(map.toString());

        map.rehash(20);
        // System.out.println(map.toString());
        
        // System.out.println(map.put("SKU-A", "Milk"));
        // System.out.println(map.put("SKU-A", "Dark"));
        // System.out.println("STARTING FOR LOOP");
        // for (int i = 0; i < map.getBuckets().length; i++) {
        //     // System.out.println(map.getBuckets()[i]);
        //     // System.out.println(map.getBuckets()[i].getPrevious().getNext());
        //     System.out.println(map.getBuckets()[i].equals(map.getBuckets()[i].getPrevious().getNext()));
        // }

        // System.out.println(inventory.put("SKU-A", "Milk") + "put should return true when inserting new key");
        // System.out.println(inventory.isEmpty() + "Map should not be empty after one put");
        // System.out.println(inventory.size() + "size should be 1 after one put");

        // System.out.println(inventory.containsKey("SKU-A"));
        // System.out.println(inventory.containsValue("Milk"));
        // System.out.println("Milk" + inventory.get("SKU-A"));

        // System.out.println(1.0 / 10.0, inventory.currentLoadFactor(), 1e-9 + "currentLoadFactor() incorrect");

            // String s = inventory.toString();
            // ToStringView v = parseToString(s);
            // System.out.println(1, v.n +  "toString header n must equal objectCount");
            // System.out.println(10, v.k + "toString header k must equal bucket count");

            // ChocolateHashMap<String, String> map = new ChocolateHashMap<>(2, 0.49);
            // System.out.println(map.getBuckets().length);
            // map.put("A", "v");
            // System.out.println(map.currentLoadFactor());
            // System.out.println(map.getBuckets().length);
            // System.out.println(map.loadFactorLimit());


    }
}
