package br.com.jc.hrwork.repositories;

import br.com.jc.hrwork.entities.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkerRepository extends JpaRepository<Worker, Long>{
}
