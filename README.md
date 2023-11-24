# Building a Weather Monitoring System



### Observers 
It supports the principle of loose coupling between objects that interact with each other
It allows sending data to other objects effectively without any change in the Subject or Observer classes
Observers can be added/removed at any point in time .
* #### `ISubject :` it contian a functions that help me to add ,remove observer in observerList and send notify .
```java
public interface ISubject {
    void add(IWeatherDataObserver observer);
    void remove(IWeatherDataObserver observer);
    void notifyAllObservers();
}

```
* #### `WeatherDataSubject: `It contains temperature and humidity and sends notification when any change occurs.
```java
public class WeatherDataSubject implements ISubject {
    private double temperature;
    private double humidity;
    private List<IWeatherDataObserver> ObserverList;
}
```
this class WetherData Implement ISubject

```java
    public class WeatherDataSubject implements ISubject {

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
}

```
I add and remove the Observer from observerList and make update in notify

* #### `IWeatherDataObserver:`Interface updates data on temperature and humidity.
```java
public interface IWeatherDataObserver {
    void update(double temperature, double humidity);
}

```

* #### `StatisticsDisplay:`It prints the average temperature and humidity based on the information you entered.
```java
public class StatisticsDisplay implements IWeatherDataObserver {
 private double allTemperature;
    private double allHumidity;
    private int count1;
    private int count2;}
```
this is attrubits for this class to calcualte avarge for temperature and Humidity
```java
public class StatisticsDisplay implements IWeatherDataObserver {

 @Override
    public void update(double temperature, double humidity) {
     allTemperature += temperature;
     count1++;
     double averageTemperature = allTemperature / count1;
     allHumidity += humidity;
     count2++;
     double averageHumidity = allHumidity / count2;
     System.out.println("Average temperature: " + averageTemperature + "C");
     System.out.println("Average Humidity : " + averageHumidity + "%");
 }}
```
* ####  `CurrentConditionsDisplay:`You print the weather condition 
```java
public class CurrentConditionsDisplay implements IWeatherDataObserver {
    @Override
    public void update(double temperature, double humidity) {
        System.out.println("Current conditions:");
        System.out.println("Temperature: " + temperature + "C");
        System.out.println("Humidity: " + humidity + "%");
    }}
```
i make override for update func to print


### Decorator 
The decorator helps me when I want to add a new functionality to the code instead of directly modifying the original object. It applies the principle of OCP principle which helps in making the code maintainable and very understandable.
* #### `precipitation Decorator :`Show me the type of weather at the moment, whether it is hot, raining, snowing, and so on.
```java
public class PrecipitationDecorator extends WindowDecorator {

  public PrecipitationDecorator(IWeatherDataObserver dataDecoratorOB, String precipitationType){
       this.dataDecoratorOB=dataDecoratorOB;
       this.precipitationType=precipitationType;
   }
    @Override
    public void update(double temperature, double humidity) {
       dataDecoratorOB.update(temperature,humidity);
        System.out.println("Precipitation Type :"+precipitationType);
    }}
```
* #### `Temperature Units Decorator :`It helps me convert the temperature type from Celsius to Fahrenheit and vice versa.
```java
public class TemperatureUnitsDecorator extends WindowDecorator {

  public void update(double temperature, double humidity) {
        if (type.equals("C")) {
            dataDecoratorOB.update(temperature, humidity);
        } else if (type.equals("F")) {
            double temperatureF = (temperature * 1.8) + 32;
            dataDecoratorOB.update(temperatureF, humidity);
        }}}
```
* #### `Wind Speed Decorator :`It shows us the wind speed we entered.
```java
public class  WindSpeedDecorator extends WindowDecorator{

@Override
    public void update(double temperature, double humidity) {
        System.out.println("Wind speed: " + windSpeed + " m/s");
        dataDecoratorOB.update(temperature,humidity);
    }}
```
* #### `Window Decorator :` this is abstract class extend this 
#### 

![Diagram](./src/Screenshot%202023-11-24%20143825.png)