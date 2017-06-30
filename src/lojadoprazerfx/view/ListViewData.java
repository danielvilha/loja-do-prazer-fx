/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojadoprazerfx.view;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

/**
 *
 * @author scopus-dev
 */
public class ListViewData {
    
    @FXML
    private HBox hBox;
    @FXML
    private Label label;
    
    public ListViewData()
    {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ListCellItem.fxml"));
        fxmlLoader.setController(this);
        try
        {
            fxmlLoader.load();
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }
    
    public void setInfo(String string)
    {
        label.setText(string);
    }

    public HBox getBox()
    {
        return hBox;
    }
}
