package com.example.democustomrepo;

import java.util.Optional;

public interface UserCustomRepository {
    Optional<String> testMethod(Long id);
}
