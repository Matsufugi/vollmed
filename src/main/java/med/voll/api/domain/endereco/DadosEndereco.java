package med.voll.api.domain.endereco;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosEndereco(

        @NotBlank
        @JsonAlias("logradouro")
        String logradouro,

        @NotBlank
        @JsonAlias("bairro")
        String bairro,

        @NotBlank
        @Pattern(regexp = "\\d{8}")
        @JsonAlias("cep")
        String cep,

        @NotBlank
        @JsonAlias("cidade")
        String cidade,

        @NotBlank
        @JsonAlias("uf")
        String uf,

        @JsonAlias("complemento")
        String complemento,

        @JsonAlias("numero) ")
        String numero

) {}