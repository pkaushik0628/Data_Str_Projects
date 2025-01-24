import java.util.Random;
/**
 * Defines abstract class Animal. Defines real methods getAge(), toString(), and abstract classes incrAge() and maxAge().
 *
 * @author Padmanabh Kaushik
 * @version 2/11/24
 */
public abstract class Animal
{
    
    protected enum Gender{
      FEMALE, MALE
  }
  
  protected Gender gender;
  protected int age;
  /**
   * Initializes the default animal constructor
   */
  public Animal(){
      Random random = new Random();
      age = random.nextInt(10) +1;
  }
  
  public Animal(int age, Gender gender){
      this.age = age;
      this.gender = gender;
  }
  
  /**
   * Returns the age of the animal
   */
  public int getAge(){
    return age;  
  }
  
  /**
   * Defines abstract class maxAge. This class has been sepapately for subclasses Fish and Bear.
   */
  abstract boolean maxAge();
  
  /**
   * Defines abstract class incrAge. This class has been sepapately for subclasses Fish and Bear.
   */
  abstract boolean incrAge();
  
  /**
   * The method gives the string representation of the animal name. Overrides the toString() method in-built in Java.
   */
  @Override
  public String toString(){
      String[] animalName = new String[3];
      
      //determine animal
      if(this instanceof Bear){
          animalName[0] = "B";
      }
      else if (this instanceof Fish){
          animalName[0] = "F";
      }
      
      //determine gender
      if (gender == Gender.MALE){
          animalName[1] = "M";
      }
      else if (gender == Gender.FEMALE){
          animalName[1] = "F";
      }
      
      //determine age
      animalName[2] = String.valueOf(age);
      return String.join("", animalName);
      
  }
}
