package radios.olx.service;

import radios.olx.model.Todo;
import radios.olx.repository.TodoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    @Autowired
    private TodoRepository taskRepository;

    public List<Todo> findAll() {
        return taskRepository.findAll();
    }

    public Optional<Todo> findById(int id) {
        return taskRepository.findById(id);
    }

    public Todo saveTask(Todo task) {
        return taskRepository.save(task);
    }

    public Todo updateTask(int id, Todo task) {
        Todo updatedTask = taskRepository.findById(id).orElse(null);
        updatedTask.setName(task.getName());
        updatedTask.setDescription(task.getDescription());
        return taskRepository.save(updatedTask);
    }

    public void deleteById(int id) {
        taskRepository.deleteById(id);
    }

}
