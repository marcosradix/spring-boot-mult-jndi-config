package br.com.workmade.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import br.com.workmade.model.Cargos;

public class CargosRowMapper implements RowMapper<Cargos> {
	@Override
	public Cargos mapRow(ResultSet rs, int rowNum) throws SQLException {
		Cargos cargo = new Cargos();
		cargo.setId(rs.getInt("id"));
		cargo.setNome(rs.getString("nome"));
		cargo.setIdDepartamentoFk(rs.getInt("id_departamento_fk"));
		return cargo;
	}
}