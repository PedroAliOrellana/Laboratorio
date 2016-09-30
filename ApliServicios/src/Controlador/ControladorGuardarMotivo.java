
package Controlador;

import Librerias.Validaciones;
import Modelo.Lista;
import Modelo.Motivo;
import Vista.JFrameGuardarMotivo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ControladorGuardarMotivo implements ActionListener
{
    private JFrameGuardarMotivo formMotivo;
    private Lista ListaMotivo;  
    
     
public ControladorGuardarMotivo(Lista lisMo)
        
{       ListaMotivo= lisMo;
        formMotivo = new JFrameGuardarMotivo();
        formMotivo.agregarListener(this);
        formMotivo.setVisible(true);
        
          formMotivo.getTxtCodigo().addKeyListener(new KeyAdapter()
      {        
            @Override
            public void keyTyped (KeyEvent e)
              {     
                ValidarTxt(e,4,formMotivo.getTxtCodigo().getText()); 
               
               }
                 
            @Override
            public void keyPressed(KeyEvent e) 
              {             
              }

       }
    );          
     //----------------------------------------
    formMotivo.getTxtDesc().addKeyListener(new KeyAdapter()
      {        
            @Override
            public void keyTyped (KeyEvent e)
              {     
                ValidarTxt(e,11,formMotivo.getTxtDesc().getText()); 
                 ValidarSoloLetras(e);
              }
                 
       }
      );
    

}

//-------Botones-------------------------
   public void Limpiar()
   {
     formMotivo.getTxtCodigo().setText("");
     formMotivo.getTxtDesc().setText("");
  
   }
public void Grabar()

{
       Motivo  motivo;
      int existe;
      String Cadena, codMotivo, descMotivo;
              
      Cadena=formMotivo.getTxtCodigo().getText().trim();
  
    if (Cadena.length()==0)
     {
       Validaciones.Aviso("Codigo de Motivo Vacia", ""); 
       formMotivo.getTxtCodigo().requestFocusInWindow();
       return;
     }  
     
      Cadena=formMotivo.getTxtDesc().getText().trim();
    
    if (Cadena.length()==0)
     {
       Validaciones.Aviso("Descripcion de servicio Vacio", ""); 
       formMotivo.getTxtDesc().requestFocusInWindow();
       return;
     }  
 
    
     
    //------------------
    codMotivo= (String)formMotivo.getTxtCodigo().getText();
    existe=ListaMotivo.BuscarServicio(Cadena);
       
    if (existe ==-1)
    { 
        descMotivo=(String)formMotivo.getTxtDesc().getText();
        motivo= new Motivo(codMotivo,
                               descMotivo);
        
      ListaMotivo.getListaMotivo().add(motivo );
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
          if (e.getSource().equals(formMotivo.getBtnCancelar()))  
      {  
        Limpiar();  
      } 
       if (e.getSource().equals(formMotivo.getBtnRegresar()))  
      {  
        formMotivo.dispose();
      }
          if (e.getSource().equals(formMotivo.getBtnGuardar()))  
      {  
        Grabar();
       }
}
}