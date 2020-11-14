package com.marcoscoutozup.transacao.transacao;

import com.marcoscoutozup.transacao.cartao.Cartao;
import com.marcoscoutozup.transacao.estabelecimento.Estabelecimento;
import com.marcoscoutozup.transacao.utils.JwtUtils;
import org.springframework.util.Assert;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Entity
@NamedQuery(
        name = "findTransacoesPorCartao",
        query = "SELECT t FROM Transacao t WHERE t.cartao.idCartao = :idCartao ORDER BY efetivadaEm DESC")
public class Transacao {

    @Id
    @GeneratedValue(generator = "uuid4")
    private UUID id;

    @NotNull
    private UUID idTransacao;

    @NotNull
    @Positive
    private BigDecimal valor;

    @NotNull
    @Embedded //1
    private Estabelecimento estabelecimento;

    @NotNull
    @Embedded //2
    private Cartao cartao;

    @NotNull
    private LocalDateTime efetivadaEm;

    @Deprecated
    public Transacao() {
    }

    public Transacao(@NotNull UUID idTransacao, @NotNull @Positive BigDecimal valor, @NotNull Estabelecimento estabelecimento, @NotNull Cartao cartao, @NotNull LocalDateTime efetivadaEm) {
        this.idTransacao = idTransacao;
        this.valor = valor;
        this.estabelecimento = estabelecimento;
        this.cartao = cartao;
        this.efetivadaEm = efetivadaEm;
    }
            //3
    public TransacaoResponse toResponse(){
        return new TransacaoResponse(this.valor, this.estabelecimento.toResponse(), this.cartao.toResponse(), this.efetivadaEm);
    }

    public static List<TransacaoResponse> toResponseList(List<Transacao> transacoes){
        Assert.notNull(transacoes, "A lista de transações não pode ser nula");
                                                //4
        return transacoes.stream().map(Transacao::toResponse).collect(Collectors.toList());
    }

    public boolean verificarSeEmailDoTokenEIgualAoEmailDaTransacao(String token){
        Assert.notNull(token, "O token não pode ser nulo para verificação dos dados");
        String emailDoToken = JwtUtils.retornarEmailDoToken(token);
        return this.cartao.verificarParidadeDeEmail(emailDoToken);
    }
}
