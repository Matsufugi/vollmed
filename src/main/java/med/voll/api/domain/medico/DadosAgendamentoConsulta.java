package med.voll.api.domain.medico;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DadosAgendamentoConsulta(
   @NotNull
   Long idMedico,

   @NotNull
   Long idPaciente,

   @NotNull
   @Future
   LocalDateTime data,

   @NotNull
   Especialidade especialidade
) {}
