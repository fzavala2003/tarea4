/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package patronBuilder;

/**
 *
 * @author zaval
 */
public abstract class BaseBuilder {
    protected Base base;
    
    public Base getBase(){
        return base;
    }
    
    public void crearNuevaBase(){
        base=new Base();
    }
    
    public abstract void BuildTipoBase();
    public abstract void BuildPrecio();
    
}
