package br.com.caelum.agiletickets.domain.precos;

import java.math.BigDecimal;

import br.com.caelum.agiletickets.models.Sessao;

public class CalculaPadrao implements CalculadoraDePrecosInter {

	@Override
	public BigDecimal calculaPreco(Sessao sessao) {
		return sessao.getPreco();
	}

}
