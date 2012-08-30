package automato;

import java.util.ArrayList;
import java.util.List;

public class Estado {
    private String nomeEstado;
    private List<Transicao> transicoes;   
    private boolean estFinal;

    public Estado(){
        transicoes = new ArrayList<>();
    }
    
    public String getNomeEstado() {
        return nomeEstado;
    }

    public void setNomeEstado(String estado) {
        this.nomeEstado = estado;
    }

    public List<Transicao> getTransicoes() {
        return transicoes;
    }

    public boolean isEstFinal() {
        return estFinal;
    }

    public void setEstFinal(boolean estFinal) {
        this.estFinal = estFinal;
    }
    
    public String VerificaToken(char token){
        for(Transicao t : transicoes)
        {
            if(t.getToken() == token)
                return t.getDestino().getNomeEstado();
        }
        return null;
    }
}
