package org.example.project.util;

import org.junit.Assert;
import org.junit.Test;

import javax.persistence.EntityManager;

public class JPATest  {

    @Test
    public void testGetEntityManager() {
        EntityManager manager = JPA.getEntityManager();
        Assert.assertNotNull(manager);
    }

}