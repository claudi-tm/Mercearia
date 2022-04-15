package ListasLigadas;

import java.io.Serializable;

public class No implements Serializable{
    private Object elemento;
    private No proximo;
    public No(Object elemento, No proximo) {
        this.elemento = elemento;
        this.proximo = proximo;
    }
    public No(Object elemento){
        this.elemento = elemento;
    }

    public void setElemento(Object elemento){
        this.elemento = elemento;
    }
    public Object getElemento(){
        return elemento;
    }

    public void setProximo(No proximo){
        this.proximo = proximo;
    }
    public No getProximo(){
        return proximo;
    }
    
}
