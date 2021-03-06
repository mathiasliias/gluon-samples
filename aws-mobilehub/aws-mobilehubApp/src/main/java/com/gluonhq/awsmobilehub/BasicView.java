package com.gluonhq.awsmobilehub;

import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.control.Icon;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class BasicView extends View {

    public BasicView() {
        
        Label label = new Label("Gluon - AWS Mobile Hub");

        Label signIn = new Label("Accesing signed view...");
        signIn.setGraphic(new Icon(MaterialDesignIcon.VPN_LOCK));
        
        VBox controls = new VBox(15.0, label, signIn);
        controls.setAlignment(Pos.CENTER);
        
        setCenter(controls);
        
        setOnShowing(e -> {
            if (! AWSService.getInstance().isSignedIn()) {
                getApplication().switchView(AwsMobileHub.SIGNED_OUT_VIEW);
            }
        });
    }

    @Override
    protected void updateAppBar(AppBar appBar) {
        appBar.setNavIcon(MaterialDesignIcon.MENU.button(e -> System.out.println("Menu")));
        appBar.setTitleText("AWS Mobile Hub");
    }
    
}
