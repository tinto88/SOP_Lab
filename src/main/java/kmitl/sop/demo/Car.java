package kmitl.sop.demo;

import java.util.List;
import java.util.ArrayList;

//import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/car")
public class Car implements Cloneable{
	public static Car instance = new Car();
	final ArrayList<Car> cars = new ArrayList<Car>();
	private String color;
	private String type;
	private int displacement;
	private boolean sunroof;
	private int speed;
	@RequestMapping(value = "/")
	public String helloSpringBoot() {
		return "Hello Spring Boot Rest API";
	}
	
	@GetMapping("/clearall")
	public ResponseEntity<ArrayList<Car>> ClearAll() {
		for (int i = 0; i < cars.size(); i++) {
			cars.remove(i);
		}
		return new ResponseEntity<ArrayList<Car>>(cars, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Car> findCarById(@PathVariable int id) {
		return new ResponseEntity<Car>(cars.get(id-1), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<ArrayList<Car>> car(@RequestBody List<Car> cars_) {
		for (int i = 0; i < cars_.size(); i++) {
			cars.add((Car) cars_.get(i));
         }
		return new ResponseEntity<ArrayList<Car>>(cars, HttpStatus.OK);
	}

	@PatchMapping("/{id}")
	public ResponseEntity<ArrayList<Car>> PatchCar(@RequestBody Car cars_, @PathVariable int id) {
		
		cars.get(id-1).color = cars_.color;
		cars.get(id-1).type = cars_.type;
		cars.get(id-1).displacement = cars_.displacement;
		cars.get(id-1).sunroof = cars_.sunroof;
		cars.get(id-1).speed = cars_.speed;
		
		return new ResponseEntity<ArrayList<Car>>(cars, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ArrayList<Car>> DelCar(@PathVariable int id) {
		cars.remove(id-1);
		return new ResponseEntity<ArrayList<Car>>(cars, HttpStatus.OK);
	}
	
	public Object clone() throws CloneNotSupportedException {
	      return super.clone();
	}
	
	public static Car getInstance() {
		return instance;
	}
	
	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getDisplacement() {
		return displacement;
	}

	public void setDisplacement(int displacement) {
		this.displacement = displacement;
	}

	public boolean getSunroof() {
		return sunroof;
	}

	public void hasSunroof(boolean sunroof) {
		this.sunroof = sunroof;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

}
