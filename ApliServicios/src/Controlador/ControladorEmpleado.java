
package Controlador;

import Vista.JFrameEmpleado;
import Vista.JFrameRecurso;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ControladorEmpleado implements ActionListener,KeyListener
{

    private JFrameEmpleado formEmpleado;
    public ControladorEmpleado() 
    {
         formEmpleado = new JFrameEmpleado();
        formEmpleado.agregarListener(this);
        formEmpleado.setVisible(true);
        
        formEmpleado.getTxtApellidos().addKeyListener(new KeyAdapter()
         {        
            @Override
            public void keyTyped (KeyEvent e)
              {     
                 ValidarTxt(e,14,formEmpleado.getTxtApellidos().getText()); 
               }
            //-----------
            @Override
            public void keyPressed (KeyEvent e)
              {     
                 //CodigokeyPressed(e); 
              }
         }
       );
        formEmpleado.getTxtCedula().addKeyListener(new KeyAdapter()
         {        
            @Override
            public void keyTyped (KeyEvent e)
              {     
                 ValidarTxtNum(e,7,formEmpleado.getTxtCedula().getText()); 
               }
            //-----------
            @Override
            public void keyPressed (KeyEvent e)
              {     
                 //CodigokeyPressed(e); 
              }
         }
       );
        
            formEmpleado.getTxtDireccion().addKeyListener(new KeyAdapter()
         {        
            @Override
            public void keyTyped (KeyEvent e)
              {     
                 ValidarTxt(e,49,formEmpleado.getTxtDireccion().getText()); 
               }
            //-----------
            @Override
            public void keyPressed (KeyEvent e)
              {     
                 //CodigokeyPressed(e); 
              }
         }
       );
            
        formEmpleado.getTxtNombre().addKeyListener(new KeyAdapter()
         {        
            @Override
            public void keyTyped (KeyEvent e)
              {     
                 ValidarTxt(e,14,formEmpleado.getTxtNombre().getText()); 
               }
            //-----------
            @Override
            public void keyPressed (KeyEvent e)
              {     
                 //CodigokeyPressed(e); 
              }
         }
       );
    
    }

    //-----------Validaciones---------------------
    
    private void ValidarTxt(KeyEvent e,int largo,String txt) 
    {
        if (txt.length()>largo){
            e.consume();
        }
    }
    
        private void ValidarTxtNum(KeyEvent e,int largo,String txt) 
    {
        if (txt.length()>largo){
            e.consume();
            return;
    }
    char Digito;
    Digito=e.getKeyChar();
    if (Digito<'0' || Digito >'9')
    e.consume();
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) 
    {
        if(ae.getSource().equals(formEmpleado.getBtnCancelar()))
        {
            Limpiar();
            Deshabilitar();
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

    private void Limpiar() 
    {
      formEmpleado.getTxtApellidos().setText("");
      formEmpleado.getTxtCedula().setText("");
      formEmpleado.getTxtDireccion().setText("");
      formEmpleado.getTxtFechaIng().setText("");
      formEmpleado.getTxtFechaNac().setText("");
      formEmpleado.getTxtNombre().setText("");
      formEmpleado.getTxtTlf().setText("");
      formEmpleado.getcmbCargo().setSelectedIndex(0);
      formEmpleado.getCmbSexo().setSelectedIndex(0);
      formEmpleado.getCmbNacionalidad().setSelectedIndex(0);
      
    }

    private void Deshabilitar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
