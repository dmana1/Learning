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
public class Inventory {
    private ArrayList<InventoryItem> inventoryList;
    
    public Inventory(){
        inventoryList = new ArrayList<InventoryItem>();
    }

    public ArrayList<InventoryItem> getInventoryList() {
        return inventoryList;
    }

    public void setInventoryList(ArrayList<InventoryItem> inventoryList) {
        this.inventoryList = inventoryList;
    }
    
    //add order item
    public InventoryItem addInventoryItem(Drug drug, int quantity) {
        InventoryItem oi = new InventoryItem();
        oi.setDrug(drug);
        oi.setQuantity(quantity);
        inventoryList.add(oi);
        return oi;
    }
    
    public void removeInventoryItem(InventoryItem inventoryItem){
        inventoryList.remove(inventoryItem);
    }
    
}
