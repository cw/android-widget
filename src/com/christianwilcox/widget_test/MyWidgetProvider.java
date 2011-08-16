package com.christianwilcox.widget_test;

import java.util.Random;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.widget.RemoteViews;

public class MyWidgetProvider extends AppWidgetProvider {

  @Override
  public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
    final int N = appWidgetIds.length;
    // Create some random data
    String fakeUpdate = "Random: ";
    Random random = new Random();
    int nextInt = random.nextInt(100);
    fakeUpdate += String.valueOf(nextInt);
    for (int i=0; i<N; i++) {
      int widgetId = appWidgetIds[i];
      int number = (new Random().nextInt(100));

      RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.widget_layout);
      views.setTextViewText(R.id.TextView01, String.valueOf(number));
      appWidgetManager.updateAppWidget(widgetId, views);
    }
  }	
}
