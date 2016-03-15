package SRL;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 * Created by MiguelAngel on 15/03/2016.
 */
public interface IRemoteClient extends Remote {

    public List<Seat> getSelectedSeats(Spectacle s) throws RemoteException;

    public List<Seat> getPreSoldSeats(Spectacle s) throws RemoteException;

}
