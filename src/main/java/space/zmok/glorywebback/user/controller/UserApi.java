package space.zmok.glorywebback.user.controller;

import com.sun.istack.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import space.zmok.glorywebback.user.dto.UserCreateRequest;
import space.zmok.glorywebback.user.dto.UserResponse;
import space.zmok.glorywebback.user.dto.UserUpdateRequest;

import java.util.List;
import java.util.UUID;

public interface UserApi {

  ResponseEntity<UserResponse> createUser(@NotNull UserCreateRequest userRequest);

  ResponseEntity<List<UserResponse>> listUser(int page, int size, @Nullable String sort);

  ResponseEntity<UserResponse> getUserById(@NotNull UUID userId);

  ResponseEntity<UserResponse> updateUser(@NotNull UserUpdateRequest userRequest);

  ResponseEntity<Void> deleteUserById(@NotNull UUID userId);
}
