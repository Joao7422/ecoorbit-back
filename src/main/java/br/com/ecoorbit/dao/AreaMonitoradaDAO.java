package br.com.ecoorbit.dao;

import br.com.ecoorbit.factory.ConnectionFactory;
import br.com.ecoorbit.model.AreaMonitorada;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AreaMonitoradaDAO {

    public void cadastrar(AreaMonitorada area) {
        String sql = "INSERT INTO areas_monitoradas (nome, cidade, estado, tamanho_hectares, usuario_id) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, area.getNome());
            stmt.setString(2, area.getCidade());
            stmt.setString(3, area.getEstado());
            stmt.setDouble(4, area.getTamanhoHectares());
            stmt.setInt(5, area.getUsuarioId());

            stmt.executeUpdate();
            System.out.println("Área monitorada cadastrada com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar área monitorada: " + e.getMessage());
        }
    }

    public List<AreaMonitorada> listar() {
        String sql = "SELECT * FROM areas_monitoradas";
        List<AreaMonitorada> areas = new ArrayList<>();

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                AreaMonitorada area = new AreaMonitorada();

                area.setId(rs.getInt("id"));
                area.setNome(rs.getString("nome"));
                area.setCidade(rs.getString("cidade"));
                area.setEstado(rs.getString("estado"));
                area.setTamanhoHectares(rs.getDouble("tamanho_hectares"));
                area.setUsuarioId(rs.getInt("usuario_id"));

                areas.add(area);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar áreas monitoradas: " + e.getMessage());
        }

        return areas;
    }

    public AreaMonitorada buscarPorId(int id) {
        String sql = "SELECT * FROM areas_monitoradas WHERE id = ?";
        AreaMonitorada area = null;

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                area = new AreaMonitorada();

                area.setId(rs.getInt("id"));
                area.setNome(rs.getString("nome"));
                area.setCidade(rs.getString("cidade"));
                area.setEstado(rs.getString("estado"));
                area.setTamanhoHectares(rs.getDouble("tamanho_hectares"));
                area.setUsuarioId(rs.getInt("usuario_id"));
            }

        } catch (SQLException e) {
            System.out.println("Erro ao buscar área monitorada: " + e.getMessage());
        }

        return area;
    }

    public void atualizar(AreaMonitorada area) {
        String sql = "UPDATE areas_monitoradas SET nome = ?, cidade = ?, estado = ?, tamanho_hectares = ?, usuario_id = ? WHERE id = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, area.getNome());
            stmt.setString(2, area.getCidade());
            stmt.setString(3, area.getEstado());
            stmt.setDouble(4, area.getTamanhoHectares());
            stmt.setInt(5, area.getUsuarioId());
            stmt.setInt(6, area.getId());

            stmt.executeUpdate();
            System.out.println("Área monitorada atualizada com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar área monitorada: " + e.getMessage());
        }
    }

    public void deletar(int id) {
        String sql = "DELETE FROM areas_monitoradas WHERE id = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

            System.out.println("Área monitorada deletada com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao deletar área monitorada: " + e.getMessage());
        }
    }
}