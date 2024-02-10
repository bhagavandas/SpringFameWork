package com.example.demo.utilities;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.example.demo.DTO.LoginDTO;
import com.example.demo.repository.IUserRepository;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenUtil {

	@Autowired
	IUserRepository repo;
	LoginDTO loginDTO = new LoginDTO();
	// @Value("${jwt.secret}")
	private String secret = "spring";

	public String generateToken(LoginDTO loginDTO) {
		Map<String, Object> claims = new HashMap<>();
		claims.put("Email", loginDTO.getEmail());
		claims.put("Password", loginDTO.getPassword());

		System.out.println("claims : " + claims);

		return doGenerateToken(claims);
	}

	private String doGenerateToken(Map<String, Object> claims) {

		return Jwts.builder().setClaims(claims)
				// .setIssuedAt(new Date(System.currentTimeMillis()))
				// .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY *
				// 1000))
				.signWith(SignatureAlgorithm.HS512, secret).compact();
	}

	public LoginDTO deCode(String token) {

		final Map<String, Object> claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
		loginDTO.setEmail((String) claims.get("Email"));
		loginDTO.setPassword((String) claims.get("Password"));
		return loginDTO;
	}

	public String generateToken(String employeeId, String employeeName) {
//		Map<String, Object> claims = new HashMap<>();
//		claims.put("Email", loginDTO.getEmail());
//		claims.put("Password", loginDTO.getPassword()); //payload
		Map<String, Object> claims = new HashMap<>();
		claims.put("ID", employeeId);
		claims.put("Employee Name", employeeName);
		System.out.println("claims : " + claims);
		System.out.println("Generated Token for : ");
		return doGenerateToken(claims);
	}
}
