package space.zmok.glorywebback.dto.user;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UserCreateDTO {

  private String username;
  private String email;
  private String password;
  private LocalDate birthDate;
}
