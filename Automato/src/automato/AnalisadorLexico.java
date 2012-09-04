package automato;

import java.util.List;

public class AnalisadorLexico {
   
    public static String VerificaPalavra(String palavra, List<GrafoAutomato> automato){   
        String retorno = "Palava Inválida!";
        for(GrafoAutomato ga : automato){
            if(VerificaToken("q0", palavra.toCharArray(), 0, ga))
            {
                return "Palavra Válida!";
            }
        }
        return retorno;
    }
    
    private static boolean VerificaToken(String estado, char[] palavra, int index, GrafoAutomato automato){
        if((index >= palavra.length))
            return false;
        Estado est = automato.BuscaEstado(estado);
        String estDest = VerificaTransicoes(est.getTransicoes(), palavra[index]);
        
        if((estDest != null) && (index <= palavra.length)){        
            if(((palavra.length - 1) == index) && automato.BuscaEstado(estDest).isEstFinal())
                return true;
            else{
                index++;
                return VerificaToken(estDest, palavra, index, automato);                
            }
        }
        
        return false;
        
    }
    
    private static String VerificaTransicoes(List<Transicao> trans, char transicao){
        for(Transicao t : trans){
            if(transicao == t.getToken())
                return t.getDestino().getNomeEstado();
        }
        return null;
    }
}
