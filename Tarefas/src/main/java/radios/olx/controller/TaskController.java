package radios.olx.controller;

import radios.olx.model.Task;
import radios.olx.model.Todo;
import radios.olx.service.TodoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TaskController {

    @Autowired
    private TodoService taskService;
    
    @GetMapping("/")
    public ModelAndView home() {
    ModelAndView modelAndView = new ModelAndView("taskView");
    Task task = new Task();
    modelAndView.addObject("task", task);
    return modelAndView;
    }
    @PostMapping("/displayTaskInfo")
    public ModelAndView taskInfo (Task task) { 
    ModelAndView modelAndView = new ModelAndView("displayTaskInfo");
    modelAndView.addObject("task", task); 
    return modelAndView;
 }
    @RequestMapping("/")
    public String indexPage() {
        return "index";
    }
    
    @RequestMapping("/read-task")
    public String showReadTaskPage(Model model) {
        model.addAttribute("tasks", taskService.findAll());
        return "readtask";
    }
    
    @RequestMapping("/rest-read-task")
    public String showReadTaskPageRest(Model model) {
        //model.addAttribute("tasks", taskService.findAll());
        return "readtaskapi";
    }
    
    @RequestMapping("/create-task")
    public String showCreateTaskPage(Model model) {
        model.addAttribute("command", new Todo());
        return "createtask";
    }
    
    @RequestMapping(value = "/create-task", method = RequestMethod.POST)
    public String createTask(@ModelAttribute("contact") Todo task) {
        taskService.saveTask(task);
        return "redirect:/read-task";
    }
    
    @RequestMapping(value = "/update-task/{id}")
    public String showUpdateTaskPage(@PathVariable int id, Model model) {
        model.addAttribute("id", id);
        model.addAttribute("command", taskService.findById(id).orElse(null));
        return "updatetask";
    }

    @RequestMapping(value = "/update-task/{id}", method = RequestMethod.POST)
    public String updateTask(@PathVariable int id, @ModelAttribute("contact") Todo task) {
        taskService.updateTask(id, task);
        return "redirect:/read-task";
    }
    

    @RequestMapping(value = "/delete-task/{id}")
    public String deletTask(@PathVariable int id) {
        taskService.deleteById(id);
        return "redirect:/read-task";
    }
    

    

}
