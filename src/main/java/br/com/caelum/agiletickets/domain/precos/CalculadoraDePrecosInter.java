package br.com.caelum.agiletickets.domain.precos;

import java.math.BigDecimal;

import br.com.caelum.agiletickets.models.Sessao;

public interface CalculadoraDePrecosInter {
	BigDecimal calculaPreco(Sessao sessao);
}
