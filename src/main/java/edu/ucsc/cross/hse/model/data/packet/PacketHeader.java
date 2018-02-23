package edu.ucsc.cross.hse.model.data.packet;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYDataset;

import edu.ucsc.cross.hse.core.chart.ChartType;
import edu.ucsc.cross.hse.core.chart.ChartUtils;
import edu.ucsc.cross.hse.core.figure.Figure;
import edu.ucsc.cross.hse.core.trajectory.HybridTime;
import edu.ucsc.cross.hse.core.trajectory.TrajectorySet;

public interface PacketHeader
{

	public Object getSource();

	public Object getTarget();

	public double getHeaderSize();

	public <T> T getIdTag(Class<T> type);

	public static Figure nodeChart2(TrajectorySet solution)
	{
		XYDataset dataset = ChartUtils.createXYDataset(solution, HybridTime.TIME, "sizeSent");
		JFreeChart plot = ChartUtils.createXYChart(solution, dataset, null, null, ChartType.LINE);
		ChartPanel panel = ChartUtils.createPanel(plot);
		XYDataset dataset2 = ChartUtils.createXYDataset(solution, HybridTime.TIME, "sizeReceived");
		JFreeChart plot2 = ChartUtils.createXYChart(solution, dataset2, null, null, ChartType.LINE);
		ChartPanel panel2 = ChartUtils.createPanel(plot2);
		ChartUtils.configureLabels(panel, "Time (sec)", "Sent Size", null, false);
		ChartUtils.configureLabels(panel2, "Time (sec)", "Received Size", null, false);

		Figure figure = new Figure(1000, 500);
		figure.addComponent(0, 0, panel);
		figure.addComponent(1, 0, panel2);
		return figure;
	}
}
