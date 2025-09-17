package med.voll.api.domain.consulta.validations;

import jakarta.validation.ValidationException;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import med.voll.api.domain.medico.IMedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorMedicoAtivo implements ValidadorAgendamentoDeConsulta{

    @Autowired
    private IMedicoRepository repository;

    public void validar(DadosAgendamentoConsulta dados) {

        if (dados.idMedico() == null) { return; }

        var medicoAtivo = repository.findAtivoById(dados.idMedico());

        if (!medicoAtivo) {
            throw new ValidationException("Consulta não pode ser marcada com médico inátivo.");
        }
    }
}
