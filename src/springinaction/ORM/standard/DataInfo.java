package springinaction.ORM.standard;

/**
 * Created by admin on 2017/2/13.
 */
public interface DataInfo<KEY extends KeyInfo> {
    public KEY getKey();

    public void setKey(KEY keyInfo);
}
