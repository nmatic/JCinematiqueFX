package ca.qc.nmatic.cinematique.jcfx.ui;

/*
 * Copyright (C) 2017 Victor Babin
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */


import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author Victor Babin
 */
public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        URL fxml = getClass().getClassLoader().getResource("resources/fxml/JCinematiqueFXUI.fxml");
        //URL fxml = getClass().getClassLoader().getResource("resources/fxml/JCinematiqueFXUI.fxml");
        Image icon = new Image(getClass().getClassLoader().getResource("resources/images/icon.png").toExternalForm());
        FXMLLoader fxmlLoader = new FXMLLoader(fxml);
        stage.setScene(new Scene(fxmlLoader.load()));
        stage.setTitle("JCinematiqueFX");
        stage.setResizable(false);
        stage.getIcons().add(icon);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);

    }

}
