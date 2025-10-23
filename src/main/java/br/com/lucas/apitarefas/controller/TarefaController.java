package br.com.lucas.apitarefas.controller;

import br.com.lucas.apitarefas.entity.Tarefa;
import br.com.lucas.apitarefas.service.TarefaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {
    private TarefaService tarefaService;

    public TarefaController(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }

    @PostMapping
    List <Tarefa> create (@RequestBody Tarefa tarefa) {
        return tarefaService.create(tarefa);
    }

    @GetMapping
    List <Tarefa> list () {
        return tarefaService.list();

    }

    @PostMapping
    List <Tarefa> update (@RequestBody Tarefa tarefa) {
        return tarefaService.update(tarefa);

    }

    @DeleteMapping("{id}")
    List<Tarefa> delete (@PathVariable("id") Long id) {
        return tarefaService.delete(id);
    }

}
