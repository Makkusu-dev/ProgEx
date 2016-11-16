package employee;

import java.io.IOException;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Main extends Application {
	private static Stage primaryStage;
	private static BorderPane mainLayout;
	
	@Override
	public void start(Stage primaryStage) throws IOException {
		Main.primaryStage =primaryStage;
		Main.primaryStage.setTitle("Rocket Hospital V1.0");
		showMainView();
		showMainItems();
		//showAbout();
	}
	
	public static void showMainView() throws IOException{						
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("view/MainView.fxml"));
		mainLayout = loader.load();
		Scene scene = new Scene(mainLayout);		// <-- change scene size (<name>, <px>, <px>)
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void showMainItems() throws IOException{							// homepage launcher
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("view/MainItems.fxml"));
		BorderPane mainItems = loader.load();
		mainLayout.setCenter(mainItems);
	}
	
	public static void showAbout() throws IOException{								// about page launcher
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("view/About.fxml"));
		BorderPane about = loader.load();
		mainLayout.setCenter(about);
	}
																					// addEmployee page launcher
	public static void showAddEmployeePage() throws IOException{					// to implement from adminController page
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("admin/AddEmployeePage.fxml"));
		BorderPane addEmployee = loader.load();
		
		Stage addDialogStage = new Stage();
		addDialogStage.setTitle("Add New Employee");
		addDialogStage.initModality(Modality.WINDOW_MODAL);
		addDialogStage.initOwner(primaryStage);
		
		Scene scene = new Scene(addEmployee);
		addDialogStage.setScene(scene);
		addDialogStage.showAndWait();
		
	}
	
	public static void showAdminLogin() throws IOException{					// admin login page launcher
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("view/AdminLogin.fxml"));
		BorderPane adminLoginPage = loader.load();
		
		Stage addDialogStage = new Stage();
		addDialogStage.setTitle("Admin Login");
		addDialogStage.initModality(Modality.WINDOW_MODAL);
		addDialogStage.initOwner(primaryStage);
		
		Scene scene = new Scene(adminLoginPage);
		addDialogStage.setScene(scene);
		addDialogStage.showAndWait();
		
	}
	
	
	
	public static void launchMainAdmin() throws IOException{			// admin main launcher
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("admin/MainAdmin.fxml"));
		BorderPane about = loader.load();
		mainLayout.setCenter(about);
	}
	

	public static void main(String[] args) {
		launch(args);
	}
}
