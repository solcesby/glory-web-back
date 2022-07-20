package space.zmok.glorywebback.dto.user;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UserDTO {

  private String username;
  private String email;
  private LocalDate birthDate;
  private boolean isAllowedToPlay;
}
