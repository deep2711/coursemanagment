package coursemanagment.admin.repository;


import coursemanagment.admin.entity.AdminEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<AdminEntity, Integer> {
    AdminEntity findByAdminName(String adminName);
    boolean existsByAdminName(String adminName);
}
