// comprueba que esta en el lugar correcto
// package librerias.estructurasDeDatos.lineales;
package librerias.estructurasDeDatos.lineales;

import java.util.*;
import librerias.estructurasDeDatos.modelos.ListaConPI;

/** Implementa la interfaz ListaConPI mediante una LEG ...
 *  (a) Con Nodo ficticio cabecera .
 *  (b) Una referencia al primer Nodo  .
 *  (c) Una referencia al ult Nodo.
 *  (d) Para representar el Punto de Interes, una referencia al Nodo 
 *       anterior al que ocupa el punto de interes.
 *  (e) Un int talla que representa la talla de la LEG.
 *
 *  @version Febrero 2014 *  
  * @param <E> tipo de datos de la estructura
 */ 
public class LEGListaConPI<E> implements ListaConPI<E> {
    // En principio, una LEGListaConPI NO tendria una talla ...
    // PERO se incluye pensando en la futura reutilizacion del Modelo
    private int talla;
    
    private NodoLEG<E> pri;
    private NodoLEG<E> ant;
    private NodoLEG<E> ult;  

    /** construye una Lista Con PI vacia **/
    public LEGListaConPI () {
        pri = ant = ult = new NodoLEG<E>(null,null);
        talla = 0;
    }
    
    /** inserta e en una Lista antes del Elemento que ocupa su PI, 
      * que permanece inalterado.
      *
      * @param e Elememto a insertar.
      **/
    public void insertar(E e) {
        NodoLEG<E> nuevo = new NodoLEG<E>(e,null);
        if (esVacia()) {
            pri.siguiente = nuevo;
            ant = ult = nuevo;        
        }
        else {
            nuevo.siguiente = ant.siguiente;
            ant.siguiente = nuevo;
            if(nuevo.siguiente==null){ult=nuevo;}
            ant = ant.siguiente;
        }  
        talla++;
    }
    
     /** SII !esFin(): elimina de una Lista el Elemento que ocupa 
      * su PI que permanece inalterado. 
      **/ 
    public void eliminar() {
        talla--;
        if(ant.siguiente==ult){ult=ant;}
        ant.siguiente = ant.siguiente.siguiente;
    }
    
    /** situa el PI de una Lista en su inicio, sobre su primer 
      * elemento si no esta vacia.
      **/
    public void inicio() {
        ant = pri;
    }
    
    /** SII !esFin(): situa sobre el siguiente Elemento el PI 
      * de una Lista.  
      **/
    public void siguiente() {
        ant = ant.siguiente;
    } 
    
    /** situa el PI de una Lista en su fin, detras de su ultimo 
      * Elemento si no esta vacia. 
     **/
    public void fin() { ant=ult; }
    
    /** SII !esFin(): obtiene el Elemento que ocupa el PI de 
      * una Lista.
      *
      * @return E, el Elemento que ocupa el PI de una Lista.
     */
    public E recuperar() {
        return ant.siguiente.dato;
    }   
    
    /** comprueba si el PI de una Lista esta en su fin.
      *
      *  @return true si el PI de una Lista esta en su fin y 
      * false en caso contrario
      **/
    public boolean esFin() { return ((ant == ult) || (ant == null)); }
    
    /** comprueba si una Lista Con PI esta vacia
      *
      *  @return true si una Lista Con PI esta vacia y 
      * false en caso contrario
      **/
    public boolean esVacia() { return talla == 0; }

    /** devuelve la talla de una Lista Con PI, i.e. su 
      * numero de elementos.
      *
      * @return int, el numero de Elementos de una Lista con PI.
      **/
    public int talla() { return talla; }

    public String toString() {
        // NOTA: se usa la clase StringBuilder, en lugar de String, 
        // por motivos de eficiencia 
        StringBuilder s = new StringBuilder();
        s.append("[");
        NodoLEG<E> aux = pri.siguiente;         
        for (int i = 1; i < talla; i++, aux = aux.siguiente) {            
            s.append(aux.dato.toString() + ", ");
        }
        if (talla != 0) {
            s.append(aux.dato.toString() + "]"); 
        } else { s.append("]"); }
        return s.toString();
    }
}

