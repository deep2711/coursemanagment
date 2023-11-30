package coursemanagment.admin.service;

import coursemanagment.admin.entity.AdminEntity;

public interface AdminService {
    public AdminEntity getAdminByName(String adminName);
    boolean existsByAdminName(String adminName);

    public AdminEntity registerAdmin(AdminEntity admin);

}
