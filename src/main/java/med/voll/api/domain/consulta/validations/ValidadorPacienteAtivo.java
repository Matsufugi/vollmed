package med.voll.api.domain.consulta.validations;

import jakarta.validation.ValidationException;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import med.voll.api.domain.paciente.IPacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorPacienteAtivo implements ValidadorAgendamentoDeConsulta{

    @Autowired
    private IPacienteRepository repository;

    public void validar(DadosAgendamentoConsulta dados) {

        var pacienteAtivo = repository.findAtivoById(dados.idPaciente());

        if (!pacienteAtivo) {
            throw new ValidationException("Consulta não pode ser agendada com o paciente ativo");
        }

    }
}
