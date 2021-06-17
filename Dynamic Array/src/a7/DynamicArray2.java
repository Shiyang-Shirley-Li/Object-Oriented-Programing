package a7;

public class DynamicArray2 {

    private String[] data;   
    private int virtualArrayLength; 
    /**
     * Creates an empty dynamic array with room to grow.
     * (DO NOT modify this method.)
     */
    public DynamicArray2() {
        data = new String[8];
        virtualArrayLength = 0;
    }

    /**
     * Returns the number of elements in the dynamic array.
     * 
     * @return the number of elements
     */
    public int size() {
        return virtualArrayLength;
    }

    /**
     * 
     * @param s a String that adds at the end of an array
     */
    public void add(String s) {
        add(this.size(), s);
    }
    /**
     * Throws an IndexOutOfBoundsException if i is not a valid index
     * for adding to the dynamic array, otherwise inserts s at index i.
     * Elements can be added from index 0 to this.size().
     * @param i the index of the String s to add
     * @param s a String to add into the array
     */
    public void add(int i, String s) {
        if(i < 0 || i > this.size())
            throw new IndexOutOfBoundsException();

        if (virtualArrayLength >= data.length) {
            String[] newData = new String[data.length * 2];
            for(int j = 0; j < virtualArrayLength; j++)
                newData[j] = data [j];
            data = newData;
        }

        for(int k = virtualArrayLength; k > i; k--)
            data[k] = data[k-1];

        data[i] = s;

        virtualArrayLength ++;
    }

    /**
     * Throws an IndexOutOfBoundsException if i is not a valid index
     * of the dynamic array, otherwise removes the element at index i
     * and shifts the elements after i down one to fill in the gap.
     * @param i the index of where you want to remove
     */
    public void remove(int i) {
        if(i < 0 || i >= this.size())
            throw new IndexOutOfBoundsException();

        if(i == size()-1)
            data[i] = null;
        else 
            for(int j = i + 1; j < size() ; j++) {
                data[j-1] = data[j];	        
            }
        virtualArrayLength --;
    }

    /**
     * Throws an IndexOutOfBoundsException if i is not a valid index
     * of the dynamic array, otherwise returns the element at index i
     * @param i index of dynamic array
     * @return element at index i
     */
    public String get(int i) {
        if(i < 0 || i >= this.size())
            throw new IndexOutOfBoundsException();

        return data[i];
    }
    /**
     * Throws an IndexOutOfBoundsException if i is not a valid index
     * of the dynamic array, otherwise replaces the element at index i 
     * with s
     * @param i the index where you want replace 
     * @param s a string you want to replace with
     */
    public void set(int i, String s) {
        if(i < 0 || i >= this.size())
            throw new IndexOutOfBoundsException();

        data[i] = s;
    }

    /**
     * Returns a formatted string version of this dynamic array.
     * 
     * @return the formatted string
     */
    public String toString() {
        String result = "[";
        if(size() > 0) 
            result += get(0);

        for(int i = 1; i < size(); i++) 
            result += ", " + get(i);

        return result + "] backing size: " + data.length;
    }

    public static void main(String[] args) {
        DynamicArray2 d = new DynamicArray2();
        d.add("David");
        d.add("Joe1");
        d.add("David2");
        d.add("Joe3");
        d.add("David4");
        d.add("Joe5");
        d.add("David6");
        d.add("Joe7");
        d.add("David8");
        d.add("Joe9");
        d.add("David10");
        d.add("Joe11");
        d.add("David12");
        d.add("Joe13");
        d.add("David14");
        d.add("Joe15");
        System.out.println(d);
        System.out.println(d.get(0));
        d.add(1, "Mary");
        System.out.println(d);
        d.remove(2);
        System.out.println(d);
    }
}
