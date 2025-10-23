package br.com.lucas.apitarefas.controller;

import br.com.lucas.apitarefas.entity.Tarefa;
import br.com.lucas.apitarefas.service.TarefaService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {
    private TarefaService tarefaService;

    public TarefaController(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }

    List <Tarefa> create (Tarefa tarefa) {
        return tarefaService.create(tarefa);

    }

    List <Tarefa> list () {
        return tarefaService.list();

    }

    List <Tarefa> update (Tarefa tarefa) {
        return tarefaService.update(tarefa);

    }

    List<Tarefa> delete (Long id) {
        return tarefaService.delete(id);
    }

}
