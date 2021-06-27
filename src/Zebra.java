public class Zebra extends Animal {
    public String name;

    public Zebra(){
        this.name = "Zebra";
    }


    @Override
    public void eat(){
        System.out.println("The zebra is eating grass...");
    }

    @Override
    public void perform(){
        System.out.println("The zebra is running...");
    }
}
