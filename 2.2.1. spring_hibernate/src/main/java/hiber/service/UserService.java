package hiber.service;

import hiber.model.Car;
import hiber.model.User;

import java.util.List;

public interface UserService {
    void addCar(Car car);
    void add(User user);
    List<User> listUsers();
    void getUserByCar(String model, String series);
}
