
package Controlador;


import Vista.JFrameServicio;

import Util.Rutinas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControladorServicio implements ActionListener
{
     private JFrameServicio formServicio;

     @SuppressWarnings("LeakingThisInConstructor")
    public ControladorServicio()
    {
        formServicio = new JFrameServicio();
        formServicio.agregarListener(this);
        formServicio.setVisible(true);
        
     
        //Zona de los KeyListener
        formServicio.getTxtCodServicio().addKeyListener(new KeyAdapter()
      {        
            @Override
            public void keyTyped (KeyEvent e)
              {     
                CodServicioKeyTyped(e); 
               }
                 
            @Override
            public void keyPressed(KeyEvent e) 
               {             
              }

            private void CodServicioKeyTyped(KeyEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
       }
    );          
     //----------------------------------------
    
   formServicio.getTxtDescServicio().addKeyListener(new KeyAdapter()
      {        
            @Override
            public void keyTyped (KeyEvent e)
              {     
                DescServicioKeyTyped(e); 
               }
                 
       }
      );          
          
   
    }
   
//-------------------------------------
private void CodServicioKeyTyped(KeyEvent e)
{
  String Cadena;
  Cadena=formServicio.getTxtCodServicio().getText();
  Cadena=Cadena.trim();
  
  if (Cadena.length()==5)
   {
     e.consume();   
   }   
}        
//-------------------------------------
private void DescServicioKeyTyped(KeyEvent e)
{
  String Cadena;
  Cadena=formServicio.getTxtDescServicio().getText();
  Cadena=Cadena.trim();
  
  if (Cadena.length()==30)
   {
     e.consume();   
   }   
    
}        
//-------------------------------------

    @Override
    public void actionPerformed(ActionEvent ae) 
    {
    }


}
