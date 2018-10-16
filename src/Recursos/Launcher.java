/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Recursos;

import Controlador.Cola;

/**
 *
 * @author Camila
 */
public class Launcher {
    public static void main(String[] args) {
        Cola servidor = new Cola();
        servidor.procesarCola(servidor.generarProcesos());
        servidor.imprimirProcesos();
        //servidor.reiniciar();
        //servidor.generarTiemposLlegada(5);
    }
    
}
