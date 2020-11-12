package br.com.cartao.transacao.domain.model;

import br.com.cartao.transacao.domain.enums.EstadoProposta;
import br.com.cartao.transacao.utils.Encoder;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

/**
 * Carga intrínseca máxima permitida - 9
 * Carga intrínseca da classe - 4
 */

@Entity
public class Proposta {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    @NotBlank @Column(unique = true)
    private String documento;
    @NotBlank @Email @Column(unique = true)
    private String email;
    @NotBlank
    private String endereco;
    @NotBlank
    private String nome;
    @Positive @NotNull
    private BigDecimal salario;
    @Enumerated(EnumType.STRING)
    // +1
    private EstadoProposta estadoProposta;

    private Boolean cartaoCriado;

    @OneToOne(mappedBy = "proposta", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    // +1
    private Cartao cartao;

    @Deprecated
    public Proposta() {
    }

    public Proposta(@NotBlank String documento, @NotBlank String email, @NotBlank String endereco, @NotBlank String nome, @Positive @NotBlank BigDecimal salario) {
        this.documento = Encoder.encode(documento);
        this.email = email;
        this.endereco = endereco;
        this.nome = nome;
        this.salario = salario;
        this.estadoProposta = EstadoProposta.PENDENTE;
        this.cartaoCriado = Boolean.FALSE;
    }

    public String getId() {
        return id;
    }

    public String getDocumento() {
        return documento;
    }

    public String getEmail() {
        return email;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getNome() {
        return nome;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public EstadoProposta getEstadoProposta() {
        return estadoProposta;
    }

    public Cartao getCartao() {
        return cartao;
    }


    @Override
    public String toString() {
        return "Proposta{" +
                "documento='" + documento + '\'' +
                ", email='" + email + '\'' +
                ", endereco='" + endereco + '\'' +
                ", nome='" + nome + '\'' +
                ", salario=" + salario +
                '}';
    }

}
