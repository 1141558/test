/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.List;
import lapr.project.model.Distance;
import lapr.project.model.Event;
import lapr.project.model.ExhibitionCentre;
import lapr.project.model.Stand;

/**
 *
 * @author andre
 */
public class ReadFileStand {
    

    private void addDistanceList(Stand s, String[] listDistance){
        for(int i = 0; i < listDistance.length; i = i + 2){
            s.addPairDistance(listDistance[i], Double.parseDouble(listDistance[i+1]));
        }
    }
    
    private String[] convertList(String[] stand){
        String list = stand[3];       
        list = list.replace("{", "");
        list = list.replace("}", "");
        list = list.replace(")", "");
        list = list.replace("(", "");
        String[] listDistance = list.split(",");           
        
        return  listDistance;
    }
    
    /**
     *
     * @param centre
     * @throws ClassNotFoundException
     * @throws IllegalAccessException
     */
    public void run(ExhibitionCentre centre) throws ClassNotFoundException, IllegalAccessException {
        
    Event event = new Event();
    List<Distance> distance = new ArrayList<>();
    Stand st = new Stand();

    String file = "./src/main/resources/exhibition1_stands_v0.1.csv";
    BufferedReader br = null;
    String line;
    String csvDivisor = ";";
    String [] listDistance;
    int count = 0;
    Stand s = new Stand();
    
    try {
        
        if(centre.getEventRegister().isEmptyEvents()){
            
            throw new IllegalAccessException();
            
        }else{
        
            br = new BufferedReader(new FileReader(file));
            
            while ((line = br.readLine()) != null) {

                String[] stand = line.split(csvDivisor);
                if(count != 0){ //ignora a 1ª linha
                    
                    //verifica se existe o evento
                    event = centre.getEventRegister().existEventByDescription(stand[0]); 

                    if(event == null){//se não existir
                        
                        throw new ClassNotFoundException();
                        
                    }else{ //se existir
                        
                         System.out.println("Stand [event= " + stand[0] 
                                     + " , Stand= " + stand[1] + "]"
                                     + " , area= " + stand[2] + "]"
                                     + "");
                         
                        //instancia um stand
                        s.addPairDistance(stand[1], Double.parseDouble(stand[2]));
                        
                        //Verificar se o event tem stands e se tiver devolvende o objecto stand ou null se não existir
                        st = event.getStandRegister().getStandByDescriptionStand(s);
                        //se não existir o stand em questão ou se o evento não tiver lista de stands 
                        if(st == null || event.getStandRegister().getStandList().isEmpty()){                                                 
                            //adiciona o stand à lista
                            event.getStandRegister().addStand(s);
//                            int j = event.getStandRegister().getStandList().indexOf(s);
//                            s = event.getStandRegister().getStandList().get(j);
                            //Se existir lista de distancias no ficheiro
                            if(stand.length > 3){
                                //Converter a String no array stand, num array de strings
                                listDistance = convertList(stand);
                                //adiciona lista de distancias ao stand
                                addDistanceList(s, listDistance);
                                
                                for (String listDistance1 : listDistance) {
                                    System.out.println("[ listArray= " + listDistance1 + "]");
                                }
                            }                          
                        }else{//se o stand existir

                            //verificar se a lista de distancias do stand está vazia
                            if(st.isEmptyDistancelist() && stand.length > 3){
                            //se estiver vazia e se existe uma lista de distancias no ficheiro
                                //Converter a String do array stand, num array de strings
                                listDistance = convertList(stand);
                                //adiciona lista de distancias ao stand
                                addDistanceList(s, listDistance);
                           }else{//se nao estiver vazia
                                //Se existe uma lista de distancias no ficheiro
                                if(stand.length > 3){
                                    //vou buscar a lista de distancias do stand em questao
                                    distance = st.getDistanceList();
                                    listDistance = convertList(stand);
                                    for(Distance dt: distance){
                                        for(int i = 0; i < listDistance.length; i = i + 2){
                                            Distance tmp = new Distance(listDistance[i], Double.parseDouble(listDistance[i + 1]));
                                            if(!dt.equals(tmp))//se não existir uma distancia igual adiciona a distancia do ficheiro
                                                st.addDistance(tmp);
                                        }
                                    }
                                    
                                }
                            }
                        }                           
                        
                    }
                }           
                count++;        
            }
        }

    } catch (FileNotFoundException e) {
       out.println("File not found");
    } catch (IOException e) {
        out.println("Error data read");
    } catch (ClassNotFoundException e) {
        out.println("Event not exist");
    } catch (IllegalAccessException e) {
        out.println("List of events is empty");
    } finally {
        if (br != null) {
            try {
                br.close();
            } catch (IOException e) {
                out.println("Error to data load");
            }
        }
    }
  }
    
}
