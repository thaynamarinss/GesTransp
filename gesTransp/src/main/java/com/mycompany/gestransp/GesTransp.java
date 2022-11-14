/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.gestransp;

/**
 *
 * @author thayn
 */
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;

public class GesTransp {

  public static void main(String[] args) {
    
    List<Clientes> clientes = new ArrayList<Clientes>();
    List<Funcionarios> funcionarios = new ArrayList<Funcionarios>();
    List<GastosVeiculo> veiculos = new ArrayList<GastosVeiculo>();
    
    Scanner scan = new Scanner(System.in);
    int op = 0;
  do{
      System.out.println("___ESCOLHA UMA OPÇÃO___\n");
      System.out.println("1 - Gerenciar Clientes\n");
      System.out.println("2 - Gerenciar Funcionarios\n");
      System.out.println("3 - Gerenciar Gastos com veiculos\n");
      System.out.println("4 - Gerenciar Coleta de mercadoria\n");
      System.out.println("5 - Gerenciar Entrega de mercadoria\n");
      System.out.println("6 - Gerar relatorio de entrega e coleta de mercadoria\n");
      System.out.println("7 - Sair\n");
      System.out.println("Digite uma opção: ");
      op = scan.nextInt();
      
      switch(op){
        case 1:
          int opCliente = 0;          
          do{
              System.out.println("___ESCOLHA UMA OPÇÃO___\n");
              System.out.println("1 - Adicionar Cliente\n");
              System.out.println("2 - Remover Cliente\n");
              System.out.println("3 - Editar Cliente\n");
              System.out.println("4 - Voltar\n");
              opCliente = scan.nextInt();
              switch(opCliente){
                case 1:
                  String nome, razaoSocial, cnpj, inscricaoEstadual, tel, endereco, email;
                  System.out.println("Digite o nome:\n");
                  nome = scan.nextLine();
                  System.out.println("Digite a razão social:\n");
                  razaoSocial = scan.nextLine();
                  System.out.println("Digite o cnpj:\n");
                  cnpj = scan.nextLine();
                  System.out.println("Digite a inscrição estadual:\n");
                  inscricaoEstadual = scan.nextLine();
                  System.out.println("Digite o telefone:\n");
                  tel = scan.nextLine();
                  System.out.println("Digite o endereço:\n");
                  endereco = scan.nextLine();
                  System.out.println("Digite o email:\n");
                  email = scan.nextLine();
                  Clientes tempCliente = new Clientes(nome, razaoSocial, cnpj, inscricaoEstadual, tel, endereco, email);
                  clientes.add(tempCliente);
                  break;
              }
                
          }while(opCliente != 4);                    
          break;
          
        case 2:
            int opFunc = 0;
            do
            {
              
              System.out.println("___ESCOLHA UMA OPÇÃO___\n");
              System.out.println("1 - Adicionar Funcionario\n");
              System.out.println("2 - Remover Funcionario\n");
              System.out.println("3 - Editar Funcionario\n");
              System.out.println("4 - Voltar\n");
              opFunc = scan.nextInt();

              switch(opFunc)
              {
                case 1:
                  break;
                case 2:
                  break;
                case 3:
                  break;
                default:
                  System.out.println("Opção inválida, tente novamente");                 
                  
               
              }
              
            }while(opFunc != 4);
            break;
         
        case 3:
            int opGasto = 0;
            do
            {
              
              System.out.println("___ESCOLHA UMA OPÇÃO___\n");
              System.out.println("1 - Adicionar Gasto\n");
              System.out.println("2 - Remover gasto\n");
              System.out.println("3 - Editar gasto\n");
              System.out.println("3 - Gerar resumo de gastos\n");
              System.out.println("4 - Voltar\n");
              opGasto = scan.nextInt();

              switch(opGasto)
              {
                case 1:
                  break;
                case 2:
                  
                  break;
                case 3:
                  String dataDe, dataAte;
                  System.out.println("Digite o periodo que gostaria de gerar o resumo:\n");
                  System.out.println("Digite a data inicial(00/00/0000): ");
                  dataDe = scan.nextLine();
                  System.out.println("Digite a data final (00/00/0000) : ");
                  dataAte = scan.nextLine();               
                  /*convertendo data de string para date*/
                  SimpleDateFormat toDate = new SimpleDateFormat("dd/MM/yyyy");
                  Date dateA = toDate.parse(dataDe);                 
                  Date dateB = toDate.parse(dataAte);
                  
                  
                  
                  
                  break;
                default:
                  System.out.println("Opção inválida, tente novamente");                 
                  
               
              }
              
            }while(opGasto != 4);
          
            break;
        case 4:
            int opColeta = 0;
            do
            {
              
              System.out.println("___ESCOLHA UMA OPÇÃO___\n");
              System.out.println("1 - Adicionar informação de uma coleta\n");
              System.out.println("2 - Remover informação de uma coleta\n");
              System.out.println("3 - Editar informação de uma coleta\n");
              System.out.println("3 - Gerar resumo de uma coleta\n");
              System.out.println("4 - Voltar\n");
              opColeta = scan.nextInt();

              switch(opColeta)
              {
                case 1:
                  break;
                case 2:
                  
                  break;
                case 3:
                  String dataDe, dataAte;
                  System.out.println("Digite o periodo que gostaria de gerar o resumo:\n");
                  System.out.println("Digite a data inicial(00/00/0000): ");
                  dataDe = scan.nextLine();
                  System.out.println("Digite a data final (00/00/0000) : ");
                  dataAte = scan.nextLine();               
                  /*convertendo data de string para date*/
                  SimpleDateFormat toDate = new SimpleDateFormat("dd/MM/yyyy");
                  Date dateA = toDate.parse(dataDe);                 
                  Date dateB = toDate.parse(dataAte);
                  
                  
                  
                  
                  break;
                default:
                  System.out.println("Opção inválida, tente novamente");                 
                  
               
              }
              
            }while(opColeta != 4);
          
            break;
        case 5:
            int opEntrega = 0;
            do
            {
              
              System.out.println("___ESCOLHA UMA OPÇÃO___\n");
              System.out.println("1 - Adicionar informação de uma entrega\n");
              System.out.println("2 - Remover informação de uma entrega\n");
              System.out.println("3 - Editar informação de uma entrega\n");
              System.out.println("3 - Gerar resumo de uma entrega\n");
              System.out.println("4 - Voltar\n");
              opEntrega = scan.nextInt();

              switch(opEntrega)
              {
                case 1:
                  break;
                case 2:
                  
                  break;
                case 3:
                  String dataDe, dataAte;
                  System.out.println("Digite o periodo que gostaria de gerar o resumo:\n");
                  System.out.println("Digite a data inicial(00/00/0000): ");
                  dataDe = scan.nextLine();
                  System.out.println("Digite a data final (00/00/0000) : ");
                  dataAte = scan.nextLine();               
                  /*convertendo data de string para date*/
                  SimpleDateFormat toDate = new SimpleDateFormat("dd/MM/yyyy");
                  Date dateA = toDate.parse(dataDe);                 
                  Date dateB = toDate.parse(dataAte);
                  
                  
                  
                  
                  break;
                default:
                  System.out.println("Opção inválida, tente novamente");                 
                  
               
              }
              
            }while(opEntrega != 4);
            break;
          
        case 6:          
            String dataDe, dataAte;
            System.out.println("Digite o periodo que gostaria de gerar o resumo:\n");
            System.out.println("Digite a data inicial(00/00/0000): ");
            dataDe = scan.nextLine();
            System.out.println("Digite a data final (00/00/0000) : ");
            dataAte = scan.nextLine();               
            /*convertendo data de string para date*/
            SimpleDateFormat toDate = new SimpleDateFormat("dd/MM/yyyy");
            Date dateA = toDate.parse(dataDe);                 
            Date dateB = toDate.parse(dataAte);
          
            break;
          
        default:
            System.out.println("Opção inválida, tente novamente");                  
              
          
      }
        
        
    }while(op != 7);
    
  }
}