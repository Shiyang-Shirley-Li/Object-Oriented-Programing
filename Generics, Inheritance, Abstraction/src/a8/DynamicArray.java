package a8;
/**
 * 
 * @author Shiyang(Shirley) Li
 */

/**
 * A DynamicArray behaves like an array of strings, except that it can grow and
 * shrink. It is indexed beginning with zero. When a DynamicArray is created, it
 * is empty. Operations are provided to add, get, set, and remove elements at an index.
 * 
 */
public class DynamicArray <T> {
    @SuppressWarnings("unchecked")
    protected T[] data = (T[]) new Object[0];
    protected int count; 
    /**
     * Creates an empty dynamic array.
     */
    public DynamicArray() {
        count = 0;
    }

    /***
     * Given an index i, returns a reference to an array that
     * has space at i for a new value, and old values in the data 
     * array copied into their appropriate locations. The count is 
     * changed by 1 to account for the "opening" in the array.
     * @param i: the index where a value will be added
     * @return a reference to the new array (or the same old one) with values placed as needed.
     */

    public T[] growthStrategy(int i) {
        if (count == data.length) {
            @SuppressWarnings("unchecked")
            T[] newData = (T[]) new Object[data.length + 1];
            for(int j = 0; j < i; j++) {
                newData[j] = data[j];
            }			

            for (int j = size(); j > i; j--) {
                newData[j] = data[j - 1];
            }
            count++;
            return newData;
        } 

        for (int j = size(); j > i; j--) {
            data[j] = data[j - 1];
        }

        count++;
        return data;
    }


    /**
     * Adds a string s to the dynamic array at index i.
     * 
     * @param i the index
     * @param s the String to add
     */
    public void add(int i, T s) {
        if(i < 0 || i > size())
            throw new IndexOutOfBoundsException();

        T[] newData = growthStrategy(i);
        newData[i] = s;
        data = newData;
    }

    /**
     * Adds string s to end of the dynamic array.
     * 
     * @param s the String to add to the end of the array
     */
    public void add(T s) {
        add(count, s);
    }

    /**
     * Returns the string stored at index i in the dynamic array.
     * 
     * @param i
     * @return the string stored at index i
     */
    public T get(int i) {
        if(i < 0 || i >= size())
            throw new IndexOutOfBoundsException();

        return data[i];
    }

    /**
     * Returns the number of elements in the dynamic array.
     * 
     * @return the number of elements
     */
    public int size() {
        return count;
    }

    /**
     * Changes the value of the string stored at index i in the dynamic array to
     * s.
     * 
     * @param i : the index of the location to be assigned a new value
     * @param s
     */
    public void set(int i, T s) {
        if(i < 0 || i >= size())
            throw new IndexOutOfBoundsException();

        data[i] = s;
    }

    /***
     * Given an index i, returns a reference to an array that
     * has the value at i removed and the array values copied to their appropriate locations. 
     * The count is changed by -1 to account for the "removal" in the array.
     * @param i the index of the item to remove
     * @return a smaller array with values placed as needed.
     */

    public T[] shrinkStrategy(int i) {
        @SuppressWarnings("unchecked")
        T[] newData = (T[]) new Object[data.length - 1];
        count--;
        for(int j = 0; j < i; j++) {
            newData[j] = data[j];
        }

        for(int j = i; j < size(); j++) {
            newData[j] = data[j + 1];
        }

        return newData;
    }

    /**
     * Removes the string at index i in the dynamic array.
     * 
     * @param i : the index of the item to remove.
     */
    public void remove(int i) {
        if(i < 0 || i >= size())
            throw new IndexOutOfBoundsException();

        data = shrinkStrategy(i);
    }

    /**
     * Returns the dynamic array as a formatted string.
     * 
     * @return the formatted string
     */
    public String toString() {
        String result = "[";
        if(size() > 0) {
            result += get(0);
        }
        for(int i = 1; i < size(); i++) {
            result += ", " + get(i);
        }
        return result + "]"+" real storage length: " + data.length;
    }

    public static void main(String[] args) {
        DynamicArray<String> das = new DynamicArray<String>();
        das.add("a");
        das.add("b");
        das.remove(1);
        das.add(0,"c");
        System.out.println(das);
    }

}

