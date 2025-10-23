package br.com.lucas.apitarefas.service;

import br.com.lucas.apitarefas.entity.Tarefa;
import br.com.lucas.apitarefas.repository.TarefaRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarefaService {

    private TarefaRepository tarefaRepository;

    public TarefaService(TarefaRepository tarefaRepository) {
        this.tarefaRepository = tarefaRepository;
    }

    public List<Tarefa> create(Tarefa tarefa) {
        tarefaRepository.save(tarefa);
        return list();
    }

    public List<Tarefa> list() {
        return tarefaRepository.findAll(
                Sort.by(Sort.Order.asc("dataEntrega"), Sort.Order.desc("prioridade"))
        );

    }

    public List<Tarefa> update(Tarefa tarefa) {
        tarefaRepository.save(tarefa);
        return list();

    }

    public List<Tarefa> delete(Long id) {
        tarefaRepository.deleteById(id);
        return list();

    }

}
