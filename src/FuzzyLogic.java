/*
 @author Markus
*/

    public class FuzzyLogic{

        // declaring needed variables
        double a,b;


        // constructor
        public FuzzyLogic( double mainValue, double secondaryValue) {
            a = mainValue;
            b = secondaryValue;
        }

        // methods for set operations
        public double negation(){
            return 1 - a;
        }

        public double union(){
            return a*b;
        }

        public double intersection(){
            double isct = 1 - ((1-a) * (1-b));
            return isct;
        }
    }