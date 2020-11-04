package br.com.transacao.entidades;
import javax.persistence.Embeddable;



@Embeddable
public class Cartao {

    private String identificacao;

    private String email;


    @Deprecated
    public Cartao(){}

    public Cartao(String identificacao, String email) {
        this.identificacao = identificacao;
        this.email = email;
    }

    public String getId() {
        return identificacao;
    }

    public void setId(String identification) {
        this.identificacao = identificacao;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
