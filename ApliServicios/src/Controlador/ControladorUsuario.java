package Controlador;

import Librerias.Validaciones;
import Modelo.Lista;
import Modelo.Usuario;
import Vista.JFrameUsuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class ControladorUsuario implements ActionListener
{
    private JFrameUsuario formUsuario;
    private Lista ListaUsuario;

    public ControladorUsuario() 
    {
        formUsuario = new JFrameUsuario();
        formUsuario.agregarListener(this);
        formUsuario.setVisible(true);
        
            formUsuario.getTxtNombreUsuario().addKeyListener(new KeyAdapter()
      {        
            @Override
            public void keyTyped (KeyEvent e)
              {     
                NombreUsuarioKeyTyped(e); 
                ValidaNombreUsuario(e);
               }
                 
            @Override
            public void keyPressed(KeyEvent e) 
               {             
              }

       }
    );          
     //----------------------------------------
    formUsuario.getTxtPasw().addKeyListener(new KeyAdapter()
      {        
            @Override
            public void keyTyped (KeyEvent e)
              {     
                PaswKeyTyped(e); 
               }
                 
       }
      );       
    
        formUsuario.getTxtConfPasw().addKeyListener(new KeyAdapter()
      {        
            @Override
            public void keyTyped (KeyEvent e)
              {     
                ConfPaswKeyTyped(e); 
               }
                 
       }
      ); 
          
    }

    //-------------------------------------
private void NombreUsuarioKeyTyped(KeyEvent e)
{
  String Cadena;
  Cadena=formUsuario.getTxtNombreUsuario().getText();
  Cadena=Cadena.trim();
  
  if (Cadena.length()==15)
   {
     e.consume();   
   }  
  
}        
//-------------------------------------
private void PaswKeyTyped(KeyEvent e)
{
  String Cadena;
  Cadena=formUsuario.getTxtPasw().getText();
  Cadena=Cadena.trim();
  
  if (Cadena.length()==12)
   {
     e.consume();   
   }   
    
}      
    
 //-------------------------------------
private void ConfPaswKeyTyped(KeyEvent e)
{
  String Cadena;
  Cadena=formUsuario.getTxtConfPasw().getText();
  Cadena=Cadena.trim();
  
  if (Cadena.length()==12)
   {
     e.consume();   
   }   
    
}    
  private void Limpiar()    
{
  formUsuario.getTxtConfPasw().setText("");  
  formUsuario.getTxtPasw().setText("");
  formUsuario.getTxtNombreUsuario().setText("");
  formUsuario.getCmbNivelA().setSelectedIndex(0);
  
}
  
  private void Grabar()
  {
      Usuario usuario;
      int existe;
      String Cadena, NombreUsuario, NivelAcceso, Contrasena;
   
   Cadena=formUsuario.getTxtNombreUsuario().getText().trim();
    
    if (Cadena.length()==0)
     {
       Validaciones.Aviso("Nombre Usuario Vacio", "");   
       formUsuario.getTxtNombreUsuario().requestFocusInWindow();
       return;
     }  
   
   Cadena=formUsuario.getTxtPasw().getText().trim();
    
    if (Cadena.length()==0)
     {
       Validaciones.Aviso("Contraseña Vacia", "");   
       formUsuario.getTxtPasw().requestFocusInWindow();
       return;
     }  
    
    Cadena=formUsuario.getTxtConfPasw().getText().trim();
    
    if (Cadena.length()==0)
     {
       Validaciones.Aviso("Confirmar contraseña Vacio", "");   
       formUsuario.getTxtConfPasw().requestFocusInWindow();
       return;
     }  
    
    
    if (!Cadena.equals(formUsuario.getTxtPasw().getText().trim()))
     {
       Validaciones.Aviso("Contraseñas direfentes", "");   
       formUsuario.getTxtPasw().requestFocusInWindow();
       return;
     }  

    Cadena=(String)formUsuario.getCmbNivelA().getSelectedItem();
    
    if (Cadena.length()==0)
     {
       Validaciones.Aviso("Nivel de Acceso Vacio", "");   
       formUsuario.getCmbNivelA().requestFocusInWindow();
       return;
     }  
    
     
    //------------------
    NombreUsuario= (String)formUsuario.getTxtNombreUsuario().getText();
    existe=ListaUsuario.ExisteUsuario(Cadena);
    
    if (existe ==-1)
    { 
        
        NivelAcceso=(String)formUsuario.getCmbNivelA().getSelectedItem();
        Contrasena = (String)formUsuario.getTxtPasw().getText();
        
        usuario = new Usuario(NombreUsuario,
                               Contrasena,
                               NivelAcceso);

        ListaUsuario.getListaUsuario().add(usuario);
        Limpiar();
    }
    else 
    {
        Validaciones.Aviso("No puede guardar, YA ESTA REGISTRADO", "");
        return;
    } 
  }
  
  
   private void ValidaNombreUsuario(KeyEvent e) 
 {
     String cadena = String.valueOf(e.getKeyChar());
     
     if(!(cadena.matches("[a-zA-Z]")) && e.getKeyChar()==0)
     {
        e.consume();
     }        
 }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if (e.getSource().equals(formUsuario.getBtnCancelar()))  
      {  
        Limpiar();  
      }   
        if (e.getSource().equals(formUsuario.getBtnRegresar()))  
      {  
        formUsuario.dispose();
      }
        if (e.getSource().equals(formUsuario.getBtnGrabar()))  
      {  
        Grabar();
      }
        
    }
    
}
