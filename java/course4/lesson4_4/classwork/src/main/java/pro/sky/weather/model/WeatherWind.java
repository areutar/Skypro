package pro.sky.weather.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class WeatherWind {
    private BigDecimal speed;
    private Integer deg;
}
