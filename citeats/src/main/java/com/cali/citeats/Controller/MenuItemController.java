package com.cali.citeats.Controller;

import com.cali.citeats.Entity.MenuItemEntity;
import com.cali.citeats.Service.MenuItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menuitems")
@CrossOrigin(origins = "http://localhost:3000")
public class MenuItemController {

    @Autowired
    private MenuItemService menuItemService;

    // C - Create a menu item
    @PostMapping("/createMenuItem")
    public ResponseEntity<MenuItemEntity> createMenuItem(@RequestBody MenuItemEntity menuItem) {
        MenuItemEntity createdMenuItem = menuItemService.createMenuItem(menuItem);
        return new ResponseEntity<>(createdMenuItem, HttpStatus.CREATED);
    }

    // R - Read all menu items
    @GetMapping("/getAllMenuItems")
    public ResponseEntity<List<MenuItemEntity>> getAllMenuItems() {
        List<MenuItemEntity> menuItems = menuItemService.getAllMenuItems();
        return new ResponseEntity<>(menuItems, HttpStatus.OK);
    }

    // U - Update a menu item
    @PutMapping("/updateMenuItem/{id}")
    public ResponseEntity<MenuItemEntity> updateMenuItem(@PathVariable int id, @RequestBody MenuItemEntity menuItem) {
        MenuItemEntity updatedMenuItem = menuItemService.updateMenuItem(id, menuItem);
        if (updatedMenuItem != null) {
            return new ResponseEntity<>(updatedMenuItem, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // D - Delete a menu item
    @DeleteMapping("/deleteMenuItem/{id}")
    public ResponseEntity<String> deleteMenuItem(@PathVariable int id) {
        String result = menuItemService.deleteMenuItem(id);
        if (result.startsWith("Menu item with ID " + id + " deleted successfully")) {
            return new ResponseEntity<>(result, HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }
    }
}
