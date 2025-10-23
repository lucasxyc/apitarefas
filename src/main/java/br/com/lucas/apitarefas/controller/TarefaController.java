package br.com.lucas.apitarefas.controller;

import br.com.lucas.apitarefas.entity.Tarefa;
import br.com.lucas.apitarefas.service.TarefaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    private final TarefaService tarefaService;

    public TarefaController(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }

    @PostMapping("/criar")
    public List<Tarefa> create(@RequestBody Tarefa tarefa) {
        return tarefaService.create(tarefa);
    }

    @GetMapping
    public List<Tarefa> list() {
        return tarefaService.list();
    }

    @GetMapping("/{id}")
    public Tarefa getById(@PathVariable Long id) {
        return tarefaService.getById(id);
    }

    @PutMapping("/atualizar")
    public List<Tarefa> update(@RequestBody Tarefa tarefa) {
        return tarefaService.update(tarefa);
    }

    @DeleteMapping("/{id}")
    public List<Tarefa> delete(@PathVariable("id") Long id) {
        return tarefaService.delete(id);
    }
}
