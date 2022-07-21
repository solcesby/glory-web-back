package space.zmok.glorywebback.user.controller;

import com.sun.istack.NotNull;
import io.swagger.v3.oas.annotations.headers.Header;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;
import space.zmok.glorywebback.common.util.WebUtils;
import space.zmok.glorywebback.user.dto.UserCreateRequest;
import space.zmok.glorywebback.user.dto.UserResponse;
import space.zmok.glorywebback.user.dto.UserUpdateRequest;
import space.zmok.glorywebback.user.service.UserService;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;
import java.util.UUID;

import static space.zmok.glorywebback.common.util.WebConsts.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController implements UserApi {

  private final UserService userService;

  @Override
  @PostMapping
  @ApiResponse(responseCode = CREATED, headers = @Header(name = LOCATION))
  public ResponseEntity<UserResponse> createUser(
      @RequestBody @Valid @NotNull UserCreateRequest userCreateRequest) {
    var response = userService.create(userCreateRequest);
    var location = WebUtils.getByIdLocation(response.getId());
    return ResponseEntity.created(location).body(response);
  }

  @Override
  @GetMapping
  @ApiResponse(responseCode = OK, headers = @Header(name = X_TOTAL_COUNT))
  public ResponseEntity<List<UserResponse>> listUser(
      @RequestParam(name = "page", required = false, defaultValue = "1") @Min(1) int page,
      @RequestParam(name = "size", required = false, defaultValue = "20") @Min(1) @Max(100)
          int size,
      @RequestParam(name = "sort", required = false) @Nullable String sort) {
    var responses = userService.getAll(page, size);
    return ResponseEntity.status(HttpStatus.OK)
        .header("X-Total-Count", String.valueOf(responses.getTotalElements()))
        .body(responses.toList());
  }

  @Override
  @GetMapping("/{id}")
  @ApiResponse(responseCode = OK)
  public ResponseEntity<UserResponse> getUserById(@PathVariable("id") @NotNull UUID userId) {
    var response = userService.get(userId);
    return ResponseEntity.of(response);
  }

  @Override
  @PutMapping
  @ApiResponse(responseCode = OK)
  public ResponseEntity<UserResponse> updateUser(
      @RequestBody @Valid @NotNull UserUpdateRequest userRequest) {
    var response = userService.update(userRequest);
    return ResponseEntity.ok(response);
  }

  @Override
  @DeleteMapping("/{id}")
  @ApiResponse(responseCode = NO_CONTENT)
  public ResponseEntity<Void> deleteUserById(@PathVariable("id") @NotNull UUID userId) {
    userService.delete(userId);
    return ResponseEntity.noContent().build();
  }
}
