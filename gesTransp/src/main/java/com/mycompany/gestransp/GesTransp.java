/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.gestransp;

/**
 *
 * @author Thayná Marins e Raphael Yoshiki
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.io.PrintStream;
import java.text.ParseException;

public class GesTransp {

  public static void main(String[] args) throws ParseException, FileNotFoundException {

    // criando a pasta arquivos
    File dir = new File("arquivos");
    dir.mkdir();

    List<Clientes> clientes = new ArrayList();
    List<Funcionarios> funcionarios = new ArrayList();
    List<GastosVeiculo> veiculos = new ArrayList();
    List<ControleMercadoria> coletas = new ArrayList();
    List<ControleMercadoria> entregas = new ArrayList();

    Scanner scan = new Scanner(System.in);

    // leitura de arquivos
    // Arquivo Clientes
    try {
      FileReader arqClientes = new FileReader("arquivos/clientes.txt");
      Scanner sc = new Scanner(arqClientes);
      while (sc.hasNextLine()) {
        String linha = sc.nextLine();
        String[] campos = linha.split(";");
        String tempNome = campos[0];
        String tempRazaoSocial = campos[1];
        String tempCnpj = campos[2];
        String tempInscricaoEstadual = campos[3];
        String tempTel = campos[4];
        String tempEndereco = campos[5];
        String tempEmail = campos[6];

        Clientes tempCliente = new Clientes(tempNome,
            tempRazaoSocial,
            tempCnpj,
            tempInscricaoEstadual,
            tempTel,
            tempEndereco,
            tempEmail);
        clientes.add(tempCliente);
      }

    } catch (Exception e) {
      System.out.println("exception");
      e.printStackTrace();
    }

    // Arquivo Funcionarios
    try {
      FileReader arqFuncionarios = new FileReader("arquivos/funcionarios.txt");
      Scanner sc = new Scanner(arqFuncionarios);
      while (sc.hasNextLine()) {
        String linha = sc.nextLine();
        String[] campos = linha.split(";");
        String nome = campos[0];
        String cpf = campos[1];
        String dataContrat = campos[2];
        String sal = campos[3];
        String endereco = campos[4];
        String cargo = campos[5];
        String tel = campos[6];

        sal = sal.replaceAll(",", ".");
        float salario = Float.parseFloat(sal);
        Funcionarios tempFuncionario = new Funcionarios(nome, cpf, dataContrat, salario, endereco, cargo, tel);
        funcionarios.add(tempFuncionario);

      }

    } catch (Exception e) {
      System.out.println("exception");
      e.printStackTrace();
    }
// Arquivo Gastos Veiculares
    try {
      FileReader arqVeiculos = new FileReader("arquivos/gastosVeiculos.txt");
      Scanner sc = new Scanner(arqVeiculos);
      while (sc.hasNextLine()) {
        String linha = sc.nextLine();
        String[] campos = linha.split(";");

        String placa = campos[0];
        String data = campos[1];
        String motorista = campos[2];
        String km = campos[3];
        String qtdLitros = campos[4];
        String valorComb = campos[5];
        String descManutencao = campos[6];
        String valorManut = campos[6];
        String kmPordia = campos[6];
        
        valorComb = valorComb.replaceAll(",", ".");
        float valorCombustivel = Float.parseFloat(valorComb);
        
        valorManut = valorManut.replaceAll(",", ".");
        float valorManutencao = Float.parseFloat(valorManut);

        GastosVeiculo tempVeiculo = new GastosVeiculo(placa, data, motorista, Integer.parseInt(km), Integer.parseInt(qtdLitros), valorCombustivel,descManutencao, valorManutencao,Integer.parseInt(kmPordia));
        veiculos.add(tempVeiculo);
      }

    } catch (Exception e) {
      System.out.println("exception");
      e.printStackTrace();
    }


    // Arquivo Coleta de mercadoria
    try {
      FileReader arqColetas = new FileReader("arquivos/coletasMercadoria.txt");
      Scanner sc = new Scanner(arqColetas);
      while (sc.hasNextLine()) {
        String linha = sc.nextLine();
        String[] campos = linha.split(";");

        String tempData = campos[0];
        String tempMotorista = campos[1];
        String tempNumNota = campos[2];
        String tempCidade = campos[3];
        String tempNomeEmpresa = campos[4];
        String tempDataEmissaoNota = campos[5];
        String tempAjudante = campos[6];

        ControleMercadoria tempColeta = new ControleMercadoria(tempData,
            tempMotorista,
            tempNumNota,
            tempCidade,
            tempNomeEmpresa,
            tempDataEmissaoNota,
            tempAjudante);
        coletas.add(tempColeta);
      }

    } catch (Exception e) {
      System.out.println("exception");
      e.printStackTrace();
    }

    // Arquivo Entregas de mercadoria
    try {
      FileReader arqEntrega = new FileReader("arquivos/entregasMercadoria.txt");
      Scanner sc = new Scanner(arqEntrega);
      while (sc.hasNextLine()) {
        String linha = sc.nextLine();
        String[] campos = linha.split(";");

        String tempData = campos[0];
        String tempMotorista = campos[1];
        String tempNumNota = campos[2];
        String tempCidade = campos[3];
        String tempNomeEmpresa = campos[4];
        String tempDataEmissaoNota = campos[5];
        String tempAjudante = campos[6];

        ControleMercadoria tempEntrega = new ControleMercadoria(tempData,
            tempMotorista,
            tempNumNota,
            tempCidade,
            tempNomeEmpresa,
            tempDataEmissaoNota,
            tempAjudante);
        entregas.add(tempEntrega);
      }

    } catch (Exception e) {
      System.out.println("exception");
      e.printStackTrace();
    }

    int op = 0;
    do {
      System.out.println("\n___ESCOLHA UMA OPÇÃO___\n");
      System.out.println("1 - Gerenciar Clientes");
      System.out.println("2 - Gerenciar Funcionarios");
      System.out.println("3 - Gerenciar Gastos com veiculos");
      System.out.println("4 - Gerenciar Coleta de mercadoria");
      System.out.println("5 - Gerenciar Entrega de mercadoria");
      System.out.println("6 - Gerar relatorio de entrega e coleta de mercadoria");
      System.out.println("7 - Sair");
      System.out.println("Digite uma opção: ");
      op = scan.nextInt();

      switch (op) {
        case 1 -> {
          int opCliente = 0;
          do {
            System.out.println("___ESCOLHA UMA OPÇÃO___");
            System.out.println("1 - Adicionar Cliente");
            System.out.println("2 - Remover Cliente");
            System.out.println("3 - Editar Cliente");
            System.out.println("4 - Mostrar Clientes");
            System.out.println("5 - Voltar");
            opCliente = scan.nextInt();
            switch (opCliente) {
              case 1 -> {
                String nome,
                    razaoSocial,
                    cnpj,
                    inscricaoEstadual,
                    tel,
                    endereco,
                    email;
                System.out.println("Digite o nome:");
                scan.nextLine();
                nome = scan.nextLine();
                System.out.println("Digite a razão social:");
                razaoSocial = scan.nextLine();
                System.out.println("Digite o cnpj:");
                cnpj = scan.nextLine();
                System.out.println("Digite a inscrição estadual:");
                inscricaoEstadual = scan.nextLine();
                System.out.println("Digite o telefone:");
                tel = scan.nextLine();
                System.out.println("Digite o endereço:");
                endereco = scan.nextLine();
                System.out.println("Digite o email:");
                email = scan.nextLine();
                Clientes tempCliente = new Clientes(nome, razaoSocial, cnpj, inscricaoEstadual, tel, endereco, email);
                clientes.add(tempCliente);
              }

              case 2 -> {
                String cnpj;
                System.out.println("Digite o cnpj do cliente a ser removido:");
                scan.nextLine();
                cnpj = scan.nextLine();
                clientes.removeIf(Clientes -> Clientes.getCnpj().equals(cnpj));
              }

              case 3 -> {
                String cnpj;
                int indexOfCliente = -1;
                boolean check = false;
                System.out.println("Digite o cnpj do cliente a ser editado:");
                scan.nextLine();
                cnpj = scan.nextLine();
                for (int i = 0; i < clientes.size(); i++) {
                  if (cnpj.equals(clientes.get(i).getCnpj())) {
                    indexOfCliente = i;
                    break;
                  }
                  if (i == clientes.size()) {
                    System.out.println("Cnpj não encontrado.");
                  }
                }
                if (indexOfCliente > -1) {
                  char accept;
                  String nome, razaoSocial, cnpjC, inscricaoEstadual, tel, endereco, email;
                  System.out.println("Deseja mudar o nome?(y/n):");

                  accept = scan.next().charAt(0);
                  if (accept == 'y') {
                    check = true;
                    System.out.println("Digite o nome:");
                    scan.nextLine();
                    nome = scan.nextLine();
                  } else {
                    nome = clientes.get(indexOfCliente).getNomeFantasia();
                  }
                  System.out.println("Deseja mudar a razão social?(y/n):");

                  accept = scan.next().charAt(0);
                  if (accept == 'y') {
                    check = true;
                    System.out.println("Digite a razão social:");
                    scan.nextLine();
                    razaoSocial = scan.nextLine();
                  } else {
                    razaoSocial = clientes.get(indexOfCliente).getRazaoSocial();
                  }
                  System.out.println("Deseja mudar o cnpj?(y/n):");

                  accept = scan.next().charAt(0);
                  if (accept == 'y') {
                    check = true;
                    System.out.println("Digite o cnpj:");
                    scan.nextLine();
                    cnpjC = scan.nextLine();
                  } else {
                    cnpjC = clientes.get(indexOfCliente).getCnpj();
                  }
                  System.out.println("Deseja mudar a inscrição estadual?(y/n):");
                  accept = scan.next().charAt(0);
                  if (accept == 'y') {
                    check = true;
                    System.out.println("Digite a inscrição estadual:");
                    scan.nextLine();
                    inscricaoEstadual = scan.nextLine();
                  } else {
                    inscricaoEstadual = clientes.get(indexOfCliente).getInscricaoEstadual();
                  }
                  System.out.println("Deseja mudar o telefone?(y/n):");
                  accept = scan.next().charAt(0);
                  if (accept == 'y') {
                    check = true;
                    System.out.println("Digite o telefone:");
                    scan.nextLine();
                    tel = scan.nextLine();
                  } else {
                    tel = clientes.get(indexOfCliente).getTel();
                  }
                  System.out.println("Deseja mudar o endereço?(y/n):");

                  accept = scan.next().charAt(0);
                  if (accept == 'y') {
                    check = true;
                    System.out.println("Digite o endereço:");
                    scan.nextLine();
                    endereco = scan.nextLine();
                  } else {
                    endereco = clientes.get(indexOfCliente).getEndereco();
                  }
                  System.out.println("Deseja mudar o email?(y/n):");

                  accept = scan.next().charAt(0);
                  if (accept == 'y') {
                    check = true;
                    System.out.println("Digite o email:");
                    scan.nextLine();
                    email = scan.nextLine();
                  } else {
                    email = clientes.get(indexOfCliente).getEmail();
                  }

                  if (check) {
                    Clientes tempCliente = new Clientes(nome, razaoSocial, cnpjC, inscricaoEstadual, tel, endereco,
                        email);
                    clientes.remove(indexOfCliente);
                    clientes.add(indexOfCliente, tempCliente);
                  }
                }
              }

              case 4 -> {
                for (Clientes c : clientes) {
                  System.out.println(c);
                }
              }

            }

          } while (opCliente != 5);
        }

        case 2 -> {
          int opFunc = 0;
          do {

            System.out.println("___ESCOLHA UMA OPÇÃO___");
            System.out.println("1 - Adicionar Funcionario");
            System.out.println("2 - Remover Funcionario");
            System.out.println("3 - Editar Funcionario");
            System.out.println("4 - Mostrar Funcionarios");
            System.out.println("5 - Voltar");
            opFunc = scan.nextInt();

            switch (opFunc) {
              case 1 -> {
                String nome,
                    cpf,
                    dataContrat,
                    endereco,
                    cargo,
                    tel;
                float salario;
                System.out.println("Digite o nome:");
                scan.nextLine();
                nome = scan.nextLine();
                System.out.println("Digite o CPF:");
                cpf = scan.nextLine();
                System.out.println("Digite a data de contratação:");
                dataContrat = scan.nextLine();
                System.out.println("Digite o salário:");
                salario = scan.nextFloat();
                System.out.println("Digite o endereço:");
                scan.nextLine();
                endereco = scan.nextLine();
                System.out.println("Digite o cargo:");
                cargo = scan.nextLine();
                System.out.println("Digite o telefone:");
                tel = scan.nextLine();

                Funcionarios tempFuncionario = new Funcionarios(nome, cpf, dataContrat, salario, endereco, cargo, tel);
                funcionarios.add(tempFuncionario);
              }
              case 2 -> {
                String RMVcpf;
                System.out.println("Digite o CPF do funcionário a ser removido:");
                scan.nextLine();
                RMVcpf = scan.nextLine();
                funcionarios.removeIf(Funcionarios -> Funcionarios.getCPF().equals(RMVcpf));

              }
              case 3 -> {
                String cpf;
                int indexOfFuncionario = -1;
                boolean check = false;
                System.out.println("Digite o CPF do funcionário a ser editado:");
                scan.nextLine();
                cpf = scan.nextLine();
                for (int i = 0; i < funcionarios.size(); i++) {
                  if (cpf.equals(funcionarios.get(i).getCPF())) {
                    indexOfFuncionario = i;
                    break;
                  }
                  if (i == funcionarios.size()) {
                    System.out.println("CPF não encontrado.");
                  }
                }
                if (indexOfFuncionario > -1) {
                  char accept;
                  String nome, cpfA, dataContrat, endereco, cargo, tel;

                  float salario;
                  System.out.println("Deseja mudar o nome?(y/n):");

                  accept = scan.next().charAt(0);
                  if (accept == 'y') {
                    check = true;
                    System.out.println("Digite o nome:");
                    scan.nextLine();
                    nome = scan.nextLine();
                  } else {
                    nome = funcionarios.get(indexOfFuncionario).getNome();
                  }
                  System.out.println("Deseja mudar o cpf?(y/n):");

                  accept = scan.next().charAt(0);
                  if (accept == 'y') {
                    check = true;
                    System.out.println("Digite o novo cpf:");
                    scan.nextLine();
                    cpfA = scan.nextLine();
                  } else {
                    cpfA = funcionarios.get(indexOfFuncionario).getCPF();
                  }
                  System.out.println("Deseja mudar a data da contratação?(y/n):");

                  accept = scan.next().charAt(0);
                  if (accept == 'y') {
                    check = true;
                    System.out.println("Digite a nova data (dd/MM/yyyy):");
                    scan.nextLine();
                    dataContrat = scan.nextLine();

                  } else {
                    dataContrat = funcionarios.get(indexOfFuncionario).getDataContrat();
                  }
                  System.out.println("Deseja mudar o salário?(y/n):");
                  accept = scan.next().charAt(0);
                  if (accept == 'y') {
                    check = true;
                    System.out.println("Digite o salário atualizado:");
                    scan.nextLine();
                    salario = scan.nextFloat();
                  } else {
                    salario = funcionarios.get(indexOfFuncionario).getSalario();
                  }
                  System.out.println("Deseja mudar o endereço?(y/n):");
                  accept = scan.next().charAt(0);
                  if (accept == 'y') {
                    check = true;
                    System.out.println("Digite o endereço:");
                    scan.nextLine();
                    endereco = scan.nextLine();
                  } else {
                    endereco = funcionarios.get(indexOfFuncionario).getEndereco();
                  }
                  System.out.println("Deseja mudar o cargo?(y/n):");

                  accept = scan.next().charAt(0);
                  if (accept == 'y') {
                    check = true;
                    System.out.println("Digite o cargo:");
                    scan.nextLine();
                    cargo = scan.nextLine();
                  } else {
                    cargo = funcionarios.get(indexOfFuncionario).getCargo();
                  }
                  System.out.println("Deseja mudar o telefone?(y/n):");

                  accept = scan.next().charAt(0);
                  if (accept == 'y') {
                    check = true;
                    System.out.println("Digite o telefone:");
                    scan.nextLine();
                    tel = scan.nextLine();
                  } else {
                    tel = funcionarios.get(indexOfFuncionario).getTel();
                  }

                  if (check) {
                    Funcionarios tempFuncionario = new Funcionarios(nome, cpfA, dataContrat, salario, endereco, cargo,
                        tel);
                    funcionarios.remove(indexOfFuncionario);
                    funcionarios.add(indexOfFuncionario, tempFuncionario);

                  }
                }
              }

              case 4 -> {
                for (Funcionarios f : funcionarios) {
                  System.out.println(f);
                }
              }
              default ->
                System.out.println("Opção inválida, tente novamente");

            }

          } while (opFunc != 5);
        }

        case 3 -> {
          int opGasto = 0;
          do {

            System.out.println("___ESCOLHA UMA OPÇÃO___");
            System.out.println("1 - Adicionar Gasto");
            System.out.println("2 - Remover gasto");
            System.out.println("3 - Editar gasto");
            System.out.println("4 - Gerar resumo de gastos");
            System.out.println("5 - Voltar");
            opGasto = scan.nextInt();

            switch (opGasto) {
              case 1 -> {
                String placa, data, motorista, descManutencao;
                int km, qtdLitros;
                float valorCombustivel, valorManutencao;

                System.out.println("Digite a placa:");
                scan.nextLine();
                placa = scan.nextLine();
                System.out.println("Digite a data (dd/mm/yyyy):");
                data = scan.nextLine();
                System.out.println("Digite o nome do motorista:");
                motorista = scan.nextLine();
                System.out.println("Digite a kilometragem:");
                km = scan.nextInt();
                System.out.println("Digite a quantidade em litros de combustível consumido:");
                qtdLitros = scan.nextInt();
                System.out.println("Digite o preço do combustível:");
                valorCombustivel = scan.nextFloat();
                System.out.println("Descreva a manutenção do veículo:");
                scan.nextLine();
                descManutencao = scan.nextLine();
                System.out.println("Digite o custo da manutenção:");
                //scan.nextLine();
                valorManutencao = scan.nextFloat();
                // obs: falta calcular o km por dia
                GastosVeiculo tempGastos = new GastosVeiculo(placa, data, motorista, km, qtdLitros, valorCombustivel,
                    descManutencao, valorManutencao, 0);
                veiculos.add(tempGastos);
              }
              case 2 -> {
                String placa;
                System.out.println("Digite a placa do veículo a remover o gasto:");
                scan.nextLine();
                placa = scan.nextLine();
                veiculos.removeIf(GastosVeiculo -> GastosVeiculo.getPlaca().equals(placa));
              }

              case 3 -> {
                String placa;
                int indexOfVeiculo = -1;
                boolean check = false;
                System.out.println("Digite a placa do veículo a ser editado:");
                scan.nextLine();
                placa = scan.nextLine();
                for (int i = 0; i < veiculos.size(); i++) {
                  if (placa.equals(veiculos.get(i).getPlaca())) {
                    indexOfVeiculo = i;
                    break;
                  }
                  if (i == veiculos.size()) {
                    System.out.println("Placa não encontrada.");
                  }
                }
                if (indexOfVeiculo > -1) {
                  char accept;
                  String placaV, data, motorista;
                  int km, qtdLitros;
                  float valorCombustivel;
                  String descManutencao;
                  Float valorManutencao;

                  System.out.println("Deseja mudar a placa?(y/n):");
                  accept = scan.next().charAt(0);
                  if (accept == 'y') {
                    check = true;
                    System.out.println("Digite a placa:");
                    scan.nextLine();
                    placaV = scan.nextLine();
                  } else {
                    placaV = veiculos.get(indexOfVeiculo).getPlaca();
                  }

                  System.out.println("Deseja mudar a data?(y/n):");
                  accept = scan.next().charAt(0);
                  if (accept == 'y') {
                    check = true;
                    System.out.println("Digite a data:");
                    scan.nextLine();
                    data = scan.nextLine();
                  } else {
                    data = veiculos.get(indexOfVeiculo).getData();
                  }

                  System.out.println("Deseja mudar o motorista?(y/n):");
                  accept = scan.next().charAt(0);
                  if (accept == 'y') {
                    check = true;
                    System.out.println("Digite o nome do motorista:");
                    scan.nextLine();
                    motorista = scan.nextLine();
                  } else {
                    motorista = veiculos.get(indexOfVeiculo).getMotorista();
                  }

                  System.out.println("Deseja mudar a kilometragem?(y/n):");
                  accept = scan.next().charAt(0);
                  if (accept == 'y') {
                    check = true;
                    System.out.println("Digite a kilometragem:");
                    scan.nextLine();
                    km = scan.nextInt();
                  } else {
                    km = veiculos.get(indexOfVeiculo).getKm();
                  }

                  System.out.println("Deseja mudar a litragem?(y/n):");
                  accept = scan.next().charAt(0);
                  if (accept == 'y') {
                    check = true;
                    System.out.println("Digite a litragem:");
                    scan.nextLine();
                    qtdLitros = scan.nextInt();
                  } else {
                    qtdLitros = veiculos.get(indexOfVeiculo).getQtdLitros();
                  }

                  System.out.println("Deseja mudar o preço do combustível?(y/n):");
                  accept = scan.next().charAt(0);
                  if (accept == 'y') {
                    check = true;
                    System.out.println("Digite o preço:");
                    scan.nextLine();
                    valorCombustivel = scan.nextFloat();
                  } else {
                    valorCombustivel = veiculos.get(indexOfVeiculo).getValorCombustivel();
                  }

                  System.out.println("Deseja mudar a descrição da manutenção?(y/n):");
                  accept = scan.next().charAt(0);
                  if (accept == 'y') {
                    check = true;
                    System.out.println("Descreva a manutenção:");
                    scan.nextLine();
                    descManutencao = scan.nextLine();
                  } else {
                    descManutencao = veiculos.get(indexOfVeiculo).getDescManutencao();
                  }

                  System.out.println("Deseja mudar o custo da manutenção?(y/n):");
                  accept = scan.next().charAt(0);
                  if (accept == 'y') {
                    check = true;
                    System.out.println("Digite o novo custo:");
                    scan.nextLine();
                    valorManutencao = scan.nextFloat();
                  } else {
                    valorManutencao = veiculos.get(indexOfVeiculo).getValorManutencao();
                  }

                  if (check) {
                    GastosVeiculo tempVeiculo = new GastosVeiculo(placaV, data, motorista, km, qtdLitros,
                        valorCombustivel, descManutencao, valorManutencao, 0);
                    veiculos.remove(indexOfVeiculo);
                    veiculos.add(indexOfVeiculo, tempVeiculo);
                  }
                }
              }
              case 4 -> {
                String dataDe,
                    dataAte;
                System.out.println("Digite o periodo que gostaria de gerar o resumo:");
                System.out.println("Digite a data inicial(00/00/0000): ");
                dataDe = scan.nextLine();
                System.out.println("Digite a data final (00/00/0000) : ");
                dataAte = scan.nextLine();
                /* convertendo data de string para date */
                SimpleDateFormat toDate = new SimpleDateFormat("dd/MM/yyyy");
                Date dateA = toDate.parse(dataDe);
                Date dateB = toDate.parse(dataAte);
              }
              default ->
                System.out.println("Opção inválida, tente novamente");

            }

          } while (opGasto != 5);
        }
        case 4 -> {
          int opColeta = 0;
          do {

            System.out.println("___ESCOLHA UMA OPÇÃO___");
            System.out.println("1 - Adicionar informação de uma coleta");
            System.out.println("2 - Remover informação de uma coleta");
            System.out.println("3 - Editar informação de uma coleta");
            System.out.println("4 - Gerar resumo de uma coleta");
            System.out.println("5 - Voltar");
            opColeta = scan.nextInt();

            switch (opColeta) {
              case 1 -> {
                String dataColeta,
                    motorista,
                    numNota,
                    cidade,
                    nomeEmpresa,
                    dataEmissaoNota,
                    ajudante;
                System.out.println("Digite a data da coleta:");
                scan.nextLine();
                dataColeta = scan.nextLine();
                System.out.println("Digite o nome do motorista:");
                motorista = scan.nextLine();
                System.out.println("Digite o número da nota:");
                numNota = scan.nextLine();
                System.out.println("Digite a cidade da coleta:");
                cidade = scan.nextLine();
                System.out.println("Digite o nome da empresa (dona da mercadoria):");
                scan.nextLine();
                nomeEmpresa = scan.nextLine();
                System.out.println("Digite a data em que a nota foi emitida (DD/MM/YYYY):");
                dataEmissaoNota = scan.nextLine();
                System.out.println("Digite o nome do ajudante:");
                ajudante = scan.nextLine();

                ControleMercadoria tempColeta = new ControleMercadoria(dataColeta, motorista, numNota, cidade,
                    nomeEmpresa, dataEmissaoNota, ajudante);
                coletas.add(tempColeta);
              }
              case 2 -> {
                String RMVnumNota;
                System.out.println("Digite o número da nota para remover a informação de coleta:");
                scan.nextLine();
                RMVnumNota = scan.nextLine();
                coletas.removeIf(ControleMercadoria -> ControleMercadoria.getNumNota().equals(RMVnumNota));

              }
              case 3 -> {

                String EDITnumNota;
                int indexOfColeta = -1;
                boolean check = false;
                System.out.println("Digite o número da nota para editar a informação de coleta:");
                scan.nextLine();
                EDITnumNota = scan.nextLine();
                for (int i = 0; i < coletas.size(); i++) {
                  if (EDITnumNota.equals(coletas.get(i).getNumNota())) {
                    indexOfColeta = i;
                    break;
                  }
                  if (i == coletas.size()) {
                    System.out.println("CPF não encontrado.");
                  }
                }
                if (indexOfColeta > -1) {
                  char accept;
                  String dataColeta,
                      motorista,
                      numNota,
                      cidade,
                      nomeEmpresa,
                      dataEmissaoNota,
                      ajudante;

                  System.out.println("Deseja mudar a data da coleta?(y/n):");

                  accept = scan.next().charAt(0);
                  if (accept == 'y') {
                    check = true;
                    System.out.println("Digite a nova data:");
                    scan.nextLine();
                    dataColeta = scan.nextLine();
                  } else {
                    dataColeta = coletas.get(indexOfColeta).getData();
                  }
                  System.out.println("Deseja mudar o motorista?(y/n):");

                  accept = scan.next().charAt(0);
                  if (accept == 'y') {
                    check = true;
                    System.out.println("Digite o novo motorista:");
                    scan.nextLine();
                    motorista = scan.nextLine();
                  } else {
                    motorista = coletas.get(indexOfColeta).getMotorista();
                  }
                  System.out.println("Deseja mudar o numero da nota ?(y/n):");

                  accept = scan.next().charAt(0);
                  if (accept == 'y') {
                    check = true;
                    System.out.println("Digite o novo número da nota:");
                    scan.nextLine();
                    numNota = scan.nextLine();

                  } else {
                    numNota = coletas.get(indexOfColeta).getNumNota();
                  }
                  System.out.println("Deseja mudar a cidade?(y/n):");
                  accept = scan.next().charAt(0);
                  if (accept == 'y') {
                    check = true;
                    System.out.println("Digite a cidade atualizada:");
                    scan.nextLine();
                    cidade = scan.nextLine();
                  } else {
                    cidade = coletas.get(indexOfColeta).getCidade();
                  }
                  System.out.println("Deseja mudar o nome da empresa?(y/n):");
                  accept = scan.next().charAt(0);
                  if (accept == 'y') {
                    check = true;
                    System.out.println("Digite o nome da empresa:");
                    scan.nextLine();
                    nomeEmpresa = scan.nextLine();
                  } else {
                    nomeEmpresa = coletas.get(indexOfColeta).getNomeEmpresa();
                  }
                  System.out.println("Deseja mudar a data de emissão da nota?(y/n):");

                  accept = scan.next().charAt(0);
                  if (accept == 'y') {
                    check = true;
                    System.out.println("Digite a nova data de emissão da nota:");
                    scan.nextLine();
                    dataEmissaoNota = scan.nextLine();
                  } else {
                    dataEmissaoNota = coletas.get(indexOfColeta).getDataEmissaoNota();
                  }
                  System.out.println("Deseja mudar o ajudante?(y/n):");

                  accept = scan.next().charAt(0);
                  if (accept == 'y') {
                    check = true;
                    System.out.println("Digite o nome do ajudante:");
                    scan.nextLine();
                    ajudante = scan.nextLine();
                  } else {
                    ajudante = coletas.get(indexOfColeta).getNomeAjudante();
                  }

                  if (check) {
                    ControleMercadoria tempColeta = new ControleMercadoria(dataColeta, motorista, numNota, cidade,
                        nomeEmpresa, dataEmissaoNota, ajudante);
                    coletas.remove(indexOfColeta);
                    coletas.add(indexOfColeta, tempColeta);

                  }
                }
              }
              case 4 -> {
                String dataDe,
                    dataAte;
                System.out.println("Digite o periodo que gostaria de gerar o resumo:");
                System.out.println("Digite a data inicial(00/00/0000): ");
                dataDe = scan.nextLine();
                System.out.println("Digite a data final (00/00/0000) : ");
                dataAte = scan.nextLine();
                /* convertendo data de string para date */
                SimpleDateFormat toDate = new SimpleDateFormat("dd/MM/yyyy");
                Date dateA = toDate.parse(dataDe);
                Date dateB = toDate.parse(dataAte);
              }
              default ->
                System.out.println("Opção inválida, tente novamente");

            }

          } while (opColeta != 5);
        }
        case 5 -> {
          int opEntrega = 0;
          do {

            System.out.println("___ESCOLHA UMA OPÇÃO___");
            System.out.println("1 - Adicionar informação de uma entrega");
            System.out.println("2 - Remover informação de uma entrega");
            System.out.println("3 - Editar informação de uma entrega");
            System.out.println("4 - Gerar resumo de uma entrega");
            System.out.println("5 - Voltar");
            opEntrega = scan.nextInt();

            switch (opEntrega) {
              case 1 -> {
                String dataEntrega,
                    motorista,
                    numNota,
                    cidade,
                    nomeEmpresa,
                    dataEmissaoNota,
                    ajudante;
                System.out.println("Digite a data da entrega:");
                scan.nextLine();
                dataEntrega = scan.nextLine();
                System.out.println("Digite o nome do motorista:");
                motorista = scan.nextLine();
                System.out.println("Digite o número da nota:");
                numNota = scan.nextLine();
                System.out.println("Digite a cidade da entrega:");
                cidade = scan.nextLine();
                System.out.println("Digite o nome da empresa (dona da mercadoria):");
                scan.nextLine();
                nomeEmpresa = scan.nextLine();
                System.out.println("Digite a data em que a nota foi emitida (DD/MM/YYYY):");
                dataEmissaoNota = scan.nextLine();
                System.out.println("Digite o nome do ajudante:");
                ajudante = scan.nextLine();

                ControleMercadoria tempEntrega = new ControleMercadoria(dataEntrega, motorista, numNota, cidade,
                    nomeEmpresa, dataEmissaoNota, ajudante);
                entregas.add(tempEntrega);
              }
              case 2 -> {
                String RMVnumNota;
                System.out.println("Digite o número da nota para remover a informação de entrega:");
                scan.nextLine();
                RMVnumNota = scan.nextLine();
                entregas.removeIf(ControleMercadoria -> ControleMercadoria.getNumNota().equals(RMVnumNota));

              }
              case 3 -> {

                String EDITnumNota;
                int indexOfEntrega = -1;
                boolean check = false;
                System.out.println("Digite o número da nota para editar a informação de entrega:");
                scan.nextLine();
                EDITnumNota = scan.nextLine();
                for (int i = 0; i < entregas.size(); i++) {
                  if (EDITnumNota.equals(entregas.get(i).getNumNota())) {
                    indexOfEntrega = i;
                    break;
                  }
                  if (i == entregas.size()) {
                    System.out.println("CPF não encontrado.");
                  }
                }
                if (indexOfEntrega > -1) {
                  char accept;
                  String dataEntrega,
                      motorista,
                      numNota,
                      cidade,
                      nomeEmpresa,
                      dataEmissaoNota,
                      ajudante;

                  System.out.println("Deseja mudar a data da entrega?(y/n):");

                  accept = scan.next().charAt(0);
                  if (accept == 'y') {
                    check = true;
                    System.out.println("Digite a nova data:");
                    scan.nextLine();
                    dataEntrega = scan.nextLine();
                  } else {
                    dataEntrega = entregas.get(indexOfEntrega).getData();
                  }
                  System.out.println("Deseja mudar o motorista?(y/n):");

                  accept = scan.next().charAt(0);
                  if (accept == 'y') {
                    check = true;
                    System.out.println("Digite o novo motorista:");
                    scan.nextLine();
                    motorista = scan.nextLine();
                  } else {
                    motorista = entregas.get(indexOfEntrega).getMotorista();
                  }
                  System.out.println("Deseja mudar o numero da nota ?(y/n):");

                  accept = scan.next().charAt(0);
                  if (accept == 'y') {
                    check = true;
                    System.out.println("Digite o novo número da nota:");
                    scan.nextLine();
                    numNota = scan.nextLine();

                  } else {
                    numNota = entregas.get(indexOfEntrega).getNumNota();
                  }
                  System.out.println("Deseja mudar a cidade?(y/n):");
                  accept = scan.next().charAt(0);
                  if (accept == 'y') {
                    check = true;
                    System.out.println("Digite a cidade atualizada:");
                    scan.nextLine();
                    cidade = scan.nextLine();
                  } else {
                    cidade = entregas.get(indexOfEntrega).getCidade();
                  }
                  System.out.println("Deseja mudar o nome da empresa?(y/n):");
                  accept = scan.next().charAt(0);
                  if (accept == 'y') {
                    check = true;
                    System.out.println("Digite o nome da empresa:");
                    scan.nextLine();
                    nomeEmpresa = scan.nextLine();
                  } else {
                    nomeEmpresa = entregas.get(indexOfEntrega).getNomeEmpresa();
                  }
                  System.out.println("Deseja mudar a data de emissão da nota?(y/n):");

                  accept = scan.next().charAt(0);
                  if (accept == 'y') {
                    check = true;
                    System.out.println("Digite a nova data de emissão da nota:");
                    scan.nextLine();
                    dataEmissaoNota = scan.nextLine();
                  } else {
                    dataEmissaoNota = entregas.get(indexOfEntrega).getDataEmissaoNota();
                  }
                  System.out.println("Deseja mudar o ajudante?(y/n):");

                  accept = scan.next().charAt(0);
                  if (accept == 'y') {
                    check = true;
                    System.out.println("Digite o nome do ajudante:");
                    scan.nextLine();
                    ajudante = scan.nextLine();
                  } else {
                    ajudante = entregas.get(indexOfEntrega).getNomeAjudante();
                  }

                  if (check) {
                    ControleMercadoria tempColeta = new ControleMercadoria(dataEntrega, motorista, numNota, cidade,
                        nomeEmpresa, dataEmissaoNota, ajudante);
                    entregas.remove(indexOfEntrega);
                    entregas.add(indexOfEntrega, tempColeta);

                  }
                }
              }

              case 4 -> {
                String dataDe,
                    dataAte;
                System.out.println("Digite o periodo que gostaria de gerar o resumo:");
                System.out.println("Digite a data inicial(00/00/0000): ");
                dataDe = scan.nextLine();
                System.out.println("Digite a data final (00/00/0000) : ");
                dataAte = scan.nextLine();
                /* convertendo data de string para date */
                SimpleDateFormat toDate = new SimpleDateFormat("dd/MM/yyyy");
                Date dateA = toDate.parse(dataDe);
                Date dateB = toDate.parse(dataAte);
              }
              default ->
                System.out.println("Opção inválida, tente novamente");

            }

          } while (opEntrega != 4);
        }

        case 6 -> {
          String dataDe,
              dataAte;
          System.out.println("Digite o periodo que gostaria de gerar o resumo:");
          System.out.println("Digite a data inicial(00/00/0000): ");
          dataDe = scan.nextLine();
          System.out.println("Digite a data final (00/00/0000) : ");
          dataAte = scan.nextLine();
          /* convertendo data de string para date */
          SimpleDateFormat toDate = new SimpleDateFormat("dd/MM/yyyy");
          Date dateA = toDate.parse(dataDe);
          Date dateB = toDate.parse(dataAte);
        }

      }

    } while (op != 7);

    // Salvar arquivo clientes
    String clientDestination = "arquivos/clientes.txt";
    try (PrintStream ps = new PrintStream(clientDestination)) {

      for (int i = 0; i < clientes.size(); i++) {
        ps.printf("%s;%s;%s;%s;%s;%s;%s\n",
            clientes.get(i).getNomeFantasia(),
            clientes.get(i).getRazaoSocial(),
            clientes.get(i).getCnpj(),
            clientes.get(i).getInscricaoEstadual(),
            clientes.get(i).getTel(),
            clientes.get(i).getEndereco(),
            clientes.get(i).getEmail());

      }
      ps.flush();

    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }

    // Salvar arquivo Funcionarios
    String funcDestination = "arquivos/funcionarios.txt";
    try (PrintStream ps = new PrintStream(funcDestination)) {

      for (int i = 0; i < funcionarios.size(); i++) {
        ps.printf("%s;%s;%s;%f;%s;%s;%s\n",
            funcionarios.get(i).getNome(),
            funcionarios.get(i).getCPF(),
            funcionarios.get(i).getDataContrat(),
            funcionarios.get(i).getSalario(),
            funcionarios.get(i).getEndereco(),
            funcionarios.get(i).getCargo(),
            funcionarios.get(i).getTel());

      }
      ps.flush();

    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }

    // Salvar arquivo gastos de veículos
    String spendingDestination = "arquivos/gastosVeiculos.txt";
    try (PrintStream ps = new PrintStream(spendingDestination)) {

      for (int i = 0; i < veiculos.size(); i++) {
        ps.printf("%s;%s;%s;%d;%d;%f;%s;%f;%d\n",
            veiculos.get(i).getPlaca(),
            veiculos.get(i).getData(),
            veiculos.get(i).getMotorista(),
            veiculos.get(i).getKm(),
            veiculos.get(i).getQtdLitros(),
            veiculos.get(i).getValorCombustivel(),
            veiculos.get(i).getDescManutencao(),
            veiculos.get(i).getValorManutencao(),
            veiculos.get(i).getKmpordia());
      }
      ps.flush();

    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }

    // Salvar arquivo Coletas
    String coletasDestination = "arquivos/coletasMercadoria.txt";
    try (PrintStream ps = new PrintStream(coletasDestination)) {

      for (int i = 0; i < coletas.size(); i++) {
        ps.printf("%s;%s;%s;%s;%s;%s;%s\n",
            coletas.get(i).getData(),
            coletas.get(i).getMotorista(),
            coletas.get(i).getNumNota(),
            coletas.get(i).getCidade(),
            coletas.get(i).getNomeEmpresa(),
            coletas.get(i).getDataEmissaoNota(),
            coletas.get(i).getNomeAjudante());

      }
      ps.flush();

    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }

    // Salvar arquivo Entregas
    String entregasDestination = "arquivos/entregasMercadoria.txt";
    try (PrintStream ps = new PrintStream(entregasDestination)) {

      for (int i = 0; i < entregas.size(); i++) {
        ps.printf("%s;%s;%s;%s;%s;%s;%s\n",
            entregas.get(i).getData(),
            entregas.get(i).getMotorista(),
            entregas.get(i).getNumNota(),
            entregas.get(i).getCidade(),
            entregas.get(i).getNomeEmpresa(),
            entregas.get(i).getDataEmissaoNota(),
            entregas.get(i).getNomeAjudante());

      }
      ps.flush();

    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }

  }
}
