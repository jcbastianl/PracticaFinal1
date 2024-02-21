/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package controlador;

import controlador.Exception.EmptyException;
import controlador.TDA.Colas.QueueUltimate;
import controlador.TDA.Pilas.FullStackException;

import controlador.TDA.Pilas.StackUltimate;

/**
 *
 * @author mrbingus
 */
public class LLANTASALMACEN {
    
    
   private Double calculo(Double a, Double b, Character operacion){
                if(operacion.charValue() == '+')
                        return a+b;
                else if(operacion.charValue() == '-')
                        return a-b;
                else if(operacion.charValue() == '*')
                        return a*b;
                else if(operacion.charValue() == '/')
                        return a/b;
                else
                        return Double.NaN;
        }
        
        private Boolean validadorOperacion(Character a){
                return (a.charValue() == '+' || a.charValue() == '-'
                        || a.charValue() == '*' || a.charValue() == '/');
        }
        
        public Double calcular(String info) throws EmptyException, FullStackException{
                StackUltimate<Double> pila = new StackUltimate(10);
                Double resp = Double.NaN;
                for(Character a:info.toCharArray()){
                        if(Character.isDigit(a)){
                                pila.push(Double.parseDouble(a.toString()));
                        } else {
                                if(validadorOperacion(a)){
                                        Double op1 = pila.pop();
                                        Double op2 = pila.pop();
                                        pila.push(calculo(op1, op2, a));
                                }
                        }
                }
                if(pila.lenght() == 1)
                        resp = pila.pop();
                return resp;
        } 
                                
        public static void main(String[] args) {
                String info = "64*46+-";
                LLANTASALMACEN eje = new LLANTASALMACEN();
                try {
                        System.out.println(eje.calcular(info));
                } catch (Exception e) {
                        System.out.println("Error" + e.toString());
                }
        }
    
}
