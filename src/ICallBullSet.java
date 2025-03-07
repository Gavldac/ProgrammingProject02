import java.util.HashMap;
import java.util.Map;

/**
 * Class for instantiating and performing operations on sets.
 * Sets are defined as a map of keys and values. 
 * The keys are the domain of the set and the values are the membership values of the set.
 * This class can be used for both standard sets ( keys with a value 'n' greater than 0 are equal to 1 ) 
 * as well as multisets ( keys with a value 'n' greater than 0 are equal to 'n' ).
 * 
 * @author Edwin Casady
 * @author revisions by Corbin
*/

public class ICallBullSet<K, V extends Number> extends HashMap<K, V> {
    private Map<K, V> map;

    /**
     * Creates a new set object.
     * Sets are defined as a map of keys and values.
     * The keys are the domain of the set and the values are the membership values of the set.
     * This class is used for both standard sets ( keys with a value 'n' greater than 0 = 1 )
     * as well as multisets ( keys with a value 'n' greater than 0 = 'n' ).
     * 
     * @param <K> The type of the keys in the set.
     * @param <V> The type of the values in the set.    
     * 
     */
    public ICallBullSet() {
        map = new HashMap<K, V>();
    }


    /**
     * Returns the set of items not in the given set.
     * 
     * @return ICallBullSet<K,V> result
     */
    @SuppressWarnings("unchecked")
    ICallBullSet<K, V> not() {
        ICallBullSet<K, V> result = new ICallBullSet<>();
        
        for (Map.Entry<K, V> m : this.entrySet()) {
            K k = m.getKey();
            V v = this.get(k);

            // Damn the ugly casts, should set all positive values to 0 and all 0s to 1
            Number opposite = (v.intValue() > 0) ? Integer.valueOf(0) : Integer.valueOf(1);
            result.put(k, (V) opposite);
        }
        return result;
    }

    /**
     * Returns the union of two sets.
     * Matching items (with a value greater than 0) are found and
     * the maximum values of matching items returned for the union.
     * @param b
     * @return
     */
    ICallBullSet<K, V> union(ICallBullSet<K, V> b) {
        ICallBullSet<K, V> result = new ICallBullSet<>();

        for (Map.Entry<K, V> m : this.entrySet()) {
            K k = m.getKey();
            V va = this.get(k);
            V vb = b.get(k);

            // Damn the ugly casts, should set the max(va, vb)
            V max = (va.intValue() < vb.intValue()) ? vb : va;
            result.put(k, max);
        }
        return result;
    }

    /**
     * Returns the set of items that are in both sets.
     * Matching items (with a value greater than 0) are found, the minimum value is returned.
     * 
     * @param ICallBullSet<K,V> b
     * 
     * @return ICallBullSet<K,V> result (the intersection of the two sets)
     */
    ICallBullSet<K, V> intersects(ICallBullSet<K, V> b) {
        ICallBullSet<K, V> result = new ICallBullSet<>();

        for (Map.Entry<K, V> m : this.entrySet()) {
            K k = m.getKey();
            V va = this.get(k);
            V vb = b.get(k);

            // set the min(va, vb)
            V min = (va.intValue() < vb.intValue()) ? va : vb;
            result.put(k, min);
        }
        return result;
    }

    /**
     * Returns the difference between two sets.
     * Items in set B are subtracted from set A.
     * If the result is negative, the value is set to 0.
     * @param IcallBullSet<K,V> b
     * @return IcallBullSet<K,V> result
     */
    @SuppressWarnings("unchecked")
    ICallBullSet<K, V> difference(ICallBullSet<K, V> b) {
        ICallBullSet<K, V> result = new ICallBullSet<>();

        for (Map.Entry<K, V> m : map.entrySet()) {
            K k = m.getKey();
            V va = map.get(k);
            V vb = b.containsKey(k) ? b.get(k) : (V) Integer.valueOf(0);

            Number v = va.intValue() - vb.intValue();
            if (v.intValue() < 0)
                v =  0;
            result.put(k,  (V) v);
        }
        return result;
    }

    /**
     * Returns the symmetric difference between two sets.
     * The symmetric difference is the union of the difference between the two sets.
     * defined as (A - B) U (B - A)
     * @param ICallBullSet<K,V> b
     * @return ICallBullSet<K,V> result
     */
    ICallBullSet<K, V> symmetricDifference(ICallBullSet<K, V> b) {
        ICallBullSet<K, V> result = new ICallBullSet<>();
     
        // defined as (A - B) U (B - A)
        // A - B can use the differnce method already defined.
        // Union is also already defined.
        result = this.difference(b).union(b.difference(this));
    
        return result; // 
    }

    /**
     * Returns the sum of two sets.
     * The sum of two sets is the sum of the values of the two sets
     * defined as A + B
     * 
     * @param ICallBullSet<K,V> b
     * @return ICallBullSet<K,V> result
     */
    @SuppressWarnings("unchecked")
    ICallBullSet<K, V> sum(Map<K, V> b) {
        ICallBullSet<K, V> result = new ICallBullSet<>();

        for (Map.Entry<K, V> m : this.entrySet()) {
            K k = m.getKey();
            V va = this.get(k);
            V vb = b.get(k);

            // Should find the sum between the two sets
            Number v = va.intValue() + vb.intValue();
            if (v.intValue() < 0)
                v = 0;
            result.put(k, (V) v);
        }
        return result;
    }

}
