package dev.arielalvesdutra.transacao.configs.dtos;

public class TransacaoMessageCartaoDTO {

    /**
     * ID do Cartão no sistema de legado (Serviço de Cartões).
     */
    private String id;
    private String email;

    public TransacaoMessageCartaoDTO() {
    }

    public String getId() {
        return id;
    }

    public TransacaoMessageCartaoDTO setId(String id) {
        this.id = id;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public TransacaoMessageCartaoDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    @Override
    public String toString() {
        return "TransacaoMessageCartaoDTO{" +
                "id='" + id + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
