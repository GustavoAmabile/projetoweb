package br.com.ada.locate.service;


import br.com.ada.locate.model.Cliente;
import br.com.ada.locate.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public void createCliente(Cliente cliente) {
        this.clienteRepository.save(cliente);
    }
    public List<Cliente> listarTodos() {
        return this.clienteRepository.findAll();
    }

    public Optional<Cliente> buscarClientePorId(Long id) {
        return this.clienteRepository.findById(id);
    }

    public Optional<Cliente> buscarClientePorCpf(String cpf) {
        return this.clienteRepository.findByCpfContaining(cpf);
    }
    public Optional<Cliente> buscarClientePorNome(String nome) {
        return this.clienteRepository.findByNomeContaining(nome);
    }


    public void removerVeiculoPorId(Long id) {
        this.clienteRepository.deleteById(id);
    }
}
