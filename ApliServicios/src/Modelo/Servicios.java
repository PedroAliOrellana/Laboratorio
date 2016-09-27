package Modelo;

public class Servicios 
{
   private String codServicio;
   private String descripcion;

   

 public Servicios() 
   {
        this.codServicio = "";
        this.descripcion = "";
    }
//-------------------------------   
   public Servicios(String codServicio, 
                    String descripcion) 
   {
        this.codServicio = codServicio;
        this.descripcion = descripcion;
    }
//------------------------------
    public String getCodServicio() 
    {
        return codServicio;
    }
//-----------------------------------
    public void setCodServicio(String codServicio) 
    {
        this.codServicio = codServicio;
    }
//-----------------------------------
    public String getDescripcion() 
    {
        return descripcion;
    }
//-----------------------------------
    public void setDescripcion(String descripcion) 
    {
        this.descripcion = descripcion;
    }
   
   
}
