import java.util.ArrayList;
import java.util.List;

/** 
 * Test class for ICallBullSet and FuzzyLogic classes.
 * This class tests the ICallBullSet and FuzzyLogic classes by creating two sets of characters and integers
 * and performing set operations on them. It also tests the FuzzyLogic class by creating two FuzzyLogic objects
 * and performing set operations on them.
 * 
 * 
* @author Edwin Casady
* @author ADD YOUR NAME!!!!!!!!!
* @author revised by Markus
*
*/

public class Project02 {

	public static void main(String[] args) throws Exception {

        /*----------------------------TESTING CLIENT-----------------------------*/
        ICallBullSet<Character, Integer> set1 = new ICallBullSet<>();
        ICallBullSet<Character, Integer> set2 = new ICallBullSet<>();


        FuzzyLogic fuz1 = new FuzzyLogic(.3);
        FuzzyLogic fuz2 = new FuzzyLogic(.8);

        // This is to define the domain of the sets as
        // {a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r}
        List<Character> setDomain = new ArrayList<>();
        char start = 'a';
        for (int i = 0; i < 18; i++) {
            setDomain.add(start++);
        }
        
         // This is to initialize the sets with the domain.
        // This does not assign any values to the sets, just keys
        for (Character c : setDomain) {
            set1.put(c, 0);
            set2.put(c, 0);
        }

        // Sets values for set1 to every other character in the domain
        // {a, c, e, g, i, k, m, o, q}
        for (int i = 'a'; i <= 'r'; i+=2) {
            set1.put( (char)i, set1.get( (char)i ) +1);
            
        }

        // Sets values for set2 to every other character in the domain
        // {b, d, f, h, j, l, n, p, r}
        for (int i = 'b'; i <= 'r'; i+=2) {
            set2.put( (char)i, set2.get( (char)i ) +1);
        }

        System.out.println(); // Padding for console output
        System.out.println("Testing set operations on sets of characters and integers\n");


        System.out.println("Set1 init:  " + set1);
        System.out.println("Set1.not(): " + set1.not());
        System.out.println();
        
        System.out.println("Set2 init:  " + set2);
        System.out.println("set2.not(): " + set2.not());
        System.out.println();

        ICallBullSet<Character, Integer> set3 =  set1.union(set2);
        ICallBullSet<Character, Integer> set4 =  set1.intersects(set2);

        System.out.println("Set1:             " + set1);
        System.out.println("Set2:             " + set2);

        System.out.println("set1.union(set2): " + set3);
        System.out.println("set1.inter(set2): " + set4);

        System.out.println("set1.diffr(set2): " +  set1.difference(set2));
        System.out.println("set1.sum(set2):   " +  set1.sum(set2));

        System.out.println(); // Padding for console output
        System.out.println("Testing multiset operations on sets of characters and integers\n");

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

         set3 =  set1.union(set2);
         set4 =  set1.intersects(set2);

        System.out.println("Set1:             " + set1);
        System.out.println("Set2:             " + set2);

        System.out.println("set1.union(set2): " + set3);
        System.out.println("set1.inter(set2): " + set4);

        System.out.println("set1.diffr(set2): " +  set1.difference(set2));
        System.out.println("set1.sum(set2):   " +  set1.sum(set2));

        System.out.println();
        System.out.println("Fuzzy Logic Testing: ");
       
        System.out.println("A = " + fuz1.get());
        System.out.println("B = " + fuz2.get());
        System.out.printf("Negation for A: %2.2f\n" , fuz1.negation() );
        System.out.printf("Negation for B: %2.2f\n" , fuz2.negation());
        System.out.printf("A union B: %2.2f\n" , fuz1.union(fuz2));
        System.out.printf("A intersection B: %2.2f\n" , fuz1.intersection(fuz2));
    }
}
