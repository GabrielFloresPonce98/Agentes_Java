/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoagente;

import java.util.Scanner;

public class ProyectoAgente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner t = new Scanner(System.in);
        System.out.println("Cuanto caminos desea generar?");
        Rutas ObjetosRutas = new Rutas(t.nextInt());

        System.out.println("Opciones: " + "\n" + "1.Torneo" + "\n" + "2.Menor a mayor" + "\n" + "3.Cruce" + "\n");
        ObjetosRutas.setOp(t.nextInt());
        ObjetosRutas.GenerarRutas();

        System.out.println(ObjetosRutas.MuestraRutasA());
        System.out.println("¿GENERACIONES?");
        ObjetosRutas.RepetirCambio(t.nextInt());

        ObjetosRutas.AptitudGanadora();

    }
    
}
