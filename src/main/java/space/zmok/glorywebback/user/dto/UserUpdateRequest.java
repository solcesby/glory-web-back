package space.zmok.glorywebback.user.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UserUpdateRequest {

  private String username;
  private String email;
  private String password;
  private LocalDate birthDate;
  private boolean isAllowedToPlay;
}
