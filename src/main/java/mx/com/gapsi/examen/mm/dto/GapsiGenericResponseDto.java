package mx.com.gapsi.examen.mm.dto;

import java.io.Serializable;

public class GapsiGenericResponseDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String error;

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
