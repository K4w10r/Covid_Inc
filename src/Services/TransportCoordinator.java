package Services;

import Models.Transport;

import java.util.List;

public class TransportCoordinator implements Runnable{

    private static List<Transport> transportList = Transport.extent;
    private boolean stop;

    @Override
    public void run() {
        while(!stop){
            for(Transport transport : transportList){
                transport.move();
                System.out.println("moving");
            }
            try{
                Thread.sleep(5000);
            }catch(InterruptedException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void stop(){
        this.stop = true;
    }

    public TransportCoordinator(){
        stop = false;
    }
}
