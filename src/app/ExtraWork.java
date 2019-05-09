package app;

public class ExtraWork
{
    public String appRootPath()
    {
        String AppPath = System.getProperty("java.class.path");
        StringBuilder x = new StringBuilder();

        if (AppPath.contains(".jar;")) {
            AppPath = "";
        }
        else if (AppPath.contains(".jar")) {
            if (this.isWindows()) {
                String[] tmp = AppPath.split("\\s*\\\\s*");
                for (int i = 0; i < tmp.length-1; i++)
                    x.append(tmp[i]).append("\\");
            } else {
                String[] tmp = AppPath.split("\\s*/\\s*");
                for (int i = 0; i < tmp.length-1; i++)
                    x.append(tmp[i]).append("/");
            }
            AppPath = x.toString();
        } else {
            AppPath = "";
        }
        return AppPath;
    }

    private boolean isWindows()
    {
        String osName = System.getProperty("os.name");
        return osName.contains("Windows");
    }
}
