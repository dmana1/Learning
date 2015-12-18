/*
 * This class is responsible for creating the corpus index.
 */
package com.info.search;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import snowballstemmer.PorterStemmer;

/**
 *
 * @author Deepthi
 */
public class CreateIndex {

    String folderName = "C:\\Users\\Deepthi\\Documents\\Algorithms\\AlgoProject\\Drexel-AMT-Corpus\\Drexel-AMT-Corpus\\aa";
    PorterStemmer stemmer;
    HashMap<String, HashMap<String, Posting>> corpusInvertedFreqMap;

    public CreateIndex() {
        stemmer = new PorterStemmer();
    }

    //creates the inverted index of corpus
    public HashMap<String, HashMap<String, Posting>> createIndex() throws IOException {
        corpusInvertedFreqMap = new HashMap<String, HashMap<String, Posting>>();

        File folder = new File(folderName);
        File[] listOfFiles = folder.listFiles();
        Scanner wordFile = null;
        String word = null;
        String stemWord;
        StopWords stopWords = new StopWords();
        BufferedReader reader;
        for (int i = 0; i < listOfFiles.length; i++) {
            File file = listOfFiles[i];
            try {
                wordFile = new Scanner(new FileReader(file));
                reader = new BufferedReader(new FileReader(file));
//                System.out.println("1 : " + file.getAbsoluteFile());
//                System.out.println("2 : " + file.getAbsolutePath());
//                System.out.println("3 : " + file.getName());
            } catch (FileNotFoundException e) {
                System.err.println(e);
                return null;
            }
            int position = 0;
            String lineRead;
            String[] wordsInLine;
            while ((lineRead = reader.readLine()) != null) {

                //removing all the special characters in line
                 lineRead=  lineRead.replaceAll("[^a-zA-Z0-9_-]", " ");

                wordsInLine = lineRead.split(" ");

                for (String term : wordsInLine) {
                    
                    if(term.equals(""))continue;

                    // This makes the Word lower case.
                    word = term.toLowerCase();

                    //trim for spaces
                    word = word.trim();

                    //check for stop word
                    boolean isStopWord = stopWords.isStopWord(word);
                    if (isStopWord) {
                        continue;
                    } else {
                        stemmer.setCurrent(word);
                        if (stemmer.stem()) {
                            //If stemming is successful obtain the stem of the given word
                            stemWord = stemmer.getCurrent();
                            position++;
                            //Create the posting
                            if (corpusInvertedFreqMap.containsKey(stemWord)) {
                                HashMap<String, Posting> docPostingMap = corpusInvertedFreqMap.get(stemWord);

                                //if the word is already present in the same document
                                if (docPostingMap.containsKey(file.getName())) {
                                    Posting posting = docPostingMap.get(file.getName());
                                    int frequency = posting.getFrequency();
                                    posting.setFrequency(++frequency);
                                    posting.getPositionOfTerm().add(position);
                                } else {
                                    //if the word is present in some other document
                                    Posting posting = new Posting();
                                    posting.setFrequency(1);
                                    posting.getPositionOfTerm().add(position);
                                    posting.setDocumentName(file.getName());
                                    posting.setSizeOfDocument(file.getTotalSpace() / 1000.0);
                                    docPostingMap.put(file.getName(), posting);
                                }
                            } else {
                                //if the word is not there in the inverted index at all
                                Posting posting = new Posting();
                                posting.setFrequency(1);
                                posting.getPositionOfTerm().add(position);
                                posting.setDocumentName(file.getName());
                                posting.setSizeOfDocument(file.getTotalSpace() / 1000.0);
                                HashMap<String, Posting> docPostingMap = new HashMap<String, Posting>();
                                docPostingMap.put(file.getName(), posting);
                                corpusInvertedFreqMap.put(stemWord, docPostingMap);
                            }

                        }
                    }

                }

            }

        }
        saveObjectToFile("corpusInvertedIndex.txt", corpusInvertedFreqMap);

        return corpusInvertedFreqMap;

    }

    //saves the inverted index to file
    public void saveObjectToFile(String fileName, HashMap<String, HashMap<String, Posting>> docInvertedIndex) {

        FileOutputStream fout;
        try {
            fout = new FileOutputStream("C:\\Users\\Deepthi\\Documents\\Algorithms\\AlgoProject\\index\\" + fileName);
            ObjectOutputStream oos = new ObjectOutputStream(fout);

            oos.writeObject(docInvertedIndex);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(CreateIndex.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CreateIndex.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    //reads the inverted index stored on file
    public void readObjectFromFile(String fileName) {
        FileInputStream fin = null;
        try {
            fin = new FileInputStream("C:\\Users\\Deepthi\\Documents\\Algorithms\\AlgoProject\\index\\" + fileName);
            ObjectInputStream ois = new ObjectInputStream(fin);
            HashMap<String, HashMap<String, Posting>> corpusInvertedIndex = (HashMap<String, HashMap<String, Posting>>) ois.readObject();
            for (String word : corpusInvertedIndex.keySet()) {
                System.out.print("[token]:" + word);

                HashMap<String, Posting> docPostingMap = corpusInvertedIndex.get(word);
                for (String document : docPostingMap.keySet()) {
                    System.out.print("...... [Doc]:" + document + ".....[Freq:]" + docPostingMap.get(document).getFrequency()+ ".....[Position:]" + docPostingMap.get(document).getPositionOfTerm());

                }
                System.out.println("");
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(CreateIndex.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CreateIndex.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CreateIndex.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fin.close();
            } catch (IOException ex) {
                Logger.getLogger(CreateIndex.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void main(String args[]) {
        CreateIndex ci = new CreateIndex();
        try {
            HashMap<String, HashMap<String, Posting>> map = ci.createIndex();
        } catch (IOException ex) {
            Logger.getLogger(CreateIndex.class.getName()).log(Level.SEVERE, null, ex);
        }
        ci.readObjectFromFile("corpusInvertedIndex.txt");

    }

}
