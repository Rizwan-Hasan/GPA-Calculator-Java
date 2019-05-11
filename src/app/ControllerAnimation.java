package app;

import javafx.animation.FadeTransition;
import javafx.animation.PathTransition;
import javafx.animation.RotateTransition;
import javafx.fxml.Initializable;
import javafx.scene.shape.Line;
import javafx.util.Duration;
import java.net.URL;
import java.util.ResourceBundle;


class ControllerAnimation extends ControllerSceneObjectVars implements Initializable
{
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        // Making check boxes selected
        theoryCheckBox.setSelected(true);
        labCheckBox.setSelected(true);

        //Circle Image and Calculate Button Animation
        {
            // Circle Image Rotation Part 1
            {
                RotateTransition rt = new RotateTransition();
                rt.setNode(circleImage);
                rt.setDuration(Duration.seconds(1));
                rt.setFromAngle(360);
                rt.setToAngle(0);
                rt.setAutoReverse(true);
                rt.setCycleCount(3);
                rt.play();
            }

            // Calculate Button Rotation
            {
                RotateTransition rt = new RotateTransition();
                rt.setNode(calculateButton);
                rt.setDuration(Duration.seconds(2));
                rt.setFromAngle(0);
                rt.setToAngle(360);
                rt.setAutoReverse(true);
                rt.setCycleCount(3);
                rt.play();
            }

            // Circle Image Rotation Part 2
            {
                RotateTransition rt = new RotateTransition();
                rt.setNode(circleImage);
                rt.setDuration(Duration.seconds(2));
                rt.setFromAngle(360);
                rt.setToAngle(0);
                rt.setAutoReverse(false);
                rt.setCycleCount(2);
                rt.play();
            }
        }

        // Main Label Slide and Fade In Animation
        {
            // Fade In
            {
                FadeTransition fadeIn = new FadeTransition();
                fadeIn.setDuration(Duration.seconds(3));
                fadeIn.setNode(mainLabel);
                fadeIn.setFromValue(0.0);
                fadeIn.setToValue(1.0);
                fadeIn.setCycleCount(1);
                fadeIn.setAutoReverse(false);
                fadeIn.playFromStart();
            }
            // Slide
            {
                Line line = new Line();
                line.setStartX(-150);
                line.setStartY(30);
                line.setEndX(235);
                line.setEndY(30);
                PathTransition scaleIn2 = new PathTransition();
                scaleIn2.setNode(mainLabel);
                scaleIn2.setDuration(Duration.seconds(3));
                scaleIn2.setPath(line);
                scaleIn2.play();
            }
        }

        // Theory Box Fade In Animation
        {
            FadeTransition fadeIn = new FadeTransition();
            fadeIn.setDuration(Duration.seconds(2));
            fadeIn.setNode(theoryBox);
            fadeIn.setFromValue(0.0);
            fadeIn.setToValue(1.0);
            fadeIn.setCycleCount(1);
            fadeIn.setAutoReverse(false);
            fadeIn.playFromStart();
        }

        // Lab Box Fade In Animation
        {
            FadeTransition fadeIn = new FadeTransition();
            fadeIn.setDuration(Duration.seconds(2));
            fadeIn.setNode(labBox);
            fadeIn.setFromValue(0.0);
            fadeIn.setToValue(1.0);
            fadeIn.setCycleCount(1);
            fadeIn.setAutoReverse(false);
            fadeIn.playFromStart();
        }

        // Theory CheckBox Fade In Animation
        {
            FadeTransition fadeIn = new FadeTransition();
            fadeIn.setDuration(Duration.seconds(1));
            fadeIn.setNode(theoryCheckBox);
            fadeIn.setFromValue(0.0);
            fadeIn.setToValue(1.0);
            fadeIn.setCycleCount(3);
            fadeIn.setAutoReverse(true);
            fadeIn.playFromStart();
        }

        // Lab CheckBox Fade In Animation
        {
            FadeTransition fadeIn = new FadeTransition();
            fadeIn.setDuration(Duration.seconds(1));
            fadeIn.setNode(labCheckBox);
            fadeIn.setFromValue(0.0);
            fadeIn.setToValue(1.0);
            fadeIn.setCycleCount(3);
            fadeIn.setAutoReverse(true);
            fadeIn.playFromStart();
        }
    }
}
