package med.voll.api.domain.consulta.validations;

import jakarta.validation.ValidationException;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import med.voll.api.domain.consulta.IConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorMedicoComOutraConsultaNoMesmoHorario implements ValidadorAgendamentoDeConsulta {

    @Autowired
    private IConsultaRepository repository;

    public void validar(DadosAgendamentoConsulta dados) {
        var medicoConsulta  = repository.existsByMedicoIdAndData(dados.idMedico(), dados.data());

        if (medicoConsulta) {
            throw new ValidationException("Médico já possui uma consulta nesse horário.");
        }
    }
}
