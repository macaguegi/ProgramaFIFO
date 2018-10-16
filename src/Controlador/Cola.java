/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Proceso;
import java.util.Arrays;
import java.util.Random;
import java.util.Vector;

/**
 *
 * @author Camila
 */
public class Cola {

    //Logica
    private int numeroProcesos;
    private Random aleatorio = new Random(System.currentTimeMillis());
    private Vector<Proceso> procesos = new Vector<Proceso>();
    private int[] tiemposLlegada;

    public Cola() {
    }

    public void iniciaServicio() {
        reiniciar();
        generarProcesos();
    }

    public Vector<Proceso> generarProcesos() {
        numeroProcesos = generarAleatorio(8);
        tiemposLlegada = generarTiemposLlegada(numeroProcesos);
        Arrays.sort(tiemposLlegada);
        System.out.println("Se generaron " + numeroProcesos + " Procesos");
        for (int i = 1; i <= numeroProcesos; i++) {
            procesos.add(new Proceso(i, generarAleatorio(8), tiemposLlegada[i - 1]));
        }
        return procesos;
    }

    public void reiniciar() {
        numeroProcesos = 0;
        tiemposLlegada = null;
        procesos.removeAllElements();

    }

    public int generarAleatorio(int limite) {
        return aleatorio.nextInt(limite) + 1;
    }

    public int[] generarTiemposLlegada(int numProcesos) {
        tiemposLlegada = new int[numProcesos];
        for (int i = 0; i < tiemposLlegada.length; i++) {
            tiemposLlegada[i] = generarAleatorio(9);

        }
        Arrays.sort(tiemposLlegada);
        return tiemposLlegada;
    }

    public void imprimirProcesos() {
        for (int i = 0; i < procesos.size(); i++) {
            System.out.println("|Proceso| " + procesos.get(i).getIdProceso() + " |Rafaga| " + procesos.get(i).getRafagaEjecucion() + " |Llegada| " + procesos.get(i).getTiempoLlegada()
                    + " |TiempoComienzo| " + procesos.get(i).getTiempoInicio() + " |TiempoFinal| " + procesos.get(i).getTiempoFinal() + " |TiempoRetorno| " + procesos.get(i).getTiempoRetorno()
                    + " |TiempoEspera| " + procesos.get(i).getTiempoEspera());

        }
    }

    public int tamanoCola() {
        return procesos.size();
    }

    public Vector<Proceso> procesarCola(Vector<Proceso> cola) {
        //Primer elemento de la cola
        cola.get(0).setTiempoInicio(cola.get(0).getTiempoLlegada());
        cola.get(0).calcularTiempoFinalProcesoUno();
        cola.get(0).calcularTiempoRetorno();
        cola.get(0).calcularTiempoEspera();

        //Resto de elementos de la cola
        for (int i = 1; i < cola.size(); i++) {
            if (cola.get(i).getTiempoLlegada() <= cola.get(i - 1).getTiempoFinal()) {
                cola.get(i).setTiempoInicio(cola.get(i - 1).getTiempoFinal());
            } else {
                cola.get(i).setTiempoInicio(cola.get(i).getTiempoLlegada());
            }
            cola.get(i).calcularTiempoFinal(cola.get(i - 1).getTiempoFinal());
            cola.get(i).calcularTiempoRetorno();
            cola.get(i).calcularTiempoEspera();
        }
        return cola;
    }

}
