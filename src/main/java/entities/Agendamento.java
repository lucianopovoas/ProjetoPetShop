package entities;

import java.time.LocalDate;

import dto.CadastrarAgendamento;

public class Agendamento {
	private LocalDate dataHoraAgendar;
	private String tipoServico, precoServico;
	
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
	public String getPrecoServico() {
		return precoServico;
	}
	public void setPrecoServico(String precoServico) {
		this.precoServico = precoServico;
	}

	@Override
	public String toString() {
		return "Agendamento dataHoraAgendar=" + dataHoraAgendar + ", tipoServico=" + tipoServico + ", precoServico="
				+ precoServico;
	}
	
	
}
