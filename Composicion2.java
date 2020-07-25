/*
 PROGRAMA DE COMPOSICION BASADO EN LIBRO
 */
package composicion2;

/**
 *
 * @author Medardo Chango
 */
import java.util.*;

class Pagina {
    // ATRIBUTOS DE INSTANCIA
    private String contenido; 
    private int numero;
    
    // CoONSTRUCTOR CON PARAMETRO 
    
    public Pagina(String contenido, int numero){
        this.contenido = new String(contenido);
        this.numero = numero; 
    }
    // METODOS DE INSTANCIA
    
    public String getContenido(){
        return this.contenido;
    }
    public void setContenido(String nuevo_contenido){
        this.contenido = nuevo_contenido;
    }
    public int getNumero(){
        return this.numero;
    }
    public void setNumero(int nuevo_numero){
        this.numero= nuevo_numero;
    }

}    
    class Libro{
        //ATRIBUTOS 
        
        private String titulo;
        private long isbn;
        private String autor;
        private int anioPublicacion;
        
        // ATRIBUTOS REPRESENTANDO LA RELACION DE COMPOSICION 
        
        private Pagina[] paginas;
        private int numeroPaginas;
        
        
        // CONTRUCTOR
        public Libro(String titulo, long isbn, String autor, int anioPublicacion){
            this.titulo=titulo;
            this.isbn=isbn;
            this.autor=autor;
            this.anioPublicacion=anioPublicacion;
            
            //RESERVAMOS ESPACIO DE MEMORIA PARA EL OBJETO "array"
            
            this.paginas=new Pagina[999];
            
            // RESERVAMOS ESPACIO EN MEMORIA PARA LAS PAGINAS
            
            for (int i=0; i<999;i++){
                this.paginas[i]=new Pagina("",0);
                
            }
            this.numeroPaginas=0;
        }
        
        //METODOS DE INSTANCIA 
        public String getTitulo(){
            return this.titulo;
        }
        public void setTitulo(String titulo){
            this.titulo=titulo;
        }
        public long getIsbn(){
            return this.isbn;
        }
        public void setIsbn(long nuevo_isbn){
            this.isbn=nuevo_isbn;
        }
        public String getAutor(){
            return this.autor;
        }
        public void setAutor(String nuevo_autor){
            this.autor=nuevo_autor;
        }
        public int getAnioPublicaion(){
            return this.anioPublicacion;
        }
        public void setAnioPublacion(int nuevo_anioPublicacion){
            this.anioPublicacion=nuevo_anioPublicacion;
        }
        
        //METODOS PARA TRABAJAR CON LA CLASE DE COMPOSICION
        
        public int getNumeroPaginas(){
            return this.numeroPaginas;
        }
        public void AnadirPaginas(Pagina nueva_pagina){
            if(this.numeroPaginas<99){
                this.paginas[this.numeroPaginas]=nueva_pagina;
                this.numeroPaginas++;
            }
        }
        public Pagina getPaginaNumero(int numero_Paginas){
            for(int i=0;i<this.numeroPaginas;i++){
                if(this.paginas[i].getNumero()==numero_Paginas){
                    return this.paginas[i];
                }
            }
            return this.paginas[1];
        }


    }



public class Composicion2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        
        // DECLARACION Y DEFINICION DE OBJETOS      
        Libro Controles_Instrumentos=new Libro ("Arranque y apagado del motor", 1234567896, "Chevrolet", 2020);
        Pagina pagina1=new Pagina("Asegurese que todos los interruptores esten en la posicion de desactivada ", 1);
        Pagina pagina2=new Pagina("Gire interrupto de arranque a posicion ON verifique luces y combustible normal",0);
        
        //PASAMOS AL OBJETO LIBRO LOS OBJETOS TIPO PAGINA 
        
        Controles_Instrumentos.AnadirPaginas(pagina1);
        Controles_Instrumentos.AnadirPaginas(pagina2);
        
        for(int i=1; i <= Controles_Instrumentos.getNumeroPaginas();i++){
            System.out.println(Controles_Instrumentos.getPaginaNumero(i).getContenido());
        } 
    }
    
}

