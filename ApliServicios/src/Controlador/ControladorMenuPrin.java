package Controlador;

import Modelo.Lista;
import Vista.JFrameMenuPrin;
import com.sun.xml.internal.bind.v2.runtime.reflect.Lister;
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
        lisEmpreServicios.cargarEmpleado();
        
        formMenuPrin = new JFrameMenuPrin();
        formMenuPrin.agregarListener(this);
        formMenuPrin.setVisible(true);
        
    }

//-----------------Espacio de los eventos de los Menu----------------------    
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
      //-------------------------------------
      if (e.getSource().equals( formMenuPrin.getjMenuItemServicio()))
      {
         new ControladorServicio();
      }
      if(e.getSource().equals(formMenuPrin.getjMenuItemRecursos()))
      {
          new ControladorRecurso();
      }
       if(e.getSource().equals(formMenuPrin.getjMenuItemEmpleado()))
      {
          new ControladorEmpleado(lisEmpreServicios);
      }
       if(e.getSource().equals(formMenuPrin.getjMenuItemUsuario()))
      {
          new ControladorUsuario();
      }
    }

  
}
