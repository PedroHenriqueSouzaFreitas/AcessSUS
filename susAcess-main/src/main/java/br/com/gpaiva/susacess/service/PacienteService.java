package br.com.gpaiva.susacess.service;


import br.com.gpaiva.susacess.model.dto.PacienteInputDTO;
import br.com.gpaiva.susacess.model.Paciente;
import br.com.gpaiva.susacess.model.dto.PacienteOutDTO;
import br.com.gpaiva.susacess.repository.PacienteRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PacienteService {
    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private ModelMapper modelMapper;

    public PacienteOutDTO cadastrar(PacienteInputDTO pacienteInputDTO) {
        Paciente paciente = modelMapper.map(pacienteInputDTO, Paciente.class);
        paciente = pacienteRepository.save(paciente);
        return modelMapper.map(paciente, PacienteOutDTO.class);
    }

    public PacienteOutDTO obterPaciente(Long id) {
        Paciente paciente = pacienteRepository.findById(id).orElseThrow();
        return modelMapper.map(paciente, PacienteOutDTO.class);
    }

    public List<PacienteOutDTO> listarPacientes() {
        List<Paciente> pacientes = pacienteRepository.findAll();
        return pacientes.stream()
                .map(paciente -> modelMapper.map(paciente, PacienteOutDTO.class))
                .collect(Collectors.toList());
    }

    public PacienteOutDTO atualizarPaciente(Long id, PacienteInputDTO pacienteInputDTO) {
        Paciente paciente = pacienteRepository.findById(id).orElseThrow();
        modelMapper.map(pacienteInputDTO, paciente);
        paciente = pacienteRepository.save(paciente);
        return modelMapper.map(paciente, PacienteOutDTO.class);
    }

    public void deletarPaciente(Long id) {
        pacienteRepository.deleteById(id);
    }

}
