package Controlador;

import Librerias.Validaciones;
import Modelo.Lista;
import Modelo.Usuario;
import Vista.JFrameUsuario;
import static com.sun.javafx.tk.Toolkit.getToolkit;
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
                ValidarTxt(e,14,formUsuario.getTxtNombreUsuario().getText()); 
                ValidarSoloLetras(e);
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
                ValidarTxt(e,11,formUsuario.getTxtPasw().getText());  
              }
                 
       }
      );       
    
        formUsuario.getTxtConfPasw().addKeyListener(new KeyAdapter()
      {        
            @Override
            public void keyTyped (KeyEvent e)
              {     
                ValidarTxt(e,11,formUsuario.getTxtConfPasw().getText()); 
               }
                 
       }
      ); 
          
    }

    //------------zona de los botones-------------------------
  
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
    
    /*if (Cadena.length()==0)
     {
       Validaciones.Aviso("Nivel de Acceso Vacio", "");   
       formUsuario.getCmbNivelA().requestFocusInWindow();
       return;
     }  
    */
     
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
