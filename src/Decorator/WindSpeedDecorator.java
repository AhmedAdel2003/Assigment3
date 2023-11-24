package Decorator;

import Observer.IWeatherDataObserver;

public class  WindSpeedDecorator extends WindowDecorator{
    private IWeatherDataObserver dataDecoratorOB;
    private double windSpeed;

    public WindSpeedDecorator(IWeatherDataObserver dataDecoratorOB, double windSpeed) {
        this.dataDecoratorOB = dataDecoratorOB;
        this.windSpeed = windSpeed;
    }

    @Override
    public void update(double temperature, double humidity) {
        System.out.println("Wind speed: " + windSpeed + " m/s");
        dataDecoratorOB.update(temperature,humidity);
    }
}
