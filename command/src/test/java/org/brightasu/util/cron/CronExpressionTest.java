package org.brightasu.util.cron;


import org.brightasyou.asmoon.util.cron.CronExpression;
import org.brightasyou.asmoon.util.date.DateUtil;

import java.util.Date;
import java.util.concurrent.CountDownLatch;

public class CronExpressionTest {

	public static void main(String[] args) throws Exception {
		String cronExpression = "0 * */2 * * ?";
		CronExpression cexpStart = new CronExpression(cronExpression);
		Date current = new Date( );

		for(int i = 0 ;i < 10 ;i++){
			current = cexpStart.getNextValidTimeAfter(current);
			System.out.println(DateUtil.parseDateToStr(current, DateUtil.DATE_TIME_FORMAT_YYYY_MM_DD_HH_MI_SS));
		}
		
		/*String number = "1a";
		Long.valueOf(number);*/
		
		CountDownLatch countDownLatch = new CountDownLatch(20);
		for(int i = 0;i < 20;i++){
			countDownLatch.countDown();
		}
		countDownLatch.await();
		System.out.println("============结束了=============");
		
	}
}
