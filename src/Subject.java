public interface Subject {
    void subscribeObserver(ZooObserver observer);
    void unsubscribeObserver(ZooObserver observer);
    void notifyObservers();
}
