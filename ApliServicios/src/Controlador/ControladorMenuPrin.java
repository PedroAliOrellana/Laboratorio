package Controlador;

import Modelo.Lista;
import Vista.JFrameMenuPrin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ControladorMenuPrin implements ActionListener
{
   private JFrameMenuPrin formMenuPrin;    
   private Lista lisEmpreServicios;
           
    public ControladorMenuPrin() 
    {
        lisEmpreServicios=new Lista();        
        lisEmpreServicios.cargarServicio();        
        lisEmpreServicios.cargarCliente();
        lisEmpreServicios.cargarRecurso();
        
        formMenuPrin = new JFrameMenuPrin();
        formMenuPrin.agregarListener(this);
        formMenuPrin.setVisible(true);
        
    }

//---------------------------------------    
    @Override
    public void actionPerformed(ActionEvent e) 
    {
      if (e.getSource().equals(formMenuPrin.getjMenuItemObras()))  
      {
          new ControladorObras(); 
      }  
      //-------------------------------------
      if (e.getSource().equals(formMenuPrin.getjMenuItemClientes()))  
      {
         System.out.println("Esta en cliente"); 
      } 
      //---------------------------------
      if (e.getSource().equals( formMenuPrin.getjMenuItemServicio()))
      {
         new ControladorServicio();
      }
      if(e.getSource().equals(formMenuPrin.getjMenuItemRecursos()))
      {
          new ControladorRecurso();
      }
      if(e.getSource().equals(formMenuPrin.getjMenuItemUsuario()))
      {
          new ControladorUsuario();
      }
    }

  
}
