package a8;

/**
 * 
 * @author Shiyang(Shirley) Li
 */

public class DynamicArrayDouble<T> extends DynamicArray<T>{
    public DynamicArrayDouble() {
        super();
    }
    @Override 
    public T[] growthStrategy(int i) {
        if (count == data.length) {
            @SuppressWarnings("unchecked")
            T[] newData = (T[]) new Object[data.length * 2 + 1];
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
}

