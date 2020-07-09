package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class Main extends Application {
    TextArea textArea;

    @Override
    public void start(Stage primaryStage) throws Exception {

        List<Button> buttons = createNumberButtons(50, 50);
        Button reset = createButton("#", 50, 50);
        Button enter = createButton("enter", 50, 50);
        Button mutliply = createAppendNameButton("*", 50, 50);
        Button divide = createAppendNameButton("/", 50, 50);
        Button add = createAppendNameButton("+", 50, 50);
        Button subtract = createAppendNameButton("-", 50, 50);

        textArea = new TextArea("");
        textArea.setMaxWidth(230);
        textArea.setMaxHeight(50);

        GridPane gridPane = new GridPane();

        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(10.0);
        gridPane.setHgap(10.0);

        gridPane.add(textArea, 0, 0, 4, 1);
        gridPane.addRow(1, buttons.get(1), buttons.get(2), buttons.get(3), mutliply);
        gridPane.addRow(2, buttons.get(4), buttons.get(5), buttons.get(6), divide);
        gridPane.addRow(3, buttons.get(7), buttons.get(8), buttons.get(9), add);
        gridPane.addRow(4, reset, buttons.get(0), enter, subtract);

        Scene scene = new Scene(gridPane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private List<Button> createNumberButtons(int width, int height) {
        ArrayList<Button> buttons = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Button button = createAppendNameButton("" + i, width, height);
            buttons.add(button);
        }
        return buttons;
    }

    private Button createAppendNameButton(String name, int width, int height) {
        Button b = createButton(name, width, height);
        b.setOnAction(event -> {
            this.textArea.appendText(name);
        });
        return b;
    }

    private Button createButton(String name, int width, int height) {
        Button button = new Button(name);
        button.setMinSize(width, height);
        return button;
    }


    public static void main(String[] args) {
        launch(args);
    }
}
