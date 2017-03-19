
package beproject;

/**
 *
* @author Student
 */
import java.io.File;
import java.io.IOException;
import java.util.*;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import jxl.read.biff.BiffException;

import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableCell;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

import edu.stanford.nlp.ling.CoreAnnotations.LemmaAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.SentencesAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.TokensAnnotation;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.util.CoreMap;

public class JExcelAPIDemo
{
    protected StanfordCoreNLP pipeline;

    JExcelAPIDemo(int id, String rev) throws Exception
    {
        String hotel = "";
        String[] stopwords = { "a",
                              "about",
                              "above",
                              "after",
                              "again",
                              "against",
                              "all",
                              "am",
                              "an",
                              "and",
                              "any",
                              "are",
                              "as",
                              "at",
                              "be",
                              "because",
                              "been",
                              "before",
                              "being",
                              "beside",
                              "between",
                              "both",
                              "but",
                              "by",
                              "could",
                              "did",
                              "do",
                              "does",
                              "doing",
                              "down",
                              "during",
                              "each",
                              "for",
                              "from",
                              "further",
                              "guys",
                              "gals",
                              "hey",
                              "girls",
                              "had",
                              "has",
                              "have",
                              "having",
                              "he",
                              "he'd",
                              "he'll",
                              "he's",
                              "her",
                              "here",
                              "here's",
                              "hers",
                              "herself",
                              "him",
                              "himself",
                              "his",
                              "how",
                              "how's",
                              "i",
                              "i'd",
                              "i'll",
                              "i'm",
                              "i've",
                              "if",
                              "in",
                              "into",
                              "is",
                              "it",
                              "it's",
                              "its",
                              "itself",
                              "let's",
                              "me",
                              "more",
                              "most",
                              "my",
                              "myself",
                              "of",
                              "on",
                              "once",
                              "only",
                              "or",
                              "other",
                              "ought",
                              "our",
                              "ours",
                              "ourselves",
                              "out",
                              "over",
                              "own",
                              "same",
                              "she",
                              "she'd",
                              "she'll",
                              "she's",
                              "should",
                              "so",
                              "some",
                              "such",
                              "than",
                              "that",
                              "that's",
                              "the",
                              "their",
                              "theirs",
                              "them",
                              "themselves",
                              "then",
                              "there",
                              "there's",
                              "these",
                              "they",
                              "they'd",
                              "they'll",
                              "they're",
                              "they've",
                              "this",
                              "those",
                              "through",
                              "to",
                              "too",
                              "under",
                              "until",
                              "up",
                              "very",
                              "was",
                              "we",
                              "we'd",
                              "we'll",
                              "we're",
                              "we've",
                              "were",
                              "what",
                              "what's",
                              "when",
                              "when's",
                              "where",
                              "where's",
                              "which",
                              "while",
                              "who",
                              "who's",
                              "whom",
                              "why",
                              "why's",
                              "with",
                              "won't",
                              "would",
                              "you",
                              "you'd",
                              "you'll",
                              "you're",
                              "you've",
                              "your",
                              "yours",
                              "yourself",
                              "yourselves",
                              ",",
                              "!",
                              "?",
                              "(",
                              ")",
                              "&",
                              "@",
                              "$",
                              "0",
                              "1",
                              "2",
                              "3",
                              "4",
                              "5",
                              "6",
                              "7",
                              "8",
                              "9" };

        String review_excel = new String();
        /*String path = new String("\\Final.xls\\");
        String sw = new String("\\Final\\Stopwords\\");
        String lem = new String("\\Final\\Lemmatized\\");*/
        String path = new String("resources/final_");
        String sw = new String("resources/final_Stopwords_");
        String lem = new String("resources/final_Lemmatized_");
        if (id == 1)
        {
            hotel = "Poptates";
            path = path + "Poptates-1.xls";
            sw = sw + "Poptates-1.xls";
            lem = lem + "Poptates-1.xls";
        }
        else if (id == 4)
        {
            hotel = "BlueFrog";
            path = path + "BlueFrog-1.xls";
            sw = sw + "BlueFrog-1.xls";
            lem = lem + "BlueFrog-1.xls";
        }
        else if (id == 3)
        {
            hotel = "Candies";
            path = path + "Candies.xls";
            sw = sw + "Candies.xls";
            lem = lem + "Candies.xls";
        }
        else if (id == 2)
        {
            hotel = "WildDining";
            path = path + "WildDining-2.xls";
            sw = sw + "WildDining-2.xls";
            lem = lem + "WildDining-2.xls";
        }
        else
        {
            review_excel = "Review_Excel.xls";
            sw = sw + "Review_Excel.xls";
            lem = lem + "Review_Excel.xls";
        }

        if (id == 0)
        {
            WritableWorkbook wr = Workbook.createWorkbook(new File(review_excel));
            WritableSheet wsheet_r = wr.createSheet("First Sheet", 0);

            //write the review

            Label labelr = new Label(1, 1, rev);
            wsheet_r.addCell(labelr);

            WritableWorkbook w = Workbook.createWorkbook(new File(sw));
            WritableSheet wsheet = w.createSheet("First Sheet", 0); //read-write version

            WritableWorkbook w1 = Workbook.createWorkbook(new File(lem));
            WritableSheet wsheet1 = w1.createSheet("First Sheet", 0);

            StanfordLemmatizerSecond slem = new StanfordLemmatizerSecond();
            List<String> ls = new LinkedList<String>();

            int i = 1;

            for (i = 1; i <= 1; i++)
            {
                Cell cell1;
                cell1 = wsheet_r.getCell(1, i);

                String s = (cell1.getContents()).toString();

                //stop words filtering

                String s1 = new String();
                String s2 = new String();

                String array[] = new String[s.length()];
                String d = " ";

                array = s.split(d);

                int j = 0;
                int k = 0;

                for (j = 0; j < array.length; j++)
                {
                    for (k = 0; k < stopwords.length; k++)
                    {
                        if (array[j].equalsIgnoreCase(stopwords[k]))
                            array[j] = " ";

                    }
                }

                s = " ";

                for (j = 0; j < array.length; j++)
                {
                    s = s + " " + array[j];
                }

                //lemmatization

                ls = slem.lemmatize(s);

                String temp = new String();

                String a[] = new String[ls.size()];
                int t = 0;
                for (Object value : ls) {
                    a[t] = (String) value;
                    t++;
                }

                for (int p = 0; p < a.length; p++)
                {
                    temp = temp + a[p] + " ";
                }

                Label label = new Label(1, i, s);
                wsheet.addCell(label); //copying stop words filtered

                Label label1 = new Label(1, i, temp);
                wsheet1.addCell(label1); //copying lemmatized 

                Cell cell2 = wsheet.getCell(1, i);
                // System.out.println(cell2.getContents());

                Cell cell3 = wsheet1.getCell(1, i);
                // System.out.println(cell3.getContents());

            }

            w.write();
            w1.write();
            wr.write();
            w.close();
            w1.close();
            wr.close();

            Hypernyms h = new Hypernyms();

            h.setup(hotel, lem);

        }

        else
        {
            Workbook workbook = Workbook.getWorkbook(new File(path));
            Sheet sheet = workbook.getSheet(0); //original review sheet (read only)

            WritableWorkbook w = Workbook.createWorkbook(new File(sw));
            WritableSheet wsheet = w.createSheet("First Sheet", 0); //read-write version

            WritableWorkbook w1 = Workbook.createWorkbook(new File(lem));
            WritableSheet wsheet1 = w1.createSheet("First Sheet", 0);

            StanfordLemmatizerSecond slem = new StanfordLemmatizerSecond();
            List<String> ls = new LinkedList<String>();

            int i = 1;

            for (i = 1; i <= 50; i++)
            {
                Cell cell1;

                cell1 = sheet.getCell(1, i);

                String s = (cell1.getContents()).toString();

                //stop words filtering

                String s1 = new String();
                String s2 = new String();

                String array[] = new String[s.length()];
                String d = " ";

                array = s.split(d);

                int j = 0;
                int k = 0;

                /*  for(j=0;j<array.length;j++)
                  {
                      System.out.println(array[j]);
                  }*/

                for (j = 0; j < array.length; j++)
                {
                    for (k = 0; k < stopwords.length; k++)
                    {
                        if (array[j].equalsIgnoreCase(stopwords[k]))
                            array[j] = " ";

                    }
                }

                s = " ";

                for (j = 0; j < array.length; j++)
                {
                    s = s + " " + array[j];
                }

                //lemmatization

                ls = slem.lemmatize(s);

                String temp = new String();

                String a[] = new String[ls.size()];
                int t = 0;
                for (Object value : ls) {
                    a[t] = (String) value;
                    t++;
                }

                for (int p = 0; p < a.length; p++)
                {
                    temp = temp + a[p] + " ";
                }

                Label label = new Label(1, i, s);
                wsheet.addCell(label); //copying stop words filtered

                Label label1 = new Label(1, i, temp);
                wsheet1.addCell(label1); //copying lemmatized 

                Cell cell2 = wsheet.getCell(1, i);
                // System.out.println(cell2.getContents());

                Cell cell3 = wsheet1.getCell(1, i);
                // System.out.println(cell3.getContents());

            }

            w.write();
            w1.write();

            workbook.close();
            w.close();
            w1.close();

            Hypernyms h = new Hypernyms();
            
            h.setup(hotel, lem);
        }
    }

}

class StanfordLemmatizerSecond
{
    protected StanfordCoreNLP pipeline;

    public StanfordLemmatizerSecond() {
        // Create StanfordCoreNLP object properties, with POS tagging
        // (required for lemmatization), and lemmatization
        Properties props;
        props = new Properties();
        props.put("annotators", "tokenize, ssplit,pos,lemma");

        /*
         * This is a pipeline that takes in a string and returns various analyzed linguistic forms. 
         * The String is tokenized via a tokenizer (such as PTBTokenizerAnnotator), 
         * and then other sequence model style annotation can be used to add things like lemmas, 
         * POS tags, and named entities. These are returned as a list of CoreLabels. 
         * Other analysis components build and store parse trees, dependency graphs, etc. 
         * 
         * This class is designed to apply multiple Annotators to an Annotation. 
         * The idea is that you first build up the pipeline by adding Annotators, 
         * and then you take the objects you wish to annotate and pass them in and 
         * get in return a fully annotated object.
         * 
         *  StanfordCoreNLP loads a lot of models, so you probably
         *  only want to do this once per execution
         */
        this.pipeline = new StanfordCoreNLP(props);
    }

    List<String> lemmatize(String documentText)
    {
        List<String> lemmas = new LinkedList<String>();
        // Create an empty Annotation just with the given text
        Annotation document = new Annotation(documentText);
        // run all Annotators on this text
        this.pipeline.annotate(document);
        // Iterate over all of the sentences found
        List<CoreMap> sentences = document.get(SentencesAnnotation.class);
        for (CoreMap sentence : sentences) {
            // Iterate over all tokens in a sentence
            for (CoreLabel token : sentence.get(TokensAnnotation.class)) {
                // Retrieve and add the lemma for each word into the
                // list of lemmas
                lemmas.add(token.get(LemmaAnnotation.class));
            }
        }
        return lemmas;

    }
}

/* the sheet obtained after stopwords+lemmatization is passed to hypernyms for finding hypernyms only.
    the original sheet (spell checked and pronouns wala) is to be used for finding opinions and dependencies.
    
For each restaurant
Access both the sheets concurrently,
    each review in the original sheet plus new sheet has to be traversed sentence wise.

    for each sentence, 
        check the hypernyms (i.e get features)
        for each feature, get opinions.

Each feature cluster should be populated by opinions.

Find no. of elements in each cluster. Arrange in descending order. take only first 4 features.

Now, find the sentiment score of each cluster selected.

Cluster 1 --- score
Cluster 2 --- score

pass this to the jfree chart.

*/
