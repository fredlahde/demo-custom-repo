package com.example.democustomrepo;

import java.util.Optional;

public interface UserCustomRepository {
    Optional<String> getNameByID(Long id);
}
