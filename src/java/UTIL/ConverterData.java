/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package batec.util;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Jonatas Teodoro
 */
public class ConverterData {

    public Date stringToDate(String data) throws ParseException {
        SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
        if (data == null || data.trim().equals("")) {
            return null;
        } else {
            Date date = fmt.parse(data);
            return date;
        }
    }

    public String dateToString(Date data) {
        SimpleDateFormat out = new SimpleDateFormat("dd/MM/yyyy");
        String result = out.format(data);
        return result;
    }

    public double diferencaEmDias(Date dataInicial, Date dataFinal) {
        double result = 0;
        long diferenca = dataFinal.getTime() - dataInicial.getTime();
        double diferencaEmDias = (diferenca / 1000) / 60 / 60 / 24; //resultado é diferença entre as datas em dias
        long horasRestantes = (diferenca / 1000) / 60 / 60 % 24; //calcula as horas restantes
        result = diferencaEmDias + (horasRestantes / 24d); //transforma as horas restantes em fração de dias

        return result;
    }

    public double diferencaEmHoras(Date dataInicial, Date dataFinal) {
        double result = 0;
        long diferenca = dataFinal.getTime() - dataInicial.getTime();
        long diferencaEmHoras = (diferenca / 1000) / 60 / 60;
        long minutosRestantes = (diferenca / 1000) / 60 % 60;
        double horasRestantes = minutosRestantes / 60d;
        result = diferencaEmHoras + (horasRestantes);

        return result;
    }

    public double diferencaEmMinutos(Date dataInicial, Date dataFinal) {
        double result = 0;
        long diferenca = dataFinal.getTime() - dataInicial.getTime();
        double diferencaEmMinutos = (diferenca / 1000) / 60; //resultado é diferença entre as datas em minutos
        long segundosRestantes = (diferenca / 1000) % 60; //calcula os segundos restantes
        result = diferencaEmMinutos + (segundosRestantes / 60d); //transforma os segundos restantes em minutos

        return result;
    }

    public String timeToString(Time hora) {

        SimpleDateFormat out = new SimpleDateFormat("HH:mm:ss");
        String result = out.format(hora);
        return result;
    }
}
