public abstract class AnimalFactory {
    /**
     * create a new instance of an animal.
     * implemented at derived classes according to the class
     */
    public abstract Animal createAnimal();
}

class UnicornFactory extends AnimalFactory {
    @Override
    public Animal createAnimal(){
        return new Unicorn();
    }
}

class ZebraFactory extends AnimalFactory {
    @Override
    public Animal createAnimal(){
        return new Zebra();
    }
}

class MonkeyFactory extends AnimalFactory {
    @Override
    public Animal createAnimal(){
        return new Monkey();
    }
}