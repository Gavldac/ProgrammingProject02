import java.util.HashMap;
import java.util.Map;

public class ICallBullSet<K, V extends Number> extends HashMap<K, V> {
    private Map<K, V> map;

    public ICallBullSet() {
        map = new HashMap<K, V>();
    }

    Map<K, V> not() {
        ICallBullSet<K, V> result = new ICallBullSet<>();
        
        for (Map.Entry<K, V> m : this.entrySet()) {
            K k = m.getKey();
            V v = this.get(k);

            // Damn the ugly casts, should set the all positive values to 0 and all 0s to 1
            Integer opposite = (v.intValue() > 0) ? Integer.valueOf(0) : Integer.valueOf(1);
            result.put(k, (V) opposite);
        }
        return result;
    }

    Map<K, V> union(Map<K, V> b) {
        ICallBullSet<K, V> result = new ICallBullSet();

        for (Map.Entry<K, V> m : this.entrySet()) {
            K k = m.getKey();
            V va = this.get(k);
            V vb = b.get(k);

            // Damn the ugly casts, should set the max(va, vb)
            Number max = (va.intValue() < vb.intValue()) ? vb : va;
            result.put(k, (V) max);
        }
        return result;
    }

    Map<K, V> intersection() {
        return map; // TODO
    }

    Map<K, V> difference(ICallBullSet<K, V> b) {
        ICallBullSet<K, V> result = new ICallBullSet<>();

        for (Map.Entry<K, V> m : this.entrySet()) {
            K k = m.getKey();
            V va = this.get(k);
            V vb = b.get(k);

            // Should find the difference between
            Number v = va.intValue() - vb.intValue();
            if (v.intValue() < 0)
                v = 0;
            result.put(k, (V) v);
        }
        return result;
    }

    Map<K, V> symmetricDifference(ICallBullSet<K, V> b) {
        ICallBullSet<K, V> result = new ICallBullSet<>();
        ICallBullSet<K, V> temp1 = new ICallBullSet<>();
        ICallBullSet<K, V> temp2 = new ICallBullSet<>();
        // defined as (A - B) U (B - A)
        // A - B can use the differnce method already defined.
        // Union is also already defined.
        temp1 = (ICallBullSet) this.difference(b); // A - B
        temp2 = (ICallBullSet) b.difference(this); // B - A
        result = (ICallBullSet) temp1.union(temp2);
        return result; // 
    }

    Map<K, V> plus(Map<K, V> b) {
        ICallBullSet<K, V> result = new ICallBullSet<>();
        return result; // TODO
    }

}