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
public class GastosVeiculo {
    private String placa;
    private Date data;
    private String motorista;
    private int km;
    private int qtdLitros;
    private double valorCombustivel;
    private String descManutencao;
    private Float valorManutencao;
    private int kmpordia = 0; //valor calculado usando km de dias anteriores da mesma placa
    
public GastosVeiculo(String placa, Date data, String motorista, int km, int qtdLitros, double valorCombustivel, String descManutencao, Float valorManutencao, int kmpordia){
    this.placa = placa;
    this.data = data;
    this.motorista = motorista;
    this.km = km;
    this.qtdLitros = qtdLitros;
    this.valorCombustivel = valorCombustivel;
    this.descManutencao = descManutencao;
    this.valorManutencao = valorManutencao;
    this.kmpordia = km; //possivel mudança   
    
    
}

    /**
     * @return the placa
     */
    public String getPlaca() {
        return placa;
    }

    /**
     * @param placa the placa to set
     */
    public void setPlaca(String placa) {
        this.placa = placa;
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
     * @return the km
     */
    public int getKm() {
        return km;
    }

    /**
     * @param km the km to set
     */
    public void setKm(int km) {
        this.km = km;
    }

    /**
     * @return the qtdLitros
     */
    public int getQtdLitros() {
        return qtdLitros;
    }

    /**
     * @param qtdLitros the qtdLitros to set
     */
    public void setQtdLitros(int qtdLitros) {
        this.qtdLitros = qtdLitros;
    }

    /**
     * @return the valorCombustivel
     */
    public double getValorCombustivel() {
        return valorCombustivel;
    }

    /**
     * @param valorCombustivel the valorCombustivel to set
     */
    public void setValorCombustivel(double valorCombustivel) {
        this.valorCombustivel = valorCombustivel;
    }

    /**
     * @return the descManutencao
     */
    public String getDescManutencao() {
        return descManutencao;
    }

    /**
     * @param descManutencao the descManutencao to set
     */
    public void setDescManutencao(String descManutencao) {
        this.descManutencao = descManutencao;
    }

    /**
     * @return the valorManutencao
     */
    public Float getValorManutencao() {
        return valorManutencao;
    }

    /**
     * @param valorManutencao the valorManutencao to set
     */
    public void setValorManutencao(Float valorManutencao) {
        this.valorManutencao = valorManutencao;
    }

    /**
     * @return the kmpordia
     */
    public int getKmpordia() {
        return kmpordia;
    }

    /**
     * @param kmpordia the kmpordia to set
     */
    public void setKmpordia(int kmpordia) {
        this.kmpordia = kmpordia;
    }



}
