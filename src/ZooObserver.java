public class ZooObserver {
    private final String name;

    ZooObserver(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    /**
     * represents the message arrived to the observer. printed on screen
     * @param updateMessage : the message arrived to observer
     */
    public void update(String updateMessage) {
        System.out.println("[" + this.getName() + "] " + updateMessage);
    }
}
