package br.com.gpaiva.susacess.service;

import br.com.gpaiva.susacess.model.Medico;
import br.com.gpaiva.susacess.model.Paciente;
import br.com.gpaiva.susacess.repository.MedicoRepository;
import br.com.gpaiva.susacess.repository.PacienteRepository;
import org.modelmapper.ModelMapper;
import br.com.gpaiva.susacess.model.Agendamento;
import br.com.gpaiva.susacess.model.dto.AgendamentoInputDTO;
import br.com.gpaiva.susacess.model.dto.AgendamentoOutDTO;
import br.com.gpaiva.susacess.repository.AgendamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AgendamentoService {
    @Autowired
    private AgendamentoRepository agendamentoRepository;
    @Autowired
    private MedicoRepository medicoRepository;
    @Autowired
    private PacienteRepository pacienteRepository;
    @Autowired
    private ModelMapper modelMapper;

    public AgendamentoOutDTO agendar(AgendamentoInputDTO agendamentoInputDTO) {
        Agendamento agendamento = new Agendamento();
        Medico medico = medicoRepository.findById(agendamentoInputDTO.getMedicoId()).orElseThrow();
        Paciente paciente = pacienteRepository.findById(agendamentoInputDTO.getPacienteId()).orElseThrow();
        agendamento.setMedico(medico);
        agendamento.setPaciente(paciente);
        agendamento.setDataHora(agendamentoInputDTO.getDataHora());
        agendamento = agendamentoRepository.save(agendamento);
        AgendamentoOutDTO agendamentoOutDTO = new AgendamentoOutDTO();
        agendamentoOutDTO.setId(agendamento.getId());
        agendamentoOutDTO.setMedicoId(medico.getId());
        agendamentoOutDTO.setPacienteId(paciente.getId());
        agendamentoOutDTO.setDataHora(agendamento.getDataHora());
        return agendamentoOutDTO;
    }

    public AgendamentoOutDTO obterAgendamento(Long id) {
        Agendamento agendamento = agendamentoRepository.findById(id).orElseThrow();
        return modelMapper.map(agendamento, AgendamentoOutDTO.class);
    }

    public List<AgendamentoOutDTO> listarAgendamentos() {
        List<Agendamento> agendamentos = agendamentoRepository.findAll();
        return agendamentos.stream()
                .map(agendamento -> modelMapper.map(agendamento, AgendamentoOutDTO.class))
                .collect(Collectors.toList());
    }

    public AgendamentoOutDTO atualizarAgendamento(Long id, AgendamentoInputDTO agendamentoInputDTO) {
        Agendamento agendamento = agendamentoRepository.findById(id).orElseThrow();
        Medico medico = medicoRepository.findById(agendamentoInputDTO.getMedicoId()).orElseThrow();
        Paciente paciente = pacienteRepository.findById(agendamentoInputDTO.getPacienteId()).orElseThrow();
        agendamento.setMedico(medico);
        agendamento.setPaciente(paciente);
        agendamento.setDataHora(agendamentoInputDTO.getDataHora());
        agendamento = agendamentoRepository.save(agendamento);
        return modelMapper.map(agendamento, AgendamentoOutDTO.class);
    }

    public void cancelarAgendamento(Long id) {
        agendamentoRepository.deleteById(id);
    }
}

