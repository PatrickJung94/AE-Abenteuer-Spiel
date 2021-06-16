/**
 * ToDo:
 * - add Question
 * - 
 */
package wwae;

import java.io.*;
import java.io.FileReader;
import java.io.FileNotFoundException;    
import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.text.SimpleDateFormat;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import static java.nio.file.StandardOpenOption.*;

public class FileSystem {

    private JSONParser jParser = new JSONParser();
    private final Path RANKING_PATH = Paths.get("ranking.json");

    public FileSystem() {
        //getAllQuestionsFromBundle("output");
    }

    // ============================================================
    // Question Methods
    // ============================================================

    /*
     * @param bundleName Name for the File
     * 
     * @throws FileNFileNotFoundException
     * @throws IOException
     * @throws ParseException
     */
    public void addQuestionToBundle(String bundleName, Question questionObj) {
        JSONArray jFileArray = new JSONArray();
        JSONObject jQuestionObj = new JSONObject();

        ArrayList<String> jQuestionArray = new ArrayList<String>();
        Path jFileObjPath = Paths.get("data/"+bundleName+".json");
        
        if(Files.exists(jFileObjPath)) {
            try(FileReader reader = new FileReader("data/"+bundleName+".json"))
            {        
                if(!reader.toString().isEmpty()) {
                    Object obj = jParser.parse(reader);
                    jFileArray = (JSONArray) obj;
                }

            } 
            catch (FileNotFoundException e) {
                System.out.println("File not Found.");
                e.printStackTrace();
            } 
            catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            } 
            catch (ParseException e) {
                System.out.println("An error occurred parsing the File.");
                e.printStackTrace();
            }
        }

        jQuestionObj.put("text", questionObj.getText());
        
        jQuestionArray.add(questionObj.getAnswers()[0]);
        jQuestionArray.add(questionObj.getAnswers()[1]);
        jQuestionArray.add(questionObj.getAnswers()[2]);
        jQuestionArray.add(questionObj.getAnswers()[3]);
        jQuestionObj.put("answers", jQuestionArray);
    
        jQuestionObj.put("correctIndex", questionObj.getCorrectIndex());

        jQuestionObj.put("textForPhoneJoker", questionObj.getTextForPhoneJoker());

        jQuestionObj.put("difficulty", questionObj.getDifficulty().toString());

        jFileArray.add(jQuestionObj);

        byte jObjData[] = jFileArray.toJSONString().getBytes();

        try (OutputStream out = new BufferedOutputStream(Files.newOutputStream(jFileObjPath, CREATE, TRUNCATE_EXISTING))) {
            out.write(jObjData, 0, jObjData.length);
            out.close();
        }
        catch (IOException e) {
            System.out.println("An error occurred creating the File.");
            e.printStackTrace();
        }
    }

    public boolean isBundleFull(String bundleName) {
        ArrayList<Question> questions = getAllQuestionsFromBundle(bundleName);

        if (questions.size() >= 10) {
            return true;
        } else {
            return false;
        }
    }
    
    public ArrayList<Question> getAllQuestionsFromBundle(String bundleName)
    {
        JSONArray jFileArray = new JSONArray();
        Path jFileObjPath = Paths.get("data/"+bundleName+".json");
        ArrayList<Question> questionList = new ArrayList<Question>();

        if(Files.exists(jFileObjPath)) {
            try(FileReader reader = new FileReader("data/"+bundleName+".json"))
            {        
                Object obj = jParser.parse(reader);

                jFileArray = (JSONArray) obj;

                jFileArray.forEach(jquestion -> questionList.add(parseQuestion((JSONObject) jquestion)));
            } 
            catch (FileNotFoundException e) {
                System.out.println("File not Found.");
                e.printStackTrace();
            } 
            catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            } 
            catch (ParseException e) {
                System.out.println("An error occurred parsing the File.");
                e.printStackTrace();
            }
        }
        return questionList;
    }

    public Question parseQuestion(JSONObject jquestion){
        Question question = new Question();

        question.setText((String) jquestion.get("text"));
        question.setAnswers(parseAnswers((JSONArray) jquestion.get("answers")));
        Long temp = (long) jquestion.get("correctIndex");
        question.setCorrectIndex(temp.intValue());
        question.setTextForPhoneJoker((String) jquestion.get("textForPhoneJoker"));
        if ((String) jquestion.get("difficulty") !=  null) {
            switch ((String) jquestion.get("difficulty")) {
                case "LOW":
                    question.setDifficulty(Difficulty.LOW);
                    break;
                case "MEDIUM":
                    question.setDifficulty(Difficulty.MEDIUM);
                    break;
                case "HARD":
                    question.setDifficulty(Difficulty.HARD);
                    break;
                default:
                    question.setDifficulty(Difficulty.LOW);
            }
        }

        return question;
    }

    public String[] parseAnswers(JSONArray janswer){
        String answers[] = new String[4];

        for(int i = 0; i < 4; i++){
            answers[i] = (String) janswer.get(i);
        }

        return answers;
    }

    public void rewriteBundle(ArrayList<Question> questions, String bundleName) {
        Path path = Paths.get("data/"+bundleName+".json");

        if(Files.exists(path)) {
            File f = path.toFile();
            f.delete();

            for (Question q : questions) {
                this.addQuestionToBundle(bundleName, q);
            }
        }
    }

    // ============================================================
    // Ranking Methods
    // ============================================================

    public void addRankingEntry(Rank rank) {
        JSONArray jFileArray = new JSONArray();
        JSONObject jRankObj = new JSONObject();

        if(Files.exists(RANKING_PATH)) {
            try(FileReader reader = new FileReader(RANKING_PATH.toString()))
            {        
                Object obj = jParser.parse(reader);
                jFileArray = (JSONArray) obj;
            } 
            catch (FileNotFoundException e) {
                System.out.println("File not Found.");
                e.printStackTrace();
            } 
            catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            } 
            catch (ParseException e) {
                System.out.println("An error occurred parsing the File.");
                e.printStackTrace();
            }
        }

        jRankObj.put("name", rank.getName());
        jRankObj.put("score", rank.getScore());
        jRankObj.put("ts", rank.getTimestamp());

        jFileArray.add(jRankObj);

        byte jObjData[] = jFileArray.toJSONString().getBytes();

        try (OutputStream out = new BufferedOutputStream(Files.newOutputStream(RANKING_PATH, CREATE, TRUNCATE_EXISTING))) {
            out.write(jObjData, 0, jObjData.length);
            out.close();
        }
        catch (IOException e) {
            System.out.println("An error occurred creating the File.");
            e.printStackTrace();
        }
    }

    public ArrayList<Rank> getRankings() {
        ArrayList<Rank> rankings = new ArrayList<Rank>();

        File file = RANKING_PATH.toFile();
        boolean empty = !file.exists() || file.length() == 0;

        if(!empty) {
            try(FileReader reader = new FileReader(RANKING_PATH.toString()))
            {        
                Object obj = jParser.parse(reader);
                JSONArray jFileArray = (JSONArray) obj;
                for (int i = 0; i < jFileArray.size(); i++ ) {
                    String name = ((JSONObject)jFileArray.get(i)).get("name").toString();
                    int score = Integer.parseInt(((JSONObject)jFileArray.get(i)).get("score").toString());

                    try {
                        Date date = new SimpleDateFormat("dd.MM.yyyy HH:mm").parse(((JSONObject)jFileArray.get(i)).get("ts").toString());
                        rankings.add(new Rank(name, score, date));
                    } catch (java.text.ParseException e) {
                        System.out.println("RANK: Couldnt parse the Timestamp");
                        e.printStackTrace();
                    }
                }
            } 
            catch (FileNotFoundException e) {
                System.out.println("File not Found.");
                e.printStackTrace();
            } 
            catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            } 
            catch (ParseException e) {
                System.out.println("An error occurred parsing the File.");
                e.printStackTrace();
            }
        }

        return rankings;
    }

    public ArrayList<Rank> getRankingsSortedByScore() {
        ArrayList<Rank> sorted = this.getRankings();
        Collections.sort(sorted, new RankByScoreDESC());

        return sorted;
    }

    public ArrayList<Rank> getRankingsByName(String name, boolean sorted) {
        ArrayList<Rank> filtered = new ArrayList<Rank>();
        if (sorted) {
            for (Rank r : this.getRankingsSortedByScore()) {
                if (r.matches(name)) {
                    filtered.add(r);
                }
            }
        } else {
            for (Rank r : this.getRankings()) {
                if (r.matches(name)) {
                    filtered.add(r);
                }
            }
        }

        return filtered;
    }
}
//Gruß an Markus :D
//Gruß an Christian :D:D