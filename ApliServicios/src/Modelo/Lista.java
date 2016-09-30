package Modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.LinkedList;

public class Lista 
{
  private LinkedList<Servicio> ListaServicio= new LinkedList<Servicio>();        
  private LinkedList<Cliente> ListaCliente= new LinkedList<Cliente>();
  private LinkedList<Recurso> ListaRecurso= new LinkedList<Recurso>();
  private LinkedList<Obra> ListaObra= new LinkedList<Obra>();
  private LinkedList<Empleado> ListaEmpleado= new LinkedList<Empleado>();
  private LinkedList<Usuario> ListaUsuario= new LinkedList<Usuario>();
  private LinkedList<Vehiculo> ListaVehiculo= new LinkedList<Vehiculo>();
    
  
  public LinkedList<Servicio> getListaServicio() {
        return ListaServicio;
    }

    public LinkedList<Cliente> getListaCliente() {
        return ListaCliente;
    }

    public LinkedList<Recurso> getListaRecurso() {
        return ListaRecurso;
    }

    public LinkedList<Obra> getListaObra() {
        return ListaObra;
    }

    public LinkedList<Empleado> getListaEmpleado() {
        return ListaEmpleado;
    }

    public LinkedList<Usuario> getListaUsuario() {
        return ListaUsuario;
    }
  
   public LinkedList<Vehiculo> getListaVehiculo() {
        return ListaVehiculo;
    }
  
  
  
  public void cargarServicio()
  {
     Servicio servicio=new Servicio();
           
    String Via;
    int Cnt;
    File archivo = null;
    FileReader fr = null;
    BufferedReader br = null;
    boolean respon;

      try {
         // Apertura del fichero y creacion de BufferedReader para poder
         // hacer una lectura comoda (disponer del metodo readLine()).
         //archivo = new File ("C:\\Arbitros.txt");
                           
         Via=System.getProperty("user.dir")+"/src/Archivos/Servicios.txt";   
        
         archivo = new File (Via);
         
         fr = new FileReader (archivo);
         br = new BufferedReader(fr);

         // Lectura del fichero
         String linea;
         
         Cnt=0;
         
         while((linea=br.readLine())!=null)
            {               
              Cnt++;
              
              switch (Cnt)
              {
                  case 1:servicio.setCodServicio(linea);
                         break;
                      
                  case 2:servicio.setDescripcion(linea);
                         ListaServicio.add(servicio);
                         servicio=new Servicio();//resetear                         
                         Cnt=0;
                         break;    
              }                
              
            }
                        
      }
      catch(Exception e){
      }finally{
         // En el finally cerramos el fichero, para asegurarnos
         // que se cierra tanto si todo va bien como si salta 
         // una excepcion.
         try{                    
            if( null != fr ){   
               fr.close();     
            }                  
         }catch (Exception e2){ 
         }
      }    
  }   
  //---------------------------------
  
      public void cargarCliente()
  {
     Cliente cliente=new Cliente();
           
    String Via;
    int Cnt;
    File archivo = null;
    FileReader fr = null;
    BufferedReader br = null;
    boolean respon;

      try {
         // Apertura del fichero y creacion de BufferedReader para poder
         // hacer una lectura comoda (disponer del metodo readLine()).
         //archivo = new File ("C:\\Arbitros.txt");
                           
         Via=System.getProperty("user.dir")+"/src/Archivos/Cliente.txt";   
        
         archivo = new File (Via);
         
         fr = new FileReader (archivo);
         br = new BufferedReader(fr);

         // Lectura del fichero
         String linea;
         
         Cnt=0;
         
         while((linea=br.readLine())!=null)
            {               
              Cnt++;
              
              switch (Cnt)
              {
                  case 1:cliente.setRif(linea);
                         break;
                      
                  case 2:cliente.setRazonSocial(linea);
                         break;
                         
                  case 3:cliente.setDireccion(linea);
                         break;
                       
                  case 4:cliente.setTelefono(linea);
                         ListaCliente.add(cliente);
                         cliente=new Cliente();//resetear                         
                         Cnt=0;
                         break;    
              }                
              
            }
                        
      }
      catch(Exception e){
      }finally{
         // En el finally cerramos el fichero, para asegurarnos
         // que se cierra tanto si todo va bien como si salta 
         // una excepcion.
         try{                    
            if( null != fr ){   
               fr.close();     
            }                  
         }catch (Exception e2){ 
         }
      }      
}
   //---------------------------------
  
   public void cargarRecurso()
  {
     Recurso recurso=new Recurso();
           
    String Via;
    int Cnt;
    File archivo = null;
    FileReader fr = null;
    BufferedReader br = null;
    boolean respon;

      try {
         // Apertura del fichero y creacion de BufferedReader para poder
         // hacer una lectura comoda (disponer del metodo readLine()).
         //archivo = new File ("C:\\Arbitros.txt");
                           
         Via=System.getProperty("user.dir")+"/src/Archivos/Recurso.txt";   
        
         archivo = new File (Via);
         
         fr = new FileReader (archivo);
         br = new BufferedReader(fr);

         // Lectura del fichero
         String linea;
         
         Cnt=0;
         
         while((linea=br.readLine())!=null)
            {               
              Cnt++;
              
              switch (Cnt)
              {
                  case 1:recurso.setCodRecurso(linea);
                         break;
                      
                  case 2:recurso.setDescRecurso(linea);
                         break;
                         
                  case 3:recurso.setTasaRecurso(Cnt);
                         break;
                       
                  case 4:recurso.setUnidMedida(linea);
                         ListaRecurso.add(recurso);
                         recurso=new Recurso();//resetear                         
                         Cnt=0;
                         break;    
              }                
              
            }
                        
      }
      catch(Exception e){
      }finally{
         // En el finally cerramos el fichero, para asegurarnos
         // que se cierra tanto si todo va bien como si salta 
         // una excepcion.
         try{                    
            if( null != fr ){   
               fr.close();     
            }                  
         }catch (Exception e2){ 
         }
      }      
}
  //---------------------------------
   public void cargarObra()
  {
     Obra obra=new Obra();
           
    String Via;
    int Cnt;
    File archivo = null;
    FileReader fr = null;
    BufferedReader br = null;
    boolean respon;

      try {
         // Apertura del fichero y creacion de BufferedReader para poder
         // hacer una lectura comoda (disponer del metodo readLine()).
         //archivo = new File ("C:\\Arbitros.txt");
                           
         Via=System.getProperty("user.dir")+"/src/Archivos/Obra.txt";   
        
         archivo = new File (Via);
         
         fr = new FileReader (archivo);
         br = new BufferedReader(fr);

         // Lectura del fichero
         String linea;
         
         Cnt=0;
         
         while((linea=br.readLine())!=null)
            {               
              Cnt++;
              
              switch (Cnt)
              {
                  case 1:obra.setCodObra(linea);
                         break;
                      
                  case 2:obra.setDescObra(linea);
                         break;
                         
                  case 3:obra.setLugarObra(linea);
                         ListaObra.add(obra);
                         obra=new Obra();//resetear                         
                         Cnt=0;
                         break;    
              }                
              
            }
                        
      }
      catch(Exception e){
      }finally{
         // En el finally cerramos el fichero, para asegurarnos
         // que se cierra tanto si todo va bien como si salta 
         // una excepcion.
         try{                    
            if( null != fr ){   
               fr.close();     
            }                  
         }catch (Exception e2){ 
         }
      }      
}
  
  //---------------------------------
    public void cargarUsuario()
  {
     Usuario usuario=new Usuario();
           
    String Via;
    int Cnt;
    File archivo = null;
    FileReader fr = null;
    BufferedReader br = null;
    boolean respon;

      try {
         // Apertura del fichero y creacion de BufferedReader para poder
         // hacer una lectura comoda (disponer del metodo readLine()).
         //archivo = new File ("C:\\Arbitros.txt");
                           
         Via=System.getProperty("user.dir")+"/src/Archivos/Usuario.txt";   
        
         archivo = new File (Via);
         
         fr = new FileReader (archivo);
         br = new BufferedReader(fr);

         // Lectura del fichero
         String linea;
         
         Cnt=0;
         
         while((linea=br.readLine())!=null)
            {               
              Cnt++;
              
              switch (Cnt)
              {
                  case 1:usuario.setNombreUsuario(linea);
                         break;
                      
                  case 2:usuario.setContrasena(linea);
                         break;
                         
                  case 3:usuario.setNivelAcceso(linea);
                          ListaUsuario.add(usuario);
                          usuario=new Usuario();
                          Cnt=0;
                         break;
  
              }                
              
            }
                        
      }
      catch(Exception e){
      }finally{
         // En el finally cerramos el fichero, para asegurarnos
         // que se cierra tanto si todo va bien como si salta 
         // una excepcion.
         try{                    
            if( null != fr ){   
               fr.close();     
            }                  
         }catch (Exception e2){ 
         }
      }      
}
   //-----
  //--------------------------------- 
      public void cargarEmpleado()
  {
    Empleado emp=new Empleado();
           
    String Via;
    int Cnt;
    File archivo = null;
    FileReader fr = null;
    BufferedReader br = null;
    boolean respon;

      try {
         // Apertura del fichero y creacion de BufferedReader para poder
         // hacer una lectura comoda (disponer del metodo readLine()).
         //archivo = new File ("C:\\Arbitros.txt");
                           
         Via=System.getProperty("user.dir")+"/src/Archivos/Empleado.txt";   
        
         archivo = new File (Via);
         
         fr = new FileReader (archivo);
         br = new BufferedReader(fr);

         // Lectura del fichero
         String linea;
         
         Cnt=0;
         
         while((linea=br.readLine())!=null)
            {               
              Cnt++;
              
              switch (Cnt)
              {
                  case 1:emp.setCedula(linea);
                         break;
                  case 2:emp.setNombre(linea);
                        break;
                  case 3:emp.setApellido(linea);
                        break;
                  case 4:emp.setDireccion(linea);
                        break;
                  case 5:emp.setTelefono(linea);
                        break;
                  case 6:emp.setFechaNacimiento(linea);
                        break;      
                  case 7:emp.setSexo(Via);
                        break;
                  case 8:emp.setFechaInicio(linea); 
                         ListaEmpleado.add(emp);
                         emp=new Empleado();//resetear                         
                         Cnt=0;
                         break;    
              }                
              
            }
                        
      }
      catch(Exception e){
      }finally{
         // En el finally cerramos el fichero, para asegurarnos
         // que se cierra tanto si todo va bien como si salta 
         // una excepcion.
         try{                    
            if( null != fr ){   
               fr.close();     
            }                  
         }catch (Exception e2){ 
         }
      }      
}
   
   //---------------------------------  

    public int ExisteUsuario(String nomUs) 
    {
      Integer Posi;
      Usuario usu= new Usuario();
      String nomLista;
  
  for (Posi=0;Posi< ListaUsuario.size();Posi++)
     {
     usu=ListaUsuario.get(Posi);
     nomLista=usu.getNombreUsuario();
     
     if (nomLista.equals(nomUs))
        return Posi;
     }
   return -1;
    }
//----------------------------------------
   
    public void cargarVehiculo()
  {
    Vehiculo veh=new Vehiculo();
           
    String Via;
    int Cnt;
    File archivo = null;
    FileReader fr = null;
    BufferedReader br = null;
    boolean respon;

      try {
         // Apertura del fichero y creacion de BufferedReader para poder
         // hacer una lectura comoda (disponer del metodo readLine()).
         //archivo = new File ("C:\\Arbitros.txt");
                           
         Via=System.getProperty("user.dir")+"/src/Archivos/Vehiculo.txt";   
        
         archivo = new File (Via);
         
         fr = new FileReader (archivo);
         br = new BufferedReader(fr);

         // Lectura del fichero
         String linea;
         
         Cnt=0;
         
         while((linea=br.readLine())!=null)
            {               
              Cnt++;
              
              switch (Cnt)
              {
                  case 1:veh.setMarca(linea);
                         break;
                  case 2:veh.setModelo(linea);
                        break;
                  case 3:veh.setPlaca(linea);
                        break;
                  
                  case 4:veh.setCapacidad(linea); 
                         ListaVehiculo.add(veh);
                         veh=new Vehiculo();//resetear                         
                         Cnt=0;
                         break;    
              }                
              
            }
                        
      }
      catch(Exception e){
      }finally{
         // En el finally cerramos el fichero, para asegurarnos
         // que se cierra tanto si todo va bien como si salta 
         // una excepcion.
         try{                    
            if( null != fr ){   
               fr.close();     
            }                  
         }catch (Exception e2){ 
         }
      }      
}
   public int BuscarEmpleado(String C)
    {
        int posi;
        Empleado emp = new Empleado();
        String ced;
        
        for(posi = 0;posi<ListaEmpleado.size();posi++)
        {
            emp = ListaEmpleado.get(posi);
            ced= emp.getCedula();
            if(ced.equals(C))
                return posi;
        }
        return -1;
    }
}

 

 

   