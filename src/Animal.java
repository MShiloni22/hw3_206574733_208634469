public abstract class Animal {
    String name;
    abstract void eat();
    abstract void perform();

    public Animal(){
        if (this instanceof Monkey) this.name = "Monkey";
        if (this instanceof Zebra) this.name = "Zebra";
        if (this instanceof Unicorn) this.name = "Unicorn";
    }

}
