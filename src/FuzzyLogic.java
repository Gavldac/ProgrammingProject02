/*
 @author Markus
 */

 public class FuzzyLogic
 {
 
     // declaring needed variables
     double a, b;
 
     // constructor
     public FuzzyLogic(double mainValue, double secondaryValue)
     {
         a = mainValue;
         b = secondaryValue;
     }
 
     // methods for set operations
     public double negation(boolean n)   // enter true boolean for negation of variable "a" and enter false for variable "b"
     {
         if (n == true)
         {
             return 1 - a;
         } else
         {
             return 1 - b;
         }
     }
 
     public double union()
     {
         return a * b;
     }
 
     public double intersection()
     {
         double isct = 1 - ((1 - a) * (1 - b));
         return isct;
     }
 }