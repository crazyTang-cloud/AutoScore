package Logical.Data;

public class OpData {
    /**
     * ��һ��������
     */
    private int Data1;

    /**
     * �ڶ���������
     */
    private int Data2;

    /**
     * ������
     */
    private int Data3;

    public OpData(int data1,int data2, int data3) {
        this.Data1=data1;
        this.Data2=data2;
        this.Data3=data3;
    }

    public int getData1() {
        return Data1;
    }

    public int getData2() {
        return Data2;
    }

    public int getData3() {
        return Data3;
    }
}
