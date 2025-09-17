package med.voll.api.domain.consulta;

import jakarta.validation.ValidationException;
import med.voll.api.domain.consulta.validations.ValidadorAgendamentoDeConsulta;
import med.voll.api.domain.medico.IMedicoRepository;
import med.voll.api.domain.medico.Medico;
import med.voll.api.domain.paciente.IPacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgendaDeConsultas {

    @Autowired
    private IConsultaRepository consultaRepository;

    @Autowired
    private IMedicoRepository medicoRepository;

    @Autowired
    private IPacienteRepository pacienteRepository;

    @Autowired
    private List<ValidadorAgendamentoDeConsulta> validadores;

    public DadosDetalhamentoConsulta agendar(DadosAgendamentoConsulta dados) {
        // verificar se o paciente existe

        if (!pacienteRepository.existsById(dados.idPaciente())) {
            throw new ValidationException("O formato do ID está incorreto ou o ID informado não existe.");
        }

        if(dados.idMedico() != null && !medicoRepository.existsById(dados.idMedico())) {
            throw new ValidationException("O formato do ID está incorreto ou o ID informado não existe.");
        }

        validadores.forEach(v -> v.validar(dados));

        // salvar o agendamento no banco de dados
        var medico = escolherMedico(dados);
        var paciente = pacienteRepository.getReferenceById(dados.idPaciente());
        var consulta = new Consulta(null, medico, paciente, dados.data(), null);

        consultaRepository.save(consulta);

        return new DadosDetalhamentoConsulta(consulta);

    }
    private Medico escolherMedico(DadosAgendamentoConsulta dados) {
        if (dados.idMedico() != null) {
            return medicoRepository.getReferenceById(dados.idMedico());
        }

        // escolher o médico random
        if (dados.especialidade() == null) {
            throw new ValidationException("O campo de ESPECIALIDADE deve ser preenchido");
        }

        return medicoRepository.escolherMedicoAleatorio(dados.data(), dados.especialidade());
    }
    public void cancelar(DadosCancelamentoConsulta dados) {
        if (!consultaRepository.existsById(dados.idConsulta())) {
            throw new ValidationException("Id da consulta informado não existe!");
        }

        var consulta = consultaRepository.getReferenceById(dados.idConsulta());
        consulta.cancelar(dados.motivo());
    }
}
