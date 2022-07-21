package space.zmok.glorywebback.user.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import space.zmok.glorywebback.user.dto.UserCreateRequest;
import space.zmok.glorywebback.user.dto.UserResponse;
import space.zmok.glorywebback.user.dto.UserUpdateRequest;
import space.zmok.glorywebback.user.entity.UserEntity;

@Mapper(componentModel = "spring")
public interface UserMapper {

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "createdAt", ignore = true)
  @Mapping(target = "updatedAt", ignore = true)
  @Mapping(target = "deletedAt", ignore = true)
  UserEntity toEntity(UserResponse dto);

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "createdAt", ignore = true)
  @Mapping(target = "updatedAt", ignore = true)
  @Mapping(target = "deletedAt", ignore = true)
  UserEntity toEntity(UserCreateRequest dto);

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "createdAt", ignore = true)
  @Mapping(target = "updatedAt", ignore = true)
  @Mapping(target = "deletedAt", ignore = true)
  UserEntity toEntity(UserUpdateRequest dto);

  UserResponse toResponse(UserEntity entity);
}
