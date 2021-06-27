public class Unicorn implements Animal {
    String name;

    public Unicorn(){
        this.name = "Unicorn";
    }


    @Override
    public void eat(){
        System.out.println("The unicorn is eating rainbow cakes...");
    }

    @Override
    public void perform(){
        System.out.println("The unicorn is flying...");
    }
}
