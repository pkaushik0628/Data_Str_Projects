
import java.util.Random;
/**
 * The River class is mainly used to initialize, create, add elements to the river, and represent the river as a string. The class is implementing
 * the methods getLength(), numEmpty(), addRandom(Animal animal), updateCell(int i), and updateRiver(), and toString().
 *
 * @author Padmanabh Kaushik
 * @version 2/11/24
 */
public class River
{

    public Animal[] river;
    public int size;

    /**
     * This method creates a river of a specified length with random elements: null, fish, or bear. The bish and bears have randomly assigned
     * ages and genders.
     */
    public River(int length){
        river = new Animal[length];
        for(int i = 0; i < river.length; i++){
            Random rand = new Random();
            int k = rand.nextInt(3); // Generate a random number between 0 and 2
            Animal.Gender gender;
            int l = rand.nextInt(2); // Generate a random number between 0 and 1
            gender = (l == 0) ? Animal.Gender.MALE : Animal.Gender.FEMALE;
            if(k == 0) {
                river[i] = null;  
            } else if (k == 1) {
                river[i] = new Bear(rand.nextInt(10), gender);
            } else {
                river[i] = new Fish(rand.nextInt(5), gender);
            }
        }
    }

    /**
     * This method gets the legth of the river array
     */
    public int getLength(){
        return river.length;
    }

    /**
     * This method gets the length of the river array
     */
    public int numEmpty(){
        int count = 0;

        for(int i = 0; i<river.length; i++){
            if(river[i] == null){
                count++;
            }
        }
        return count;
    }

    /**
     * This method puts the specified animal at one the available empty spaces in the river, randomly and returns true. If all
     * spaces in the river array are filled, it returns false.
     */
    public boolean addRandom(Animal animal){
        if(numEmpty() == 0){
            return false;
        }
        else{
            int[] emptyIndices = new int[numEmpty()];
            int cntIndex = 0;
            for(int i = 0; i<river.length; i++){
                if(river[i] == null){
                    emptyIndices[cntIndex] = i;
                    cntIndex++;
                }
            }
            Random random = new Random();
            int randomIndex = emptyIndices[random.nextInt(emptyIndices.length)];
            river[randomIndex] = animal;
            size++;
            return true;
        }
    }

    /**
     * The method updates the cell at a specified index. If the cell is null, the method does nothing. 
     * If the creature has reached the end of its lifespan, the method replaces the cell with a null.
     * Otherwise, the algorithm decides which direction, if any, the animal should move, and what other actions
     * to take (including the creation of a child), following the specific rules.
     */
    public void updateCell(int i){
        if(river[i] == null){
            return;
        }
        else{
            if(river[i].maxAge()){
                river[i] = null;
            }
            else{
                Random rand = new Random();
                int k = rand.nextInt(0,3);
                int nextIndex = 0;

                if(k == 0){
                    nextIndex = i;
                }
                else if(k==1){
                    nextIndex = i-1;

                    if(nextIndex <= -1){
                        nextIndex = nextIndex+1;
                    }
                }
                else if(k==2){
                    nextIndex = i+1;

                    if(nextIndex >= river.length){
                        nextIndex = nextIndex-1;
                    }
                }

                //Implementation of interaction between animal after the move
                Animal competingAnimal = river[nextIndex];
                if (competingAnimal == null){
                    river[nextIndex] = river[i];
                    river[i] = null;
                }
                else if((competingAnimal instanceof Fish) && (river[i] instanceof Bear)){
                    river[nextIndex] = river[i];
                    river[i] = null;
                }
                else if((competingAnimal instanceof Bear) && (river[i] instanceof Fish)){
                    river[nextIndex] = river[nextIndex];
                    river[i] = null;
                }
                else if ((competingAnimal instanceof Fish) && (river[i] instanceof Fish)){
                    if(competingAnimal.gender == river[i].gender){
                        //If fishes are of the same gender, nothing happens
                        river[nextIndex] = river[nextIndex];
                        river[i] = river[i];
                    }
                    //If genders of Fish are opposite genders
                    else if(competingAnimal.gender != river[i].gender){
                        //If array is full, do nothing
                        if(numEmpty() == 0){
                            return;
                        }
                        else{
                            //Select from among the random indices
                            int[] emptyIndices = new int[numEmpty()];
                            int cntIndex = 0;
                            for(int j = 0; j<river.length; j++){
                                if(river[j] == null){
                                    emptyIndices[cntIndex] = j;
                                    cntIndex++;
                                }
                            }
                            Random random = new Random();
                            int randomIndex = emptyIndices[random.nextInt(emptyIndices.length)];
                            //Generate a fish baby with random gender
                            int l = random.nextInt(2);// Generates a random integer between 0 and 1
                            Animal.Gender gender;
                            gender = (l == 0) ? Animal.Gender.MALE : Animal.Gender.FEMALE;
                            //Place the fish baby in the randomly generated (and unfilled) index
                            river[randomIndex] = new Fish(0, gender);
                            size++;
                        }

                    }
                }
                else if((competingAnimal instanceof Bear) && (river[i] instanceof Bear)){
                    Bear bear1 = (Bear) river[i];
                    Bear bearCompeting = (Bear) competingAnimal;

                    if(bearCompeting.gender == bear1.gender){
                        if(bear1.getStrength() == bearCompeting.getStrength()){
                            //If bears have equal strength, then nothing happens
                            river[nextIndex] = river[nextIndex];
                            river[i] = river[i];
                        }
                        else if (bear1.getStrength()>bearCompeting.getStrength()){
                            river[nextIndex] = river[i];
                            river[i] = null;
                        }
                        else if (bear1.getStrength()<bearCompeting.getStrength()){
                            river[i] = river[nextIndex];
                            river[nextIndex] = null;
                        }
                    }
                    else if(bear1.gender != bearCompeting.gender){
                        if(numEmpty() == 0){
                            return;
                        }
                        else{
                            //Select from among the random indices
                            int[] emptyIndices = new int[numEmpty()];
                            int cntIndex = 0;
                            for(int j = 0; j<river.length; j++){
                                if(river[j] == null){
                                    emptyIndices[cntIndex] = j;
                                    cntIndex++;
                                }
                            }
                            Random random = new Random();
                            int randomIndex = emptyIndices[random.nextInt(emptyIndices.length)];
                            //Generate a bear baby with random gender
                            int l = random.nextInt(2);// Generates a random integer between 0 and 1
                            Animal.Gender gender;
                            gender = (l == 0) ? Animal.Gender.MALE : Animal.Gender.FEMALE;
                            //Place the fish baby in the randomly generated (and unfilled) index
                            river[randomIndex] = new Bear(0, gender); 
                            size++;
                        }
                    }
                }
            }
        }
    }

    /**
     * The method update the whole river, updating ages, moving animals, creating animals, and killing animals. This constitutes one cycle.
     */
    public void updateRiver() {
        //update all cells
        for (int i = 0; i < river.length; i++) {
            if (river[i] != null) {
                updateCell(i);
                // Update the cell based on the rules
                if(river[i] != null && river[i].maxAge()){
                    river[i] = null;
                }
            }
        }
        //increment the ages
        for (int i  = 0; i<river.length; i++){
            if(river[i] != null){
                river[i].age++;
            }
        }
    }

    /**
     * This method creates the string representation of the river array, by overriding the toString method in-built in Java.
     */
    @Override
    public String toString(){
        //initialize a stringbuilder
        StringBuilder newString = new StringBuilder();
        for(int i = 0; i<river.length; i++){
            //If the elements are not null, directly append them, and tehn append spaces
            if(river[i]!= null){
                newString.append(river[i].toString()).append(" ");
            }
            //if the elements are null, put dashes, and then append spaces
            else{
                newString.append("--").append(" ");
            }
        }
        //convert the stringbuilder back to a string
        return newString.toString();
    }
}