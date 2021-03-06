package ru.apapikyan.learn.bigdata.mapreds;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class ALogReducer extends Reducer<Text, IntWritable, Text, IntWritable> {

	@Override
	protected void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException,
	        InterruptedException {

		// float totalBytes = 0f;
		int totalBytes = 0;

		for (IntWritable value : values) {
			totalBytes += value.get();
		}

		context.write(key, new IntWritable(totalBytes));
	}
}