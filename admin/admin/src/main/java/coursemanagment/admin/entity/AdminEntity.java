package coursemanagment.admin.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "admin")
public class AdminEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int adminId;
    @NotBlank(message = "Admin name cannot be blank")
    @Size(min = 3, max = 50, message = "Admin name must be between 3 and 50 characters")
    private String adminName;

    public AdminEntity(int adminId, String adminName) {
        this.adminId = adminId;
        this.adminName = adminName;
    }

    public AdminEntity() {
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    @Override
    public String toString() {
        return "AdminEntity{" +
                "adminId=" + adminId +
                ", adminName='" + adminName + '\'' +
                '}';
    }
}
