package com.kardex.serviceImpl;

import com.kardex.dao.UsersDao;
import com.kardex.dto.GenericAnswerDto;
import com.kardex.entities.Users;
import com.kardex.servicesImpl.UserServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class UserServiceImplTest {

    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private UsersDao usersDao;

    private String user;
    private Users users;
    private String userLogin;
    private static final String USER_EMAIL = "admin@correo.com";
    public static final String USER_CREATED_SUCCESFULL = "Usuario creado con exito.";
    public static final String USER_FOUND_SUCCESFULL = "Usuario encontrado.";
    public static final String CODE_SUCCESFULL = "1";
    public static final String CODE_ERROR = "0";
    public static final String LOGIN_INVALID = "Correo o contraseña invalida.";

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        setNewUser();
        setUsers();
        setUserLogin();
        Mockito.when(usersDao.findByEmail(USER_EMAIL)).thenReturn(users);
    }

    @Test
    public void createUser() {
        GenericAnswerDto response = userService.createUser(user);
        assertEquals(response.getMessage(),USER_CREATED_SUCCESFULL);
        assertNotNull(response.getCode(),CODE_SUCCESFULL);
    }


    @Test
    public void findUser() {
        GenericAnswerDto response = userService.findUser(USER_EMAIL);
        assertEquals(response.getMessage(),USER_FOUND_SUCCESFULL);
        assertNotNull(response.getCode(),CODE_SUCCESFULL);
    }

    @Test
    public void login() {
        GenericAnswerDto response = userService.login(userLogin);
        assertEquals(response.getMessage(),LOGIN_INVALID);
        assertNotNull(response.getCode(),CODE_ERROR);
    }

    public void  setUsers(){
        users = new Users(null,"andres","andres@correo.com", "123");
    }

    public void setNewUser() {
        user = "{data: {\r\n"
                + "        \"userName\": \"admin31\",\r\n"
                + "        \"userEmail\": \"adm3i1n@correo.com\",\r\n"
                + "        \"password\": \"1234\"\r\n"
                + "    }\r\n"
                + "}";
    }

    public void setUserLogin(){
        userLogin = "{\n" +
                "    \"data\": {\n" +
                "        \"userEmail\": \"andres@correo.com\",\n" +
                "        \"password\": \"123\"\n" +
                "    }\n" +
                "}";
    }
}
