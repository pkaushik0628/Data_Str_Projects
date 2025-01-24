
/**
 * Implements the Bear class, which is a sub class of the abstract class Animal. Defines the constructor 
 * to initialize the bear with given age and gender. Implements methods incrAge, maxAge, and getStrength. 
 *
 * @author Padmanabh Kaushik
 * @version 2/11/24
 */
public class Bear extends Animal
{
    protected int maxAge_bear = 9;
    protected int strength;

    /**
     * Constructor to create a bear object
     */
    public Bear(int age, Gender gender){
        this.age = age;
        this.gender = gender;
        strength = this.getStrength();
    }
    
    /**
     * Increments the age of the bear by 1 and returns true. If max age is reached, it returns false.
     */
    public boolean incrAge(){
        if(this.age < maxAge_bear){
            this.age++;
            return true;
        }
        else{
            return false;
        }
    }

    
    /**
     * Returns true if the maximum age of the bear is reached. Else it returns false. 
     */
    public boolean maxAge(){
        if(this.age == maxAge_bear){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * This method returns the strength of the bear as a function of its age.
     */
    public int getStrength(){
        if(this.age == 0){
            strength = 1;
        }
        else if (this.age  == 1){
            strength = 2;
        }

        else if(this.age == 2){
            strength  = 3;
        }
        else if(this.age == 3){
            strength  = 4;
        }
        else if(this.age == 4){
            strength  = 5;
        }
        else if(this.age == 5){
            strength  = 4;
        }
        else if(this.age == 6){
            strength  = 3;
        }
        else if(this.age == 7){
            strength  = 2;
        }
        else if(this.age == 8){
            strength  = 1;
        }
        else if(this.age == 9){
            strength  = 0;
        }
        else{
            strength = 0;
        }
        return strength;
    }

}
