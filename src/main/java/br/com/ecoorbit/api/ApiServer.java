package br.com.ecoorbit.api;

import br.com.ecoorbit.dao.AlertaAmbientalDAO;
import br.com.ecoorbit.dao.AreaMonitoradaDAO;
import br.com.ecoorbit.dao.UsuarioDAO;
import br.com.ecoorbit.model.AlertaAmbiental;
import br.com.ecoorbit.model.AreaMonitorada;
import br.com.ecoorbit.model.Usuario;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class ApiServer {

    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);

        server.createContext("/", exchange -> {
            if ("OPTIONS".equalsIgnoreCase(exchange.getRequestMethod())) {
                responderOptions(exchange);
                return;
            }

            String resposta = """
                    {
                      "mensagem": "API EcoOrbit funcionando",
                      "rotas": [
                        "/usuarios",
                        "/areas",
                        "/alertas"
                      ]
                    }
                    """;

            responderJson(exchange, resposta);
        });

        server.createContext("/usuarios", exchange -> {
            if ("OPTIONS".equalsIgnoreCase(exchange.getRequestMethod())) {
                responderOptions(exchange);
                return;
            }

            if (!"GET".equalsIgnoreCase(exchange.getRequestMethod())) {
                responderJson(exchange, "{\"erro\":\"Método não permitido\"}", 405);
                return;
            }

            UsuarioDAO usuarioDAO = new UsuarioDAO();
            List<Usuario> usuarios = usuarioDAO.listar();

            StringBuilder json = new StringBuilder();
            json.append("[");

            for (int i = 0; i < usuarios.size(); i++) {
                Usuario u = usuarios.get(i);

                json.append("{")
                        .append("\"id\":").append(u.getId()).append(",")
                        .append("\"nome\":\"").append(escapar(u.getNome())).append("\",")
                        .append("\"email\":\"").append(escapar(u.getEmail())).append("\",")
                        .append("\"tipo\":\"").append(escapar(u.getTipo())).append("\"")
                        .append("}");

                if (i < usuarios.size() - 1) {
                    json.append(",");
                }
            }

            json.append("]");
            responderJson(exchange, json.toString());
        });

        server.createContext("/areas", exchange -> {
            if ("OPTIONS".equalsIgnoreCase(exchange.getRequestMethod())) {
                responderOptions(exchange);
                return;
            }

            if (!"GET".equalsIgnoreCase(exchange.getRequestMethod())) {
                responderJson(exchange, "{\"erro\":\"Método não permitido\"}", 405);
                return;
            }

            AreaMonitoradaDAO areaDAO = new AreaMonitoradaDAO();
            List<AreaMonitorada> areas = areaDAO.listar();

            StringBuilder json = new StringBuilder();
            json.append("[");

            for (int i = 0; i < areas.size(); i++) {
                AreaMonitorada a = areas.get(i);

                json.append("{")
                        .append("\"id\":").append(a.getId()).append(",")
                        .append("\"nome\":\"").append(escapar(a.getNome())).append("\",")
                        .append("\"cidade\":\"").append(escapar(a.getCidade())).append("\",")
                        .append("\"estado\":\"").append(escapar(a.getEstado())).append("\",")
                        .append("\"tamanhoHectares\":").append(a.getTamanhoHectares()).append(",")
                        .append("\"usuarioId\":").append(a.getUsuarioId())
                        .append("}");

                if (i < areas.size() - 1) {
                    json.append(",");
                }
            }

            json.append("]");
            responderJson(exchange, json.toString());
        });

        server.createContext("/alertas", exchange -> {
            if ("OPTIONS".equalsIgnoreCase(exchange.getRequestMethod())) {
                responderOptions(exchange);
                return;
            }

            if (!"GET".equalsIgnoreCase(exchange.getRequestMethod())) {
                responderJson(exchange, "{\"erro\":\"Método não permitido\"}", 405);
                return;
            }

            AlertaAmbientalDAO alertaDAO = new AlertaAmbientalDAO();
            List<AlertaAmbiental> alertas = alertaDAO.listar();

            StringBuilder json = new StringBuilder();
            json.append("[");

            for (int i = 0; i < alertas.size(); i++) {
                AlertaAmbiental al = alertas.get(i);

                json.append("{")
                        .append("\"id\":").append(al.getId()).append(",")
                        .append("\"tipo\":\"").append(escapar(al.getTipo())).append("\",")
                        .append("\"nivelRisco\":\"").append(escapar(al.getNivelRisco())).append("\",")
                        .append("\"descricao\":\"").append(escapar(al.getDescricao())).append("\",")
                        .append("\"dataAlerta\":\"").append(al.getDataAlerta()).append("\",")
                        .append("\"areaId\":").append(al.getAreaId())
                        .append("}");

                if (i < alertas.size() - 1) {
                    json.append(",");
                }
            }

            json.append("]");
            responderJson(exchange, json.toString());
        });

        server.setExecutor(null);
        server.start();

        System.out.println("API EcoOrbit rodando em http://localhost:8080");
        System.out.println("Rotas disponíveis:");
        System.out.println("GET http://localhost:8080/usuarios");
        System.out.println("GET http://localhost:8080/areas");
        System.out.println("GET http://localhost:8080/alertas");
    }

    private static void responderJson(HttpExchange exchange, String resposta) throws IOException {
        responderJson(exchange, resposta, 200);
    }

    private static void responderJson(HttpExchange exchange, String resposta, int statusCode) throws IOException {
        byte[] bytes = resposta.getBytes(StandardCharsets.UTF_8);

        exchange.getResponseHeaders().set("Content-Type", "application/json; charset=UTF-8");
        exchange.getResponseHeaders().set("Access-Control-Allow-Origin", "*");
        exchange.getResponseHeaders().set("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
        exchange.getResponseHeaders().set("Access-Control-Allow-Headers", "Content-Type");

        exchange.sendResponseHeaders(statusCode, bytes.length);

        try (OutputStream os = exchange.getResponseBody()) {
            os.write(bytes);
        }
    }

    private static void responderOptions(HttpExchange exchange) throws IOException {
        exchange.getResponseHeaders().set("Access-Control-Allow-Origin", "*");
        exchange.getResponseHeaders().set("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
        exchange.getResponseHeaders().set("Access-Control-Allow-Headers", "Content-Type");
        exchange.sendResponseHeaders(204, -1);
    }

    private static String escapar(String texto) {
        if (texto == null) {
            return "";
        }

        return texto
                .replace("\\", "\\\\")
                .replace("\"", "\\\"")
                .replace("\n", " ")
                .replace("\r", " ");
    }
}