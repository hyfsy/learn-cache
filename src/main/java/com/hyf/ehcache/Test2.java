package com.hyf.ehcache;

import org.ehcache.transactions.xa.txmgr.TransactionManagerWrapper;
import org.ehcache.transactions.xa.txmgr.btm.BitronixTransactionManagerLookup;

/**
 * @author baB_hyf
 * @date 2021/03/24
 */
public class Test2 {

    public static void main(String[] args) {
        // TransactionManagerWrapper transactionManagerWrapper = new BitronixTransactionManagerLookup().lookupTransactionManagerWrapper();
        // BitronixTransactionManager transactionManager =
        //         TransactionManagerServices.getTransactionManager();

        System.out.println(1);
        {
            System.out.println(2);
        }
        System.out.println(3);
    }
}
