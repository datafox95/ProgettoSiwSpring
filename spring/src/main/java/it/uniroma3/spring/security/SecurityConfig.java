
//PROBLEMI DI GESTIONE DELLA SICUREZZA CODICE COMMENTATO PER EVITARE CONFLITTI E MALFUNZIONAMENTI

/*package it.uniroma3.spring.security;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;

	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource)
		.usersByUsernameQuery("select username,password from admin where username=?")
		.authoritiesByUsernameQuery("select nome_admin, ruolo from ruoli_admin where username=?");
		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/index.html","/stanze", "/opere","/pageOpere","/pageStanze","/pageArtisti","/mostraOPera","/mostraAutore", "/mostraStanza","/","/artisti")                    
		.permitAll();
		
		http.authorizeRequests().antMatchers("/areaRiservata").hasRole("ADMIN_ROLE")
		.anyRequest().authenticated().and().formLogin().loginPage("/login").permitAll().and().logout()
		.permitAll();
		
	}
}*/