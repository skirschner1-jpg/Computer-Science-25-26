public class MyHash {
    private String[] array;

    public String[] getArray(){
        return array;
    }
    
    public void HashFn() {
        array = new String[500];
    }
    
    public void add(String str) {
        int index = hashFunction(str);
        array[index] = str;
    }
    
    public int hashFunction(String str) {
        int index = 0;
        for (int i = 0; i < str.length(); i++) {
            index += (str.charAt(i) * (i + 1));
        }
        int toReturn = index % 500;
        return toReturn;
    }
}
