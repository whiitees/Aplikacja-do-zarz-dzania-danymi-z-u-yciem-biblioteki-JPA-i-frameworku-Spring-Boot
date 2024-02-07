import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@SpringBootApplication
public class ZaawansowanaAplikacjaWebowa {

    public static void main(String[] args) {
        SpringApplication.run(ZaawansowanaAplikacjaWebowa.class, args);
    }
}

@Entity
class Data {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String category;
    private double value;

    // Getters and setters
}

interface DataRepository extends JpaRepository<Data, Long> {
}

@Controller
class DataController {

    private final DataRepository dataRepository;

    public DataController(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    @GetMapping("/")
    public String index(Model model) {
        List<Data> dataList = dataRepository.findAll();
        model.addAttribute("dataList", dataList);
        return "index";
    }
}
