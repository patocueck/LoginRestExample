package cl.patocueck.loginrestexample.enums;

public enum ErrorEnum {

	OK("00", "Respuesta correcta"),
	DATOS_INVALIDOS("01","Datos Inválidos"),	
	NOK("9999","Error genérico");
	
	private String code;
	private String menssage;
	
	private ErrorEnum(String code, String menssage){
		this.code = code;
		this.menssage = menssage;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return menssage;
	}
	public void setMenssage(String menssage) {
		this.menssage = menssage;
	}
}
