package entities;

import java.time.LocalDate;

import dto.CadastrarAgendamento;

public class Agendamento {
	private LocalDate dataHoraAgendar;
	private String tipoServico;
	private double precoServico;
	
	public Agendamento(CadastrarAgendamento castrarAgendamento) {
		this.dataHoraAgendar = castrarAgendamento.getDataHoraAgendar();
		this.tipoServico = castrarAgendamento.getTipoServico();
		this.precoServico = castrarAgendamento.getPrecoServico();
	}
	
	
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

	@Override
	public String toString() {
		return "Agendamento dataHoraAgendar=" + dataHoraAgendar + ", tipoServico=" + tipoServico + ", precoServico="
				+ precoServico;
	}
	
	
}
