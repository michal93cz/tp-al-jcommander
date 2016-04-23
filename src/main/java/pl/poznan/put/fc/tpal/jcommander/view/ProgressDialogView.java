package pl.poznan.put.fc.tpal.jcommander.view;

import javafx.concurrent.Task;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import pl.poznan.put.fc.tpal.jcommander.controller.ProgressDialogController;
import pl.poznan.put.fc.tpal.jcommander.util.BundleUtil;

import java.io.IOException;
import java.util.ResourceBundle;

/**
 * @author Kamil Walkowiak
 */
public class ProgressDialogView {
    private Stage stage;

    public ProgressDialogView(Task<Void> task) throws IOException {
        ResourceBundle bundle = BundleUtil.getInstance().getBundle();

        stage = new Stage();
        stage.initStyle(StageStyle.UTILITY);
        stage.setResizable(false);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle(bundle.getString("operationProgress"));

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ProgressDialogLayout.fxml"));
        loader.setResources(bundle);
        Parent root = loader.load();

        ((ProgressDialogController) loader.getController()).setTask(task);

        stage.setScene(new Scene(root));
        stage.show();
    }

    public void close() {
        stage.close();
    }
}
