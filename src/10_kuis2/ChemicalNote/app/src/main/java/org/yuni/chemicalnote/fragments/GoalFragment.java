package org.yuni.chemicalnote.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import org.yuni.chemicalnote.R;
import org.yuni.chemicalnote.databinding.FragmentGoalBinding;
import org.yuni.chemicalnote.model.GoalScorer;
import org.yuni.chemicalnote.viewmodels.ScoreViewModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class GoalFragment extends Fragment {

	private ScoreViewModel viewModel;
	private String requestKey;
	private GoalScorer goalScorer;

	public GoalFragment() {
		// Required empty public constructor
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.goalScorer = new GoalScorer();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		FragmentGoalBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_goal, container, false);
		// instance viewmodel here
		viewModel = new ViewModelProvider(requireActivity()).get(ScoreViewModel.class);
		binding.setFragment(this);
		binding.setGoalScorer(goalScorer);
		requestKey = GoalFragmentArgs.fromBundle(getArguments()).getRequestKey();
		return binding.getRoot();
	}

	public void onSaveClicked(View view) {
		Bundle bundle = new Bundle();
		bundle.putParcelable(ScoreFragment.SCORER_KEY, goalScorer);

		// set goalscorer use viewmodel
		viewModel.setGoalScorer(requestKey, goalScorer);
		Navigation.findNavController(view).navigateUp();
	}

	public void onCancelClicked(View view) {
		Navigation.findNavController(view).navigateUp();
	}

}