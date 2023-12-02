package com.cali.citeats.Service;

import com.cali.citeats.Entity.MenuItemEntity;
import com.cali.citeats.Repository.MenuItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.Optional;

@Service
@CrossOrigin(origins = "http://localhost:3000") 
public class MenuItemService {

    private final MenuItemRepository menuItemRepository;

    @Autowired
    public MenuItemService(MenuItemRepository menuItemRepository) {
        this.menuItemRepository = menuItemRepository;
    }

    public List<MenuItemEntity> getAllMenuItems() {
        return menuItemRepository.findAll();
    }

    public MenuItemEntity getMenuItemById(int id) {
        Optional<MenuItemEntity> menuItem = menuItemRepository.findById(id);
        return menuItem.orElse(null);
    }

    public MenuItemEntity createMenuItem(MenuItemEntity menuItem) {
        return menuItemRepository.save(menuItem);
    }

    public MenuItemEntity updateMenuItem(int id, MenuItemEntity menuItem) {
        Optional<MenuItemEntity> existingMenuItem = menuItemRepository.findById(id);

        if (existingMenuItem.isPresent()) {
            menuItem.setMenuItemId(id);
            return menuItemRepository.save(menuItem);
        } else {
            return null;
        }
    }

    public String deleteMenuItem(int id) {
        if (menuItemRepository.existsById(id)) {
            menuItemRepository.deleteById(id);
            return "Menu item with ID " + id + " deleted successfully";
        } else {
            return "Menu item with ID " + id + " not found";
        }
    }
}
