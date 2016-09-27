
package Modelo;


public class Vehiculo 
{
    private String Placa;
    private String Modelo;
    private int Cantidad;
    private String Marca;

    public Vehiculo() 
    {
        Placa = "";
        Modelo = "";
        Cantidad =0;
        Marca = "";
    }

    
    public Vehiculo(String Placa, String Modelo, int Cantidad, String Marca) 
    {
        this.Placa = Placa;
        this.Modelo = Modelo;
        this.Cantidad = Cantidad;
        this.Marca = Marca;
    }

    
    
    
    public String getPlaca() 
    {
        return Placa;
    }

    public void setPlaca(String Placa) 
    {
        this.Placa = Placa;
    }

    public String getModelo()
    {
        return Modelo;
    }

    public void setModelo(String Modelo) 
    {
        this.Modelo = Modelo;
    }

    public int getCantidad() 
    {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) 
    {
        this.Cantidad = Cantidad;
    }

    public String getMarca() 
    {
        return Marca;
    }

    public void setMarca(String Marca) 
    {
        this.Marca = Marca;
    }
}
