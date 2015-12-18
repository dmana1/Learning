/*
 *This class is creates the search query index and searches for relevant documents
 */
package com.info.search;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import snowballstemmer.PorterStemmer;

/**
 *
 * @author Deepthi
 */
public class QueryIndex {
    
    HashMap<String, HashMap<String, Posting>> answerInvertedIndex;
    HashMap<String, HashMap<String, Posting>> corpusInvertedIndex;
    Map<String,Double> vsRankedMap;
    VectorSpaceModel vectorSpaceModel;
    HashMap<String,Double> documentRelevance = new HashMap<>();
    
    public Map<String,Double> search(String searchQuery){
         createTheIndexForSearchQuery(searchQuery);
         populateTheRelevantDocuments(answerInvertedIndex);
         
         
         //Find the ranking of the documents based on vector space model
         vectorSpaceModel = new VectorSpaceModel();
         vsRankedMap =  vectorSpaceModel.vectorSpaceModelForRanking(answerInvertedIndex);
        
         //normalize it to cosine angle
         vsRankedMap = normalizeToCosine(vsRankedMap);
         for(String s: vsRankedMap.keySet()){
             if(documentRelevance.containsKey(s)){
                 Double rel = documentRelevance.get(s);
                 Double cosineRank = documentRelevance.get(s);
                 vsRankedMap.put(s, rel + cosineRank);
             }
         }
         //again normalize after relevance
         vsRankedMap = normalizeToCosine(vsRankedMap);

        
        
         return vsRankedMap;
        
    }
    
    //normalizes to cosine after adding the relevance
    public  Map<String,Double> normalizeToCosine( Map<String,Double> vsRankedMap){
          Double total = 0.0;
         for(String s : vsRankedMap.keySet()){
             total += vsRankedMap.get(s);
             
         }
        for(String s : vsRankedMap.keySet()){
             double rank  = vsRankedMap.get(s);
             vsRankedMap.put(s, rank/total);
             
         }
        return vsRankedMap;
    }
    
    //creates the index for the search query
    public void createTheIndexForSearchQuery(String query){
        PorterStemmer stemmer = new PorterStemmer();;
        answerInvertedIndex = new HashMap<String,HashMap<String, Posting>>();
        String[] queryTerms = query.split(" ");
        StopWords stopWords = new StopWords();
        for(String s : queryTerms){
             if(s.equals(""))continue;
              s = s.toLowerCase();
            boolean isStopWord = stopWords.isStopWord(s);
            if(isStopWord){
                continue;
            }
            else{                
                 stemmer.setCurrent(s);
                   if (stemmer.stem()) {
                    //If stemming is successful obtain the stem of the given word
                    String stemWord = stemmer.getCurrent();
                    answerInvertedIndex.put(stemWord, null);
                    
                   }
            }
            
        }
              
    }
    
    //populates the relavant documents based on the search query
    public void populateTheRelevantDocuments( HashMap<String,HashMap<String, Posting>> answerInvertedIndex){
        
        //read the saved object from disk
        corpusInvertedIndex = readObjectFromFile();
               
         for(String term : answerInvertedIndex.keySet()){
            HashMap<String,Posting> documentPostingMap = corpusInvertedIndex.get(term);
            answerInvertedIndex.put(term, documentPostingMap);
         }       
               
    }
    
    //reads the corpuse inverted index from file
     public  HashMap<String,HashMap<String, Posting>> readObjectFromFile() {
        FileInputStream fin = null;
        try {
            fin = new FileInputStream("C:\\Users\\Deepthi\\Documents\\Algorithms\\AlgoProject\\index\\corpusInvertedIndex.txt");
            ObjectInputStream ois = new ObjectInputStream(fin);
            HashMap<String,HashMap<String, Posting>> corpusInvertedIndex = (HashMap<String,HashMap<String, Posting>>) ois.readObject();
           return corpusInvertedIndex;

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
        return null;
    }
     
     //Sets the relevance of the document
     public void setRelevanceForDocument(String docName){
          if(!documentRelevance.containsKey(docName)){
             documentRelevance.put(docName, 0.5);
         }else{
            
            Double relavance =  documentRelevance.get(docName);
           
            relavance++;
           
            documentRelevance.put(docName, relavance);
        }
         
//        if(!documentRelevance.containsKey(docName)){
//             Relevance relevance = new Relevance();
//             relevance.setRank(1);
//             for (String word : answerInvertedIndex.keySet()) {
//                 relevance.getQueryTerms().add(word);
//             }
//
//             documentRelevance.put(docName, relevance);
//         }else{
//            
//            Relevance rel =  documentRelevance.get(docName);
//            for(String s : answerInvertedIndex.keySet()){
//                if(!rel.getQueryTerms().contains(s)){
//                    rel.getQueryTerms().add(s);
//                }
//            }
//            Double rank   = rel.getRank();
//            rank++;
//            rel.setRank(rank);
//            documentRelevance.put(docName, rel);
//        }
         
     }
    
}
