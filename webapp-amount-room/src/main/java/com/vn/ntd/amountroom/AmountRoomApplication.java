package com.vn.ntd.amountroom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AmountRoomApplication {

  public static void main(String[] args) {
    SpringApplication.run(AmountRoomApplication.class, args);
  }

  // @Bean
  // CommandLineRunner commandLineRunner(PasswordEncoder passwordEncoder) {
  // return args -> {
  // System.out.println("Manager token: " + passwordEncoder.encode("Tanduoc@123admin"));
  //
  // };
  // }
}
