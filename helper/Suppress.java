package helper;

public class Suppress
{
	@FunctionalInterface
	public interface Unstable<T> { T run() throws Throwable; }
	
	@FunctionalInterface
	public interface UnstableVoid { void run() throws Throwable; }
	
	public static <T> T suppressNull(Unstable<T> unstable)
	{
		try { return unstable.run(); }
		catch (Throwable ignored) { return null; }
	}
	
	public static void suppressNull(UnstableVoid unstable)
	{
		try { unstable.run(); }
		catch (Throwable ignored) {}
	}
}