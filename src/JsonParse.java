
import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;


public class JsonParse {
    public static void main(String[] args) throws FileNotFoundException {


        JSONParser parser = new JSONParser();

        StringBuilder stringBuilder=new StringBuilder();

        try {
            URL url = Resources.getResource("Employee.json");
            String text = Resources.toString(url, Charsets.UTF_8);
            JSONObject obj = (JSONObject)parser.parse(text);

            JSONArray arr = (JSONArray)obj.get("employees");

            for (int i = 0; i < arr.size(); i++) {
                JSONObject o = (JSONObject) arr.get(i);
                Employee e =  new Employee();
                e.setName(o.get("name").toString());
                e.setEmail(o.get("email").toString());
                stringBuilder.append(e);
            }






        PrintWriter writer = new PrintWriter("Employee.txt");
            writer.println(stringBuilder);

            writer.close();





        } catch (ParseException pe) {

            System.out.println("Position: " + pe.getPosition());
            System.out.println(pe);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}