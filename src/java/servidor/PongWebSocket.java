package servidor;

import java.io.IOException;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
/**
 *
 * @author valeria
 */
@ServerEndpoint("/pong")
public class PongWebSocket {
    private int jogador = 0;

    @OnOpen
    public void OnOpen(Session session) {
        ++jogador;
        
        System.out.println(session.getId() + "has opened a connection" + jogador);
        try {
            session.getBasicRemote().sendText("Connection Established");
        } catch (IOException ex) {
            System.out.println(ex);

        }
        
    }

    @OnMessage
    public void OnMessage(String message,Session session) {
      System.out.println("Message from "+session.getId()+":"+message);
       try{
          session.getBasicRemote().sendText(message);
       }catch(IOException ex){
           System.out.println(ex);
       }
    }

    @OnClose
    public void OnClose(Session session) {

    }

}
