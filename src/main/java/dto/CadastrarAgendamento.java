package dto;

import java.time.LocalDate;

public class CadastrarAgendamento {
	private LocalDate dataHoraAgendar;
	private String tipoServico;
	private double precoServico;


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
	public double getPrecoServico() {
		return precoServico;
	}
	public void setPrecoServico(double precoServico) {
		this.precoServico = precoServico;
	}
	
}
