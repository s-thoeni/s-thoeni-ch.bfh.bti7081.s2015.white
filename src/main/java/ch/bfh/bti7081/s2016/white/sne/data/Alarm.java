package ch.bfh.bti7081.s2016.white.sne.data;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ch.bfh.bti7081.s2016.white.sne.data.enums.Operator;
import ch.bfh.bti7081.s2016.white.sne.data.states.AlarmNotCheckedState;
import ch.bfh.bti7081.s2016.white.sne.data.states.AlarmState;

/**
 * Class representing alarm
 * @author team white
 *
 */
public class Alarm {
	
	/**
	 * Logger for this class
	 */
	private static final Logger logger = LogManager.getLogger(Alarm.class);
	
	private ReportConfig alarmReportConfig;
	private Report alarmReport;
	private Operator operator;
	private int errorValue;
	private int warningValue;
	private AlarmState alarmState;
	

	public Alarm(ReportConfig alarmReportConfig, int errorValue, int warningValue, Operator operator) {
		this.alarmReportConfig = alarmReportConfig;
		this.errorValue = errorValue;
		this.warningValue = warningValue;
		this.operator = operator;
		this.alarmState = new AlarmNotCheckedState();
	}

	
	public Object[] visualizeAlarm(){
		logger.debug("->");
		
		this.alarmState.check(this);
		logger.debug("<-");
		return this.alarmState.visualizeAlarm(this);
	}
	
	public Report getAlarmReport() {
		logger.debug("->");
		logger.debug("<-");
		return this.alarmReport;
	}

	public void setAlarmReport(Report alarmReport) {
		logger.debug("->");
		this.alarmReport = alarmReport;
		logger.debug("<-");
	}

	public int getErrorValue() {
		logger.debug("->");
		logger.debug("<-");
		return this.errorValue;
	}

	public void setErrorValue(int errorValue) {
		logger.debug("->");
		this.errorValue = errorValue;
		logger.debug("<-");
	}

	public int getWarningValue() {
		logger.debug("->");
		logger.debug("<-");
		return this.warningValue;
	}

	public void setWarningValue(int warningValue) {
		logger.debug("->");
		this.warningValue = warningValue;
		logger.debug("<-");
	}

	public ReportConfig getAlarmReportConfig() {
		logger.debug("->");
		logger.debug("<-");
		return this.alarmReportConfig;
	}

	public void setAlarmReportConfig(ReportConfig alarmReportConfig) {
		logger.debug("->");
		this.alarmReportConfig = alarmReportConfig;
		logger.debug("<-");
	}

	public Operator getOperator() {
		logger.debug("->");
		logger.debug("<-");
		return this.operator;
	}

	public void setOperator(Operator operator) {
		logger.debug("->");
		this.operator = operator;
		logger.debug("<-");
	}

	public void setAlarmState(AlarmState alarmState) {
		logger.debug("->");
		logger.debug("<-");
		this.alarmState = alarmState;
	}
	
	public String getAlarmStateString(){
		logger.debug("->");
		logger.debug("<-");
		return this.alarmState.toString();
	}
}
