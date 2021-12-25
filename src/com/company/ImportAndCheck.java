package com.company;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.jfree.data.category.DefaultCategoryDataset;

import java.io.Console;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.sql.*;
import java.util.*;

public class ImportAndCheck {
    private static final String DB_URL = "jdbc:sqlite:Спортивные_Учреждения.db";
    public static Connection connection;
    public static Statement stmt;
    private static final String CREATE_TABLE_QUERY = "CREATE TABLE IF NOT EXISTS Sports_Facility ("
            + "id INTEGER PRIMARY KEY, "
            + "Название TEXT NOT NULL, "
            + "НазваниеEng TEXT NOT NULL,"
            + "Активный TEXT NOT NULL, "
            + "Краткое_описание TEXT, "
            + "Детальное_описание TEXT, "
            + "Краткое_описаниеEng TEXT, "
            + "Детальное_описаниеEng TEXT, "
            + "МО TEXT, "
            + "Субъект_федерации TEXT, "
            + "Значимость TEXT, "
            + "Населённый_пункт TEXT, "
            + "Населённый_пунктEng TEXT, "
            + "Адрес TEXT, "
            + "АдресEng TEXT, "
            + "ОКТМО TEXT, "
            + "ФЦП TEXT, "
            + "Действия_с_объектом TEXT, "
            + "Дата_начала_строительства DATETIME, "
            + "Дата_завершения_строительства DATETIME, "
            + "Общий_объем_финансирования DOUBLE, "
            + "Финансирование_из_федерального_бюджета DOUBLE, "
            + "Финансирование_из_федерального_бюджета_освоено DOUBLE, "
            + "Финансирование_из_бюджета_субъекта_федерации DOUBLE, "
            + "Финансирование_из_бюджета_субъекта_федерации_освоено DOUBLE, "
            + "Финансирование_из_бюджета_муниципального_образования DOUBLE, "
            + "Финансирование_из_бюджета_муниципального_образования_освоено DOUBLE, "
            + "Финансирование_из_внебюджетных_источников DOUBLE, "
            + "Финансирование_из_внебюджетных_источников_освоено DOUBLE, "
            + "Ключевой TEXT, "
            + "Курирующий_орган TEXT, "
            + "Курирующий_органEng TEXT, "
            + "Адрес_курирующего_органа TEXT, "
            + "Адрес_курирующего_органаEng TEXT, "
            + "Телефон_курирующего_органа TEXT, "
            + "Контактный_телефон_объекта TEXT, "
            + "Режим_работы_будни TEXT, "
            + "Режим_работы_суббота TEXT, "
            + "Режим_работы_воскресенье TEXT, "
            + "Площадь INTEGER, "
            + "Email TEXT, "
            + "URL_сайта TEXT, "
            + "Реестр TEXT, "
            + "Тип_спортивного_комплекса TEXT, "
            + "Соревнования TEXT, "
            + "Виды_спорта TEXT, "
            + "Яндекс_координата_объекта_X DOUBLE, "
            + "Яндекс_координата_объекта_Y DOUBLE, "
            + "Масштаб_Яндекс_карты DOUBLE, "
            + "Яндекс_координата_центра_X DOUBLE, "
            + "Яндекс_координата_центра_Y DOUBLE, "
            + "Мини_координата_X DOUBLE, "
            + "Мини_координата_Y DOUBLE, "
            + "Генеральный_план INTEGER, "
            + "Дополнительные_планы INTEGER, "
            + "Фото INTEGER, "
            + "URL_фото TEXT, "
            + "Видео INTEGER, "
            + "Панорамы INTEGER, "
            + "Web_трансляции INTEGER, "
            + "Прочие_материалы INTEGER)";
    private static final String INSERT_SPORTS_QUERY = "INSERT INTO Sports_Facility VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?," +
            " ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, " +
            "?, ?, ?, ?, ?, ?, ?, ?, ?, ?," +
            " ?, ?, ?, ?, ?, ?, ?, ?, ?, ?," +
            " ?, ?, ?, ?, ?, ?, ?, ?, ?," +
            " ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    public static void Connect() throws SQLException {
        connection = DriverManager.getConnection(DB_URL);
        stmt = connection.createStatement();
    }

    public static DefaultCategoryDataset FirstTask() throws SQLException {
        PreparedStatement stm = connection.prepareStatement("SELECT Дата_завершения_строительства, Общий_объем_финансирования FROM Sports_Facility");
        ResultSet result  = stm.executeQuery();
        TreeMap<Integer, Double> map = new TreeMap<>();
        while (result.next()) {
            if(result.getString(1) != null){
                Integer date = Integer.parseInt(result.getString(1).split("-")[0]);
                if (map.containsKey(date)){
                    map.replace(date, map.get(date),
                            map.get(date) + result.getDouble(2));
                }
                else{
                    map.put(date, result.getDouble(2));
                }
            }
        }
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for(Integer k: map.keySet()) {
            dataset.addValue(map.get(k), "Общий объем финансирования", k.toString());
        }
        return dataset;
    }

    public static void SecondTusk() throws SQLException {
        PreparedStatement stm = connection.prepareStatement("SELECT Общий_объем_финансирования FROM Sports_Facility " +
                "WHERE Дата_начала_строительства between date('2012-01-01') and date('2012-12-31')");
        ResultSet result  = stm.executeQuery();
        Long totalFundingAverage = (long)0;
        Long count = (long)0;
        while (result.next()) {
            totalFundingAverage += result.getLong(1);
            count++;
        }
        System.out.println("Средний общий объём финансирования за 2012 год: " + totalFundingAverage/count + " рублей");
    }

    public static void ThirdTusk() throws SQLException {
        PreparedStatement stm = connection.prepareStatement("SELECT Max(Общий_объем_финансирования), Название FROM Sports_Facility " +
                "WHERE Тип_спортивного_комплекса = \"стадион\" or Тип_спортивного_комплекса = \"многофункциональный спортивный комплекс\"");
        ResultSet result  = stm.executeQuery();
        while (result.next()) {
            System.out.println(String.format("%s - постройка с максимальным размером финансирования = %d рублей" +
                    "\nсреди многофункциональных спортивных комплексов и стадионов", result.getString(2), result.getLong(1)));
        }
    }

    public static void CreateTable(String name) throws SQLException {
        stmt.execute(CREATE_TABLE_QUERY);
        try (CSVReader reader = new CSVReader(new FileReader(name, Charset.forName("windows-1251")));
             PreparedStatement stmt = connection.prepareStatement(INSERT_SPORTS_QUERY)) {
            List<String[]> allRows = reader.readAll();
            List<sportsFacility> facilities = new ArrayList<>();
            allRows.remove(0);
            allRows.remove(allRows.size()-1);
            for(String[] row : allRows) {
                facilities.add(new sportsFacility(row));
            }
            for(sportsFacility s: facilities) {
                stmt.setString(1, s.getId());
                stmt.setString(2, s.getName());
                stmt.setString(3, s.getNameEnglish());
                stmt.setString(4, s.getActive());
                stmt.setString(5, s.getsDescription());
                stmt.setString(6, s.getlDescription());
                stmt.setString(7, s.getsDescriptionEnglish());
                stmt.setString(8, s.getlDescriptionEnglish());
                stmt.setString(9, s.getMo());
                stmt.setString(10, s.getSubject());
                stmt.setString(11, s.getSignificance());
                stmt.setString(12, s.getLocality());
                stmt.setString(13, s.getLocalityEnglish());
                stmt.setString(14, s.getAddress());
                stmt.setString(15, s.getAddressEnglish());
                stmt.setString(16, s.getArctmu());
                stmt.setString(17, s.getFtp());
                stmt.setString(18, s.getActions());
                try {
                    stmt.setString(19, s.getConstructionStartDate().toString());
                } catch (Exception e) {
                    stmt.setString(19, null);
                }
                try {
                    stmt.setString(20, s.getConstructionEndDate().toString());
                } catch (Exception e) {
                    stmt.setString(20, null);
                }
                try {
                    stmt.setString(21, s.getTotalFunding().toString());
                } catch (Exception e) {
                    stmt.setString(21, null);
                }
                try {
                    stmt.setString(22, s.getFundingFederalBudget().toString());
                } catch (Exception e) {
                    stmt.setString(22, null);
                }
                try {
                    stmt.setString(23, s.getFundingFederalBudgetMastered().toString());
                } catch (Exception e) {
                    stmt.setString(23, null);
                }
                try {
                    stmt.setString(24, s.getFundingFederalSubjectBudget().toString());
                } catch (Exception e) {
                    stmt.setString(24, null);
                }
                try {
                    stmt.setString(25, s.getFundingFederalSubjectBudgetMastered().toString());
                } catch (Exception e) {
                    stmt.setString(25, null);
                }
                try {
                    stmt.setString(26, s.getFundingMunicipalityBudget().toString());
                } catch (Exception e) {
                    stmt.setString(26, null);
                }
                try {
                    stmt.setString(27, s.getFundingMunicipalityBudgetMastered().toString());
                } catch (Exception e) {
                    stmt.setString(27, null);
                }
                try {
                    stmt.setString(28, s.getFundingExtraBudgetarySources().toString());
                } catch (Exception e) {
                    stmt.setString(28, null);
                }
                try {
                    stmt.setString(29, s.getFundingExtraBudgetarySourcesMastered().toString());
                } catch (Exception e) {
                    stmt.setString(29, null);
                }
                stmt.setString(30, s.getCore());
                stmt.setString(31, s.getSupervisingAuthority());
                stmt.setString(32, s.getSupervisingAuthorityEnglish());
                stmt.setString(33, s.getSupervisingAuthorityAddress());
                stmt.setString(34, s.getSupervisingAuthorityEnglishAddress());
                stmt.setString(35, s.getSupervisingAuthorityPhone());
                stmt.setString(36, s.getObjectContactPhone());
                stmt.setString(37, s.getWorkingHoursWeekdays());
                stmt.setString(38, s.getWorkingHoursSaturday());
                stmt.setString(39, s.getWorkingHoursSunday());
                try {
                    stmt.setString(40, s.getArea().toString());
                } catch (Exception e) {
                    stmt.setString(40, null);
                }
                stmt.setString(41, s.getEmail());
                stmt.setString(42, s.getUrl());
                stmt.setString(43, s.getRegister());
                stmt.setString(44, s.getSportsComplexType());
                stmt.setString(45, s.getCompetitions());
                stmt.setString(46, s.getSports());
                try {
                    stmt.setString(47, s.getYandexX().toString());
                } catch (Exception e) {
                    stmt.setString(47, null);
                }
                try {
                    stmt.setString(48, s.getYandexY().toString());
                } catch (Exception e) {
                    stmt.setString(48, null);
                }
                try {
                    stmt.setString(49, s.getYandexScale().toString());
                } catch (Exception e) {
                    stmt.setString(49, null);
                }
                try {
                    stmt.setString(50, s.getYandexCenterX().toString());
                } catch (Exception e) {
                    stmt.setString(50, null);
                }
                try {
                    stmt.setString(51, s.getYandexCenterY().toString());
                } catch (Exception e) {
                    stmt.setString(51, null);
                }
                try {
                    stmt.setString(52, s.getMiniX().toString());
                } catch (Exception e) {
                    stmt.setString(52, null);
                }
                try {
                    stmt.setString(53, s.getMiniY().toString());
                } catch (Exception e) {
                    stmt.setString(53, null);
                }
                try {
                    stmt.setString(54, s.getGeneralPlan().toString());
                } catch (Exception e) {
                    stmt.setString(54, null);
                }
                try {
                    stmt.setString(55, s.getExtraPlan().toString());
                } catch (Exception e) {
                    stmt.setString(55, null);
                }
                try {
                    stmt.setString(56, s.getPhoto().toString());
                } catch (Exception e) {
                    stmt.setString(56, null);
                }
                stmt.setString(57, s.getUrlPhoto());
                try {
                    stmt.setString(58, s.getVideo().toString());
                } catch (Exception e) {
                    stmt.setString(58, null);
                }
                try {
                    stmt.setString(59, s.getPanorama().toString());
                } catch (Exception e) {
                    stmt.setString(59, null);
                }
                try {
                    stmt.setString(60, s.getWebStreams().toString());
                } catch (Exception e) {
                    stmt.setString(60, null);
                }
                try {
                    stmt.setString(61, s.getOthers().toString());
                } catch (Exception e) {
                    stmt.setString(61, null);
                }
                stmt.execute();
            }
        }
        catch (IOException exc) {
            exc.printStackTrace();
        } catch (CsvException e) {
            e.printStackTrace();
        }
    }
}
