package auca.ac.rw.question3_restaurant_api.controller;

import auca.ac.rw.question3_restaurant_api.model.MenuItem;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/menu")
public class MenuController {

    private List<MenuItem> menuItems = new ArrayList<>();

    public MenuController() {

        menuItems.add(new MenuItem(1L, "Sambusa",
                "Fried pastry filled with meat or vegetables",
                1.5, "Appetizer", true));

        menuItems.add(new MenuItem(2L, "Grilled Tilapia",
                "Fresh grilled fish served with vegetables",
                8.0, "Main Course", true));

        menuItems.add(new MenuItem(3L, "Chicken Brochettes",
                "Grilled chicken skewers",
                7.5, "Main Course", true));

        menuItems.add(new MenuItem(4L, "Chapati",
                "Soft flatbread",
                1.0, "Appetizer", true));

        menuItems.add(new MenuItem(5L, "Fruit Salad",
                "Mixed seasonal fruits",
                3.0, "Dessert", true));

        menuItems.add(new MenuItem(6L, "Chocolate Cake",
                "Rich chocolate layered cake",
                4.5, "Dessert", false));

        menuItems.add(new MenuItem(7L, "Fresh Juice",
                "Natural fruit juice",
                2.5, "Beverage", true));

        menuItems.add(new MenuItem(8L, "Coffee",
                "Hot brewed coffee",
                2.0, "Beverage", true));
    }

    
    @GetMapping
    public ResponseEntity<List<MenuItem>> getAllMenuItems() {
        return ResponseEntity.ok(menuItems);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MenuItem> getMenuItemById(@PathVariable Long id) {

        for (MenuItem item : menuItems) {
            if (item.getId().equals(id)) {
                return ResponseEntity.ok(item);
            }
        }

        return ResponseEntity.notFound().build();
    }

    
    @GetMapping("/category/{category}")
    public ResponseEntity<List<MenuItem>> getByCategory(@PathVariable String category) {

        List<MenuItem> result = new ArrayList<>();

        for (MenuItem item : menuItems) {
            if (item.getCategory().equalsIgnoreCase(category)) {
                result.add(item);
            }
        }

        return ResponseEntity.ok(result);
    }

    
    @GetMapping("/available")
    public ResponseEntity<List<MenuItem>> getAvailableItems(@RequestParam boolean available) {

        List<MenuItem> result = new ArrayList<>();

        for (MenuItem item : menuItems) {
            if (item.isAvailable() == available) {
                result.add(item);
            }
        }

        return ResponseEntity.ok(result);
    }

    
    @GetMapping("/search")
    public ResponseEntity<List<MenuItem>> searchByName(@RequestParam String name) {

        List<MenuItem> result = new ArrayList<>();

        for (MenuItem item : menuItems) {
            if (item.getName().toLowerCase().contains(name.toLowerCase())) {
                result.add(item);
            }
        }

        return ResponseEntity.ok(result);
    }

   
    @PostMapping
    public ResponseEntity<MenuItem> addMenuItem(@RequestBody MenuItem menuItem) {

        menuItems.add(menuItem);
        return ResponseEntity.status(201).body(menuItem);
    }

   
    @PutMapping("/{id}/availability")
    public ResponseEntity<MenuItem> toggleAvailability(@PathVariable Long id) {

        for (MenuItem item : menuItems) {
            if (item.getId().equals(id)) {
                item.setAvailable(!item.isAvailable());
                return ResponseEntity.ok(item);
            }
        }

        return ResponseEntity.notFound().build();
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMenuItem(@PathVariable Long id) {

        for (MenuItem item : menuItems) {
            if (item.getId().equals(id)) {
                menuItems.remove(item);
                return ResponseEntity.noContent().build();
            }
        }

        return ResponseEntity.notFound().build();
    }
}
