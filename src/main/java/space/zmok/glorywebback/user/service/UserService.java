package space.zmok.glorywebback.user.service;

import org.springframework.data.domain.Page;
import space.zmok.glorywebback.user.dto.UserCreateRequest;
import space.zmok.glorywebback.user.dto.UserResponse;
import space.zmok.glorywebback.user.dto.UserUpdateRequest;

import java.util.Optional;
import java.util.UUID;

public interface UserService {

  UserResponse create(UserCreateRequest createDTO);

  Page<UserResponse> getAll(Integer page, Integer size);

  Optional<UserResponse> get(UUID id);

  UserResponse update(UserUpdateRequest updateDTO);

  void delete(UUID id);
}
