package syskathelpproject.syskathelpproject.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig  extends WebSecurityConfigurerAdapter {
	@Autowired
private DataSource datasource;
	
@Override 
protected void configure(AuthenticationManagerBuilder auth ) throws Exception {
PasswordEncoder passwordEncoder =  passwordEncoder();

System.out.println(passwordEncoder
		().encode("admin"));
	auth.jdbcAuthentication()
	.dataSource(datasource)
	.authoritiesByUsernameQuery("SELECT username as principal, password as credentials,enabled FROM Users WHERE username=?")

	.authoritiesByUsernameQuery("SELECT u.username as principal, r.role as role FROM users_roles ur,users u,role r WHERE r.id=ur.roles_id AND u.id= ur.users_id AND u.username=?")
	  .passwordEncoder(NoOpPasswordEncoder.getInstance());//.passwordEncoder(passwordEncoder);

	
}
//@Override 
protected void configure1(HttpSecurity http) throws Exception {
	http.formLogin().loginPage("/login");
	http.authorizeRequests().antMatchers("/login").permitAll();
		
	 http.authorizeRequests()
    .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll();
	 http.authorizeRequests().antMatchers("/list**","/edit**","/add**","/dashboard").hasAnyRole("ADMIN");
	 http.authorizeRequests().anyRequest().authenticated();
	
	
}
@Override
protected void configure(HttpSecurity http) throws Exception {
	
	 http.authorizeRequests()
   .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll();
    http.csrf().disable()
            .authorizeRequests()
            .antMatchers("/login","/registration").permitAll()
            .anyRequest().authenticated()
            .and()
            .formLogin()
            .loginPage("/login").defaultSuccessUrl("/dashboard")
            .permitAll()
            .and()
            .logout()
            .permitAll();
}

@Bean
public BCryptPasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
}

}
