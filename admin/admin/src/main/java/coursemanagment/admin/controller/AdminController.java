package coursemanagment.admin.controller;


import coursemanagment.admin.entity.AdminEntity;
import coursemanagment.admin.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/login")
    public String login(@RequestBody AdminEntity admin) {

        AdminEntity storedAdmin = adminService.getAdminByName(admin.getAdminName());

        if (storedAdmin != null && storedAdmin.getAdminName().equals(admin.getAdminName())) {
            return "Login successful";
        } else {
            return "Login failed. Invalid username or password.";
        }
    }
    @PostMapping("/signup")
    public String signup (@RequestBody AdminEntity admin) {
        AdminEntity storedAdmin = adminService.registerAdmin(admin);
        return "Sucessfully signed up";
    }

}
