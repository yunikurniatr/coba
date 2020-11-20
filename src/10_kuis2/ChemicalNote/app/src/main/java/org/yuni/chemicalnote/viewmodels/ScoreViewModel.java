package org.yuni.chemicalnote.viewmodels;

import android.view.View;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.navigation.Navigation;

import org.yuni.chemicalnote.fragments.ScoreFragment;
import org.yuni.chemicalnote.fragments.ScoreFragmentDirections;
import org.yuni.chemicalnote.model.GoalScorer;

import java.util.ArrayList;

public class ScoreViewModel extends ViewModel {
    private final MutableLiveData<ArrayList<GoalScorer>> homeGoalScorerList =
            new MutableLiveData<>(new ArrayList<GoalScorer>());
    private final MutableLiveData<ArrayList<GoalScorer>> awayGoalScorerList =
            new MutableLiveData<>(new ArrayList<GoalScorer>());

    public void setGoalScorer(String team, GoalScorer goalScorer) {
        if (team.equals(ScoreFragment.HOME)) {
            homeGoalScorerList.getValue().add(goalScorer);
        } else {
            awayGoalScorerList.getValue().add(goalScorer);
        }
    }

    public void onAddHomeClick(View view) {
        ScoreFragmentDirections.GoalScorerAction action =
                ScoreFragmentDirections.goalScorerAction(ScoreFragment.HOME);
        Navigation.findNavController(view).navigate(action);
    }

    public void onAddAwayClick(View view) {
        ScoreFragmentDirections.GoalScorerAction action =
                ScoreFragmentDirections.goalScorerAction(ScoreFragment.AWAY);
        Navigation.findNavController(view).navigate(action);
    }

    public String getHomeScorer(){
        StringBuilder result = new StringBuilder();
        for (GoalScorer g : homeGoalScorerList.getValue()) {
            result.append(g.getName())
                    .append(" ")
                    .append("Voltage :")
                    .append(g.getMinute())
                    .append("V")
                    .append("\n");
        }

        return result.toString();
    }

    public String getAwayScorer(){
        StringBuilder result = new StringBuilder();
        for (GoalScorer g : awayGoalScorerList.getValue()) {
            result.append(g.getName())
                    .append(" ")
                    .append(g.getMinute())
                    .append("\" ");
        }
        return result.toString();
    }
}

