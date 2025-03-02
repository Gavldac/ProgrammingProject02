package net.sourceforge.jFuzzyLogic.test;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.rule.FuzzyRuleSet;

/*
 @author Markus
*/

    public class FuzzyLogic{

        // declaring needed variables
        float bobHunger;
        float fredHunger;
        Variable bobV;
        Variable fredV;
        FIS bob;
        FIS fred;

        // constructor (still needs work)
        public FuzzyLogic() {
            bob = FIS.load("fuzzy.fcl", true);
            if (bob == null) {
                System.err.println("error loading FCL file");
                return;
            }
            fred = FIS.load("fuzzy.fcl", true);
            if (fred == null) {
                System.err.println("error loading FCL file");
                return;
            }

            // setting values for people

            bob.setVariable("activity", 5);
            bob.setVariable("time",3.5);

            fred.setVariable("activity", 3);
            fred.setVariable("time",6);

            bob.evaluate();
            fred.evaluate();

            bobV = bob.getVariable("hunger");
            fredV = bob.getVariable("hunger");

            bobHunger = bobV.getValue();
            fredHunger = fredV.getValue();
        }

        // methods for set operations
        public float negation(float value){
            return 1 - value;
        }

        public float union(float x,float y){
            return x*y;
        }

        public float intersection(float x,float y){
            float isct = 1 - ((1-x) * (1-y));
            return isct;
        }
    }