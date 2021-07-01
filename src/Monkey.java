public class Monkey extends Animal {
    public String name;

    public Monkey(){ /* name set by the super class Animal */ }


    @Override
    public void eat(){
        System.out.println("The monkey is eating a banana...");
    }

    @Override
    public void perform(){
        System.out.println("The monkey is hanging on trees...");
    }
}