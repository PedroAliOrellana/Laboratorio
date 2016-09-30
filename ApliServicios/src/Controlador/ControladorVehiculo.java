
package Controlador;

import Librerias.Validaciones;
import Modelo.Lista;
import Modelo.Usuario;
import Modelo.Vehiculo;
import Vista.JFrameVehiculo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ControladorVehiculo implements ActionListener,KeyListener
{
    private JFrameVehiculo formVehiculo;
    private Lista ListaVehiculo;

    public ControladorVehiculo(Lista lisV) 
    {
        ListaVehiculo = lisV;
        formVehiculo = new JFrameVehiculo();
        formVehiculo.agregarListener(this);
        formVehiculo.setVisible(true);
            formVehiculo.getBtnCancelar1().setVisible(true);
            formVehiculo.getBtnEliminar().setVisible(true);
            formVehiculo.getBtnModificar().setVisible(true);
            formVehiculo.getBtnGrabar().setVisible(true);
            formVehiculo.getBtnConsultar().setVisible(true);
            formVehiculo.getBtnRegresar().setVisible(true);
     
                //Zona de los KeyListener
             formVehiculo.getTxtMarca().addKeyListener(new KeyAdapter()
      {        
            @Override
            public void keyTyped (KeyEvent e)
              {     
                ValidarTxt(e,10,formVehiculo.getTxtMarca().getText()); 
                ValidarSoloLetras(e);
               }
                 
            @Override
            public void keyPressed(KeyEvent e) 
              {             
              }

       }
    ); 
       
          formVehiculo.getTxtModelo().addKeyListener(new KeyAdapter()
      {        
            @Override
            public void keyTyped (KeyEvent e)
              {     
               ValidarTxt(e,10,formVehiculo.getTxtModelo().getText()); 
                ValidarSoloLetras(e);
               }
                 
            @Override
            public void keyPressed(KeyEvent e) 
               {   
              }
       }
      );  
          
          formVehiculo.getTxtPlaca().addKeyListener(new KeyAdapter()
      {        
            @Override
            public void keyTyped (KeyEvent e)
              {     
               ValidarTxt(e,10,formVehiculo.getTxtPlaca().getText()); 
                ValidarSoloLetras(e);
               }
                 
            @Override
            public void keyPressed(KeyEvent e) 
               {   
              }
       }
      );     
        
         formVehiculo.getTxtCapacidad().addKeyListener(new KeyAdapter()
      {        
            @Override
            public void keyTyped (KeyEvent e)
              {     
               ValidarTxtNum(e,1,formVehiculo.getTxtCapacidad().getText()); 
               
               }
                 
            @Override
            public void keyPressed(KeyEvent e) 
               {   
              }
       }
      ); 
         
         
    }

    
   //---------------------------------
    
     private void Limpiar()    
{
  formVehiculo.getTxtMarca().setText("");  
  formVehiculo.getTxtCapacidad().setText("");
  formVehiculo.getTxtModelo().setText("");
  formVehiculo.getTxtPlaca().setText("");
  
}
  
  private void Grabar()
  {
      Vehiculo vehiculo;
      int existe;
      String Cadena, Marca, Modelo, Placa, Capacidad;
    
      Cadena=formVehiculo.getTxtPlaca().getText().trim();
    
    if (Cadena.length()==0)
     {
       Validaciones.Aviso("Indique la Placa", "");   
       formVehiculo.getTxtPlaca().requestFocusInWindow();
       return;
     }  
    Cadena=formVehiculo.getTxtMarca().getText().trim();
    
    if (Cadena.length()==0)
     {
       Validaciones.Aviso("Indique la Marca", "");   
       formVehiculo.getTxtMarca().requestFocusInWindow();
       return;
     }  
    
    Cadena=formVehiculo.getTxtCapacidad().getText().trim();
    if (Cadena.length()==0)
     {
       Validaciones.Aviso("Indique la Capacidad", "");   
       formVehiculo.getTxtCapacidad().requestFocusInWindow();
       return;
     }  
  
    
    Cadena=formVehiculo.getTxtModelo().getText().trim();
    
    if (Cadena.length()==0)
     {
       Validaciones.Aviso("Indique el Modelo", "");   
       formVehiculo.getTxtModelo().requestFocusInWindow();
       return;
     }    
   
   
     
    //------------------
    Marca= (String)formVehiculo.getTxtMarca().getText();
    existe=ListaVehiculo.ExisteUsuario(Cadena);
    
    if (existe ==-1)
    { 
        
        Marca=(String)formVehiculo.getTxtMarca().getText();
        Modelo = (String)formVehiculo.getTxtModelo().getText();
        Placa = (String)formVehiculo.getTxtPlaca().getText();
        Capacidad = (String)formVehiculo.getTxtCapacidad().getText(); 
        
                     vehiculo = new Vehiculo(    Placa,
                                                 Modelo,
                                                 Capacidad,
                                                 Marca);

        ListaVehiculo.getListaVehiculo().add(vehiculo);
        Validaciones.Confirmacion("Guardado con éxito", "");
        Limpiar();
    }
    else 
    {
        Validaciones.Aviso("No puede guardar, YA ESTA REGISTRADO", "");
        return;
    } 
  }
  

    
     //-----------Validaciones---------------------
    
    private void ValidarTxt(KeyEvent e,int largo,String txt) 
    {
        if (txt.length()>largo){
            e.consume();
        }
    
    }
    
    private void ValidarSoloLetras(KeyEvent e)
    {
        Character s= e.getKeyChar();
        if (!Character.isLetter(s))
            e.consume();
    }
        
    
        private void ValidarTxtNum(KeyEvent e,int largo,String txt) 
    {
        if (txt.length()>largo)
        {
            e.consume();
            return;
        }
        
        char Digito; 
        Digito=e.getKeyChar();
        
        if (Digito<'0' || Digito >'9')
            e.consume();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if (e.getSource().equals(formVehiculo.getBtnCancelar1()))  
      {  
        Limpiar();  
      }   
        if (e.getSource().equals(formVehiculo.getBtnRegresar()))  
      {  
        formVehiculo.dispose();
      }
        if (e.getSource().equals(formVehiculo.getBtnGrabar()))  
      {  
        Grabar();
      }
        
    }

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

   