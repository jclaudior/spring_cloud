package br.com.jc.hrwork.resources;

import br.com.jc.hrwork.entities.Worker;
import br.com.jc.hrwork.repositories.WorkerRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/workers")
public class WorkerResource {
    @Autowired
    private WorkerRepositorie workerRepositorie;

    @GetMapping
    public ResponseEntity<List<Worker>> findAll(){
        List<Worker> list = workerRepositorie.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Worker> findById(@PathVariable Long id){
        Worker worker = workerRepositorie.findById(id).get();
        return ResponseEntity.ok().body(worker);
    }
}
