package br.com.zup.transacao.model;

import br.com.zup.transacao.response.InfoTransacaoCartaoResponse;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class InfoTransacaoCartao {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;
    @JsonProperty("id")
    private String numeroTransacao;
    private BigDecimal valor;
    private Estabelecimento estabelecimento;
    private Cartao cartao;
    private LocalDateTime efetivadaEm;

    @Deprecated
    public InfoTransacaoCartao(){}

    public InfoTransacaoCartao(String numeroTransacao, BigDecimal valor, Estabelecimento estabelecimento,
                               Cartao cartao, LocalDateTime efetivadaEm) {
        this.numeroTransacao = numeroTransacao;
        this.valor = valor;
        this.estabelecimento = estabelecimento;
        this.cartao = cartao;
        this.efetivadaEm = efetivadaEm;
    }

    public InfoTransacaoCartaoResponse toInfoTransacaoCartaoResponse(){
        return new InfoTransacaoCartaoResponse(this.numeroTransacao, this.valor, this.estabelecimento,
                this.cartao, this.efetivadaEm);
    }

    @Override
    public String toString() {
        return "InfoTransacaoCartao{" + "\n" +
                "id: '" + numeroTransacao + '\n' +
                ", valor: " + valor + "\n" +
                ", estabelecimento: {" + "\n" +
                "nome: " + estabelecimento.getNome() + ",\n" +
                "cidade: " + estabelecimento.getCidade() + ",\n" +
                "endereco: " + estabelecimento.getEndereco() + "\n" +
                "},"+ "\n" +
                ", cartao: {" + "\n" +
                "id: " + cartao.getId() + ",\n" +
                "email: " + cartao.getEmail() + ",\n" +
                "},"+
                "efetivadaEm: " + efetivadaEm +
                '}';
    }

}
