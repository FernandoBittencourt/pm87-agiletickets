package br.com.caelum.agiletickets.domain.precos;

import java.math.BigDecimal;

import br.com.caelum.agiletickets.models.Sessao;

public class CalculaCinemaShow implements CalculadoraDePrecosInter {
	
	@Override
	public BigDecimal calculaPreco(Sessao sessao) {
		Double percentualIngressos = (sessao.getTotalIngressos() - sessao.getIngressosReservados()) / sessao.getTotalIngressos().doubleValue();
		if(percentualIngressos <= 0.05) { 
			return sessao.getPreco().add(sessao.getPreco().multiply(BigDecimal.valueOf(0.10)));
		} 
		return sessao.getPreco();
	}

}
