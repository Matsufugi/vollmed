package med.voll.api.domain.consulta.validations;

import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;

@Component
public class ValidadorHorarioFuncionamentoClinica implements ValidadorAgendamentoDeConsulta{

    public void validar(DadosAgendamentoConsulta dados) {

        var data = dados.data();

        // verificar se a data do DTO çé um domingo

        var domingo = data.getDayOfWeek().equals(DayOfWeek.SUNDAY);
        var beforeAbertura = data.getHour() < 7;
        var afterFechamento = data.getHour() > 18;

        if (domingo || beforeAbertura || afterFechamento) {
            throw new RuntimeException("Consulta fora do horário de funcionamento da Vollmed");
        }
    }
}
