package med.voll.api.domain.consulta.validations;

import jakarta.validation.ValidationException;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import med.voll.api.domain.consulta.IConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorPacienteSemOutraConsultaNoDia implements ValidadorAgendamentoDeConsulta {

    @Autowired
    private IConsultaRepository repository;

    public void validar(DadosAgendamentoConsulta dados) {

        var primeiroHorario = dados.data().withHour(7);
        var ultimoHorario = dados.data().withHour(18);


        var pacientePossuiConsulta = repository.existsByPacienteIdAndDataBetween(dados.idPaciente(), primeiroHorario, ultimoHorario);
        if (pacientePossuiConsulta) {
            throw new ValidationException("Paciente já possui uma conquista hoje.");
        }
    }
}
