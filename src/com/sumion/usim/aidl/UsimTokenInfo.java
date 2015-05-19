package com.sumion.usim.aidl;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 스마트 USIM 토큰 정보 class
 */
public class UsimTokenInfo implements Parcelable {

	/** USIM Free memory */
	private long mUsimFreeMemory;
	/** USIM 시리얼 번호 */
	private byte[] mUsimSerialNumber;
	
	public UsimTokenInfo(Parcel In){
		readFromParcel(In);
	}

	public UsimTokenInfo(long usimFreeMemory, byte[] usimSerialNumber){
		mUsimFreeMemory = usimFreeMemory;
		mUsimSerialNumber = usimSerialNumber;
	}

	/**
	 * USIM Free memory 반환
	 * @return long - USIM Free memory
	 */
	public long getFreeMem(){
		return mUsimFreeMemory;
	}

	/**
	 * USIM 시리얼 번호 반환
	 * @return byte[] - USIM 시리얼 번호
	 */
	public byte[] getUismSerialNumber(){
		return mUsimSerialNumber;
	}
	
	@Override
	public int describeContents() {
		return 0;
	}
	
	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeLong(mUsimFreeMemory);
		dest.writeByteArray(mUsimSerialNumber);
	}
	
	public void readFromParcel(Parcel in){
		mUsimFreeMemory = in.readLong();
		in.readByteArray(mUsimSerialNumber);
	}
	
	public static final Parcelable.Creator<UsimTokenInfo> CREATOR = new Parcelable.Creator<UsimTokenInfo>(){
		@Override
		public UsimTokenInfo createFromParcel(Parcel source) {
			return new UsimTokenInfo(source);
		}

		@Override
		public UsimTokenInfo[] newArray(int size) {
			return new UsimTokenInfo[size];
		}
	};
}