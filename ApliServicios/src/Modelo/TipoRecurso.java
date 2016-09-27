
package Modelo;


public class TipoRecurso
{
  private String CodigoTipoRecurso;
  private String DescripcionTipoRecurso;

    public TipoRecurso(String CodigoTipoRecurso, String DescripcionTipoRecurso)
    {
        this.CodigoTipoRecurso = CodigoTipoRecurso;
        this.DescripcionTipoRecurso = DescripcionTipoRecurso;
    }

   public TipoRecurso()
    {
        CodigoTipoRecurso ="" ;
        DescripcionTipoRecurso ="" ;
    }

  
  
    public String getCodigoTipoRecurso() {
        return CodigoTipoRecurso;
    }

    public void setCodigoTipoRecurso(String CodigoTipoRecurso) {
        this.CodigoTipoRecurso = CodigoTipoRecurso;
    }

    public String getDescripcionTipoRecurso() {
        return DescripcionTipoRecurso;
    }

    public void setDescripcionTipoRecurso(String DescripcionTipoRecurso) {
        this.DescripcionTipoRecurso = DescripcionTipoRecurso;
    }
  
}
