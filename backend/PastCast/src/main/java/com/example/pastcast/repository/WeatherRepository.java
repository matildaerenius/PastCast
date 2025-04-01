package com.example.pastcast.repository;

import com.example.pastcast.model.Weather;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface WeatherRepository extends MongoRepository<Weather, String> {
    List<Weather> findByLocation(String location);
    List<Weather> findByDate(String date);
}
