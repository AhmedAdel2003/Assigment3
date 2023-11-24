package Observer;

import java.util.ArrayList;
import java.util.List;

public class WeatherDataSubject implements ISubject {
    private double temperature;
    private double humidity;
    private List<IWeatherDataObserver>ObserverList;

    @Override
    public void add(IWeatherDataObserver observer) {
        ObserverList.add(observer);

    }

    @Override
    public void remove(IWeatherDataObserver observer) {
        ObserverList.remove(observer);

    }

    @Override
    public void notifyAllObservers() {
        for (IWeatherDataObserver observer : ObserverList) {
            observer.update(temperature, humidity);
        }
    }
    public WeatherDataSubject(){
        this.humidity=humidity;
        this.ObserverList=new ArrayList<>();
        this.temperature=temperature;

    }



    public void sets(double temperature,double humidity) {
        this.temperature = temperature;
        notifyAllObservers();
    }


}

