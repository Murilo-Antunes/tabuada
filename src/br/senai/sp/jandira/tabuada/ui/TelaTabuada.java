package br.senai.sp.jandira.tabuada.ui;

import br.senai.sp.jandira.tabuada.model.Tabuada;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.util.Optional;

public class TelaTabuada extends Application {

    TextField tfMultiplicando;
    TextField tfMultiplicador1;
    TextField tfMultiplicador2;

    @Override
    public void start(Stage stage) throws Exception {
        stage.setWidth(400);
        stage.setHeight(550);
        stage.setTitle("Tabuada");
        stage.setResizable(false);

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

        tfMultiplicando = new TextField();
        tfMultiplicando.setPrefSize(200, 20);
        tfMultiplicador1 = new TextField();
        tfMultiplicador2 = new TextField();

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

        listaTabuada.getItems().addAll();


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

        btLimpar.setOnAction(e -> {
            tfMultiplicador1.clear();
            tfMultiplicador2.clear();
            tfMultiplicando.clear();
            listaTabuada.getItems().clear();

            tfMultiplicando.requestFocus();
        });

        btSair.setOnAction(e -> {
            Alert alerta = new Alert(Alert.AlertType.CONFIRMATION, "sair do programa?",  ButtonType.YES, ButtonType.NO);

            Optional <ButtonType> resposta = alerta.showAndWait();;
            if (resposta.get()  == ButtonType.YES) {
                System.exit(0);
            }
        });

        btCalcular.setOnAction(e -> {
            if (validarEntrada()){
                Tabuada tabuada = new Tabuada();

                int multiplicando = Integer.parseInt(tfMultiplicando.getText());
                int multiplicador1 = Integer.parseInt(tfMultiplicador1.getText());
                int multiplicador2 = Integer.parseInt(tfMultiplicador2.getText());

                tabuada.multiplicando = multiplicando;
                tabuada.multiplicadorInicial = multiplicador1;
                tabuada.multiplicadorFinal = multiplicador2;

                String[] resultado = tabuada.calcularTabuada();

                listaTabuada.getItems().addAll(resultado);

                //gravar dados da tabuada em arquivo csv
                Path arquivo = Path.of("C:\\Users\\25203706\\ds1t\\tabuada\\dados_tabuada.csv");

                String dados = tfMultiplicando.getText() + ";" + tfMultiplicador1.getText() + ";" + tfMultiplicador2.getText() + ";" + LocalDateTime.now() + "\n";

                try {
                    Files.writeString(arquivo,dados, StandardOpenOption.APPEND); //acrescentar
                } catch (IOException erro){
                    System.out.printf(erro.getMessage());
                }
            }
        });
    }


    public boolean validarEntrada(){
        if (tfMultiplicando.getText().isEmpty()) {
            mostrarAlerta(Alert.AlertType.ERROR, "Digite um valor válido no multiplicando");
            tfMultiplicando.requestFocus();
            return false;
        }else if (tfMultiplicador1.getText().isEmpty()) {
            mostrarAlerta(Alert.AlertType.ERROR, "Digite um valor válido no primeiro multiplicador");
            return false;
        }else if (tfMultiplicador2.getText().isEmpty()) {
            mostrarAlerta(Alert.AlertType.ERROR, "Digite um valor válido no segundo multiplicador");
            return false;
        }
            return true;
    }

    public void mostrarAlerta(Alert.AlertType tipo, String mensagem){
        Alert alerta = new Alert(tipo, mensagem);
        alerta.showAndWait();
    }
}
