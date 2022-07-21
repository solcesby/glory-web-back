package space.zmok.glorywebback.user.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import space.zmok.glorywebback.user.dto.UserCreateRequest;
import space.zmok.glorywebback.user.dto.UserResponse;
import space.zmok.glorywebback.user.dto.UserUpdateRequest;
import space.zmok.glorywebback.user.mapper.UserMapper;
import space.zmok.glorywebback.user.repository.UserRepository;
import space.zmok.glorywebback.user.service.UserService;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

  //  private final BCryptPasswordEncoder passwordEncoder;
  private final UserRepository userRepository;
  private final UserMapper userMapper;

  @Override
  @Transactional
  public UserResponse create(UserCreateRequest userCreateRequest) {
    var user = userMapper.toEntity(userCreateRequest);
    //    user.setPassword(passwordEncoder.encode(user.getPassword()));
    user = userRepository.save(user);
    return userMapper.toResponse(user);
  }

  @Override
  @Transactional(readOnly = true)
  public Page<UserResponse> getAll(Integer page, Integer size) {
    var pageable = PageRequest.of(Math.max(page - 1, 0), size);
    return userRepository.findAll(pageable).map(userMapper::toResponse);
  }

  @Override
  @Transactional(readOnly = true)
  public Optional<UserResponse> get(UUID id) {
    return userRepository.findById(id).map(userMapper::toResponse);
  }

  @Override
  @Transactional
  public UserResponse update(UserUpdateRequest updateDTO) {
    var user = userMapper.toEntity(updateDTO);
    user = userRepository.save(user);
    return userMapper.toResponse(user);
  }

  @Override
  @Transactional
  public void delete(UUID id) {
    userRepository.deleteById(id);
  }
}
