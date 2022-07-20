package space.zmok.glorywebback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import space.zmok.glorywebback.entity.UserEntity;

import java.util.UUID;

public interface UserRepository extends JpaRepository<UserEntity, UUID> {}
