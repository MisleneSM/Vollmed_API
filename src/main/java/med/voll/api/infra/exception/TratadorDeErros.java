package med.voll.api.infra.exception;

import jakarta.persistence.EntityNotFoundException;
import med.voll.api.domain.ValidacaoException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice // anotação para tratar erros na api
public class TratadorDeErros {
    @ExceptionHandler(EntityNotFoundException.class) // em qualquer controller do projeto for lançado uma exception, o spring sabe que precisa chamar esse método.
    public ResponseEntity tratarErro404(){
        return ResponseEntity.notFound().build(); // cria um objeto responseEntity
    }

    @ExceptionHandler(MethodArgumentNotValidException.class) // trata de erros quando possui campos inválidos.
    public ResponseEntity tratarErro400(MethodArgumentNotValidException ex){
        var erros = ex.getFieldErrors(); // retorna os erros dos campos inválidos e que deram erros. Devolve uma lista

        return ResponseEntity.badRequest().body(erros.stream().map(DadosErrosValidacao::new).toList());
    }

    @ExceptionHandler(ValidacaoException.class) // trata de erros quando possui campos inválidos.
    public ResponseEntity tratarErroRegraDeNegocio(ValidacaoException ex){
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    private record DadosErrosValidacao(String campo, String mensagem){
        public DadosErrosValidacao(FieldError erro){
            this(erro.getField(), erro.getDefaultMessage());
        }
    }
}
