package space.zmok.glorywebback.user.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UserCreateRequest {

  private String username;
  private String email;
  private String password;
  private LocalDate birthDate;
}
