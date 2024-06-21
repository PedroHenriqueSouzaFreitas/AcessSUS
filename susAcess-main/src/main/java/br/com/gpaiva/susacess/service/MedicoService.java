package br.com.gpaiva.susacess.service;

import br.com.gpaiva.susacess.model.Medico;
import br.com.gpaiva.susacess.model.dto.MedicoInputDTO;
import br.com.gpaiva.susacess.model.dto.MedicoOutDTO;
import br.com.gpaiva.susacess.repository.MedicoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MedicoService {
    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private ModelMapper modelMapper;

    public MedicoOutDTO cadastrar(MedicoInputDTO medicoInputDTO) {
        Medico medico = modelMapper.map(medicoInputDTO, Medico.class);
        medico = medicoRepository.save(medico);
        return modelMapper.map(medico, MedicoOutDTO.class);
    }

    public MedicoOutDTO obterMedico(Long id) {
        Medico medico = medicoRepository.findById(id).orElseThrow();
        return modelMapper.map(medico, MedicoOutDTO.class);
    }

    public List<MedicoOutDTO> listarMedicos() {
        List<Medico> medicos = medicoRepository.findAll();
        return medicos.stream()
                .map(medico -> modelMapper.map(medico, MedicoOutDTO.class))
                .collect(Collectors.toList());
    }

    public MedicoOutDTO atualizarMedico(Long id, MedicoInputDTO medicoInputDTO) {
        Medico medico = medicoRepository.findById(id).orElseThrow();
        modelMapper.map(medicoInputDTO, medico);
        medico = medicoRepository.save(medico);
        return modelMapper.map(medico, MedicoOutDTO.class);
    }

    public void deletarMedico(Long id) {
        medicoRepository.deleteById(id);
    }
}


