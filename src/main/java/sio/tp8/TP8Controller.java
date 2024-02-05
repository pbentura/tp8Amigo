package sio.tp8;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;

public class TP8Controller implements Initializable {

    private ArrayList<Integer> lesNumerosDuJoueur;
    private ArrayList<Integer> lesNumerosDeLOrdinateur;
    private ArrayList<Integer> nbsEnCommuns;

//    private int nbNumerosChoisisJoueur;
    Button btnSelect;

    @FXML
    private Button btn1Joueur;
    @FXML
    private Button btn9Joueur;
    @FXML
    private Button btn2Joueur;
    @FXML
    private Button btn3Joueur;
    @FXML
    private Button btn4Joueur;
    @FXML
    private Button btn5Joueur;
    @FXML
    private Button btn6Joueur;
    @FXML
    private Button btn7Joueur;
    @FXML
    private Button btn8Joueur;
    @FXML
    private Button btnJouer;
    @FXML
    private Button btn9Ordi;
    @FXML
    private Button btn2Ordi;
    @FXML
    private Button btn3Ordi;
    @FXML
    private Button btn4Ordi;
    @FXML
    private Button btn5Ordi;
    @FXML
    private Button btn6Ordi;
    @FXML
    private Button btn7Ordi;
    @FXML
    private Button btn8Ordi;
    @FXML
    private Button btn1Ordi;
    @FXML
    private Label lblNbCommuns;
    @FXML
    private Button btnReset;
    @FXML
    private GridPane grdJoueur;
    @FXML
    private GridPane grdOrdinateur;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        lesNumerosDuJoueur = new ArrayList<>();
        lesNumerosDeLOrdinateur = new ArrayList<>();
        nbsEnCommuns = new ArrayList<>();
    }

    @FXML
    public void btnJoueurClicked(Event event)
    {
        // A vous de jouer
        btnSelect = (Button) event.getSource();
        couleurBoutonJoueur(btnSelect);

        if (lesNumerosDuJoueur.size() < 4 &&
                !nombreDejaChoisi(Integer.valueOf(btnSelect.getText()), lesNumerosDuJoueur))
        {
            lesNumerosDuJoueur.add(Integer.valueOf(btnSelect.getText()));
        }
        else
        {
            lesNumerosDuJoueur.remove(Integer.valueOf(btnSelect.getText()));
        }
    }

    public boolean nombreDejaChoisi(int valeur,ArrayList<Integer> uneListe)
    {
        boolean trouve = false;

        // A vous de jouer
        if (uneListe.contains(valeur))
        {
            trouve = true;
        }
        return  trouve;
    }

    @FXML
    public void btnJouerClicked(Event event)
    {
        // A vous de jouer
        System.out.println("num joueur "+lesNumerosDuJoueur);
//        System.out.println(nbNumerosChoisisJoueur);

        if(lesNumerosDuJoueur.size() != 4)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Nombre de numéros choisis");
            alert.setHeaderText("");
            alert.setContentText("Il faut choisir 4 numéros");
            alert.showAndWait();
        }
        else
        {
            lesNumerosDeLOrdinateur.clear();

            while (lesNumerosDeLOrdinateur.size() < 4)
            {
                int nbOrdi = new Random().nextInt(9) + 1;

                if (!nombreDejaChoisi(nbOrdi, lesNumerosDeLOrdinateur)) {
                    lesNumerosDeLOrdinateur.add(nbOrdi);
                }
            }

            nbsEnCommuns.clear();
            if (nombreDejaChoisi(lesNumerosDuJoueur.get(0), lesNumerosDeLOrdinateur)){
                nbsEnCommuns.add(lesNumerosDuJoueur.get(0));
            }
            if (nombreDejaChoisi(lesNumerosDuJoueur.get(1), lesNumerosDeLOrdinateur)){
                nbsEnCommuns.add(lesNumerosDuJoueur.get(1));
            }
            if (nombreDejaChoisi(lesNumerosDuJoueur.get(2), lesNumerosDeLOrdinateur)){
                nbsEnCommuns.add(lesNumerosDuJoueur.get(2));
            }
            if (nombreDejaChoisi(lesNumerosDuJoueur.get(3), lesNumerosDeLOrdinateur)){
                nbsEnCommuns.add(lesNumerosDuJoueur.get(3));
            }

            lblNbCommuns.setText(nbsEnCommuns.toString());

            System.out.println("num ordinateur "+lesNumerosDeLOrdinateur.toString());
        }
    }

    @FXML
    public void btnResetClicked(Event event)
    {
        // A vous de jouer
        lesNumerosDeLOrdinateur.clear();
        lesNumerosDuJoueur.clear();
        nbsEnCommuns.clear();
        lblNbCommuns.setText("");

        for (Node node : grdJoueur.getChildren())
        {
            if (node instanceof Button)
            {
                Button button = (Button) node;
                button.setStyle("-fx-background-color: #14e8ff;");
            }
        }
        for (Node node : grdOrdinateur.getChildren())
        {
            if (node instanceof Button)
            {
                Button button = (Button) node;
                button.setStyle("-fx-background-color: #fd86e5;");
            }
        }
    }

    public void couleurBoutonJoueur(Button bouton)
    {
        // A vous de jouer
        if (lesNumerosDuJoueur.size() < 4 &&
                !nombreDejaChoisi(Integer.valueOf(btnSelect.getText()), lesNumerosDuJoueur)) {
            bouton.setStyle("-fx-background-color: #FCF805;");
        }
        else {
            bouton.setStyle("-fx-background-color: #14e8ff;");
        }

    }

    public void couleurBoutonOrdinateur(int valeur)
    {
        // A vous de jouer

    }
}