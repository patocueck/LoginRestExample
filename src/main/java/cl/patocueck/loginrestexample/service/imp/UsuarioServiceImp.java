package cl.patocueck.loginrestexample.service.imp;

import java.util.Date;

import org.springframework.stereotype.Service;

import cl.patocueck.loginrestexample.enums.ErrorEnum;
import cl.patocueck.loginrestexample.enums.LoginEnum;
import cl.patocueck.loginrestexample.model.Usuario;
import cl.patocueck.loginrestexample.service.UsuarioService;
import cl.patocueck.loginrestexample.vo.BaseResponse;
import cl.patocueck.loginrestexample.vo.request.LoginRequest;
import cl.patocueck.loginrestexample.vo.response.LoginResponse;

@Service
public class UsuarioServiceImp implements UsuarioService {

	public BaseResponse<LoginResponse> login(LoginRequest login) {
		
		BaseResponse<LoginResponse> response = new BaseResponse<LoginResponse>();
		if (login.isNotValid()) {
			response.getHeader().setCode(ErrorEnum.DATOS_INVALIDOS.getCode());
			response.getHeader().setMessage(ErrorEnum.DATOS_INVALIDOS.getMessage());

			return response;
		}
		
		LoginResponse body = new LoginResponse();
		Usuario user = new Usuario();
		
		user.setEmail("patocueck@gmail.com");
		user.setPassword("124");
		user.setNombre("Patricio");
		user.setApellidos("Zuniga Pizarro");
		user.setEsAdmin("S");
		
		if (!login.getEmail().equals(user.getEmail()) ){
			response.getHeader().setCode(LoginEnum.USUARIO_NOEXISTE.getCode());
			response.getHeader().setMessage(LoginEnum.USUARIO_NOEXISTE.getMessage());
			return response;
		}

		if (user.getPassword().equals(login.getPassword())){
			response.getHeader().setCode(ErrorEnum.OK.getCode());
			response.getHeader().setMessage(ErrorEnum.OK.getMessage());
			

			body.setEmail(user.getEmail());
			body.setEsAdmin(user.getEsAdmin());
			body.setNombre(user.getNombre());
			body.setApellidos(user.getApellidos());;
			body.setToken(generaToken(user.getEmail() + "/"+ user.getNombre()));
			
			response.setBody(body);

		}else{
			response.getHeader().setCode(LoginEnum.USUARIO_INCORRECTO.getCode());
			response.getHeader().setMessage(LoginEnum.USUARIO_INCORRECTO.getMessage());
		}
			
		return response;
	}

	private String generaToken(String data){
		Date fecha = new Date();
		return data + fecha.toString();
	}
}
