/**
 * ChocolateHashMap<K,V>
 *
 * A custom hash map (separate chaining) built for a fictional chocolate factory inventory system.
 * Each bucket is a circular DOUBLY-linked list with a sentinel BatchNode.
 *
 * You are responsible for implementing the methods marked TODO.
 */
public class ChocolateHashMap<K, V> {
    private BatchNode<ChocolateEntry<K, V>>[] buckets;
    private int objectCount;
    private double loadFactorLimit;

    // Constructor: creates a hash map with the given initial bucket size and load factor limit
    @SuppressWarnings("unchecked")
    public ChocolateHashMap(int bucketCount, double loadFactorLimit) {
        this.buckets = (BatchNode<ChocolateEntry<K, V>>[]) new BatchNode[bucketCount];
        fillArrayWithSentinels(buckets);
        this.objectCount = 0;
        this.loadFactorLimit = loadFactorLimit;
    }

    public double loadFactorLimit() {
        return loadFactorLimit;
    }

    // Constructor: creates an empty hash map with default parameters
    public ChocolateHashMap() {
        this(10, 0.75);
    }

    private static void fillArrayWithSentinels(BatchNode[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new BatchNode();
        }
    }

    // Return a pointer to the bucket array
    public BatchNode<ChocolateEntry<K, V>>[] getBuckets() {
        return this.buckets;
    }

    // Returns true if this map is empty; otherwise returns false.
    public boolean isEmpty() {
        return (objectCount == 0);
    }

    // Returns the number of entries in this map.
    public int size() {
        return objectCount;
    }

    // Return the bucket index for the key
    // Use .hashCode(), but be aware that hashCode can return negative numbers!
    // NOTE: Math.abs(Integer.MIN_VALUE) is still negative. Consider masking the sign bit.
    private int whichBucket(K key) {
        // TODO: implement
        return Math.abs(key.hashCode() % buckets.length);
        // throw new UnsupportedOperationException("TODO: implement whichBucket");
        // DONE
    }

    private int whichBucket(K key, int newSize) {
        // TODO: implement
        return Math.abs(key.hashCode() % newSize);
        // throw new UnsupportedOperationException("TODO: implement whichBucket");
        // DONE
    }

    // Returns the current load factor (objCount / buckets)
    public double currentLoadFactor() {
        // TODO: implement
        return (double)objectCount / (double)buckets.length;
        // throw new UnsupportedOperationException("TODO: implement currentLoadFactor");
        // DONE
    }

    // Return true if the key exists as a key in the map, otherwise false.
    // Use the .equals method to check equality.
    public boolean containsKey(K key) {
        // TODO: implement
        int index = whichBucket(key);
        
        boolean notBeenHere = true;
        BatchNode thisNode = buckets[index];
        while (notBeenHere || !thisNode.isSentinel()) {
            notBeenHere = false;
            if (!thisNode.isSentinel()) {
                if (((ChocolateEntry) thisNode.getEntry()).getKey().equals(key)) {
                    return true;
                }
            }
            thisNode = thisNode.getNext();
        }
        
        return false;
        // if (get(key) != null) {
        //     return true;
        // }
        // return false;
        // throw new UnsupportedOperationException("TODO: implement containsKey");
        // DONE
    }

    // Return true if the value exists as a value in the map, otherwise false.
    // Use the .equals method to check equality.
    public boolean containsValue(V value) {
        // TODO: implement
        for (int i = 0; i < buckets.length; i++) {
            boolean notBeenHere = true;
            // System.out.println("here");
            BatchNode thisNode = buckets[i];
            while (notBeenHere || !thisNode.isSentinel()) {
                notBeenHere = false;
                // System.out.println("here");
                if (!thisNode.isSentinel()) {
                    // System.out.println("here");
                    if (((ChocolateEntry) thisNode.getEntry()).getValue() == null && value == null) {
                        return true;
                    }
                    if (((ChocolateEntry) thisNode.getEntry()).getValue().equals(value)) {
                        return true;
                    }
                }
                thisNode = thisNode.getNext();
            }
        }
        return false;
        // throw new UnsupportedOperationException("TODO: implement containsValue");
        // DONE
    }

    // Puts a key-value pair into the map.
    // If the key already exists in the map you should *not* add the key-value pair.
    // Return true if the pair was added; false if the key already exists.
    // If a pair should be added, add it to the END of the bucket.
    // After adding the pair, check if the load factor is greater than the limit.
    // - If so, you must call rehash with double the current bucket size.
    public boolean put(K key, V value) {
        // TODO: implement
        if (key == null) {
            return false;
        }
        if (containsKey(key)) {
            // System.out.println("HERE");
            return false;
        }
        int index = whichBucket(key);
        ChocolateEntry newChocolate = new ChocolateEntry(key, value);
        BatchNode newEntry = new BatchNode<>(newChocolate);
        BatchNode thisNode = buckets[index];
        while (!thisNode.getNext().isSentinel()) {
            thisNode = thisNode.getNext();
        }
        BatchNode sentinel = thisNode.getNext();
        thisNode.setNext(newEntry);
        newEntry.setPrevious(thisNode);
        newEntry.setNext(sentinel);
        sentinel.setPrevious(newEntry);
        // int prev = index - 1;
        // if (index == 0) {
        //     prev = 0;
        // }
        // BatchNode newNode = new BatchNode(newChocolate, buckets[prev], buckets[index + 1]);   
        // if (buckets[index].getEntry()!= null && buckets[index].getEntry().getKey().equals(key)) {
        //     return false;
        // }
        // if (buckets[index].isSentinel() && buckets[index].getPrevious().isSentinel()) {
        //     buckets[index] = newNode;
        // }
        // else {
        //     BatchNode thisNode = buckets[index];
        //     BatchNode sentinel = thisNode;
        //     while (!buckets[index].getNext().isSentinel()) {
        //         if (((ChocolateEntry)thisNode.getEntry()).getKey().equals(key)) {
        //             return false;
        //         }
        //         thisNode = thisNode.getNext();
        //     }
        //     thisNode.setNext(newNode);
        //     newNode.setNext(sentinel);
        // }
        objectCount++;
        if ((double) currentLoadFactor() > (double) loadFactorLimit) {
            System.out.println("here");
            rehash(buckets.length * 2);
        }
        return true;
        // throw new UnsupportedOperationException("TODO: implement put");
    }

    // Returns the value associated with the key in the map.
    // If the key is not in the map, then return null.
    public V get(K key) {
        // TODO: implement
        int index = whichBucket(key);
        BatchNode thisNode = buckets[index];
        if (thisNode == null) {
            return null;
        }
        boolean notBeenHere = true;
        while (notBeenHere || !thisNode.isSentinel()) {
            notBeenHere = false;
            if (!thisNode.isSentinel() && ((ChocolateEntry) thisNode.getEntry()).getKey().equals(key)) {
                return (V) ((ChocolateEntry) thisNode.getEntry()).getValue();
            }
            thisNode = thisNode.getNext();
        }
        return null;
        // DONE
        // throw new UnsupportedOperationException("TODO: implement get");
    }

    // Remove the pair associated with the key.
    // Return true if successful, false if the key did not exist.
    public boolean remove(K key) {
        // TODO: implement
        int index = whichBucket(key);
        BatchNode thisNode = buckets[index];
        if (thisNode == null) {
            return false;
        }
        if (!containsKey(key)) {
            return false;
        }
        boolean notBeenHere = true;
        while (notBeenHere || !thisNode.isSentinel()) {
            notBeenHere = false;
            if (!thisNode.isSentinel() && ((ChocolateEntry) thisNode.getEntry()).getKey().equals(key)) {
                // if (thisNode.getNext().isSentinel() && thisNode.getPrevious().isSentinel()) {
                //     BatchNode sentinel = thisNode.getNext();
                //     thisNode.getNext().setPrevious(sentinel);
                //     thisNode.getNext().setNext(sentinel);
                //     return true;
                // }
                BatchNode next = thisNode.getNext();
                BatchNode prev = thisNode.getPrevious();
                next.setPrevious(prev);
                prev.setNext(next);
                objectCount--;
                return true;
            }
            thisNode = thisNode.getNext();
            // throw new UnsupportedOperationException("TODO: implement remove");
        }
        return false;
    }

    // Rehash the map so that it contains the given number of buckets
    // Loop through all existing buckets, from 0 to length
    // Rehash each object into the new bucket array in the order they appear on the original chain.
    // I.e. if a bucket originally has (sentinel)->J->Z->K, then J will be rehashed first,
    // followed by Z, then K.
    public void rehash(int newBucketCount) {
        // TODO: implement
        BatchNode<ChocolateEntry<K, V>>[] newBuckets = new BatchNode[newBucketCount];
        fillArrayWithSentinels(newBuckets);
        for (int i = 0; i < buckets.length; i++) {
            BatchNode thisNode = buckets[i];
            boolean notBeenHere = true;
            while (notBeenHere || !thisNode.isSentinel()) {
                notBeenHere = false;
                if (!thisNode.isSentinel()) {
                    int index = whichBucket((K) ((ChocolateEntry) thisNode.getEntry()).getKey(), newBucketCount);
                    ChocolateEntry newChocolate = ((ChocolateEntry) thisNode.getEntry());
                    BatchNode newEntry = new BatchNode<>(newChocolate);
                    BatchNode homeBucket = newBuckets[index];
                    while (!homeBucket.getNext().isSentinel()) {
                        homeBucket = homeBucket.getNext();
                    }
                    BatchNode sentinel = homeBucket.getNext();
                    homeBucket.setNext(newEntry);
                    newEntry.setPrevious(homeBucket);
                    newEntry.setNext(sentinel);
                    sentinel.setPrevious(newEntry);
                }
                thisNode = thisNode.getNext(); // THTKJHSDGKJHSRTKLHERTEKJH
            }

            // while (!buckets[i].getNext().isSentinel()) {
            //     whichBucket((K) ((ChocolateEntry) thisNode.getEntry()).getKey(), newBucketCount);
            // }
        }
        System.out.println(newBucketCount);
        buckets = newBuckets;
        // throw new UnsupportedOperationException("TODO: implement rehash");
    }

    // The output should be in the following format:
    // [ n, k | { b#: k1,v1 k2,v2 k3,v3 } { b#: k1,v1 k2,v2 } ]
    // n is the objCount
    // k is the number of buckets
    // For each bucket that contains objects, create a substring that indicates the bucket index
    // And list all of the items in the bucket (in the order they appear)
    // Example (using chocolate-themed data):
    // [ 3, 10 | { b3: LOT-70,DARK LOT-12,MILK } { b7: LOT-99,WHITE } ]
    @Override
    public String toString() {
        // TODO: implement
        String toReturn = "[ " + objectCount + ", " + buckets.length + " | ";
        for (int i = 0; i < buckets.length; i++) {
            BatchNode thisNode = buckets[i];
            if (!(thisNode.isSentinel() && thisNode.getNext().isSentinel())) {
                toReturn += " { b" + i + ": ";
            
            
                boolean notBeenHere = true;
                while (notBeenHere || !thisNode.isSentinel()) {
                    notBeenHere = false;
                    if (!thisNode.isSentinel()) {
                        toReturn += ((ChocolateEntry) thisNode.getEntry()).getKey() + ",";
                        toReturn += ((ChocolateEntry) thisNode.getEntry()).getValue() + " ";
                    }
                    thisNode = thisNode.getNext();
                }
                toReturn += "}";
            }

            // while (!buckets[i].getNext().isSentinel()) {
            //     toReturn += ((ChocolateEntry) thisNode.getEntry()).getKey() + ",";
            //     toReturn += ((ChocolateEntry) thisNode.getEntry()).getValue() + " ";
            // }
        }
        toReturn += " ]";
        return toReturn;
        // DONE
        // throw new UnsupportedOperationException("TODO: implement toString");
    }
}
