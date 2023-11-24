package Observer;

public class StatisticsDisplay implements IWeatherDataObserver {
    private double allTemperature;
    private double allHumidity;
    private int count1;
    private int count2;
    @Override
    public void update(double temperature, double humidity) {
            allTemperature +=temperature;
            count1++;
            double averageTemperature = allTemperature / count1;
            allHumidity+=humidity;
            count2++;
            double averageHumidity=allHumidity/count2;
            System.out.println("Average temperature: " + averageTemperature + "C");
            System.out.println("Average Humidity : " + averageHumidity + "%");
        }
    }

