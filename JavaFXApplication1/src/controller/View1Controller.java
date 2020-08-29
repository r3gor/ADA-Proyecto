/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Main;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author rogrp
 */
public class View1Controller implements Initializable {

    @FXML
    private Button btnTicTacToe;
    @FXML
    private Button btnMultijugador;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void click_btn_TTT(ActionEvent event) {
        System.out.println("Opcion escogida: TicTacToe.");
        Stage primaryStage = new Stage();
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/view/View2.fxml"));
            // Cargo la ventana
            Pane ventana = (Pane) loader.load();

            // Cargo el scene
            Scene scene = new Scene(ventana);

            // Seteo la scene y la muestro
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    private void click_btn_multijugador(ActionEvent event) {
        System.out.println("Opcion escogida: Multijugador TicTacToe.");
        Stage primaryStage2 = new Stage();
        try {
            FXMLLoader loader2 = new FXMLLoader();
            loader2.setLocation(Main.class.getResource("/view/View3.fxml"));
            // Cargo la ventana
            Pane ventana = (Pane) loader2.load();

            // Cargo el scene
            Scene scene2 = new Scene(ventana);

            // Seteo la scene y la muestro
            primaryStage2.setScene(scene2);
            primaryStage2.show();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
