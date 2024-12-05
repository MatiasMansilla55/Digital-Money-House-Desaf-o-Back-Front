package com.example.demo.repository;



import com.example.demo.dto.entry.UserEntryDto;
import com.example.demo.dto.exit.UserRegisterOutDto;
import com.example.demo.entity.User;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User>findByEmail(String email);
    boolean existsByAlias(String alias); // Verificar si un alias ya existe
    //Optional<User>findByName(String userName);
    boolean existsByEmail(String email); // Verificar si un email ya existe
    //boolean existsByUserName(String userName); // Verificar si un nombre de usuario ya existe
    public User getUserById(Long id);
    @Modifying
    @Transactional
    @Query("UPDATE User u SET u.alias = :alias WHERE u.id = :id")
    int updateAlias(@Param("id") Long id, @Param("alias") String alias);
}


