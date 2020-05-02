/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import static Ventanas.VentanaPrincipal.R_repaint;
import static Ventanas.VentanaPrincipal.ingresarNodoOrigen;
import static Ventanas.VentanaPrincipal.jPanel1;
import java.awt.Color;

/**
 *
 * @author nicolas
 */
public class algoritmoprim {
    
    private int cumulado;
   private int aristaMenor;
   private int  fin;
   private boolean estaNodo=false;
   private boolean aumentaTamano;
   private int nodoApuntado;  
   private int nodoApuntador;
   private int tamano;
   private int arsitaMayor;
   private  arboles Arboles;
   private int tope;
   private  int  nodoOrigen;
   
   
   
   public algoritmoprim(arboles arbol , int top ,int aristaMayor ){
       this.cumulado = 0;
       this.aristaMenor = 0;
       this.fin = 0;
       this.estaNodo=false;
       this.aumentaTamano = false;
       this.nodoApuntado = 0;  
       this.nodoApuntador = 0;
       this.tamano = 1;
       this. arsitaMayor=aristaMayor;
       this.Arboles = arbol;
       this.tope = top;
   }

    public int getCumulado() {
        return cumulado;
    }
  
   
  public void prim(){
      this.nodoOrigen= ingresarNodoOrigen("Ingrese Nodo Origen..","nodo Origen No existe",tope);
       jPanel1.paint(jPanel1.getGraphics());
       R_repaint(tope,Arboles);
       Arboles.crearEnArbol(tope);
       Arboles.setEnArbol(0, nodoOrigen);
       do{
           this.aristaMenor = this.arsitaMayor;
           this.fin=2;
            for (int j = 0; j < tamano; j++) {
                for (int k = 0; k < tope; k++){
                    if(Arboles.getmAdyacencia(k, Arboles.getEnArbol(j))==1){
                        for (int h = 0; h < tamano; h++) {
                             if(Arboles.getEnArbol(h)==k ){
                                 this.estaNodo=true; 
                                 break;
                             }
                        }
                        if(estaNodo==false){
                            if(Arboles.getmCoeficiente(k, Arboles.getEnArbol(j))<=aristaMenor && Arboles.getmCoeficiente(k, Arboles.getEnArbol(j))>0 ){
                                 aristaMenor=Arboles.getmCoeficiente(k, Arboles.getEnArbol(j));
                                 this.nodoApuntado=k;
                                 this.aumentaTamano=true;
                                 this.nodoApuntador=Arboles.getEnArbol(j);
                                 this.fin=1;
                            }
                        }
                        this.estaNodo=false;
                    }
                }
            }           
         if(aumentaTamano==true){
                    pintar.pintarCamino(jPanel1.getGraphics(),Arboles.getCordeX(nodoApuntador), Arboles.getCordeY(nodoApuntador),Arboles.getCordeX(nodoApuntado), Arboles.getCordeY(nodoApuntado),Color.red); 
                    pintar.clickSobreNodo(jPanel1.getGraphics(),Arboles.getCordeX(nodoApuntador), Arboles.getCordeY(nodoApuntador), null,Color. red);
                    pintar.clickSobreNodo(jPanel1.getGraphics(),Arboles.getCordeX(nodoApuntado), Arboles.getCordeY(nodoApuntado), null, Color.red);                                  
                    Arboles.setEnArbol(tamano, nodoApuntado);
                    this.tamano++;
                    this.aumentaTamano=false;
                    this.cumulado += this.aristaMenor;
         }
        }while(fin<2);
   }
    
}