/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.inventory;

import business.drug.Drug;
import java.util.ArrayList;

/**
 *
 * @author Deepthi
 */
public class OrderInventory {
      private ArrayList<InventoryItem> inventoryItemList;
    
    public OrderInventory(){
        inventoryItemList = new ArrayList<InventoryItem>();
    }

    public ArrayList<InventoryItem> getInventoryList() {
        return inventoryItemList;
    }

    public void setInventoryList(ArrayList<InventoryItem> inventoryList) {
        this.inventoryItemList = inventoryList;
    }
    
    //add order item
    public InventoryItem addInventoryItem(Drug drug, int quantity) {
        InventoryItem oi = new InventoryItem();
        oi.setDrug(drug);
        oi.setQuantity(quantity);
        inventoryItemList.add(oi);
        return oi;
    }
    
    public void removeInventoryItem(InventoryItem inventoryItem){
        inventoryItemList.remove(inventoryItem);
    }
}
