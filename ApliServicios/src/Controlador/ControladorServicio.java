
package Controlador;


import Librerias.Validaciones;
import Modelo.Servicio;
import Modelo.Lista;
import Vista.JFrameServicio;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class ControladorServicio implements ActionListener
{
     private final JFrameServicio formServicio;
     private final Lista ListaServicio;

     @SuppressWarnings("LeakingThisInConstructor")
    public ControladorServicio()
    {
        ListaServicio= new Lista();
        formServicio = new JFrameServicio();
        formServicio.agregarListener(this);
        formServicio.setVisible(true);
        
         formServicio.getTxtCodServicio().addKeyListener(new KeyAdapter()
      {        
            @Override
            public void keyTyped (KeyEvent e)
              {     
                ValidarTxt(e,6,formServicio.getTxtCodServicio().getText()); 
               
               }
                 
            @Override
            public void keyPressed(KeyEvent e) 
              {             
              }

       }
    );          
     //----------------------------------------
    formServicio.getTxtDescServicio().addKeyListener(new KeyAdapter()
      {        
            @Override
            public void keyTyped (KeyEvent e)
              {     
                ValidarTxt(e,11,formServicio.getTxtDescServicio().getText()); 
                 ValidarSoloLetras(e);
              }
                 
       }
      );       
    
     
          
 }      
     
//-------------------Botones de servicios------------------
    private void Limpiar()
{ 
    formServicio.getTxtCodServicio().setText("");
    formServicio.getTxtDescServicio().setText("");
}
 private void Grabar()
 {
       Servicio servicio;
      int existe;
      String Cadena, codServicio, descripcion;
              
      Cadena=formServicio.getTxtCodServicio().getText().trim();
  
    if (Cadena.length()==0)
     {
       Validaciones.Aviso("Codigo de servicio Vacia", ""); 
       formServicio.getTxtCodServicio().requestFocusInWindow();
       return;
     }  
     
      Cadena=formServicio.getTxtDescServicio().getText().trim();
    
    if (Cadena.length()==0)
     {
       Validaciones.Aviso("Descripcion de servicio Vacio", ""); 
       formServicio.getTxtDescServicio().requestFocusInWindow();
       return;
     }  
 
    
     
    //------------------
    codServicio= (String)formServicio.getTxtCodServicio().getText();
    existe=ListaServicio.existeServicio(Cadena);
       
    if (existe ==-1)
    { 
        descripcion=(String)formServicio.getTxtDescServicio().getText();
        servicio= new Servicio(codServicio,
                               descripcion);
        
        ListaServicio.getListaServicio().add(servicio);
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
          if (e.getSource().equals(formServicio.getBtnCancelar()))  
      {  
        Limpiar();  
      } 
           if (e.getSource().equals(formServicio.getBtnRegresar()))  
      {  
        formServicio.dispose();
      }
             if (e.getSource().equals(formServicio.getBtnGrabar()))  
      {  
        Grabar();
      }
    }


}
