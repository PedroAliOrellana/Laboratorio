package Modelo;

public class Obra
{
    private String codObra;
    private String descObra;
    private String lugarObra;

    public Obra(String codObra, String descObra, String lugarObra) 
    {
        this.codObra = codObra;
        this.descObra = descObra;
        this.lugarObra = lugarObra;
    }

        public Obra()
    {
        codObra = "";
        descObra = "";
        lugarObra = "";
    }
    
    
    public String getCodObra()
    {
        return codObra;
    }

    public void setCodObra(String codObra)
    {
        this.codObra = codObra;
    }

    public String getDescObra() 
    {
        return descObra;
    }

    public void setDescObra(String descObra)
    {
        this.descObra = descObra;
    }

    public String getLugarObra()
    {
        return lugarObra;
    }

    public void setLugarObra(String lugarObra)
    {
        this.lugarObra = lugarObra;
    }  
    
}
