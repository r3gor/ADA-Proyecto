/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import model.TicTacToe;
import model.Pair;

/**
 * FXML Controller class
 *
 * @author rogrp
 */
public class View3Controller implements Initializable {

    private TicTacToe ttt = new TicTacToe();
    private boolean vsBot = true;
    private boolean enJuego = true;

    @FXML
    private Button c00;
    @FXML
    private Button c01;
    @FXML
    private Button c02;
    @FXML
    private Button c10;
    @FXML
    private Button c11;
    @FXML
    private Button c12;
    @FXML
    private Button c20;
    @FXML
    private Button c21;
    @FXML
    private Button c22;
    @FXML
    private Label msj_ttt;
    @FXML
    private Label lbl_winner;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void click_casilla(ActionEvent event) {
        if (!enJuego) {
            return;
        }

        Button bs = (Button) event.getSource();
        int x, y;

        if (c00 == bs) {
            System.out.println("boton presionado: (0,0)");
            x = 0;
            y = 0;
            
            char player = ttt.getTurno();
            if (ttt.setValue(x, y, player)) {
                c00.setText(String.valueOf(player));
            } else {
                msj_ttt.setText("¡La casilla ya esta seleccionada!");
                return;
            }
        }

        if (c01 == bs) {
            System.out.println("boton presionado: (0,1)");
            x = 0;
            y = 1;
            char player = ttt.getTurno();
            if (ttt.setValue(x, y, player)) {
                c01.setText(String.valueOf(player));
            } else {
                msj_ttt.setText("¡La casilla ya esta seleccionada!");
                return;
            }
        }

        if (c02 == bs) {
            System.out.println("boton presionado: (0,2)");
            x = 0;
            y = 2;
            char player = ttt.getTurno();
            if (ttt.setValue(x, y, player)) {
                c02.setText(String.valueOf(player));
            } else {
                msj_ttt.setText("¡La casilla ya esta seleccionada!");
                return;
            }
        }
        if (c10 == bs) {
            System.out.println("boton presionado: (1,0)");
            x = 1;
            y = 0;
            char player = ttt.getTurno();
            if (ttt.setValue(x, y, player)) {
                c10.setText(String.valueOf(player));
            } else {
                msj_ttt.setText("¡La casilla ya esta seleccionada!");
                return;
            }
        }
        if (c11 == bs) {
            System.out.println("boton presionado: (1,1)");
            x = 1;
            y = 1;
            char player = ttt.getTurno();
            if (ttt.setValue(x, y, player)) {
                c11.setText(String.valueOf(player));
            } else {
                msj_ttt.setText("¡La casilla ya esta seleccionada!");
                return;
            }
        }
        if (c12 == bs) {
            System.out.println("boton presionado: (1,2)");
            x = 1;
            y = 2;
            char player = ttt.getTurno();
            if (ttt.setValue(x, y, player)) {
                c12.setText(String.valueOf(player));
            } else {
                msj_ttt.setText("¡La casilla ya esta seleccionada!");
                return;
            }
        }
        if (c20 == bs) {
            System.out.println("boton presionado: (2,0)");
            x = 2;
            y = 0;
            char player = ttt.getTurno();
            if (ttt.setValue(x, y, player)) {
                c20.setText(String.valueOf(player));
            } else {
                msj_ttt.setText("¡La casilla ya esta seleccionada!");
                return;
            }
        }
        if (c21 == bs) {
            System.out.println("boton presionado: (2,1)");
            x = 2;
            y = 1;
            char player = ttt.getTurno();
            if (ttt.setValue(x, y, player)) {
                c21.setText(String.valueOf(player));
            } else {
                msj_ttt.setText("¡La casilla ya esta seleccionada!");
                return;
            }
        }
        if (c22 == bs) {
            System.out.println("boton presionado: (2,2)");
            x = 2;
            y = 2;
            char player = ttt.getTurno();
            if (ttt.setValue(x, y, player)) {
                c22.setText(String.valueOf(player));
            } else {
                msj_ttt.setText("¡La casilla ya esta seleccionada!");
                return;
            }
        }

        if (ttt.getWinner() != ttt.VACIO) {
            lbl_winner.setText(String.valueOf(ttt.getWinner()));
            msj_ttt.setText("El juego a terminado :)");
            enJuego = false;
        }


    }
}
