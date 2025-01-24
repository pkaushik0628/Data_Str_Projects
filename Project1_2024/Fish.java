
/**
 * Implements the fish class, which is a child class of the abstract class Animal. Defines the constructor to initialize the fish with given age
 * and gender. Implements methods incrAge and maxAge.
 *
 * @author Padmanabh Kaushik
 * @version 2/11/24
 */
public class Fish extends Animal
{
    private int maxAge_fish = 4;
    
    public Fish(int age, Gender gender){
        this.age = age;
        this.gender = gender;
    }
    
    /**
     * This method increments the age of teh fish by one and returns true. If max age is reached, it returns false.
     */
    public boolean incrAge(){
        //If maximum age is not reached, increment the age and return true
        if(this.age < maxAge_fish){
            this.age++;
            return true;
        }
        //else return false
        else{
            return false;
        }
    }
    
    /**
     * This method returns true is the maximum age of the fish has been attained. Else it returns false.
     */
    public boolean maxAge(){
        //If maximum age is reached, return true, else return false
        if(this.age >= maxAge_fish){
            return true;
        }
        else{
            return false;
        }
    }
}
