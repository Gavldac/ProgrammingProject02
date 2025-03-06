/**
 * Class for instantiating and performing operations on fuzzy logic values.
 * Fuzzy logic values are defined as a floating point value between 0 and 1.
 * 
 *@author Markus
 *@author revisions by Edwin Casady
 */

public class FuzzyLogic {

    // Fuzzy  Object value
    double fuzzyValue;

    /**
     * Creates a new fuzzy logic object with a floating point value
     * Fuzzy logic values are defined as a floating point value between 0 and 1.
     * Valus greater than 1 are set to 1 and values less than 0 are set to 0
     * @param dbl
     */
    public FuzzyLogic(double dbl) {
        // Fuzzy logic values are defined as a floating point value between 0 and 1.
        dbl = (dbl > 1) ? 1 : dbl;
        dbl = (dbl < 0) ? 0 : dbl;
        fuzzyValue = dbl;

    }

    /**
     * Negates the fuzzy logic value.
     * Negation is defined as 1 - fuzzyValue
     * 
     * @return result
     */
    public double negation() 
    {
        return 1 - fuzzyValue;
    }

    /**
     * Unions the fuzzy logic value with another fuzzy logic value
     * Union is defined as the product of the two fuzzy logic values
     * this.get() * b.get()
     * 
     * @param b
     * @return result
     */
    public double union(FuzzyLogic b)  {
        return fuzzyValue * b.get();
    }

    /**
     * Finds the intersection of the fuzzy logic value with another fuzzy logic value
     * Intersection is defined as 1 - ((1 - fuzzyObject1) * (1 - fuzzyObject2))
     * @param b
     * @return result
     */
    public double intersection(FuzzyLogic b) {
        return  1 - ((1 - fuzzyValue) * (1 - b.get()));
    }

    /**
     * Returns the fuzzy logic value
     * @return double result
     */
    public double get() {
        return fuzzyValue;
    }

    /**
     * Sets the fuzzy logic value to a new value from 0 to 1
     * Valus greater than 1 are set to 1 and values less than 0 are set to 0
     * @param dbl
     */
    public void set(double dbl) {
        dbl = (dbl > 1) ? 1 : dbl;
        dbl = (dbl < 0) ? 0 : dbl;    
        this.fuzzyValue = dbl;
    }
}