package application;
	

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;


public class Main extends Application {
	
	static Player player;
	static Player dealer;
	static Label whoWon;
	/**
	 *Start method for the primary Stage
	 */
	@Override
	public void start(Stage primaryStage) {
		try {
			StackPane root = new StackPane(); //Declare root
			
			Label AILabel = new Label("Computer cards");
			AILabel.setTranslateX(-300);
			AILabel.setTranslateY(-300);
			
			whoWon = new Label();
			whoWon.setFont(new Font("Arial", 50));
			whoWon.setTranslateX(-500);
			whoWon.setTranslateY(-300);
			Button startButton = new Button("Start Game");
			
			startButton.setMaxSize(200, 100);
			startButton.setMinSize(100, 50);
			startButton.setTranslateX(-300);
			startButton.setTranslateY(200);
			
			//AI Cards
	        GridPane AIgridpane = new GridPane();
	        AIgridpane.setHgap(2);
	        AIgridpane.setVgap(2);
	        ImageView AIcard1 = new ImageView();
	        ImageView AIcard2 = new ImageView();
	        ImageView AIcard3 = new ImageView();
	        ImageView AIcard4 = new ImageView();
	        ImageView AIcard5 = new ImageView();
	        Image cardBack = new Image(Main.class.getResourceAsStream("cardback_20.png"));
	        AIcard1.setImage(cardBack);
	        AIcard2.setImage(cardBack);
	        AIcard3.setImage(cardBack);
	        AIcard4.setImage(cardBack);
	        AIcard5.setImage(cardBack);

	        AIcard1.setFitWidth(150);
	        AIcard1.setPreserveRatio(true);
	        AIcard2.setFitWidth(150);
	        AIcard2.setPreserveRatio(true);
	        AIcard3.setFitWidth(150);
	        AIcard3.setPreserveRatio(true);
	        AIcard4.setFitWidth(150);
	        AIcard4.setPreserveRatio(true);
	        AIcard5.setFitWidth(150);
	        AIcard5.setPreserveRatio(true);
	        
	        HBox AIpictureRegion = new HBox();
	        
	        AIpictureRegion.getChildren().add(AIcard1);
	        AIpictureRegion.getChildren().add(AIcard2);
	        AIpictureRegion.getChildren().add(AIcard3);
	        AIpictureRegion.getChildren().add(AIcard4);
	        AIpictureRegion.getChildren().add(AIcard5);
	        AIgridpane.add(AIpictureRegion, 1, 1);
	        
	        AIgridpane.setTranslateX(600);
	        AIgridpane.setTranslateY(0);
	        root.getChildren().add(AIgridpane);  
			//Cards
	        GridPane gridpane = new GridPane();
	        gridpane.setHgap(2);
	        gridpane.setVgap(2);
	        ImageView card1 = new ImageView();
	        ImageView card2 = new ImageView();
	        ImageView card3 = new ImageView();
	        ImageView card4 = new ImageView();
	        ImageView card5 = new ImageView();
	        
	        card1.setImage(cardBack);
	        card2.setImage(cardBack);
	        card3.setImage(cardBack);
	        card4.setImage(cardBack);
	        card5.setImage(cardBack);

	        card1.setFitWidth(150);
	        card1.setPreserveRatio(true);
	        card2.setFitWidth(150);
	        card2.setPreserveRatio(true);
	        card3.setFitWidth(150);
	        card3.setPreserveRatio(true);
	        card4.setFitWidth(150);
	        card4.setPreserveRatio(true);
	        card5.setFitWidth(150);
	        card5.setPreserveRatio(true);
	        
	        HBox pictureRegion = new HBox();
	        
	        pictureRegion.getChildren().add(card1);
	        pictureRegion.getChildren().add(card2);
	        pictureRegion.getChildren().add(card3);
	        pictureRegion.getChildren().add(card4);
	        pictureRegion.getChildren().add(card5);
	        gridpane.add(pictureRegion, 1, 1);
	        
	        gridpane.setTranslateX(600);
			gridpane.setTranslateY(600);
	        root.getChildren().add(gridpane);   
			//Makes some UI elements
	        Button hitButton = new Button("Hit");
	        Button stayButton = new Button("Stay");
	        //Player Points label
			Label playerPoints = new Label("Dealer Hand Total: 0" + "\nPlayer Hand Total: 0");
			//Start button
			/**
			 * Event Handler for start button
			 */
	        startButton.setOnAction(new EventHandler<ActionEvent>() {
	            @Override
	            public void handle(ActionEvent event) {
	            	whoWon.setText("");
	            	
	            	hitButton.setDisable(false);
	                stayButton.setDisable(false);
	            	
	                System.err.println("Game started");
	                new Deck();
	        		Deck.shuffle();
	        		
	        		System.err.println("Dealer initialized");
	        		dealer = new Player();
	        		Image firstCard = new Image(Main.class.getResourceAsStream("cards/" + dealer.hand.get(0).address + ".png"));
	        		Image secondCard = new Image(Main.class.getResourceAsStream("cards/" + dealer.hand.get(1).address + ".png"));
	        		AIcard1.setImage(firstCard);
	        		AIcard2.setImage(secondCard);
	        		AIcard3.setImage(cardBack);
	        		AIcard4.setImage(cardBack);
	        		AIcard5.setImage(cardBack);
	        		
	        		System.err.println("Player initialized");
	        		player = new Player();
	        		
	        		firstCard = new Image(Main.class.getResourceAsStream("cards/" + player.hand.get(0).address + ".png"));
	        		secondCard = new Image(Main.class.getResourceAsStream("cards/" + player.hand.get(1).address + ".png"));
	        		card1.setImage(firstCard);
	    	        card2.setImage(secondCard);
	    	        card3.setImage(cardBack);
	    	        card4.setImage(cardBack);
	    	        card5.setImage(cardBack);
	    	        player.setTotal();
	    	        dealer.setTotal();
	        		playerPoints.setText("Dealer Hand Total: " + dealer.total + "\nPlayer Hand Total: " + player.total);
	        		System.out.println();
	        		System.err.println("Players turn");
		                
	                startButton.setDisable(true);
	            }
	        });
	        
	        //SET UP THE HIT AND STAY BUTTONS

	        hitButton.setMaxSize(200, 100);
			hitButton.setMinSize(100, 50);
			hitButton.setTranslateX(200);
			
			stayButton.setMaxSize(200, 100);
			stayButton.setMinSize(100, 50);
			stayButton.setTranslateX(-200);
	        /**
	         * Event Handler for hitButton
	         */
			hitButton.setOnAction(new EventHandler<ActionEvent>() {
	            @Override
	            public void handle(ActionEvent event) {
	                System.err.println("Player Hit");
	                
	                Card newCard = Deck.draw();
	                player.hand.add(newCard);
	                
	                Image theCard;
	                switch(player.hand.size()) {
	                case 3: 
	                	theCard = new Image(Main.class.getResourceAsStream("cards/" + player.hand.get(2).address + ".png"));
	                	card3.setImage(theCard);
	                	break;
	                case 4:
	                	theCard = new Image(Main.class.getResourceAsStream("cards/" + player.hand.get(3).address + ".png"));
	                	card4.setImage(theCard);
	                	break;
	                case 5:
	                	theCard = new Image(Main.class.getResourceAsStream("cards/" + player.hand.get(4).address + ".png"));
	                	card5.setImage(theCard);
	                	break;
	                default:
	                	break;
	                }
	                
	                player.setTotal();
	                if(player.total>21) {
	                	playerBust();
	                	hitButton.setDisable(true);
	        	        stayButton.setDisable(true);
	        	        startButton.setDisable(false);
	        	        System.err.println("Player Busted");
	                	}
	                playerPoints.setText("Dealer Hand Total: " + dealer.total + "\nPlayer Hand Total: " + player.total);
	            }
	        });
			/**
			 * Event handler for Stay Button
			 */
			stayButton.setOnAction(new EventHandler<ActionEvent>() {
	            @Override
	            public void handle(ActionEvent event) {
	                System.err.println("stayed");
	                hitButton.setDisable(true);
	                stayButton.setDisable(true);
	                
	                System.err.println("Computers turn");
	                dealer.setTotal();
	                dealer.AITurn();
	        		playerPoints.setText("Dealer Hand Total: " + dealer.total + "\nPlayer Hand Total: " + player.total);
	        		startButton.setDisable(false);
	        		
	        		Image theCard;
	                switch(dealer.hand.size()) {
	                case 5: 
	                	theCard = new Image(Main.class.getResourceAsStream("cards/" + dealer.hand.get(4).address + ".png"));
	                	AIcard5.setImage(theCard);
	                case 4:
	                	theCard = new Image(Main.class.getResourceAsStream("cards/" + dealer.hand.get(3).address + ".png"));
	                	AIcard4.setImage(theCard);
	                case 3:
	                	theCard = new Image(Main.class.getResourceAsStream("cards/" + dealer.hand.get(2).address + ".png"));
	                	AIcard3.setImage(theCard);
	                default:
	                	break;
	                }
	            }
	        });
		
	        root.getChildren().add(startButton);
			root.getChildren().add(AILabel);
			root.getChildren().add(whoWon);
			root.getChildren().add(hitButton);
			root.getChildren().add(stayButton);
        	root.getChildren().add(playerPoints);	
	        
        	//makes sure the hit and stay buttons start out disabled
        	hitButton.setDisable(true);
            stayButton.setDisable(true);
            
	        Scene scene = new Scene(root,1400,900); // declares scene
	        
			  	        
			primaryStage.setTitle("Blackjack");
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.show();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	public static void AIBust() {
		whoWon.setText("Player Won!");
	}
	public static void playerBust() {
		whoWon.setText("Dealer Won");
	}
	public static void blackJack() {
		whoWon.setText("BlackJack!");
	}

	public static void tie() {
		whoWon.setText("Tie!");
	}
}
