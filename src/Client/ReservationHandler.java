/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import SRL.Spectacle;

/**
 *
 * @author MiguelAngel
 */
public class ReservationHandler {
    
    private Spectacle spectacle;

    public ReservationHandler() {
    }
    
    public ReservationHandler(Spectacle spectacle) {
        this.spectacle = spectacle;
    }

    public Spectacle getSpectacle() {
        return spectacle;
    }

    public void setSpectacle(Spectacle spectacle) {
        this.spectacle = spectacle;
    }
    
    
    
}
