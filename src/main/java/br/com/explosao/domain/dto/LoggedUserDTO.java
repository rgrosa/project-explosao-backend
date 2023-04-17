package br.com.explosao.domain.dto;

public class LoggedUserDTO {

    private Long id;
    private String username;
    private String password;
    private String jwtToken;

    public LoggedUserDTO(Long id, String username, String password, String jwtToken) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.jwtToken = jwtToken;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getJwtToken() {
        return jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }
}
