package com.gil.bridge;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Hello World!");
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                BridgeParameters bridgeParams = new BridgeParameters();
                bridgeParams.setRoadName("\u05db\u05d1\u05d9\u05e971-\u05d4\u05e4\u05e8\u05d3\u05d5\u05ea \u05de\u05e4\u05dc\u05e1\u05d9\u05d5\u05ea");
                bridgeParams.setName("\u05d2\u05e9\u05e8 \u05d7\u05e7\u05dc\u05d0\u05d9" + " OP7");
                bridgeParams.setR(400D);
                bridgeParams.setPCVx(118.85);
                bridgeParams.setPCVelev(-66.666);
                bridgeParams.setPIVx(158.85);
                bridgeParams.setPIVelev(-62.680);
                bridgeParams.setPTVx(198.85);
                bridgeParams.setPTVelev(-66.691);
                bridgeParams.setAsfalt(0.1);
                bridgeParams.setAlfa(41.199);

                bridgeParams.getdRoadParams().add(new BridgeParameters.DRoadParams(119.85, "ABUT"));
                bridgeParams.getdRoadParams().add(new BridgeParameters.DRoadParams(139.85, "PIER"));
                bridgeParams.getdRoadParams().add(new BridgeParameters.DRoadParams(169.85, "PIER"));
                bridgeParams.getdRoadParams().add(new BridgeParameters.DRoadParams(189.85, "ABUT"));

                bridgeParams.setDestFile("c:/temp/bridge1.xlsx");

                new BridgeWorkbook(bridgeParams).run();
                System.out.println("Hello World!");
            }
        });

        StackPane root = new StackPane();
        root.getChildren().add(btn);
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }
}