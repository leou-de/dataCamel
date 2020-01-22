package de.leou.dataCamel;

import java.io.IOException;

import de.leou.dataCamel.m.SysParams;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FxMainApp extends Application {
	//create Global sysParams
	public static SysParams sysParams = new SysParams("c:\\_gd_mustbuy\\Mustbuy\\Bestellung\\daliy_stock_out\\_sysConfig\\sysParams.ini");

	@Override
	public void start(Stage stage) {

		System.out.println(sysParams.getSyspath());
		stage.setTitle("Data Camel");
		// Load root layout from fxml file.

		try {
			Parent root = FXMLLoader.load(getClass().getResource("FxMainWindow.fxml"));
			Scene scene = new Scene(root);
			scene.setRoot(root);
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Show the scene containing the root layout.

	}

	@Override
	public void init() throws Exception {
		// TODO Auto-generated method stub
		super.init();
	
	}

	public static void main(String[] args) {
		launch(args);

	}

}
