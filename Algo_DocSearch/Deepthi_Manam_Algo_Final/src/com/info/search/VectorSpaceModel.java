/*
 * Documents could be ranked by computing the distance between the points representing the documents and the query.
 * The most successful of these is the cosine correlation similarity measure. The cosine correlation measures the cosine
 * of the angle between the query and the document vectors. 
 *  
 * 
 */
package com.info.search;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

/**
 *
 * @author Deepthi
 */
public class VectorSpaceModel {
    
    
    private TreeMap<String,Double> documentRankingMap;
    static Set<String> uniqueWords;
    static Set<String> documentsInAnswerList;
    
    //calculates the cosine angle between the document vector and the query vector
   public TreeMap<String,Double> vectorSpaceModelForRanking(HashMap<String, HashMap<String, Posting>> answerInvertedIndex){
        documentRankingMap = new TreeMap<String,Double>();          
        populateUniqueWordsAndDocuments(answerInvertedIndex);
        //Caluclate CosineAngle between the document vector and query vector
        for(String document : documentsInAnswerList){
            Double cosineAngle = 0.0;
            Double sigmaDiQi = 0.0;
            Double dijSquare = 0.0;
            Double qijSquare = 0.0;
            Double squareRootOfDeno = 0.0;
            Double coeff = 0.0245;
            Double qi = 1.0;
            int phraseCount = 0;
            Double  di = 0.0;
            for(String term : uniqueWords){
                  di = getWeightOfDocumentForTerm(document,answerInvertedIndex.get(term));
                if(di != 0){
                    phraseCount++;
                }
                sigmaDiQi += di * qi;
                dijSquare += di * di;
                qijSquare += qi * qi;
            }
            
            squareRootOfDeno = Math.sqrt(dijSquare * qijSquare);
            if (uniqueWords.size() > 1) {
                cosineAngle = sigmaDiQi / (squareRootOfDeno);
            } else {
                cosineAngle = di * coeff;
            }

            documentRankingMap.put(document, cosineAngle);
           
            //check for positions of the phrase
             List<Integer> positionsList = null;
             List<Integer> prevPositionsList = null;
            if(phraseCount == uniqueWords.size()){
               for(String word : uniqueWords){
                  
                  HashMap<String, Posting> documentPostingMap = answerInvertedIndex.get(word);
                  for(String docName : documentPostingMap.keySet() ){
                      if(docName.equals(document))
                      {
                          positionsList = documentPostingMap.get(document).getPositionOfTerm();
                      }
                  }
                  if(prevPositionsList != null && positionsList != null){
                      int count = 0;
                      for(int i = 0; i < positionsList.size() ; i++){
                          for(int j = 0 ; j < prevPositionsList.size() ; j++){
                             int  diff = prevPositionsList.get(j) - positionsList.get(i);
                              if(Math.abs(diff) == 1){
                                count++;  
                                 cosineAngle = cosineAngle + 0.99;
                              }
                          }
                      }
                      
                        documentRankingMap.put(document, cosineAngle);
                      
                    
                  }
                  prevPositionsList = positionsList;
               }
            }
            
        }
        
        
        return documentRankingMap;
        
      
   }
   
   //calculates the weight of term in a document
   public Double getWeightOfDocumentForTerm(String document, HashMap<String, Posting> documentPostingMap){
       Double weight = 0.0;
       Posting posting = null;
       int invertedFrequency = 0;
       if (documentPostingMap != null && documentPostingMap.size() > 0) {
           posting = documentPostingMap.get(document);
           invertedFrequency = documentPostingMap.size();
       }
       if (posting != null) {
           weight = posting.getFrequency() / (invertedFrequency * 1.0);
       }
       return weight;
       
   }
   
   //finds the total terms and the list of relevant document
   public void  populateUniqueWordsAndDocuments(HashMap<String, HashMap<String, Posting>> answerInvertedIndex){
        uniqueWords = new HashSet<String>();
        documentsInAnswerList = new HashSet<String>();
        if(answerInvertedIndex != null && answerInvertedIndex.size() > 0){
        for (String word : answerInvertedIndex.keySet()) {
            uniqueWords.add(word);
            HashMap<String, Posting> documentPostingMap = answerInvertedIndex.get(word);
            if(documentPostingMap != null && documentPostingMap.size() > 0){
            for (String doc : documentPostingMap.keySet()) {
                if (documentsInAnswerList.contains(doc)) {
                    continue;
                } else {
                    documentsInAnswerList.add(doc);
                }
            }
        }

        }

        }

    }
   
   
   
    
}
