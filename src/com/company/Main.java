package com.company;
import java.awt.*;
import java.io.*;
import java.sql.SQLException;
import com.opencsv.exceptions.CsvException;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.ui.ApplicationFrame;
import org.jfree.chart.ui.RectangleInsets;
import org.jfree.data.category.CategoryDataset;
import javax.swing.*;

public class Main {

    public static void main(String[] args) throws CsvException, IOException, SQLException {
        ImportAndCheck.Connect();
        ImportAndCheck.CreateTable("Спортивные учреждения.csv");
        Main m = new Main();
        ApplicationFrame frame = new ApplicationFrame("Общий объем финансирования");
        frame.setMinimumSize(new Dimension(800,800));
        frame.add(m.createDemoPanel());
        frame.setVisible(true);
        ImportAndCheck.SecondTusk();
        ImportAndCheck.ThirdTusk();
    }
    private JFreeChart createChart(CategoryDataset dataset)
    {
        JFreeChart chart = ChartFactory.createBarChart(
                "Общий объем финансирования",
                null,
                "Рублей",
                dataset);
        chart.setBackgroundPaint(Color.white);

        CategoryPlot plot = (CategoryPlot) chart.getPlot();

        NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setDrawBarOutline(false);
        chart.getLegend().setFrame(BlockBorder.NONE);
        return chart;
    }
    public JPanel createDemoPanel() throws SQLException {
        JFreeChart chart = createChart(ImportAndCheck.FirstTask());
        chart.setPadding(new RectangleInsets(4, 8, 2, 2));
        ChartPanel panel = new ChartPanel(chart);
        panel.setFillZoomRectangle(true);
        panel.setMouseWheelEnabled(true);
        panel.setPreferredSize(new Dimension(600, 300));
        return panel;
    }
}
