package app;

import javafx.animation.FadeTransition;
import javafx.animation.PathTransition;
import javafx.animation.RotateTransition;
import javafx.scene.shape.Line;
import javafx.util.Duration;


class ControllerAnimation extends ControllerSceneObjectVars
{

    public void initialize()
    {
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

        /*
        // Main Form
        Line line1 = new Line();
        line1.setStartX(-1000);
        line1.setStartY(195);
        line1.setEndX(135);
        line1.setEndY(195);
        PathTransition scaleIn1 = new PathTransition();
        scaleIn1.setNode(mainForm);
        scaleIn1.setDuration(Duration.millis(3000));
        scaleIn1.setPath(line1);
        scaleIn1.play();
        */

        /*
        // Theroy Box
        Line line3 = new Line();
        line3.setStartX(-800);
        line3.setStartY(51);
        line3.setEndX(97);
        line3.setEndY(16);
        PathTransition scaleIn3 = new PathTransition();
        scaleIn3.setNode(theoryBox);
        scaleIn3.setDuration(Duration.millis(3000));
        scaleIn3.setPath(line3);
        scaleIn3.play();
        */
    }
}
