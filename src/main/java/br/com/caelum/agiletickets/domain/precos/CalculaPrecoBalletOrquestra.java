package br.com.caelum.agiletickets.domain.precos;

import java.math.BigDecimal;

import br.com.caelum.agiletickets.models.Sessao;

public class CalculaPrecoBalletOrquestra implements CalculadoraDePrecosInter {

	@Override
	public BigDecimal calculaPreco(Sessao sessao) {
		BigDecimal preco = sessao.getPreco();
		Double percentualIngressos = (sessao.getTotalIngressos() - sessao.getIngressosReservados()) / sessao.getTotalIngressos().doubleValue();
		if(percentualIngressos <= 0.50) { 
			preco = sessao.getPreco().add(sessao.getPreco().multiply(BigDecimal.valueOf(0.20)));
		} 
		
		if(sessao.getDuracaoEmMinutos() > 60){
			preco = preco.add(sessao.getPreco().multiply(BigDecimal.valueOf(0.10)));
		}
		return preco;
	}
}
