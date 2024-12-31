package com.app.handler;

import com.app.model.University;
import com.app.model.Community;
import com.app.model.Major;
import com.app.model.User;
import com.app.queue.EducationActivityQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EducationActivityHandler {

    @Autowired
    private EducationActivityQueue educationActivityQueue;

    public void handleEducationActivity(User user, University university, Major major) {
        System.out.println("Processing Education activity for User: ");
    }

}
