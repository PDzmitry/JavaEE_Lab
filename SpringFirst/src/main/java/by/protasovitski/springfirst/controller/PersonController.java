
package by.protasovitski.springfirst.controller;

import by.protasovitski.springfirst.aop.LogAnnotation;
import by.protasovitski.springfirst.aop.TimeAnn;
import by.protasovitski.springfirst.dto.PersonDto;
import by.protasovitski.springfirst.entities.Person;
import by.protasovitski.springfirst.exceptions.NoSuchEntityException;
import by.protasovitski.springfirst.service.PersonService;
import by.protasovitski.springfirst.util.Mapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@Slf4j
@Controller
@RequestMapping
public class PersonController {

    @Autowired
    private PersonService personService;

    private List<Person> persons;

    @Value("${welcome.message}")
    private String message;

    @Value("${error.message}")
    private String errorMessage;


    @GetMapping(value = {"/", "/index"})
    public ModelAndView index(Model model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        model.addAttribute("message", message);
        log.info("index was called");
        return modelAndView;
    }

    @LogAnnotation
    @TimeAnn
    @GetMapping(value = {"/personList"})
    public ModelAndView personList(Model model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("personList");
        persons = personService.getAllPerson();
        model.addAttribute("persons", persons);
        log.info("/personList was called");
        return modelAndView;
    }

    @GetMapping(value = {"/addPerson"})
    public ModelAndView showAddPersonPage(Model model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("addPerson");
        Person person = new Person();
        model.addAttribute("personDto",Mapper.map(person,PersonDto.class));
        log.info("/addPerson - GET was called");
        return modelAndView;
    }

    @PostMapping(value = {"/addPerson"})
    public ModelAndView savePerson(Model model, @Valid @ModelAttribute("personDto") PersonDto personDto,
                                   Errors errors) {
        ModelAndView modelAndView = new ModelAndView();
        if (errors.hasErrors()) {
            modelAndView.setViewName("addPerson");
        } else {
            modelAndView.setViewName("redirect:/personList");
            personService.addNewPerson(Mapper.map(personDto,Person.class));
            persons = personService.getAllPerson();
            model.addAttribute("persons", persons);
            return modelAndView;
        }
        return modelAndView;
    }


    @GetMapping(value = {"/delPerson/{id}"})
    public ModelAndView delPerson(Model model, @PathVariable("id") long id) {
        ModelAndView modelAndView = new ModelAndView();
        personService.deletePerson(id);
        persons = personService.getAllPerson();
        modelAndView.setViewName("redirect:/personList");
        model.addAttribute("persons", persons);
        log.info("/delPerson - GET was called");
        return modelAndView;
    }

    @GetMapping(value = {"/editPerson/{id}"})
    public ModelAndView editPerson(Model model,@PathVariable("id") long id) throws NoSuchEntityException{
        ModelAndView modelAndView = new ModelAndView();
        Person person = personService.getById(id).orElseThrow(()-> new NoSuchEntityException("Person not found"));
        modelAndView.setViewName("editPerson");
        model.addAttribute("personDto", Mapper.map(person,PersonDto.class));
        return modelAndView;
    }

    @PostMapping(value = {"/editPerson"})
    public ModelAndView editPerson(Model model, @Valid @ModelAttribute("personDto") PersonDto personDto,
                                   Errors errors) {
        ModelAndView modelAndView = new ModelAndView();
        if (errors.hasErrors()) {
            modelAndView.setViewName("editPerson");
        } else {
            modelAndView.setViewName("redirect:/personList");
            personService.editPerson(Mapper.map(personDto,Person.class));
            persons = personService.getAllPerson();
            model.addAttribute("persons", persons);
            return modelAndView;
        }
        return modelAndView;
    }
}
