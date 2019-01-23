package kudrya.design;

import javafx.scene.control.Alert;

public class Message {

    private String title;
    private String detail;
    private String moreDetail;

    public Message(String title, String detail, String moreDetail) {
        this.title = title;
        this.detail = detail;
        this.moreDetail = moreDetail;
    }

    public void show() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(detail);
        alert.setContentText(moreDetail);
        alert.show();
    }
}
