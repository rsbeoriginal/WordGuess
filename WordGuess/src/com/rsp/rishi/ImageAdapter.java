package com.rsp.rishi;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {

	int[] l1 = { R.drawable.l1, R.drawable.l1c };
	int[] l2 = { R.drawable.l2, R.drawable.l2c };
	int[] l3 = { R.drawable.l3, R.drawable.l3c };
	int[] l4 = { R.drawable.l4, R.drawable.l4c };
	int[] l5 = { R.drawable.l5, R.drawable.l5c };
	int[] l6 = { R.drawable.l6, R.drawable.l6c };
	int[] l7 = { R.drawable.l7, R.drawable.l7c };
	int[] l8 = { R.drawable.l8, R.drawable.l8c };
	int[] l9 = { R.drawable.l9, R.drawable.l9c };
	int[] l10 = { R.drawable.l10, R.drawable.l10c };
	int[] l11 = { R.drawable.l11, R.drawable.l11c };
	int[] l12 = { R.drawable.l12, R.drawable.l12c };
	int[] l13 = { R.drawable.l13, R.drawable.l13c };
	int[] l14 = { R.drawable.l14, R.drawable.l14c };
	int[] l15 = { R.drawable.l15, R.drawable.l15c };
	int[] l16 = { R.drawable.l16, R.drawable.l16c };
	int[] l17 = { R.drawable.l17, R.drawable.l17c };
	int[] l18 = { R.drawable.l18, R.drawable.l18c };
	int[] l19 = { R.drawable.l19, R.drawable.l19c };
	int[] l20 = { R.drawable.l20, R.drawable.l20c };
	int[] l21 = { R.drawable.l21, R.drawable.l21c };
	int[] l22 = { R.drawable.l22, R.drawable.l22c };
	int[] l23 = { R.drawable.l23, R.drawable.l23c };
	int[] l24 = { R.drawable.l24, R.drawable.l24c };
	int[] l25 = { R.drawable.l25, R.drawable.l25c };
	int[] l26 = { R.drawable.l26, R.drawable.l26c };
	int[] l27 = { R.drawable.l27, R.drawable.l27c };
	int[] l28 = { R.drawable.l28, R.drawable.l28c };
	int[] l29 = { R.drawable.l29, R.drawable.l29c };
	int[] l30 = { R.drawable.l30, R.drawable.l30c };

	private Context mContext;

	public ImageAdapter(Context c) {
		mContext = c;
	}

	public int getCount() {
		return mThumbIds.length;
	}

	public Object getItem(int position) {
		return null;
	}

	public long getItemId(int position) {
		return 0;
	}

	// create a new ImageView for each item referenced by the Adapter
	public View getView(int position, View convertView, ViewGroup parent) {
		ImageView imageView;
		if (convertView == null) { // if it's not recycled, initialize some
									// attributes
			imageView = new ImageView(mContext);
			imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
			imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
			imageView.setPadding(8, 8, 8, 8);
		} else {
			imageView = (ImageView) convertView;
		}

		imageView.setImageResource(mThumbIds[position]);
		return imageView;
	}

	// references to our images
	private Integer[] mThumbIds = { l1[Info.level_1[0]],
			l2[Info.level_1[1]], l3[Info.level_1[2]],
			l4[Info.level_1[3]], l5[Info.level_1[4]],
			l6[Info.level_1[5]], l7[Info.level_1[6]],
			l8[Info.level_1[7]], l9[Info.level_1[8]],
			l10[Info.level_1[9]], l11[Info.level_1[10]],
			l12[Info.level_1[11]], l13[Info.level_1[12]],
			l14[Info.level_1[13]], l15[Info.level_1[14]],
			l16[Info.level_1[15]], l17[Info.level_1[16]],
			l18[Info.level_1[17]], l19[Info.level_1[18]],
			l20[Info.level_1[19]], l21[Info.level_1[20]],
			l22[Info.level_1[21]], l23[Info.level_1[22]],
			l24[Info.level_1[23]], l25[Info.level_1[24]],
			l26[Info.level_1[25]], l27[Info.level_1[26]],
			l28[Info.level_1[27]], l29[Info.level_1[28]],
			l30[Info.level_1[29]] };
}