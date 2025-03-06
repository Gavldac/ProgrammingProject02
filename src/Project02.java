import java.util.ArrayList;
import java.util.List;

/* 
@author ADD YOUR NAME!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
@author ADD YOUR NAME!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
@author revised by Markus
 
*/

public class Project02 {




    public static void main(String[] args) throws Exception {

        FuzzyLogic fuz = new FuzzyLogic(.3, .8);
        ICallBullSet<Character, Integer> set1 = new ICallBullSet<>();
        ICallBullSet<Character, Integer> set2 = new ICallBullSet<>();

        // This is to define the domain of the sets
        List<Character> setDomain = new ArrayList<>();
        setDomain.add('a');
        setDomain.add('b');
        setDomain.add('c');
        setDomain.add('d');
        setDomain.add('e');
        setDomain.add('f');
        setDomain.add('g');
        setDomain.add('h');
        setDomain.add('i');
        setDomain.add('j');
        setDomain.add('k');
        setDomain.add('l');
        setDomain.add('m');
        setDomain.add('n');
        setDomain.add('o');
        setDomain.add('p');
        setDomain.add('q');
        setDomain.add('r');

        // This is to initialize the sets with the domain.
        // This does not assign any values to the sets, just keys
        for (Character c : setDomain) {
            set1.put(c, 0);
            set2.put(c, 0);
        }

        // This is the actual set for set1
        // {a, c, e, g, i, k, m, o, q}
        for (int i = 'a'; i <= 'r'; i+=2) {
            set1.put( (char)i, set1.get( (char)i ) +1);
            
        }

        // This is the actual set for set2
        // {b, d, f, h, j, l, n, p, r}
        for (int i = 'b'; i <= 'r'; i+=2) {
            set2.put( (char)i, set2.get( (char)i ) +1);
        }



        
        set2.put('d', 5);
        set2.put('f', 2);
        set2.put('r', 3);
        set1.put('a', 0);
        set1.put('b', 1);
        set1.put('c', 5);
        set1.put('r', 2);


        System.out.println("Set1 init:  " + set1);
        System.out.println("Set1.not(): " + set1.not());
        System.out.println();
        
        
        System.out.println("Set2 init:  " + set2);
        System.out.println("set2.not(): " + set2.not());
        System.out.println();

        ICallBullSet<Character, Integer> set3 = (ICallBullSet) set1.union(set2);
        ICallBullSet<Character, Integer> set4 = (ICallBullSet) set1.intersects(set2);

        System.out.println("Set1:             " + set1);
        System.out.println("Set2:             " + set2);

        System.out.println("set1.union(set2): " + set3);
        System.out.println("set1.inter(set2): " + set4);

        System.out.println("set1.diffr(set2): " +  set1.difference(set2));
        System.out.println("set1.sum(set2):   " +  set1.sum(set2));

        System.out.println();
        System.out.println("Fuzzy Logic Testing: ");
        System.out.println("A = .3");
        System.out.println("B = .8");
        System.out.printf("Negation for A: %2.2f\n" , fuz.negation(true) );
        System.out.printf("Negation for B: %2.2f\n" , fuz.negation(false));
        System.out.printf("A union B: %2.2f\n" , fuz.union());
        System.out.printf("A intersection B: %2.2f\n" , fuz.intersection());

    }
}
