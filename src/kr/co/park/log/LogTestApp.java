package kr.co.park.log;

public class LogTestApp {

	public static void main(String[] args) {
		Logger.InitLogger(LogTestApp.class);
		Logger.Write.error("error");
		Logger.Write.warn("warn");
		Logger.Write.info("info");
		Logger.Write.debug("debug");
		Logger.Write.trace("trace exception", new UnsupportedOperationException("test"));
	}

}
