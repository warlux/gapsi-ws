package mx.com.gapsi.examen.mm.dto;

import java.io.Serializable;

import org.springframework.data.domain.Page;

import mx.com.gapsi.examen.mm.ws.model.Proveedor;

public class GapsiProveedoresResponseDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String error;
	private Page<Proveedor> data;

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public Page<Proveedor> getData() {
		return data;
	}

	public void setData(Page<Proveedor> data) {
		this.data = data;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
