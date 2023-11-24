package Observer;

import java.util.Observer;

public interface ISubject {
    void add(IWeatherDataObserver observer);
    void remove(IWeatherDataObserver observer);
    void notifyAllObservers();


}
