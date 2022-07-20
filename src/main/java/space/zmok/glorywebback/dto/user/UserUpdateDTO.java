package space.zmok.glorywebback.dto.user;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UserUpdateDTO {

  private String username;
  private String email;
  private String password;
  private LocalDate birthDate;
  private boolean isAllowedToPlay;
}
