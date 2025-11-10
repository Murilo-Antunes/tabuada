package br.senai.sp.jandira.tabuada.ui;

import br.senai.sp.jandira.tabuada.model.Tabuada;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TelaTabuada extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        stage.setWidth(400);
        stage.setHeight(550);
        stage.setTitle("Tabuada");

        //criando root
        VBox root = new VBox();

        //fazendo titulo e painel superior
        Label lbTitulo = new Label("Tabuada");
        Label lbSubtitulo = new Label("Crie a tabuada que a sua imaginação mandar");

        //estilizando textos
        lbTitulo.setStyle("-fx-text-fill: #b02020; -fx-font-size: 22; -fx-font-weight: bold");
        lbSubtitulo.setStyle("-fx-text-fill: #ffffff; fx-font-size: 12");
        
        //colocando componentes na vbox
        VBox painelSuperior = new VBox();
        painelSuperior.getChildren().addAll(lbTitulo, lbSubtitulo);
        painelSuperior.setPadding(new Insets(10, 0, 10, 10));

        //estilizando painel superior
        painelSuperior.setPrefHeight(70);
        painelSuperior.setStyle("-fx-background-color: #343434; -fx-border-bo-width: 1; -fx-border-color: #1c1c1c;");


        //criando painelCentral
        Label lbMultiplicando = new Label("Multiplicando: ");
        lbMultiplicando.setStyle("-fx-text-fill: white; -fx-font-size: 15");

        Label lbMultiplicador1 = new Label("Menor multiplicador: ");
        lbMultiplicador1.setStyle("-fx-text-fill: white; -fx-font-size: 15");

        Label lbMultiplicador2 = new Label("Maior multiplicador: ");
        lbMultiplicador2.setStyle("-fx-text-fill: white;  -fx-font-size: 15");

        TextField tfMultiplicando = new TextField();
        tfMultiplicando.setPrefSize(200, 20);
        TextField tfMultiplicador1 = new TextField();
        TextField tfMultiplicador2 = new TextField();

        GridPane grid = new GridPane();

        grid.add(lbMultiplicando, 0, 0);
        grid.add(tfMultiplicando, 1, 0);
        grid.add(lbMultiplicador1, 0, 1);
        grid.add(tfMultiplicador1, 1, 1);
        grid.add(lbMultiplicador2, 0, 2);
        grid.add(tfMultiplicador2, 1, 2);

        //estilizando grid
        grid.setStyle("-fx-background-color: #343434;");
        grid.setPrefHeight(100);
        grid.setPadding(new Insets(20, 10, 10, 10));
        grid.setAlignment(Pos.CENTER_LEFT);
        grid.setVgap(10);
        grid.setHgap(20);

        //Criando botoes e painelBotoes
        Button btCalcular = new Button("Calcular");
        btCalcular.setPrefSize(100, 10);
        Button btLimpar = new Button("Limpar");
        btLimpar.setPrefSize(100, 10);
        Button btSair = new Button("Sair");
        btSair.setPrefSize(100, 10);

        HBox painelBotoes = new HBox();
        painelBotoes.getChildren().addAll(btCalcular, btLimpar, btSair);

        //estilizando painel botões
        painelBotoes.setStyle("-fx-background-color: #343434;");
        painelBotoes.setPrefHeight(70);
        painelBotoes.setAlignment(Pos.BASELINE_CENTER);
        painelBotoes.setPadding(new Insets(10, 0, 0, 0));
        painelBotoes.setSpacing(10);

        //Criando saida da lista
        Label lbResultado = new Label("Resultado");
        lbResultado.setStyle("-fx-text-fill: white; -fx-font-size: 22");

        ListView listaTabuada = new ListView();
        listaTabuada.setStyle("-fx-background-color: #595959; ");

        String[] cidades = new String[5];
        cidades[0] = "Itapevi";
        cidades[1] = "Rio";
        cidades[2] = "Rio2";
        cidades[3] = "Rio3";
        cidades[4] = "Rio4";
        listaTabuada.getItems().addAll(cidades);
        listaTabuada.getItems().add("SP");
        listaTabuada.getItems().add("Julio");
        listaTabuada.getItems().add("Madeira");


        VBox painelSaida = new VBox();
        painelSaida.getChildren().addAll(lbResultado, listaTabuada);
        painelSaida.setPrefHeight(300);
        painelSaida.setStyle("-fx-background-color: #343434;");
        painelSaida.setPadding(new Insets(10, 10, 10, 10));

        //Criando a cena
        Scene scene = new Scene(root);

        stage.setScene(scene);

        root.getChildren().addAll(painelSuperior, grid, painelBotoes, painelSaida);


        stage.show();
    }
}
