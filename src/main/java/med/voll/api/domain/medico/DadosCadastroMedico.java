package med.voll.api.domain.medico;


import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.domain.endereco.DadosEndereco;

public record DadosCadastroMedico(
        // @NotNull // verifica se não esta nulo
        @NotBlank // vetifica se não está nulo e nem vazio (mais interessante utiliza-lo) o mesmo também é apenas para string
        String nome,

        @NotBlank
        @Email
        String email,

        @NotBlank
        String telefone,

        @NotBlank
        @Pattern(regexp = "\\d{4,6}") // cria um padrao de valores de numeros obrigatorios, nesse caso de 4 a 6 numeros
        String crm,

        @NotNull
        Especialidade especialidade,

        @NotNull
        @Valid // valida as informações de outros objetos
        DadosEndereco endereco) {
}
