
package Modelo;


public class Recurso 
{
    private String codRecurso;
    private String descRecurso;
    private float  tasaRecurso;
    private String unidMedida;

    public Recurso(String codRecurso, String descRecurso, float tasaRecurso, String unidMedida)
    {
        this.codRecurso = codRecurso;
        this.descRecurso = descRecurso;
        this.tasaRecurso = tasaRecurso;
        this.unidMedida = unidMedida;
    }
    public Recurso() 
    {
        codRecurso = "";
        descRecurso = "";
        tasaRecurso = 0;
        unidMedida = "";
    }

   
    

    public String getCodRecurso() 
    {
        return codRecurso;
    }

    public void setCodRecurso(String codRecurso)
    {
        this.codRecurso = codRecurso;
    }

    public String getDescRecurso() 
    {
        return descRecurso;
    }

    public void setDescRecurso(String descRecurso) 
    {
        this.descRecurso = descRecurso;
    }

    public float getTasaRecurso()
    {
        return tasaRecurso;
    }

    public void setTasaRecurso(float tasaRecurso) 
    {
        this.tasaRecurso = tasaRecurso;
    }

    public String getUnidMedida() 
    {
        return unidMedida;
    }

    public void setUnidMedida(String unidMedida)
    {
        this.unidMedida = unidMedida;
    }
}
