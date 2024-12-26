package com.app.internal.handler;

import com.app.internal.model.MajorInteraction;
import com.app.internal.model.UniversityInteraction;
import com.app.internal.model.EducationActivity;
import com.app.internal.model.University;
import com.app.internal.model.Community;
import com.app.internal.model.Major;
import com.app.internal.queue.EducationActivityQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EducationActivityHandler {

    @Autowired
    private EducationActivityQueue educationActivityQueue;

    public void handleEducationActivity(EducationActivity educationActivity) {
        System.out.println("Processing Education activity for User: ");
    }

}
