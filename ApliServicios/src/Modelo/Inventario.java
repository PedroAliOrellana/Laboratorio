package Modelo;

public class Inventario 
{
    private String codInv;
    private String descInv;

    public Inventario(String codInv, String descInv)
    {
        this.codInv = codInv;
        this.descInv = descInv;
    }
    
        public Inventario()
    {
        codInv = "";
        descInv = "";
    }

    public String getCodInv()
    {
        return codInv;
    }

    public void setCodInv(String codInv) 
    {
        this.codInv = codInv;
    }

    public String getDescInv() 
    {
        return descInv;
    }

    public void setDescInv(String descInv)
    {
        this.descInv = descInv;
    }
    
    
}
