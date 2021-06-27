import java.util.ArrayList;
import java.util.Map;
import java.util.*;

public class Zoo implements Subject {
    int happiness;
    int hunger;
    int animalNumber;
    ArrayList<Animal> animalsList;
    Map<String, Integer> kindsOfAnimals;
    private static Zoo instance = null;  // singleton
    private List<ZooObserver> observers;


    public Zoo(){    }

    public static Zoo getInstance() {
        if (instance == null) {
            instance = new Zoo();
            instance.happiness = 2;
            instance.hunger = 3;
            instance.animalNumber = 0;
            instance.animalsList = null;
            instance.kindsOfAnimals = null;
        }
        return instance;
    }

    public void addAnimal(Animal animal){
        /*
        add animal to the list, update the number of animals
        if animal name not in kindsOfAnimals keys, append the the name as key and "1" as value
        else promote kindsOfAnimals[animal.name]
        in the end print message
        */
        this.animalsList.add(animal);
        this.animalNumber += 1;

        for (String kindOfAnimal : kindsOfAnimals.keySet()){
           if (kindOfAnimal.equals(animal.name)){
               // todo understand if this is the right way to approach maps
               kindsOfAnimals.put(animal.name, kindsOfAnimals.get(kindOfAnimal)+1);
               String updateMessage = animal.name + " has been added to the zoo!";
               notifyObservers(updateMessage);
               return;
           }
        }
        kindsOfAnimals.put(animal.name, 1);
        String updateMessage = animal.name + " has been added to the zoo!";
        notifyObservers(updateMessage);

    }

    public void feedAnimals(){
        if (this.hunger > 1) this.hunger -= 1;
        for (Animal a: this.animalsList){
            a.eat();
        }
        String updateMessage = "The animals are being fed";
        notifyObservers(updateMessage);
    }

    public void watchAnimals(){
        if (this.hunger < 5) this.hunger += 1;
        if (this.happiness < 5) this.happiness += 1;
        for (Animal a: this.animalsList){
            a.perform();
        }
        String updateMessage = "The animals are being watched";
        notifyObservers(updateMessage);
    }

    public void showAnimalsInfo(){
        System.out.println("The zoo contains total of" + this.animalNumber + "animals:");
        for (String kindOfAnimal : kindsOfAnimals.keySet()){
            // todo understand if this is the right way to approach maps
            System.out.println("- " + kindOfAnimal + ": " + kindsOfAnimals.get(kindOfAnimal));
        }
        System.out.println("Happiness level: " + this.happiness);
        if (this.happiness < 3 ) { System.out.println("The animals are not happy, you should watch them..."); }
        if (this.happiness >= 3 ) { System.out.println("The animals are very happy, keep working hard..."); }
        System.out.println("Hunger level: " + this.hunger);
        if (this.hunger > 3 ) { System.out.println("The animals are hungry, you should feed them..."); }
    }

    @Override
    public void addObserver(ZooObserver observer){
        observers.add(observer);
    }

    @Override
    public void removeObserver(ZooObserver observer){
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String updateMessage){
        for (ZooObserver observer : observers)
        observer.update(updateMessage);
    }
}
