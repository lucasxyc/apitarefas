package br.com.lucas.apitarefas.service;

import br.com.lucas.apitarefas.entity.Tarefa;
import br.com.lucas.apitarefas.repository.TarefaRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarefaService {

    private final TarefaRepository tarefaRepository;

    public TarefaService(TarefaRepository tarefaRepository) {
        this.tarefaRepository = tarefaRepository;
    }

    // Buscar tarefa por ID
    public Tarefa getById(Long id) {
        return tarefaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("❌ Tarefa não encontrada com o ID: " + id));
    }

    // Criar nova tarefa
    public List<Tarefa> create(Tarefa tarefa) {
        tarefaRepository.save(tarefa);
        System.out.println("✅ Tarefa criada com sucesso: " + tarefa.getNome());
        return list();
    }

    // Listar todas as tarefas (ordenadas por data e prioridade)
    public List<Tarefa> list() {
        List<Tarefa> tarefas = tarefaRepository.findAll(
                Sort.by(Sort.Order.asc("dataEntrega"), Sort.Order.desc("prioridade"))
        );

        if (tarefas.isEmpty()) {
            System.out.println("⚠️ Nenhuma tarefa cadastrada no momento.");
        } else {
            System.out.println("📋 " + tarefas.size() + " tarefa(s) encontrada(s).");
        }

        return tarefas;
    }

    // Atualizar tarefa existente
    public List<Tarefa> update(Tarefa tarefa) {
        if (!tarefaRepository.existsById(tarefa.getId())) {
            throw new RuntimeException("❌ Não foi possível atualizar. Tarefa com ID " + tarefa.getId() + " não encontrada.");
        }

        tarefaRepository.save(tarefa);
        System.out.println("♻️ Tarefa atualizada com sucesso: " + tarefa.getNome());
        return list();
    }

    // Deletar tarefa por ID
    public List<Tarefa> delete(Long id) {
        if (!tarefaRepository.existsById(id)) {
            throw new RuntimeException("❌ Não foi possível excluir. Tarefa com ID " + id + " não encontrada.");
        }

        tarefaRepository.deleteById(id);
        System.out.println("🗑️ Tarefa removida com sucesso. ID: " + id);
        return list();
    }
}
