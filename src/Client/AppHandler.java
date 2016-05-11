/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import SRL.IRemoteSRL;
import SRL.Spectacle;
import UI.MainView;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
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
            this.registry = LocateRegistry.getRegistry("192.168.228.233", 1098);
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
    
    public List<Spectacle> getSpectacleList(){
        try {
            return srl.readSpectacles();
        } catch (RemoteException ex) {
            Logger.getLogger(AppHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    } 

    
    
}
