package Decorator;

import Observer.IWeatherDataObserver;

public class TemperatureUnitsDecorator extends WindowDecorator {
    private IWeatherDataObserver dataDecoratorOB;
    String type;
    public TemperatureUnitsDecorator(IWeatherDataObserver dataDecoratorOB, String type) {
        this.dataDecoratorOB = dataDecoratorOB;
        this.type=type;
    }
    @Override
    public void update(double temperature, double humidity) {
        if (type.equals("C")) {
            dataDecoratorOB.update(temperature, humidity);
        } else if (type.equals("F")) {
            double temperatureF = (temperature * 1.8) + 32;
            dataDecoratorOB.update(temperatureF, humidity);
        }
    }
}
