package Decorator;

import Observer.IWeatherDataObserver;

public class PrecipitationDecorator extends WindowDecorator {
    private IWeatherDataObserver dataDecoratorOB;
    String precipitationType;
   public PrecipitationDecorator(IWeatherDataObserver dataDecoratorOB, String precipitationType){
       this.dataDecoratorOB=dataDecoratorOB;
       this.precipitationType=precipitationType;
   }
    @Override
    public void update(double temperature, double humidity) {
       dataDecoratorOB.update(temperature,humidity);
        System.out.println("Precipitation Type :"+precipitationType);
    }


}
