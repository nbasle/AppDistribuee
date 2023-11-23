
import java.rmi.Naming;

public class Client {

    // Point d'entr�e de la classe cliente
    public static void main(String[] args) {
        try {
            HelloPetstoreServerRemote server;
            // La classe obtient un stub
            server = (HelloPetstoreServerRemote) Naming.lookup("HelloPetstore");

            // Appelle la methode distante et affiche le r�sultat
            System.out.println(server.hello());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
