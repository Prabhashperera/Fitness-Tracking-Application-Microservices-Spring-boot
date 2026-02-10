package com.fitness.activityservice.service;

import com.fitness.activityservice.dto.ActivityRequest;
import com.fitness.activityservice.dto.ActivityResponse;
import com.fitness.activityservice.model.Activity;
import com.fitness.activityservice.repo.ActivityRepo;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ActivityService {
    private final ActivityRepo activityRepo;

    public ActivityResponse trackActivity(ActivityRequest request) {
        Activity activity = Activity.builder()
                .userID(request.getUserID())
                .activityType(request.getActivityType())
                .duration(request.getDuration())
                .caloriesBurned(request.getCaloriesBurned())
                .startTime(request.getStartTime())
                .additionalMetrics(request.getAdditionalMetrics())
                .build();
        Activity savedActivity = activityRepo.save(activity);
        return mapToResponse(savedActivity);
    }

    public ActivityResponse mapToResponse(Activity activity) {
        ActivityResponse response = new ActivityResponse();
        response.setId(activity.getId());
        response.setActivityType(activity.getActivityType());
        response.setDuration(activity.getDuration());
        response.setCaloriesBurned(activity.getCaloriesBurned());
        response.setStartTime(activity.getStartTime());
        response.setAdditionalMetrics(activity.getAdditionalMetrics());
        return response;
    }

    public List<ActivityResponse> getUserActivities(String userId) {
        List<Activity> dataList = activityRepo.findByUserID(userId);
        List<ActivityResponse> convertedActivities = new ArrayList<>();

        for (Activity activity : dataList) {
            ActivityResponse response = new ActivityResponse();
            response.setUserID(activity.getUserID());
            response.setActivityType(activity.getActivityType());
            response.setDuration(activity.getDuration());
            response.setCaloriesBurned(activity.getCaloriesBurned());
            response.setStartTime(activity.getStartTime());
            response.setAdditionalMetrics(activity.getAdditionalMetrics());

            convertedActivities.add(response);
        }

        return convertedActivities;
    }
}
