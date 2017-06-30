/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojadoprazerfx.view;

/**
 *
 * @author scopus-dev
 */
import javafx.scene.control.ListCell;

public class ListViewCell extends ListCell<String>
{
    @Override
    public void updateItem(String string, boolean empty)
    {
        super.updateItem(string,empty);
        if(string != null)
        {
            ListViewData data = new ListViewData();
            data.setInfo(string);
        }
    }
}
