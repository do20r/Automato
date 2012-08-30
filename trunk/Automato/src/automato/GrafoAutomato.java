
package automato;

import java.util.ArrayList;
import java.util.List;

public class GrafoAutomato {

    private int valEst = 0;
    private List<Estado> estados;
    private String prefixoEst = "q";
    
    public GrafoAutomato(){
        estados = new ArrayList<>();
        AdicionarEstado(prefixoEst + valEst, false);
        valEst++;
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
    
    private void AdicionarEstado(String nome, boolean estFinal){
        Estado e = BuscaEstado(nome);
        if(e==null)
        {
            e=new Estado();
            e.setNomeEstado(nome);           
            e.setEstFinal(estFinal);
            estados.add(e);            
        }
    }
    
    public void AdicionarPalavra(String palavra){
        AdicionarTransicao("q0", palavra.toCharArray(), 0);
    }
    
    private void AdicionarTransicao(String estado, char[] token, int index){
        if((token.length - 1) < index)
            return;
        
        Estado est = BuscaEstado(estado);
        String estNome = est.VerificaToken(token[index]);
        
        if(estNome == null){
            String novoEstado = prefixoEst + valEst;
            valEst++;
            AdicionarEstado(novoEstado, (token.length - 1) == index);
            AdicionaTransicao(est.getNomeEstado(),novoEstado,token[index]);  
            index++;
            AdicionarTransicao(novoEstado, token, index);            
        }
        else{
            index++;             
            AdicionarTransicao(estNome, token, index);
        }
        
    }
    
    public boolean VerificaPalavra(String palavra){
        char[] cPalavra = palavra.toCharArray();
        return VerificaToken("q0", cPalavra, 0);
    }
    
    private boolean VerificaToken(String estado, char[] palavra, int index){
        Estado est = BuscaEstado(estado);
        String estDest = VerificaTransicoes(est.getTransicoes(), palavra[index]);
        
        if((estDest != null) && (index <= palavra.length)){        
            if(((palavra.length - 1) == index) && BuscaEstado(estDest).isEstFinal())
                return true;
            else{
                index++;
                return VerificaToken(estDest, palavra, index);                
            }
        }
        
        return false;
        
    }
    
    private String VerificaTransicoes(List<Transicao> trans, char transicao){
        for(Transicao t : trans){
            if(transicao == t.getToken())
                return t.getDestino().getNomeEstado();
        }
        return null;
    }
}
