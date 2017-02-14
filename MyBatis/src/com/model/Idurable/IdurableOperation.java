package com.model.Idurable;

import com.model.Durable;

import java.util.List;

/**
 * Created by admin on 2017/2/14.
 */
public interface IdurableOperation {
    public Durable selectDurableByDurableName(String durableName);

    public List<Durable> selectDurables(String durableName);

    public void addDurable(Durable durable);

    public void updateDurable(Durable durable);

    public void deleteDurable(String durableName);
}
