
import java.io.DataInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;

 
public class ReceiveMessage extends Thread {    
    String msg="";
    DataInputStream dis = null;
    public JTextArea txt_area = null;
    
   public ReceiveMessage(DataInputStream d, JTextArea a){
       this.dis = d;
       this.txt_area = a; 
   }
    public void run()
   {
       while(true)
       {
           try {
               
               msg = dis.readUTF();
               String str = txt_area.getText();
               if(str==""){
                    txt_area.append("" + this.getName() + " : " + msg);
               }
               else
                   txt_area.append("\n" + this.getName() + " : " + msg);
               //this.txt_area.append("\n" + this.getName() + ":" + msg);
           } catch (IOException ex) {
               Logger.getLogger(ReceiveMessage.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
   }    
}
