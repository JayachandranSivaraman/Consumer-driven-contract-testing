package hello;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloWorldController {

    private static final String name ="Jayachandran";
    private static final String employee_id ="1000";
    private static final String department ="Quality Assurance";
    private static final String basicPay ="1000";
    private static final String allowances ="2000";

    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/get-employees")
    public @ResponseBody Employee getEmployees() {
        return new Employee(counter.incrementAndGet(), name,employee_id,department);
    }

    @RequestMapping("/get-salery")
    public @ResponseBody Salery getSalery() {
        return new Salery(basicPay,allowances);
    }

}