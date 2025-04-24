////package Check.Authentication.Repositories;
////
////import Check.Authentication.Entities.User;
////import org.springframework.data.jpa.repository.JpaRepository;
////
////import java.util.Optional;
////import java.util.UUID;
////
////public interface UserRepository extends JpaRepository<User, UUID> {
////    Optional<User> findByEmail(String email); // Find user by email
////}
//
//
//
//
//
//
//
//
//package Check.Authentication.Repositories;
//
//import Check.Authentication.Entities.User;
//import org.springframework.data.jpa.repository.JpaRepository;
//
//import java.lang.ScopedValue;
//import java.util.UUID;
//
//public interface UserRepository extends JpaRepository<User, UUID> {
//    boolean existsByEmail(String email);
//
//
//
//}





package Check.Authentication.Repositories;

import Check.Authentication.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

    Optional<User> findByName(String name);

    boolean existsByEmail(String email);

    List<User> findByNameIn(List<String> names); // ✅ Use 'name' here, not 'username'
}
