package Observer;

public class CurrentConditionsDisplay implements IWeatherDataObserver {
    @Override
    public void update(double temperature, double humidity) {
        System.out.println("Current conditions:");
        System.out.println("Temperature: " + temperature + "C");
        System.out.println("Humidity: " + humidity + "%");
    }
}
