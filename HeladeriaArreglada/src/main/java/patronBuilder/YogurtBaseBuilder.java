/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package patronBuilder;

/**
 *
 * @author zaval
 */
public class YogurtBaseBuilder extends BaseBuilder {
     @Override
    public void BuildTipoBase(){
        base.setTipoBase("yogurt");
    }
    @Override
    public void BuildPrecio(){
        base.setPrecio("1.50");
    } 
}
