public class ZooObserver {
    private final String name;

    ZooObserver(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void update(String updateMessage) {
        System.out.println("[" + this.getName() + "] " + updateMessage);
    }
}
