package Controller;

import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.event.ActionEvent;

import javafx.scene.control.Label;

import javafx.scene.image.ImageView;

import javafx.scene.input.MouseEvent;

public class LobbyController {
	@FXML
	private ImageView j2Gray;
	@FXML
	private Button startButton;
	@FXML
	private Label statusLabel;
	@FXML
	private ImageView imageLogo;
	@FXML
	private Button quitButton;

	// Event Listener on Button[#startButton].onAction
	@FXML
	public void handleStartButton(ActionEvent event) {
		// TODO Autogenerated
	}
	// Event Listener on Label[#statusLabel].onMouseClicked
	@FXML
	public void updateStatus(MouseEvent event) {
		// TODO Autogenerated
	}
	// Event Listener on Button[#quitButton].onAction
	@FXML
	public void handleQuitButton(ActionEvent event) {
		// TODO Autogenerated
	}
}