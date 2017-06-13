package cl.patocueck.loginrestexample.service;


import cl.patocueck.loginrestexample.vo.BaseResponse;
import cl.patocueck.loginrestexample.vo.request.LoginRequest;
import cl.patocueck.loginrestexample.vo.response.LoginResponse;


public interface UsuarioService {
	
	public BaseResponse<LoginResponse> login(LoginRequest login);
}
