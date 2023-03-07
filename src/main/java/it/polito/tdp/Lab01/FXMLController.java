package it.polito.tdp.Lab01;

import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.Lab01.model.Parole;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	Parole elenco;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnInserisci;

    @FXML
    private Button btnReset;
    
    @FXML
    private Button btnCancella;

    @FXML
    private TextField txtParola;

    @FXML
    private TextArea txtResult;
    
    @FXML
    private TextArea txtTempo;

    @FXML
    void doInsert(ActionEvent event) {
    	long inizio = System.nanoTime();
    	txtResult.setText("");
    	this.elenco.addParola(txtParola.getText());
    	this.restituire();
    	txtTempo.appendText(""+ ((System.nanoTime()-inizio)/1000000.0) + " Millisecondi\n");
    	
    }
    
    @FXML
    void doCancella(ActionEvent event) {
    	long inizio = System.nanoTime();
    	txtResult.setText("");
    	this.elenco.deleteParola(txtParola.getText());
    	this.restituire();
    	txtTempo.appendText(""+ ((System.nanoTime()-inizio)/1000000.0) + " Millisecondi\n");
    }
    
    void restituire() {
    	List<String> daRestituire = this.elenco.getElenco();
    	for(String s: daRestituire) {
    		txtResult.appendText(s+"\n");
    	}
    }

    @FXML
    void doReset(ActionEvent event) {
    	long inizio = System.nanoTime();
    	this.elenco.reset();
    	txtResult.setText("");
    	txtTempo.appendText(""+ ((System.nanoTime()-inizio)/1000000.0) + " Millisecondi\n");
    }
    

    @FXML
    void initialize() {
    	assert btnCancella != null : "fx:id=\"btnCancella\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        
        elenco = new Parole() ;
    }

}
