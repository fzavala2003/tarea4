/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package patronBuilder;

/**
 *
 * @author zaval
 */
public class Cocina {
    private BaseBuilder baseBuilder;
    public void setBaseBuilder(BaseBuilder bb){
        baseBuilder=bb;
    }
    public Base getBase(){
        return baseBuilder.getBase();
    }
    public void construirBase(){
        baseBuilder.crearNuevaBase();
        baseBuilder.BuildPrecio();
        baseBuilder.BuildTipoBase();
    }
}
