import Decorator.PrecipitationDecorator;
import Decorator.TemperatureUnitsDecorator;
import Decorator.WindSpeedDecorator;
import Observer.CurrentConditionsDisplay;
import Observer.IWeatherDataObserver;
import Observer.StatisticsDisplay;
import Observer.WeatherDataSubject;

public class WeatherApp {
    public static void main(String[] args) {

        WeatherDataSubject Weather=new WeatherDataSubject();
        CurrentConditionsDisplay current=new CurrentConditionsDisplay();
       StatisticsDisplay display=new StatisticsDisplay();
       Weather.add(current);
       Weather.add(display);
       IWeatherDataObserver temperatureDeco=new TemperatureUnitsDecorator(current,"F");
        IWeatherDataObserver windSpeed=new WindSpeedDecorator(current,21);
       IWeatherDataObserver precipitationDecorator=new PrecipitationDecorator(current,"Snow");
       Weather.sets(15,2);
        precipitationDecorator.update(12,123);
        windSpeed.update(12,2);
        temperatureDeco.update(12,12);

    }
}
