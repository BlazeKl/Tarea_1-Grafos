/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import static Ventanas.VentanaPrincipal.jPanel1;
import static Ventanas.VentanaPrincipal.R_repaint;
import static Ventanas.VentanaPrincipal.ingresarNodoOrigen;
import java.awt.Color;
import javax.swing.JOptionPane;

/**
 *
 * @author nicolas
 */
public class algoritmodij {
   private  arboles Arboles;
   private int subTope;
   private nodos auxi=null;
   private int auxAumulado; // es un acumulado auxiliar
   private int subAcomulado;
   private nodos nodo[]; 
   private int tope;
   private int permanente;     
   private int nodoFin; 
   
   
    public algoritmodij (arboles Arboles, int tope,int permanente, int nodoFin){
        this.Arboles = Arboles;        
        this.tope = tope;
        this.nodo= new nodos[tope]; 
        this.permanente = permanente;
        this.nodoFin = nodoFin;
        
    }

    public int getAcumulado(){
        return nodo[nodoFin].getAcumulado(); 
    }
        
    public void dijkstra(){ 
         for (int i = 0; i < tope; i++)  // creamos el vector nodo del tamaño de tope el cual tiene el numero de nodo pintados 
                    nodo[i]= new nodos(); 
         
        if(permanente != nodoFin){
             jPanel1.paint(jPanel1.getGraphics());
             R_repaint(tope, Arboles);   
             pintar.clickSobreNodo(jPanel1.getGraphics(), Arboles.getCordeX(permanente), Arboles.getCordeY(permanente), null,Color.GREEN); // pinta de color GREEN los nodos del recorrido
            
        
            nodo[permanente].setVisitado(true);        
            nodo[permanente].setNombre(permanente);       
            
            do{            
              subAcomulado=0;
              auxAumulado = 2000000000; // auxiliar no alcanzable 
              nodo[permanente].setEtiqueta(true); 
              for (int j = 0; j < tope; j++) {
                  if(Arboles.getmAdyacencia(j, permanente)==1){
                        subAcomulado= nodo[permanente].getAcumulado()+Arboles.getmCoeficiente(j, permanente);                                 
                        if(subAcomulado <= nodo[j].getAcumulado() && nodo[j].isVisitado()==true && nodo[j].isEtiqueta()== false){
                            nodo[j].setAcumulado(subAcomulado);
                            nodo[j].setVisitado(true);
                            nodo[j].setNombre(j);
                            nodo[j].setPredecesor(nodo[permanente]);
                        }
                        else if( nodo[j].isVisitado()==false){
                            nodo[j].setAcumulado(subAcomulado);
                            nodo[j].setVisitado(true);
                            nodo[j].setNombre(j);
                            nodo[j].setPredecesor(nodo[permanente]); 
                       }
                 }
              }
              for (int i = 0; i <tope; i++) { // buscamos cual de los nodos visitado tiene el acomulado menor par escogerlo como permanente 
                if(nodo[i].isVisitado()== true && nodo[i].isEtiqueta()== false){
                   if(nodo[i].getAcumulado()<=auxAumulado){
                       permanente= nodo[i].getNombre();
                       auxAumulado= nodo[i].getAcumulado();
                   }
                }               
             }
            subTope++;                
          }while(subTope<tope+1);          
          auxi= nodo[nodoFin]; 
           if(auxi.getPredecesor() == null )
             JOptionPane.showMessageDialog(null,"No se Pudo LLegar Al Nodo "+nodoFin);          
          while(auxi.getPredecesor() != null){           
              pintar.pintarCamino(jPanel1.getGraphics(), Arboles.getCordeX(auxi.getNombre()), Arboles.getCordeY(auxi.getNombre()), Arboles.getCordeX(auxi.getPredecesor().getNombre()), Arboles.getCordeY(auxi.getPredecesor().getNombre()),Color.GREEN);
              pintar.clickSobreNodo(jPanel1.getGraphics(), Arboles.getCordeX(auxi.getNombre()), Arboles.getCordeY(auxi.getNombre()), null,Color.GREEN);
             auxi=auxi.getPredecesor();              
          }  
         pintar.clickSobreNodo(jPanel1.getGraphics(), Arboles.getCordeX(nodoFin), Arboles.getCordeY(nodoFin), null,Color.GREEN);     
       }
       else pintar.clickSobreNodo(jPanel1.getGraphics(), Arboles.getCordeX(nodoFin), Arboles.getCordeY(nodoFin), null,Color.GREEN);    
    }
    
    
 
}