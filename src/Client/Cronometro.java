/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Client;

import UI.ReservationView;


/**
 *
 * @author RIP WiLHeM Mx
 */
public class Cronometro extends Thread{
    
    private ReservationView ventanaPrincipal;
    private boolean continuar;
    
    public Cronometro(ReservationView ventana){
        ventanaPrincipal = ventana;
        continuar=true;
    }
    
    @Override
    public void run(){
         for (int i = 0; i < 60; i++) {
             if (continuar) {
                 try {
            sleep(990);    
            ventanaPrincipal.reduceTimeByASecond();
            if(i%5 == 0){
                ventanaPrincipal.updateSelectedSeats();
            }
        } catch (Exception e) {
        }
             }
        }
         if (continuar) {
            ventanaPrincipal.cancelReservation();
        }
         
    }
    
    public void detener(){
        continuar = false;
    }
    
}
