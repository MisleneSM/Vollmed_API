package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component // trabalhamos com classes genéricas
public class ValidadorHorarioAntecedencia implements ValidadorAgendamentoDeConsulta{
    public void validar(DadosAgendamentoConsulta dados){
        var dataConsulta = dados.data();
        var agora = LocalDateTime.now();
        var diferenciaEmMinutos = Duration.between(agora, dataConsulta).toMinutes();

        if(diferenciaEmMinutos < 30){
            throw new ValidacaoException("Consulta deve ser agendada com 30 minutos de antecedência.");
        }
    }
}
