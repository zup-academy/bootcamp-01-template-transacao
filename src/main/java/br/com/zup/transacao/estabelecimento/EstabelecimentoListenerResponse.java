package br.com.zup.transacao.estabelecimento;

public class EstabelecimentoListenerResponse {

    private String nome;
    private String cidade;
    private String endereco;
    //1
    public Estabelecimento toEstabelecimento(){
        return new Estabelecimento(nome, cidade, endereco);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
