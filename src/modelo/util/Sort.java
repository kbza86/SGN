/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.util;



/**
 *
 * @author wally86
 */
public abstract class Sort {
    public static void ordenarPorBurbuja(ItemComparable[] items){
        for(int i=1;i<items.length;i++){
            for(int j=0; j<items.length-1;j++){
                if((items[j].comparar(items[j+1]))>0){
                    ItemComparable tempItem = items[j+1];
                    items[j+1] = items[j];
                    items[j]=tempItem;
                }
            }
        }
    }
}
