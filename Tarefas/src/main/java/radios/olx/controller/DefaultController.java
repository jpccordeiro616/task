
package radios.olx.controller;

import radios.olx.model.Todo;
import radios.olx.service.TodoService;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("api/v1")
public class DefaultController {

    @Autowired
    private TodoService taskService;

    /**
     * @param @Valid
     * @RequestBody List<Todo> todos
     * @return
     */
    @PostMapping("/taskInfo")
 	public ModelAndView taskInfo() {
	 return null;
 }
    

    @DeleteMapping("/todos")
    public ResponseEntity<Todo> deleteTodo(@Valid @RequestBody final List<Todo> todos) {
        final Todo todo = todos.get(0);
        taskService.deleteById(todo.getId());
        return ResponseEntity.ok(todo);
    }

    @PutMapping("/todos")
    public ResponseEntity<Todo> editTodo(@Valid @RequestBody final List<Todo> todos) {
        final Todo todo = todos.get(0);
        taskService.updateTask(todo.getId(), todo);
        return ResponseEntity.ok(todo);
    }

    /**
     * @return List<Todo>
     */
    @GetMapping("/todos")
    public List<Todo> getAllTodos() {
        return taskService.findAll();
    }

    @GetMapping("/index")
    public String index() {
        return "Hello World!";
        
        
     
    }
}
