package kr.co.park.log;

import java.io.PrintWriter;
import java.io.StringWriter;

import javax.xml.bind.DatatypeConverter;

import org.slf4j.LoggerFactory;

public class Logger {

	public static org.slf4j.Logger Write = LoggerFactory.getLogger(Logger.class);

	@Deprecated
	private static ILogger globalLogger = null;

	public static String ToHexString(byte[] data) {
		return DatatypeConverter.printHexBinary(data);
	}

	public static void InitLogger(Class<?> clazz) {
		Write = LoggerFactory.getLogger(clazz);
	}

	public static String toOneline(String src) {
		return src.replaceAll("[\r\n\t]+", " ");
	}

	public static String toOneline(String src, String to) {
		return src.replaceAll("[\r\n\t]+", to);
	}

	public static String toOnelineHeader(String src) {
		return toOnelineHeader(src, " ");
	}

	public static String toOnelineHeader(String src, String to) {
		if (src.contains("\r") || src.contains("\n")) {
			String header = src.replaceAll("[\r\n\t]+", to);
			return header + "\n" + src;
		}
		return src;
	}

	public static String formatException(Exception exception) {
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		exception.printStackTrace(pw);
		return sw.toString();
	}

	public static String formatException(String message, Exception exception) {
		return String.format("%s:%s", new Object[] { message, formatException(exception) });
	}

	@Deprecated
	public static void setGlobalLogger(ILogger globalLogger) {
		Logger.globalLogger = globalLogger;
	}

	@Deprecated
	public static void trace(String message) {
		if (globalLogger == null)
			return;
		globalLogger.trace(message);
	}

	@Deprecated
	public static void debug(String message) {
		if (globalLogger == null)
			return;
		globalLogger.debug(message);
	}

	@Deprecated
	public static void info(String message) {
		if (globalLogger == null)
			return;
		globalLogger.info(message);
	}

	@Deprecated
	public static void error(String message) {
		if (globalLogger == null)
			return;
		globalLogger.error(message);
	}

	@Deprecated
	public static void trace(Exception exception) {
		if (globalLogger == null)
			return;
		globalLogger.trace(formatException(exception));
	}

	@Deprecated
	public static void debug(Exception exception) {
		if (globalLogger == null)
			return;
		globalLogger.debug(formatException(exception));
	}

	@Deprecated
	public static void info(Exception exception) {
		if (globalLogger == null)
			return;
		globalLogger.info(formatException(exception));
	}

	@Deprecated
	public static void error(Exception exception) {
		if (globalLogger == null)
			return;
		globalLogger.error(formatException(exception));
	}

	@Deprecated
	public static void trace(String message, Exception exception) {
		if (globalLogger == null)
			return;
		globalLogger.trace(formatException(message, exception));
	}

	@Deprecated
	public static void debug(String message, Exception exception) {
		if (globalLogger == null)
			return;
		globalLogger.debug(formatException(message, exception));
	}

	@Deprecated
	public static void info(String message, Exception exception) {
		if (globalLogger == null)
			return;
		globalLogger.info(formatException(message, exception));
	}

	@Deprecated
	public static void error(String message, Exception exception) {
		if (globalLogger == null)
			return;
		globalLogger.error(formatException(message, exception));
	}
}