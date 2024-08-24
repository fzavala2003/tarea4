/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package patronBuilder;

/**
 *
 * @author zaval
 */
public class HeladoBaseBuilder extends BaseBuilder {
    @Override
    public void BuildTipoBase(){
        base.setTipoBase("helado");
    }
    @Override
    public void BuildPrecio(){
        base.setPrecio("2.00");
    } 
}
