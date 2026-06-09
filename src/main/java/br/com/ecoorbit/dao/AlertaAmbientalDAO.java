package br.com.ecoorbit.dao;

import br.com.ecoorbit.factory.ConnectionFactory;
import br.com.ecoorbit.model.AlertaAmbiental;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlertaAmbientalDAO {

    public void cadastrar(AlertaAmbiental alerta) {
        String sql = "INSERT INTO alertas_ambientais (tipo, nivel_risco, descricao, data_alerta, area_id) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, alerta.getTipo());
            stmt.setString(2, alerta.getNivelRisco());
            stmt.setString(3, alerta.getDescricao());
            stmt.setDate(4, Date.valueOf(alerta.getDataAlerta()));
            stmt.setInt(5, alerta.getAreaId());

            stmt.executeUpdate();
            System.out.println("Alerta ambiental cadastrado com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar alerta ambiental: " + e.getMessage());
        }
    }

    public List<AlertaAmbiental> listar() {
        String sql = "SELECT * FROM alertas_ambientais";
        List<AlertaAmbiental> alertas = new ArrayList<>();

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                AlertaAmbiental alerta = new AlertaAmbiental();

                alerta.setId(rs.getInt("id"));
                alerta.setTipo(rs.getString("tipo"));
                alerta.setNivelRisco(rs.getString("nivel_risco"));
                alerta.setDescricao(rs.getString("descricao"));
                alerta.setDataAlerta(rs.getDate("data_alerta").toLocalDate());
                alerta.setAreaId(rs.getInt("area_id"));

                alertas.add(alerta);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar alertas ambientais: " + e.getMessage());
        }

        return alertas;
    }

    public AlertaAmbiental buscarPorId(int id) {
        String sql = "SELECT * FROM alertas_ambientais WHERE id = ?";
        AlertaAmbiental alerta = null;

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                alerta = new AlertaAmbiental();

                alerta.setId(rs.getInt("id"));
                alerta.setTipo(rs.getString("tipo"));
                alerta.setNivelRisco(rs.getString("nivel_risco"));
                alerta.setDescricao(rs.getString("descricao"));
                alerta.setDataAlerta(rs.getDate("data_alerta").toLocalDate());
                alerta.setAreaId(rs.getInt("area_id"));
            }

        } catch (SQLException e) {
            System.out.println("Erro ao buscar alerta ambiental: " + e.getMessage());
        }

        return alerta;
    }

    public void atualizar(AlertaAmbiental alerta) {
        String sql = "UPDATE alertas_ambientais SET tipo = ?, nivel_risco = ?, descricao = ?, data_alerta = ?, area_id = ? WHERE id = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, alerta.getTipo());
            stmt.setString(2, alerta.getNivelRisco());
            stmt.setString(3, alerta.getDescricao());
            stmt.setDate(4, Date.valueOf(alerta.getDataAlerta()));
            stmt.setInt(5, alerta.getAreaId());
            stmt.setInt(6, alerta.getId());

            stmt.executeUpdate();
            System.out.println("Alerta ambiental atualizado com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar alerta ambiental: " + e.getMessage());
        }
    }

    public void deletar(int id) {
        String sql = "DELETE FROM alertas_ambientais WHERE id = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

            System.out.println("Alerta ambiental deletado com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao deletar alerta ambiental: " + e.getMessage());
        }
    }
}