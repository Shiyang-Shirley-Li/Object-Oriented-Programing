package a7;

/**
 * A StringSet is a collection of non-null strings, with no duplicates
 * @author ShirleyLi
 *
 */

public class StringSet {
    private DynamicArray2 set;  
    /**
     * Creates an empty StringSet object
     */

    public StringSet() {
        set = new DynamicArray2();// FILL IN
    }

    /**
     * Throws an IllegalArgumentException if e is null, otherwise adds
     * e to the set if there is not already an element in the set equal
     * to e
     * @param e a string
     */ 
    public void insert(String e) {
        if(e == null)
            throw new IllegalArgumentException();
        else 
            if(contains(e) == false)
                set.add(set.size(),e);
    }

    /**
     *  Throws an IllegalArgumentException if e is null, otherwise
     *  indicates whether the set contains e
     * @param e a string 
     * @return true or false
     */
    public boolean contains(String e) {
        if(e == null)
            throw new IllegalArgumentException();

        for (int i = 0; i < set.size(); i ++) 
            if (set.get(i).equals(e))
                return true;

        return false;
    }

    /** Throws an IllegalArgumentException if e is null, otherwise
     *  removes e from the set
     * @param e a string to remove from the set
     */
    public void remove(String e) {
        if(e == null)
            throw new IllegalArgumentException();

        else
            if(contains(e) == true) {
                for (int i = 0; i < set.size(); i ++)
                    if (set.get(i).equals(e))
                        set.remove(i);
            }       
    }

    /**
     * @return the number of strings in the set
     */
    public int size() {
        return set.size();
    }  

    /**
     * Throws an IllegalArgumentException if other is null. Otherwise, computes the 
     * union of the  StringSet that calls this method and the StringSet argument 
     * to the method.
     * @param other a StringSet
     * @return the union of the StringSet that calls this method and the 
     *         StringSet argument to the method.
     */
    public StringSet union(StringSet other) {
        if(other == null)
            throw new IllegalArgumentException();

        StringSet union = new StringSet();
        for(int i = 0; i < this.size(); i++)
            union.insert(this.set.get(i));
        for(int j = 0; j < other.size(); j++)
            union.insert(other.set.get(j));
        return union;
    }

    /**
     * Throws an IllegalArgumentException if other is null. Otherwise, Computes 
     * the intersection of the StringSet that calls this method and 
     * the StringSet argument to the method.
     * @param other a StringSet
     * @return the intersection of the StringSet that calls this method and 
     *         the StringSet argument to the method.
     */
    public StringSet intersection(StringSet other) {
        if(other == null)
            throw new IllegalArgumentException();

        StringSet intersection = new StringSet();
        if(other.size() >= this.size())
            for(int i = 0; i < this.size(); i ++) {
                for(int j = 0; j < this.size(); j++) {
                    if(other.set.get(i).equals(this.set.get(j)))
                        intersection.insert(other.set.get(i));
                }
            }
        else
            for(int i = 0; i < other.size(); i ++) {
                for(int j = 0; j < other.size(); j++) {
                    if(other.set.get(i).equals(this.set.get(j)))
                        intersection.insert(other.set.get(i));
                }
            }
        return intersection;
    }

    /**
     * If set contains "a" and "b", this method should 
     * return the string "{a, b}".  If the set is empty, this 
     * method should return the string "{}".
     * @return a formatted string version of this set
     * 
     */
    public String toString() {
        String result = "{";
        if(size() > 0) 
            result += set.get(0);

        for(int i = 1; i < size(); i++) 
            result += ", " + set.get(i);

        return result + "}";
    }

    public static void main(String[] args) {
        StringSet d = new StringSet();
        d.insert("David");
        d.insert("David");
        d.insert("David1");
        System.out.println(d);
        StringSet a = new StringSet();
        a.insert("a");
        a.insert("David");
        System.out.println(d.union(a));
        System.out.println(d.intersection(a));
    }
}