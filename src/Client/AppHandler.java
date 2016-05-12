/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import SRL.IRemoteSRL;
import SRL.Seat;
import SRL.Spectacle;
import UI.MainView;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MiguelAngel
 */
public class AppHandler {
    
    public IRemoteSRL srl;
    
    private MainView appView;
    private Registry registry;
    private Map<Integer, Spectacle> spectacles;

    public AppHandler() {
        try {
            this.registry = LocateRegistry.getRegistry("192.168.228.253", 1098);
            this.srl = (IRemoteSRL) registry.lookup("SRLServer");
            
            spectacles = new HashMap<>();
            List<Spectacle> list = srl.readSpectacles();
            for (Spectacle current : list) {
                spectacles.put(current.getId(), current);
            }
            
        } catch (RemoteException ex) {
            Logger.getLogger(AppHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(AppHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void startApp(){
        appView = new MainView();
        appView.setVisible(true);
    }

    public boolean addSession(Spectacle s){
        try {
            return srl.addSession(s);
        } catch (RemoteException ex) {
            Logger.getLogger(AppHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean removeSession(){
        try {
            return srl.removeSession();
        } catch (RemoteException ex) {
            Logger.getLogger(AppHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public List<Spectacle> readSpectacles() {
        try {
            return srl.readSpectacles();
        } catch (RemoteException ex) {
            Logger.getLogger(AppHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public Spectacle readSeats(Spectacle s) {
        try {
            return srl.readSeats(s);
        } catch (RemoteException ex) {
            Logger.getLogger(AppHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void updateSeats(Spectacle s) {
        try {
            srl.updateSeats(s);
        } catch (RemoteException ex) {
            Logger.getLogger(AppHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void updateSeat(Spectacle sp, Seat st) {
        try {
            srl.updateSeat(sp, st);
        } catch (RemoteException ex) {
            Logger.getLogger(AppHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Seat> getSelectedSeats(Spectacle s) {
        try {
            return srl.getSelectedSeats(s);
        } catch (RemoteException ex) {
            Logger.getLogger(AppHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public List<Seat> getMySelectedSeats(Spectacle s) {
        try {
            return srl.getMySelectedSeats(s);
        } catch (RemoteException ex) {
            Logger.getLogger(AppHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public List<Seat> getSoldSeats(Spectacle s) {
        try {
            return srl.getSoldSeats(s);
        } catch (RemoteException ex) {
            Logger.getLogger(AppHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void setSelectedSeats(List<Seat> seats) {
        try {
            srl.setSelectedSeats(seats);
        } catch (RemoteException ex) {
            Logger.getLogger(AppHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void setSoldSeats(List<Seat> seats) {
        try {
            srl.setSoldSeats(seats);
        } catch (RemoteException ex) {
            Logger.getLogger(AppHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
}
