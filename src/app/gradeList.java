package app;

import java.io.InputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Map;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;

public class gradeList
{
    /*
    public static void main(String[] args) {
        System.out.println(new gradeList().load());
    }
     */

    Map<String, Object> load()
    {
        InputStream inputStream = null;
        try {
            File file = new File("grade.yml");
            inputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return new Yaml().load(inputStream);
    }

    boolean dump(Map<String, Object> data)
    {
        DumperOptions options = new DumperOptions();
        options.setIndent(4);
        options.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);
        Yaml yaml = new Yaml(options);
        String gradeData = yaml.dump(data);
        // System.out.println(gradeData);

        try {
            FileWriter file = new FileWriter("grade.yml");
            file.write(gradeData);
            file.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}
