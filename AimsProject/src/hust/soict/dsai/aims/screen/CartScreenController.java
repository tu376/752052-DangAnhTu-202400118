package hust.soict.dsai.aims.screen;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import hust.soict.dsai.aims.store.Store;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;

public class CartScreenController {
    private Cart cart;
    private Store store; // optional: used when returning to store view

    @FXML
    private TableView<Media> tblMedia;

    @FXML
    private TableColumn<Media, Integer> colMediaId;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private TableColumn<Media, String> colMediaCategory;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private Label lblCost;

    @FXML
    private TextField tfFilter;

    @FXML
    private ToggleGroup filter;

    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    public CartScreenController(Cart cart) {
        super();
        this.cart = cart;
    }

    // single initialize method that sets up table and filtering
    @FXML
    private void initialize() {
        colMediaId.setCellValueFactory(new PropertyValueFactory<Media, Integer>("id"));
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
        colMediaCategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost"));

        // populate table from cart (create an observable list snapshot)
        ObservableList<Media> items = FXCollections.observableArrayList();
        if (cart != null) {
            // Cart may expose items via a getter; if not, this will be a snapshot of current items
            try {
                items.addAll(cart.getItemsOrdered());
            } catch (Exception e) {
                // fallback: leave empty
            }
        }
        tblMedia.setItems(items);

        if (lblCost != null && cart != null) {
            lblCost.setText("Total: " + cart.totalCost() + "$");
        }

        if (tfFilter != null) {
            tfFilter.textProperty().addListener(new ChangeListener<String>() {
                @Override
                public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                    if (newValue == null || newValue.isEmpty()) {
                        tblMedia.setItems(items);
                        return;
                    }
                    // determine filter by ToggleGroup (By Title or By ID)
                    RadioButton selected = (RadioButton) filter.getSelectedToggle();
                    if (selected != null && "By Title".equals(selected.getText())) {
                        final String lower = newValue.toLowerCase();
                        FilteredList<Media> filteredList = new FilteredList<>(items,
                                p -> p.getTitle() != null && p.getTitle().toLowerCase().contains(lower));
                        tblMedia.setItems(filteredList);
                    } else {
                        try {
                            final int id = Integer.parseInt(newValue);
                            FilteredList<Media> filteredList = new FilteredList<>(items,
                                    p -> p.getId() == id);
                            tblMedia.setItems(filteredList);
                        } catch (NumberFormatException e) {
                            // if not a number, show all
                            tblMedia.setItems(items);
                        }
                    }
                }
            });
        }

        // keep button visibility in sync with selection
        if (tblMedia != null) {
            tblMedia.getSelectionModel().selectedItemProperty().addListener((obs, oldSel, newSel) -> {
                updateButtonBar(newSel);
            });
        }
    }

    @FXML
    void btnPlaceOrderPressed(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Place order successfully!");
        alert.showAndWait();
    }

    @FXML
    void btnPlayPressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        if (media == null) return;
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        StringBuilder content = new StringBuilder();
        content.append("Title: " + media.getTitle() + "\n");
        content.append("Category: " + media.getCategory() + "\n");
        alert.setContentText(content.toString());
        alert.setHeaderText("Playing Media");
        alert.showAndWait();
    }

    @FXML
    void btnRemovePressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        if (media == null) return;
        // remove from table view
        tblMedia.getItems().remove(media);
        // try to remove from cart as well
        try {
            cart.removeMedia(media);
        } catch (Exception e) {
            // ignore if cart doesn't expose remove
        }
        if (lblCost != null) lblCost.setText("Total: " + cart.totalCost() + "$");
    }

    @FXML
    void btnViewStorePressed(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader();
        try {
            loader.setLocation(getClass().getResource("../view/Store.fxml"));

            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("View Store");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void updateButtonBar(Media media) {
        if (media == null) {
            if (btnPlay != null) btnPlay.setVisible(false);
            if (btnRemove != null) btnRemove.setVisible(false);
        } else {
            if (btnRemove != null) btnRemove.setVisible(true);
            if (btnPlay != null) {
                if (media instanceof Playable) {
                    btnPlay.setVisible(true);
                } else {
                    btnPlay.setVisible(false);
                }
            }
        }
    }

}