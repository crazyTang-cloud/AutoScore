package Logical.Operation;

import Logical.Data.OpData;

public interface Operator {
    /**
     * ������ɣ��ӷ�������
     * @param data
     * @return ������
     */
    public int Op_rule(OpData data);

    /**
     * �������������
     * @return ������
     */
    public OpData RandomData();
}
