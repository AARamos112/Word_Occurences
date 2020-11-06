//Author Name: Angel Ramos
//Date: 10/18/2020
//Program Name: Ramos_module7_word_occurrence
//Purpose: create a JavaFx gui showing the top 20 word occurences

package application;
	
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public class Ramos_Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		
		// initialize variables, map, and ArrayList
		String line = "";
		String URLString = "http://shakespeare.mit.edu/macbeth/full.html";
		TreeMap<String, Integer> treeMap = new TreeMap<>();
		ArrayList<Ramos_text_analyzer> theCounted = new ArrayList<>();
				
		// try/catch exceptions
		try {
			//read file from URL
			java.net.URL url = new java.net.URL(URLString);
			Scanner input = new Scanner(url.openStream());
			while (input.hasNext()) {
				line = input.nextLine();
				//remove unwanted characters
				line = line.replaceAll("<[^>]*>", "");
				line = line. replaceAll("[0-9]",""); 
				line = line.replaceAll( "[.,?!=/:;-]", " " ).trim();
				//Separate the words in the line
				String[] theLine = line.split(" ");		
						
				//loop goes through each index in theLine
				for(int i = 0; i < theLine.length; i++) {
					//skips empty index
					if(theLine[i].isEmpty() ) {
						continue;
					}
					//updates key value in treeMap if duplicate
					else if(treeMap.containsKey(theLine[i])) {
						treeMap.put(theLine[i], (treeMap.get(theLine[i]) + 1));
					}
					// adds key and value set to 1
					else {
						treeMap.put(theLine[i], 1);
					}			
				}	
			}
			//closes scanner
			input.close();
		}
		catch (java.net.MalformedURLException ex) {
			System.out.println("Invalid URL");
		}
		catch (java.io.IOException ex) {
			System.out.println("I/O Errors: no such file");
		}
		
		//makes a set of keys in treeMap
		Set<String> keySet = treeMap.keySet();
		
		//sets keys array size equal to keys set
		String[] keys = new String[keySet.size()];
		
		//makes keySet into an array
		keySet.toArray(keys);
		
		//input values into an ArrayList with Ramos_textanalyzer objects
		for (int k = 0; keys.length > k; k++) {
			theCounted.add(new Ramos_text_analyzer(keys[k], treeMap.get(keys[k])));	
		}		
		//sorts ArrayList
		Collections.sort(theCounted);
			
		GridPane pane = new GridPane();
		
		//Prints ArrayList
		Text desc = new Text("Top 20 words used in file: ");
		pane.add(desc, 1, 0);
		for (int k = 0; 20 > k; k++) {
			if (k < 10) {	
				Text label = new Text(theCounted.get(k).toString());
				pane.add(label, 1, k + 1);
			}
			else {
				Text label = new Text(theCounted.get(k).toString());
				pane.add(label, 10, k - 9);
			}
		}
		
		//Setting pane details
		pane.setPadding(new Insets(5, 5, 5, 5)); 
		pane.setVgap(2); 
		pane.setHgap(5);  
				
		primaryStage.setTitle("Word Occurrences");
		TextFlow textFlow = new TextFlow();
		Text t = new Text();
		t.setText("This is a text sample");
		textFlow.getChildren().addAll(t);
				
		try {
					
			BorderPane root = new BorderPane(textFlow);
			Scene scene = new Scene(pane,500,500);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
				
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
