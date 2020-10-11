package pl.manczak.springdataexample;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class Start {

    private CarRepo carRepo;

    @Autowired
    public Start(CarRepo carRepo) {
        this.carRepo = carRepo;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void runExample() {
       Car car1 = new Car("Honda", "Jazz", Color.BLACK);
        carRepo.save(car1);

        Car car2 = new Car("Audi", "S8", Color.BLUE);
        carRepo.save(car2);

        Car car3 = new Car("Lambo", "Vent", Color.RED);
        carRepo.save(car3);

        Car car4 = new Car("porshe", "Panamera", Color.RED);
        carRepo.save(car4);

//
//      carRepo.deleteById(1L);

      Iterable <Car> all= carRepo.findAllByColor(Color.RED);
        all.forEach(System.out::println);
    }
}
