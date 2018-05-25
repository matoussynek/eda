package librerias.estructurasDeDatos.grafos;

/** Clase Arista: representa una arista de un grafo.<br> 
 *  
 *  @version Mayo 2018
 */
 
public class Arista implements Comparable<Arista> {
    
    // UNA Arista TIENE UN vertice origen y UN vertice destino:
    /*COMPLETAR*/
    // UNA Arista TIENE UN peso:
    /*COMPLETAR*/
    
      
    private int v;
    private int w;
    private double p;
    
    /** Crea una arista (v, w) con peso p.
      *
      * @param v  Vertice origen
      * @param w  Vertice destino
      * @param p  Peso
     */
    public Arista(int v, int w, double p) {
        this.v = v; this.w = w; this.p = p;
    }

    /** Devuelve el vertice origen de una arista.
      *
      * @return int vertice origen
     */
    public int getOrigen() {    
      return this.v;
    }
    
    /** Devuelve el vertice destino de una arista.
      *
      * @return int vertice destino
     */
    public int getDestino() {  
        return this.w;
    }
    
    /** Devuelve el peso de una arista.
      *
      * @return double Peso de la arista
     */
    public double getPeso() {
        return this.p; 
    }
    
    @Override
    public int compareTo(Arista o) {
        double x = p - o.p;
        return (int) x;
    }
    
    /** Devuelve un String que representa una arista
      * en formato (origen, destino, peso)
      *
      * @return  String que representa la arista
     */
    public String toString() {
        return "("+v+", "+w+", "+p+")";
    }
}