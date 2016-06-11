package br.com.caelum.agiletickets.domain.precos;

import java.math.BigDecimal;

import br.com.caelum.agiletickets.models.Sessao;
import br.com.caelum.agiletickets.models.TipoDeEspetaculo;

public class CalculadoraDePrecos {

	public static BigDecimal calcula(Sessao sessao, Integer quantidade) {

		TipoDeEspetaculo tipoEspetaculoSessao = sessao.getEspetaculo()
				.getTipo();
		if (tipoEspetaculoSessao.equals(TipoDeEspetaculo.CINEMA)
				|| tipoEspetaculoSessao.equals(TipoDeEspetaculo.SHOW)) {
			return new CalculaCinemaShow().calculaPreco(sessao);
		} else if (tipoEspetaculoSessao.equals(TipoDeEspetaculo.BALLET)
				|| (tipoEspetaculoSessao.equals(TipoDeEspetaculo.ORQUESTRA))) {
			return new CalculaPrecoBalletOrquestra().calculaPreco(sessao);
		}
		return new CalculaPadrao().calculaPreco(sessao).multiply(BigDecimal.valueOf(quantidade));
	}
}