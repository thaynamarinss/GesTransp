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
public class ControleMercadoria {
    private Date data; //data da coleta ou entrega
    private String motorista;
    private String numNota;
    private String cidade;
    private String nomeEmpresa;
    private Date dataEmissaoNota;
    private String nomeAjudante;
    
    public ControleMercadoria(Date data, String motorista, String numNota, String cidade, String nomeEmpresa, Date dataEmissaoNota, String nomeAjudante){
        this.data = data;
        this.motorista = motorista;
        this.numNota = numNota;
        this.cidade = cidade;
        this.nomeEmpresa = nomeEmpresa;
        this.dataEmissaoNota = dataEmissaoNota;
        this.nomeAjudante = nomeAjudante;
    }

    /**
     * @return the data
     */
    public Date getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(Date data) {
        this.data = data;
    }

    /**
     * @return the motorista
     */
    public String getMotorista() {
        return motorista;
    }

    /**
     * @param motorista the motorista to set
     */
    public void setMotorista(String motorista) {
        this.motorista = motorista;
    }

    /**
     * @return the numNota
     */
    public String getNumNota() {
        return numNota;
    }

    /**
     * @param numNota the numNota to set
     */
    public void setNumNota(String numNota) {
        this.numNota = numNota;
    }

    /**
     * @return the cidade
     */
    public String getCidade() {
        return cidade;
    }

    /**
     * @param cidade the cidade to set
     */
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    /**
     * @return the nomeEmpresa
     */
    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    /**
     * @param nomeEmpresa the nomeEmpresa to set
     */
    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    /**
     * @return the dataEmissaoNota
     */
    public Date getDataEmissaoNota() {
        return dataEmissaoNota;
    }

    /**
     * @param dataEmissaoNota the dataEmissaoNota to set
     */
    public void setDataEmissaoNota(Date dataEmissaoNota) {
        this.dataEmissaoNota = dataEmissaoNota;
    }

    /**
     * @return the nomeAjudante
     */
    public String getNomeAjudante() {
        return nomeAjudante;
    }

    /**
     * @param nomeAjudante the nomeAjudante to set
     */
    public void setNomeAjudante(String nomeAjudante) {
        this.nomeAjudante = nomeAjudante;
    }
    
}
