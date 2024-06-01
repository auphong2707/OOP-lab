package hust.soict.dsai.aims.screen;

import java.util.function.Predicate;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;

public class CartScreenController {
	
	private Cart cart;
	
	@FXML
	private TableView<Media> tbMedia;
	
	@FXML
	private TableColumn<Media, String> colMediaTitle;
	
	@FXML
	private TableColumn<Media, String> colMediaCategory;
	
	@FXML
	private TableColumn<Media, Float> colMediaCost;
	
	@FXML
	private Button btnPlay;
	
	@FXML
	private Button btnRemove;
	
	@FXML private TextField tfFilter;
	@FXML private RadioButton radioBtnFilterId;
	@FXML private RadioButton radioBtnFilterTitle;
	
	public CartScreenController(Cart cart) {
		super();
		this.cart = cart;
	}
	
	@FXML
	private void initialize() {
		colMediaTitle.setCellValueFactory(
				new PropertyValueFactory<Media, String>("title"));
		
		colMediaCategory.setCellValueFactory(
				new PropertyValueFactory<Media, String>("category"));
		
		colMediaCost.setCellValueFactory(
				new PropertyValueFactory<Media, Float>("cost"));
		
		tbMedia.setItems(this.cart.getItemsOrdered());
		
		btnPlay.setVisible(false);
		btnRemove.setVisible(false);
		
		tbMedia.getSelectionModel().selectedItemProperty().addListener(
				new ChangeListener<Media>() {
				
				@Override
				public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
					if(newValue != null) {
						updateButtonBar(newValue);
					}
				}
			});
		
		tfFilter.textProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {	
				if(newValue.equals("")) {
					tbMedia.setItems(cart.getItemsOrdered());
					return;
				}
				
				showFilteredMedia(newValue);
			}
		});
	}
	
	private void updateButtonBar(Media media) {
		btnRemove.setVisible(true);
		if(media instanceof Playable) {
			btnPlay.setVisible(true);
		}
		else {
			btnPlay.setVisible(false);
		}
	}
	
	@FXML
	private void btnRemovePressed(ActionEvent event) {
		Media media = tbMedia.getSelectionModel().getSelectedItem();
		cart.removeMedia(media);
	}
	
	@FXML
	private void btnPlayPressed(ActionEvent event) {
		Playable media = (Playable) tbMedia.getSelectionModel().getSelectedItem();
		
		Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Playing");
        alert.setHeaderText(null);
        alert.setContentText(media.play());

        alert.showAndWait();
	}
	
	private void showFilteredMedia(String value) {
		Predicate <Media> filter = null;
		if (radioBtnFilterId.isSelected()) {
			filter = (m -> value.equals(String.valueOf(m.getId())));
		}
		else if(radioBtnFilterTitle.isSelected()) {
			filter = (m -> value.equals(m.getTitle()));
		}
		
		FilteredList<Media> filteredCartItems = new FilteredList<Media>(cart.getItemsOrdered(), filter);
		
		tbMedia.setItems(filteredCartItems);
	}
	
}
