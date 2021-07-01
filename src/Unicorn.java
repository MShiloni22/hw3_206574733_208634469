public class Unicorn extends Animal {
    public String name;

    public Unicorn(){ /* name set by the super class Animal */ }


    @Override
    public void eat(){
        System.out.println("The unicorn is eating rainbow cakes...");
    }

    @Override
    public void perform(){
        System.out.println("The unicorn is flying...");
    }
}
