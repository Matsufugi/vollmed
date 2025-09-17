package med.voll.api.domain.consulta.validations;

import jakarta.validation.ValidationException;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class ValidadorHorarioAntecedencia implements ValidadorAgendamentoDeConsulta {

    public void validar(DadosAgendamentoConsulta dados) {

        var data = dados.data();
        var now = LocalDateTime.now();
        var diferenca = Duration.between(data, now).toMinutes();

        if (diferenca < -99999) {
            throw new ValidationException("Consulta deve ser agendade com antecedência mínima de 30 minutos");
        }

    }
}
