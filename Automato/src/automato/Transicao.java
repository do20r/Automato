package automato;

public class Transicao {
    private Estado origem, destino;
    private char transicao;

    public Estado getOrigem() {
        return origem;
    }

    public void setOrigem(Estado origem) {
        this.origem = origem;
    }

    public Estado getDestino() {
        return destino;
    }

    public void setDestino(Estado destino) {
        this.destino = destino;
    }

    public char getToken() {
        return transicao;
    }

    public void setToken(char transicao) {
        this.transicao = transicao;
    }
}
