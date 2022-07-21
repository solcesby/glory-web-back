package space.zmok.glorywebback.user.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class UserResponse {

  private UUID id;
  private String username;
  private String email;
  private LocalDate birthDate;
  private boolean isAllowedToPlay;
}
