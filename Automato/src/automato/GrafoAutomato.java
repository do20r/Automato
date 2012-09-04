
package automato;

import java.util.ArrayList;
import java.util.List;

public class GrafoAutomato {

    private int valEst = 0;
    private List<Estado> estados;
    private String prefixoEst = "q";
    
    public List<Estado> getEstados(){
        return estados;
    }
    
    public GrafoAutomato(String palavra){
        estados = new ArrayList<>();
        AdicionaEstado(prefixoEst + valEst, false);
        valEst++;
        AdicionaPalavra("q0", palavra.toCharArray(), 0);
    }
    
    public Estado BuscaEstado(String nomeEstado){
        for(Estado e : estados){
            if(nomeEstado.equals(e.getNomeEstado()))              
                return e;            
        }
        return null;
    }
      
    private void AdicionaTransicao(String origem, String destino, char token){
        Estado ori = BuscaEstado(origem);
        Estado dest = BuscaEstado(destino);
        
        if(ori != null && dest != null){
            Transicao trans = new Transicao();
            trans.setOrigem(ori);
            trans.setDestino(dest);
            trans.setToken(token);
            ori.getTransicoes().add(trans);
        }
    }
    
    private void AdicionaEstado(String nome, boolean estFinal){
        Estado e = BuscaEstado(nome);
        if(e==null)
        {
            e=new Estado();
            e.setNomeEstado(nome);           
            e.setEstFinal(estFinal);
            estados.add(e);            
        }
    }
    
    private void AdicionaPalavra(String estado, char[] token, int index){
        if((token.length - 1) < index)
            return;
        
        Estado est = BuscaEstado(estado);
        String estNome = est.VerificaToken(token[index]);
        
        if(estNome == null){
            String novoEstado = prefixoEst + valEst;
            valEst++;
            AdicionaEstado(novoEstado, (token.length - 1) == index);
            AdicionaTransicao(est.getNomeEstado(),novoEstado,token[index]);  
            index++;
            AdicionaPalavra(novoEstado, token, index);            
        }
        else{
            index++;             
            AdicionaPalavra(estNome, token, index);
        }
        
    }
}
