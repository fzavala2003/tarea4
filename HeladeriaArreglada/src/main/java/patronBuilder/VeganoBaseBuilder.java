/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package patronBuilder;

/**
 *
 * @author zaval
 */
public class VeganoBaseBuilder extends BaseBuilder {
    @Override
    public void BuildTipoBase(){
        base.setTipoBase("vegano");
    }
    @Override
    public void BuildPrecio(){
        base.setPrecio("2.50");
    } 
}
