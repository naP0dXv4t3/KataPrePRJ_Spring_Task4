package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      Car testCar1 = new Car("TestModel1","TestSeries1" );
      Car testCar2 = new Car("BMW","520" );
      Car testCar3 = new Car("Mercedes","200" );
      Car testCar4 = new Car("Chevrolet","3311" );


      User testUser1 = new User("User1", "Lastname1", "user1@mail.ru",testCar1);
      User testUser2 = new User("User2", "Lastname2", "user2@mail.ru",testCar2);
      User testUser3 = new User("User3", "Lastname3", "user3@mail.ru",testCar3);
      User testUser4 = new User("User4", "Lastname4", "user4@mail.ru",testCar4);

      userService.addCar(testCar1);
      userService.addCar(testCar2);
      userService.addCar(testCar3);
      userService.addCar(testCar4);

      userService.add(testUser1);
      userService.add(testUser2);
      userService.add(testUser3);
      userService.add(testUser4);


      userService.getUserByCar("TestModel1","TestSeries1");
      userService.getUserByCar("BMW","520");
      userService.getUserByCar("Mercedes","200");
      userService.getUserByCar("Chevrolet","3311");


      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = " + user.getId());
         System.out.println("First Name = " + user.getFirstName());
         System.out.println("Last Name = " + user.getLastName());
         System.out.println("Email = " + user.getEmail());
         System.out.println("Car = " + user.getCar());
         System.out.println();
      }

      context.close();
   }
}
