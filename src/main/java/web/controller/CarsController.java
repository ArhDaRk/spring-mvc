package web.controller;

import config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import servise.CarService;

@Controller
public class CarsController {
    @GetMapping(value = "cars")
    public String printCarsList(@RequestParam(required = false, defaultValue = "-1") int count, ModelMap model) {
            ApplicationContext applicationContext =
                    new AnnotationConfigApplicationContext(AppConfig.class);
            CarService bean = applicationContext.getBean("carService", CarService.class);
            model.addAttribute("cars", bean.getCarList(count));
            return "cars";
    }
}
