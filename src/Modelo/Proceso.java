/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author Camila
 */
public class Proceso {

    private int id;
    private int rafagaEjecucion;
    private int tiempoLlegada;
    private int tiempoInicio;
    private int tiempoFinal;
    private int tiempoRetorno;
    private int tiempoEspera;
    private ArrayList<Integer> tiemposDeLlegada, tiemposFinales;

    public Proceso(int idProceso, int rafagaEjecucion, int tiempoLlegada) {
        this.id = idProceso;
        this.rafagaEjecucion = rafagaEjecucion;
        this.tiempoLlegada = tiempoLlegada;
    }

    public Proceso(int idProceso, int rafagaEjecucion, int tiempoLlegada, int tiempoInicio,int tiempoFinal, int tiempoRetorno, int tiempoEspera) {
        this.id = idProceso;
        this.rafagaEjecucion = rafagaEjecucion;
        this.tiempoLlegada = tiempoLlegada;
        this.tiempoInicio= tiempoInicio;
        this.tiempoFinal = tiempoFinal;
        this.tiempoRetorno = tiempoRetorno;
        this.tiempoEspera = tiempoEspera;
        tiemposDeLlegada = new ArrayList<>();
        tiemposFinales = new ArrayList<>();
    }

    public int getIdProceso() {
        return id;
    }

    public void setIdProceso(int idProceso) {
        this.id = idProceso;
    }

    public int getRafagaEjecucion() {
        return rafagaEjecucion;
    }

    public void setRafagaEjecucion(int rafagaEjecucion) {
        this.rafagaEjecucion = rafagaEjecucion;
    }

    public int getTiempoLlegada() {
        return tiempoLlegada;
    }

    public void setTiempoLlegada(int tiempoLlegada) {
        this.tiempoLlegada = tiempoLlegada;
    }

    public int getTiempoFinal() {
        return tiempoFinal;
    }

    public void setTiempoFinal(int tiempoFinal) {
        this.tiempoFinal = tiempoFinal;
    }

    public int getTiempoRetorno() {
        return tiempoRetorno;
    }

    public void setTiempoRetorno(int tiempoRetorno) {
        this.tiempoRetorno = tiempoRetorno;
    }

    public int getTiempoEspera() {
        return tiempoEspera;
    }

    public void setTiempoEspera(int tiempoEspera) {
        this.tiempoEspera = tiempoEspera;
    }

    public int getTiempoInicio() {
        return tiempoInicio;
    }

    public void setTiempoInicio(int tiempoInicio) {
        this.tiempoInicio = tiempoInicio;
    }

    
    // Formulas profesor 
    
    public void calcularTiempoFinalProcesoUno() {
        this.setTiempoFinal(this.getRafagaEjecucion()+this.getTiempoInicio());
    }
    
    //Este metodo es para el resto de nodos ya que su tiempo de inicio depende del final del proceso anterior.
    public void calcularTiempoFinal(int tFinal) {
        this.setTiempoFinal(tFinal + this.getRafagaEjecucion());
    }
    
    public void calcularTiempoRetorno() {
        this.setTiempoRetorno(this.getTiempoFinal() - this.getTiempoLlegada());
    }

    public void calcularTiempoEspera() {
        this.setTiempoEspera(this.getTiempoRetorno() - this.getRafagaEjecucion());
    }
        
}
