package br.com.cartao.transacao.domain.model;

import br.com.cartao.transacao.utils.Encoder;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

/**
 * Carga intrínseca máxima permitida - 9
 * Carga intrínseca da classe - 2
 */

@Entity
@Table(name = "cartao")
public class Cartao {

    @Id
    private String idCartao;

    private String idProposta;

    @NotBlank
    private String numeroCartao;

    @Deprecated
    public Cartao() {
    }

    public Cartao(String idCartao, String idProposta, String numeroCartao) {
        this.numeroCartao = Encoder.encode(numeroCartao);
        this.idProposta = idProposta;
        this.idCartao = idCartao;
    }

    public String getIdCartao() {
        return idCartao;
    }

    public String getIdProposta() {
        return idProposta;
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }
}
