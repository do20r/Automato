package automato;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class Automato {


    public static void main(String[] args) {
       List<String> alfabeto = new ArrayList<>();
       alfabeto.add("private");
       alfabeto.add("public");
       alfabeto.add("integer");
       
       GrafoAutomato aut = new GrafoAutomato();
       for(String s : alfabeto){
           aut.AdicionarPalavra(s);
       }
       
       System.out.println("Digite a palavra a ser validada:");
       Scanner sc = new Scanner(System.in);
       String palavra = sc.nextLine();
       
       System.out.println(aut.VerificaPalavra(palavra));
       
    }
      

}
