public interface Subject {
    void addObserver(ZooObserver observer);
    void removeObserver(ZooObserver observer);
    void notifyObservers(String updateMessage);
}
