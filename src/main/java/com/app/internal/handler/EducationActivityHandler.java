package com.app.internal.handler;

import com.app.internal.model.University;
import com.app.internal.model.Community;
import com.app.internal.model.Major;
import com.app.internal.model.User;
import com.app.internal.queue.EducationActivityQueue;
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
