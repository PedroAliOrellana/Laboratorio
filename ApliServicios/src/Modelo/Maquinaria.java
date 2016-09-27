
package Modelo;


public class Maquinaria
{
   private String CodMaquianria;
   private String PlacaMaq;
   private String ModeloMaq;
   private String CodRecurso;
   
   public Maquinaria() 
   {
        CodMaquianria = "";
        PlacaMaq = "";
        ModeloMaq = "";
        CodRecurso = "";
    }
   
    public Maquinaria(String CodMaquianria, String PlacaMaq, String ModeloMaq, String CodRecurso) {
        this.CodMaquianria = CodMaquianria;
        this.PlacaMaq = PlacaMaq;
        this.ModeloMaq = ModeloMaq;
        this.CodRecurso = CodRecurso;
    }

    public String getCodMaquianria() {
        return CodMaquianria;
    }

    public void setCodMaquianria(String CodMaquianria) {
        this.CodMaquianria = CodMaquianria;
    }

    public String getPlacaMaq() {
        return PlacaMaq;
    }

    public void setPlacaMaq(String PlacaMaq) {
        this.PlacaMaq = PlacaMaq;
    }

    public String getModeloMaq() {
        return ModeloMaq;
    }

    public void setModeloMaq(String ModeloMaq) {
        this.ModeloMaq = ModeloMaq;
    }

    public String getCodRecurso() {
        return CodRecurso;
    }

    public void setCodRecurso(String CodRecurso) {
        this.CodRecurso = CodRecurso;
    }
   
}
