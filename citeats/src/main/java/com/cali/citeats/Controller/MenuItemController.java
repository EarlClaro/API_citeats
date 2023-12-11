package com.cali.citeats.Controller;

import com.cali.citeats.Entity.MenuItemEntity;
import com.cali.citeats.Service.MenuItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    // R - Read a menu item by ID
    @GetMapping("/getMenuItemById/{id}")
    public ResponseEntity<MenuItemEntity> getMenuItemById(@PathVariable int id) {
        MenuItemEntity menuItem = menuItemService.getMenuItemById(id);
        if (menuItem != null) {
            return new ResponseEntity<>(menuItem, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    // R - Read menu items by restaurant ID
    @GetMapping("/getByRestaurantId/{restaurantId}")
    public ResponseEntity<List<MenuItemEntity>> getMenuItemsByRestaurantId(@PathVariable int restaurantId) {
        List<MenuItemEntity> menuItems = menuItemService.getMenuItemsByRestaurantId(restaurantId);
        if (!menuItems.isEmpty()) {
            return new ResponseEntity<>(menuItems, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
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
    
    // D - Delete a menu item (Soft Delete)
    @PutMapping("/softDeleteMenuItem/{id}")
    public Map<String, String> softDeleteMenuItem(@PathVariable int id) {
        Map<String, String> response = new HashMap<>();
        String result = menuItemService.softDeleteMenuItem(id);
        
        if (result.startsWith("Menu item with ID " + id + " deleted successfully")) {
            response.put("status", "success");
            response.put("message", result);
        } else {
            response.put("status", "error");
            response.put("message", result);
        }
        
        return response;
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
