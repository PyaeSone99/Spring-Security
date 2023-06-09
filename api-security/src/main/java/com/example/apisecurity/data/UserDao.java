package com.example.apisecurity.data;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.Optional;

public interface UserDao extends CrudRepository<User,Long> {
    Optional<User> findByEmail(String email);

    @Query("""
select u.* from user u inner join token t on u.id = t.user where u.id =:id 
and t.refresh_token =:refreshToken and t.expired_at >=:expiredAt
""")
    Optional<User> findUserIdAndTokenByRefreshToken(
            @Param("id")Long id,
            @Param("refreshToken")String refreshToken,
            @Param("expiredAt")LocalDateTime expiredAt
            );
}
