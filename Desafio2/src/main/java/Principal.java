
import java.util.Stack;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author gab_g
 */
public class Principal {
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        Stack<Character> pilha = new Stack<Character>();
        ArrayList<String> dados = new ArrayList<String>();
        Scanner scanner = new Scanner(new File("C:\\Users\\gab_g\\Desktop\\codigo.txt"));
        int contador = 0;

        if (scanner.hasNextLine() == true) {
            
            Boolean valido = true;
            String expressao = scanner.nextLine();

            for (Character letra : expressao.toCharArray()) {
                if ("{[(<".indexOf(letra) >= 0 ) {
                    pilha.add(letra);
                } else if ( pilha.isEmpty()) {
                    valido = false;
                } else {
                    switch (letra) {
                        case '}':
                            if (pilha.peek() == '{') {
                                pilha.pop();
                            } else {
                                valido = false;
                            }
                            break;
                        case ']':
                            if (pilha.peek()== '[') {
                                pilha.pop();
                            } else {
                                valido = false;
                            }
                            break;
                        case ')':
                            if (pilha.peek() == '(') {
                                pilha.pop();
                            } else {
                                valido = false;
                            }
                            break;
                        case '>':
                            if (pilha.peek() == '<') {
                                pilha.pop();
                            } else {
                                valido = false;
                            }
                            break;
                    }
                }

                if (valido == false) {
                    dados.add("expressao" + " - Inválido") ;
                    break;
                }                
               
            }
            
            if (valido == true) {
               if (pilha.isEmpty())
                   dados.add("expressao" + " - OK") ;
               }
           
            pilha.clear();
            contador++;
        }
        
        FileOutputStream arquivo;
        arquivo = new FileOutputStream("C:\\Users\\gab_g\\Desktop\\codigo-check.txt");
        ObjectOutputStream grava = new ObjectOutputStream(arquivo);
        grava.writeObject(dados);
        grava.close();
        arquivo.close();
    }
}
