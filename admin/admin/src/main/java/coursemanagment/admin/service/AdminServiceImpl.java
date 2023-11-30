package coursemanagment.admin.service;



import coursemanagment.admin.entity.AdminEntity;
import coursemanagment.admin.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService{

    private final AdminRepository adminRepository;

    @Autowired
    public AdminServiceImpl(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public AdminEntity getAdminByName(String adminName) {
        return adminRepository.findByAdminName(adminName);
    }

    @Override
    public boolean existsByAdminName(String adminName) {
        return adminRepository.existsByAdminName(adminName);

    }
@Override
    public AdminEntity registerAdmin(AdminEntity admin) {
        try {

            if (existsByAdminName(admin.getAdminName())) {
                throw new RuntimeException("Username already exists");
            }

            return adminRepository.save(admin);
        } catch (Exception e) {
            throw new RuntimeException("Failed to register the admin.", e);
        }
    }


}
