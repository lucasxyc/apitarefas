package br.com.lucas.apitarefas.repository;

import br.com.lucas.apitarefas.entity.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {


}
