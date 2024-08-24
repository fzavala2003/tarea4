    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.pooespol.proyecto2_heladeria;

import Clases.Pedido;
import Clases.Sabor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import java.util.ArrayList;
import Clases.Topping;
import java.util.Locale;
import java.util.Random;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.StageStyle;


/**
 * FXML Controller class
 *
 * @author PC.1
 */
public class ArmaTuHelado4Controller implements Initializable {

    ArrayList<String> lista = ArmaTuHelado1Controller.orden ;
    private  int selectedIndex = 0;
    private ObservableList<String> items;
    public static double ValorPagar =ArmaTuHelado3Controller.valor3;
    public static String idPd = null;       
 

    @FXML
    private Button btnCancelar;

    @FXML
    private Button btnConfirmar;

    @FXML
    private Button btnEliminar;

    @FXML
    private ListView<String> pedido;

    @FXML
    private Label valorPagar;
    
    @FXML 
    private ImageView imgArmaTuHelado4;
    
    @FXML
    private Label message;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        mostrarImg();
        valorFinal();
        cargarList();
        items = FXCollections.observableArrayList(cargarList());
        pedido.setItems(items);
        btnEliminar.setOnAction(e->{
            validation();
        });
    
        
       
    }    
    
    
    public void mostrarImg(){        
        try(FileInputStream  input = new FileInputStream (Principal.path+"escena5.jpg")){
            Image image = new Image(input,730,530,false,false);
            imgArmaTuHelado4.setImage(image);             
        }catch(FileNotFoundException fn){

        }catch (Exception ex) {

        }
    }
    
    @FXML
    void confirmar(ActionEvent event) throws IOException{
        guardarPedido();
        FXMLLoader fxmlloader = new FXMLLoader(Principal.class.getResource("ArmaTuHelado5.fxml"));
        Parent root = fxmlloader.load();
        Scene scene = new Scene(root, 730, 530);
        Stage s = (Stage) btnConfirmar.getScene().getWindow();
        s.setScene(scene);
        s.setTitle("ArmaTuHelado5");         
        s.show();

    }

    
    
    @FXML
    void cancelar(ActionEvent event) throws IOException {
        FXMLLoader fxmlloader = new FXMLLoader(Principal.class.getResource("CancelarCompra.fxml"));
        Parent root = fxmlloader.load();
        Scene scene = new Scene(root, 340, 230);
        Stage s = (Stage) btnCancelar.getScene().getWindow();
        s.setScene(scene);
        s.setTitle("CancelarCompra");         
        s.show();
    }
    
    public void valorFinal(){
        Double valorF = ArmaTuHelado3Controller.valor3;
        String formatted = String.format(Locale.US,"%.2f", valorF);
        valorPagar.setText("Valor a pagar: "+formatted);
    }

    public ArrayList<String> cargarList(){
        ArrayList<String> l = new ArrayList();
        for (String cadena : lista) {
            if (cadena.startsWith("Sabor:")) {
               String [] c = cadena.split("-");
               l.add(c[0]);
            }else if(cadena.startsWith("Base:")){
                l.add(cadena);
            }else if(cadena.startsWith("Topping:")){
                String [] c = cadena.split("-"); 
                l.add(c[0]);
                
            }
                     
        }
        return l;
    }
    
   
    private void mostrarPopUp(String valor) {
        Stage popUp = new Stage();
        popUp.initModality(Modality.APPLICATION_MODAL);
        popUp.initStyle(StageStyle.UTILITY);
        popUp.setTitle("Confirmar Eliminación");

        Label label = new Label("¿Está seguro de cancelar su compra?");
        Button botonConfirmar = new Button("Confirmar");
        Button botonCancelar = new Button("Cancelar");

        botonConfirmar.setOnAction(e -> {
            message.setText("");
            items.remove(selectedIndex);
            valorPagar.setText("Valor a pagar: "+valor);
            popUp.close();
        });
        botonCancelar.setOnAction(e -> {
            popUp.close();
        });
        VBox vbox = new VBox(10);
        HBox hb = new HBox(10);
        hb.getChildren().addAll(botonConfirmar,botonCancelar);
        vbox.getChildren().addAll(label, hb);
        vbox.setAlignment(javafx.geometry.Pos.CENTER);
        hb.setAlignment(javafx.geometry.Pos.CENTER);
        Scene popUpScene = new Scene(vbox, 300, 150);
        popUp.setScene(popUpScene);
        popUp.showAndWait();
    }
   
    
    
    private void validation(){
    String selectedItem = pedido.getSelectionModel().getSelectedItem();
    if (selectedItem != null) {
        String tipo = selectedItem.split(":")[0];
        ItemPedido itemPedido;
        
        switch (tipo) {
            case "Base":
                itemPedido = new BaseItem();
                break;
            case "Topping":
                itemPedido = new ToppingItem();
                break;
            case "Sabor":
                itemPedido = new SaborItem();
                break;
            default:
                return;
        }

        selectedIndex = pedido.getSelectionModel().getSelectedIndex();
        itemPedido.eliminar(pedido.getItems(), selectedIndex, valorPagar, message);
        
    } else {
        message.setText("Seleccione un elemento para eliminar");
    }
}
    
    private void guardarPedido(){
        Random random = new Random();
        int id = random.nextInt(1000) + 1;
        idPd = String.valueOf(id);
        Pedido p = new Pedido(String.valueOf(id),InicioController.name,ValorPagar);
        Pedido.guardarPedido(p);
        Pedido.serealizarPedido(p);
    }
    
}//Fin
