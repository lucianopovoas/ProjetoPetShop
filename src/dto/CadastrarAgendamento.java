package dto;

import java.time.LocalDate;

public class CadastrarAgendamento {
	private LocalDate dataHoraAgendar;
	private String tipoServico, precoServico;


	public LocalDate getDataHoraAgendar() {
		return dataHoraAgendar;
	}
	public void setDataHoraAgendar(LocalDate dataHoraAgendar) {
		this.dataHoraAgendar = dataHoraAgendar;
	}
	public String getTipoServico() {
		return tipoServico;
	}
	public void setTipoServico(String tipoServico) {
		this.tipoServico = tipoServico;
	}
	public String getPrecoServico() {
		return precoServico;
	}
	public void setPrecoServico(String precoServico) {
		this.precoServico = precoServico;
	}
	
}
