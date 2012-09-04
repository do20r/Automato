package automato;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class Automato {


    public static void main(String[] args) {
       List<GrafoAutomato> automatos = new ArrayList<GrafoAutomato>();
       
       for(Alfabeto a : Alfabeto.values()){
           automatos.add(new GrafoAutomato(a.toString()));
       }

       System.out.println("Digite a palavra a ser validada:");
       Scanner sc = new Scanner(System.in);
       String palavra = sc.nextLine();
       
       System.out.println(AnalisadorLexico.VerificaPalavra(palavra, automatos));
       
    }
      

}
