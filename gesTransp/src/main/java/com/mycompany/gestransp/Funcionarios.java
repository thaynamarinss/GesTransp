/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestransp;

/**
 *
 * @author thayn
 */
import java.util.Date;
public class Funcionarios {
    private String nome;
    private String CPF;
    private Date dataContrat;
    private Float salario;
    private String endereco;
    private String cargo;
    private String tel;
    
    public Funcionarios(String nome, String CPF, Date dataContrat, float salario, String endereco, String cargo, String tel) {
       this.nome = nome;
       this.CPF = CPF;
       this.dataContrat = dataContrat;
       this.salario = salario;
       this.endereco = endereco;
       this.cargo = cargo;
       this.tel = tel;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the CPF
     */
    public String getCPF() {
        return CPF;
    }

    /**
     * @param CPF the CPF to set
     */
    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    /**
     * @return the dataContrat
     */
    public Date getDataContrat() {
        return dataContrat;
    }

    /**
     * @param dataContrat the dataContrat to set
     */
    public void setDataContrat(Date dataContrat) {
        this.dataContrat = dataContrat;
    }

    /**
     * @return the salario
     */
    public Float getSalario() {
        return salario;
    }

    /**
     * @param salario the salario to set
     */
    public void setSalario(Float salario) {
        this.salario = salario;
    }

    /**
     * @return the endereco
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * @param endereco the endereco to set
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * @return the cargo
     */
    public String getCargo() {
        return cargo;
    }

    /**
     * @param cargo the cargo to set
     */
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    /**
     * @return the tel
     */
    public String getTel() {
        return tel;
    }

    /**
     * @param tel the tel to set
     */
    public void setTel(String tel) {
        this.tel = tel;
    }
    
}
