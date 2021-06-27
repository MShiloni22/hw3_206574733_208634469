import java.util.ArrayList;
import java.util.*;

public class Zoo implements Subject {
    int happiness;
    int hunger;
    int animalNumber;
    ArrayList<Animal> animalsList;
    HashMap<String, Integer> kindsOfAnimals;
    private static Zoo instance = null;  // singleton
    private List<ZooObserver> observers = new ArrayList<>();


    public Zoo(){    }

    public static Zoo getInstance() {
        if (instance == null) {
            System.out.println("Creating zoo...");
            instance = new Zoo();
            instance.happiness = 2;
            instance.hunger = 3;
            instance.animalNumber = 0;
            instance.animalsList = new ArrayList<>();
            instance.kindsOfAnimals = new HashMap<>();
        }
        else{
            System.out.println("The zoo already exists...");
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

        // for first time
        if (kindsOfAnimals.keySet().toArray().length == 0){
            kindsOfAnimals.put(animal.name, 1);
            System.out.println("Notifying observers:");
            String updateMessage = animal.name + " has been added to the zoo!";
            notifyObservers(updateMessage);
            return;
        }

        // for non first time
        for (String kindOfAnimal : kindsOfAnimals.keySet()){
           if (kindOfAnimal.equals(animal.name)){
               kindsOfAnimals.put(animal.name, kindsOfAnimals.get(kindOfAnimal)+1);
               System.out.println("Notifying observers:");
               String updateMessage = animal.name + " has been added to the zoo!";
               notifyObservers(updateMessage);
               return;
           }
        }
        kindsOfAnimals.put(animal.name, 1);
        System.out.println("Notifying observers:");
        String updateMessage = animal.name + " has been added to the zoo!";
        notifyObservers(updateMessage);

    }

    public void feedAnimals(){
        if (this.hunger > 1) this.hunger -= 1;
        for (Animal a: this.animalsList){
            a.eat();
        }
        System.out.println("Notifying observers:");
        String updateMessage = "The animals are being fed";
        notifyObservers(updateMessage);
    }

    public void watchAnimals(){
        if (this.hunger < 5) this.hunger += 1;
        if (this.happiness < 5) this.happiness += 1;
        for (Animal a: this.animalsList){
            a.perform();
        }
        System.out.println("Notifying observers:");
        String updateMessage = "The animals are being watched";
        notifyObservers(updateMessage);
    }

    public void showAnimalsInfo(){
        System.out.println("The zoo contains total of " + this.animalNumber + " animals:");
        for (String kindOfAnimal : kindsOfAnimals.keySet()){
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
