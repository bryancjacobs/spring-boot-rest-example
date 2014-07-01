package app.mbean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedOperationParameter;
import org.springframework.jmx.export.annotation.ManagedOperationParameters;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Component;

/**
 * User: brjacobs
 * Date: 7/1/14
 * Time: 3:13 PM
 */
@Component
@ManagedResource(objectName="app.mbean:name=TestInectionMBean", description="test injecting another mbean into this mbean")
public class TestInectionMBean {

    @Autowired
    PersonMBean personMBean;

    @ManagedOperation(description = "get a person by their id")
    @ManagedOperationParameters( { @ManagedOperationParameter(name = "id", description = "id of person") })
    public String getById(Long id){
        return personMBean.getById(id).toString();
    }
}
