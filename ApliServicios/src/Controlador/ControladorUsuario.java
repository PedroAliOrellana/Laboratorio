package Controlador;

import Modelo.Lista;
import Modelo.Usuario;
import Vista.JFrameUsuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ControladorUsuario implements ActionListener,KeyListener
{
    private JFrameUsuario formUsuario;
    private Lista ListaUsuario;

    public ControladorUsuario(Lista lisUs) 
    {
        ListaUsuario = lisUs;
        formUsuario = new JFrameUsuario();
        formUsuario.agregarListener(this);
        formUsuario.setVisible(true);
            formUsuario.getBtnModificar().setVisible(false);
            formUsuario.getBtnBorrar().setVisible(false);
            formUsuario.getBtnActualizarCont().setVisible(false);
        cargarUsuario();
                //Zona de los KeyListener
        formUsuario.getTxtBuscar().addKeyListener(new KeyAdapter()
      {        
            @Override
            public void keyTyped (KeyEvent e)
              {     
                ValidarTxt(e,15,formUsuario.getTxtBuscar().getText());
                ValidarSoloLetras(e);
               }
                 
            @Override
            public void keyPressed(KeyEvent e) 
               {             
              }
       }
                
              
    ); 
        
          formUsuario.getTUsuario().addKeyListener(new KeyAdapter()
      {        
            @Override
            public void keyTyped (KeyEvent e)
              {     
                ActivarBotones();
               }
                 
            @Override
            public void keyPressed(KeyEvent e) 
               {   
                   ActivarBotones();
              }
       }
      );    
        
    }

    
    //-----------Validaciones---------------------
    
    private void ActivarBotones()
    {
        if (formUsuario.getTUsuario().getSelectedRow()>1)
        {
            formUsuario.getBtnModificar().setVisible(true);
            formUsuario.getBtnBorrar().setVisible(true);
            formUsuario.getBtnActualizarCont().setVisible(true);
        }
    }
    
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
        

    @Override
    public void actionPerformed(ActionEvent e) 
    {
         if (e.getSource().equals(formUsuario.getBtnNuevo()))  
      {  
        new ControladorGuardarUsuario();  
      }   
        if (e.getSource().equals(formUsuario.getBtnRegresar()))  
      {  
        formUsuario.dispose();
      }
        if (e.getSource().equals(formUsuario.getBtnModificar()))  
      {  
        new ControladorGuardarUsuario();
      }
    }

    @Override
    public void keyTyped(KeyEvent ke)
    {
       
    }

    @Override
    public void keyPressed(KeyEvent ke)
    {
        
    }

    @Override
    public void keyReleased(KeyEvent ke)
    {
        
    }

    private void cargarUsuario()
    {
         int Fila;  
         Usuario us=new Usuario();
  
    for (Fila=0;Fila<ListaUsuario.getListaUsuario().size();Fila++)
        {
        us=ListaUsuario.getListaUsuario().get(Fila);
        formUsuario.getTUsuario().setValueAt(us.getNombreUsuario(), Fila,0);
        formUsuario.getTUsuario().setValueAt(us.getNivelAcceso(), Fila,1);    
        }
    }
    
    
    
}
