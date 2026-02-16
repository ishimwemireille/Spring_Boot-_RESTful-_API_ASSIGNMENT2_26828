
package auca.ac.rw.question6_userprofile_api.controller;

import auca.ac.rw.question6_userprofile_api.model.UserProfile;
import auca.ac.rw.question6_userprofile_api.response.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserProfileController {

    private List<UserProfile> users = new ArrayList<>();

    public UserProfileController() {

        users.add(new UserProfile(1L, "mireille",
                "mireille@example.com", "Ishimwe Mireille",
                22, "Rwanda", "Software Engineering Student", true));

        users.add(new UserProfile(2L, "ericdev",
                "eric@example.com", "Eric Ndayisenga",
                25, "Rwanda", "Backend Developer", true));

        users.add(new UserProfile(3L, "janedoe",
                "jane@example.com", "Jane Doe",
                28, "Kenya", "Tech Enthusiast", false));
    }


    @GetMapping
    public ResponseEntity<ApiResponse<List<UserProfile>>> getAllUsers() {
        return ResponseEntity.ok(
                new ApiResponse<>(true, "Users retrieved successfully", users));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<ApiResponse<UserProfile>> getUserById(@PathVariable Long userId) {

        for (UserProfile user : users) {
            if (user.getUserId().equals(userId)) {
                return ResponseEntity.ok(
                        new ApiResponse<>(true, "User found", user));
            }
        }

        return ResponseEntity.status(404)
                .body(new ApiResponse<>(false, "User not found", null));
    }

 
    @GetMapping("/search")
    public ResponseEntity<ApiResponse<List<UserProfile>>> searchByUsername(@RequestParam String username) {

        List<UserProfile> result = new ArrayList<>();

        for (UserProfile user : users) {
            if (user.getUsername().toLowerCase().contains(username.toLowerCase())) {
                result.add(user);
            }
        }

        return ResponseEntity.ok(
                new ApiResponse<>(true, "Search completed", result));
    }

    @GetMapping("/country/{country}")
    public ResponseEntity<ApiResponse<List<UserProfile>>> getByCountry(@PathVariable String country) {

        List<UserProfile> result = new ArrayList<>();

        for (UserProfile user : users) {
            if (user.getCountry().equalsIgnoreCase(country)) {
                result.add(user);
            }
        }

        return ResponseEntity.ok(
                new ApiResponse<>(true, "Users filtered by country", result));
    }


    @GetMapping("/age-range")
    public ResponseEntity<ApiResponse<List<UserProfile>>> getByAgeRange(
            @RequestParam int min,
            @RequestParam int max) {

        List<UserProfile> result = new ArrayList<>();

        for (UserProfile user : users) {
            if (user.getAge() >= min && user.getAge() <= max) {
                result.add(user);
            }
        }

        return ResponseEntity.ok(
                new ApiResponse<>(true, "Users filtered by age range", result));
    }

   
    @PostMapping
    public ResponseEntity<ApiResponse<UserProfile>> addUser(@RequestBody UserProfile user) {

        users.add(user);

        return ResponseEntity.status(201)
                .body(new ApiResponse<>(true, "User created successfully", user));
    }

 
    @PutMapping("/{userId}")
    public ResponseEntity<ApiResponse<UserProfile>> updateUser(
            @PathVariable Long userId,
            @RequestBody UserProfile updatedUser) {

        for (UserProfile user : users) {
            if (user.getUserId().equals(userId)) {

                user.setUsername(updatedUser.getUsername());
                user.setEmail(updatedUser.getEmail());
                user.setFullName(updatedUser.getFullName());
                user.setAge(updatedUser.getAge());
                user.setCountry(updatedUser.getCountry());
                user.setBio(updatedUser.getBio());
                user.setActive(updatedUser.isActive());

                return ResponseEntity.ok(
                        new ApiResponse<>(true, "User updated successfully", user));
            }
        }

        return ResponseEntity.status(404)
                .body(new ApiResponse<>(false, "User not found", null));
    }

    // Activate user
    @PatchMapping("/{userId}/activate")
    public ResponseEntity<ApiResponse<UserProfile>> activateUser(@PathVariable Long userId) {

        for (UserProfile user : users) {
            if (user.getUserId().equals(userId)) {
                user.setActive(true);
                return ResponseEntity.ok(
                        new ApiResponse<>(true, "User activated", user));
            }
        }

        return ResponseEntity.status(404)
                .body(new ApiResponse<>(false, "User not found", null));
    }

    @PatchMapping("/{userId}/deactivate")
    public ResponseEntity<ApiResponse<UserProfile>> deactivateUser(@PathVariable Long userId) {

        for (UserProfile user : users) {
            if (user.getUserId().equals(userId)) {
                user.setActive(false);
                return ResponseEntity.ok(
                        new ApiResponse<>(true, "User deactivated", user));
            }
        }

        return ResponseEntity.status(404)
                .body(new ApiResponse<>(false, "User not found", null));
    }

    
    @DeleteMapping("/{userId}")
    public ResponseEntity<ApiResponse<Void>> deleteUser(@PathVariable Long userId) {

        for (UserProfile user : users) {
            if (user.getUserId().equals(userId)) {
                users.remove(user);
                return ResponseEntity.ok(
                        new ApiResponse<>(true, "User deleted successfully", null));
            }
        }

        return ResponseEntity.status(404)
                .body(new ApiResponse<>(false, "User not found", null));
    }
}
