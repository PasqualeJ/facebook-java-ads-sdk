/**
 * Copyright (c) 2015-present, Facebook, Inc. All rights reserved.
 *
 * You are hereby granted a non-exclusive, worldwide, royalty-free license to
 * use, copy, modify, and distribute this software in source code or binary
 * form for use in connection with the web services and APIs provided by
 * Facebook.
 *
 * As with any software that integrates with the Facebook platform, your use
 * of this software is subject to the Facebook Developer Principles and
 * Policies [http://developers.facebook.com/policy/]. This copyright notice
 * shall be included in all copies or substantial portions of the software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL
 * THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
 * DEALINGS IN THE SOFTWARE.
 *
 */

package com.facebook.ads.sdk;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.IllegalArgumentException;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.JsonObject;
import com.google.gson.JsonArray;
import com.google.gson.JsonParseException;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.google.gson.FieldNamingStrategy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;


public class FundingSourceDetailsCoupon extends APINode {
  @SerializedName("amount")
  private Long mAmount = null;
  @SerializedName("currency")
  private String mCurrency = null;
  @SerializedName("display_amount")
  private String mDisplayAmount = null;
  @SerializedName("expiration")
  private String mExpiration = null;
  protected static Gson gson = null;

  public FundingSourceDetailsCoupon() {
  }

  public String getId() {
    return null;
  }
  public static FundingSourceDetailsCoupon loadJSON(String json, APIContext context) {
    FundingSourceDetailsCoupon fundingSourceDetailsCoupon = getGson().fromJson(json, FundingSourceDetailsCoupon.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(fundingSourceDetailsCoupon.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if(!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    fundingSourceDetailsCoupon.mContext = context;
    fundingSourceDetailsCoupon.rawValue = json;
    return fundingSourceDetailsCoupon;
  }

  public static APINodeList<FundingSourceDetailsCoupon> parseResponse(String json, APIContext context, APIRequest request) {
    APINodeList<FundingSourceDetailsCoupon> fundingSourceDetailsCoupons = new APINodeList<FundingSourceDetailsCoupon>(request);
    JsonArray arr;
    JsonObject obj;
    JsonParser parser = new JsonParser();
    try{
      JsonElement result = parser.parse(json);
      if (result.isJsonArray()) {
        // First, check if it's a pure JSON Array
        arr = result.getAsJsonArray();
        for (int i = 0; i < arr.size(); i++) {
          fundingSourceDetailsCoupons.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return fundingSourceDetailsCoupons;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          try {
            JsonObject paging = obj.get("paging").getAsJsonObject().get("cursors").getAsJsonObject();
            fundingSourceDetailsCoupons.setPaging(paging.get("before").getAsString(), paging.get("after").getAsString());
          } catch (Exception ignored) {
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              fundingSourceDetailsCoupons.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
            };
          } else if (obj.get("data").isJsonObject()) {
            // Third, check if it's a JSON object with "data"
            obj = obj.get("data").getAsJsonObject();
            fundingSourceDetailsCoupons.add(loadJSON(obj.toString(), context));
          }
          return fundingSourceDetailsCoupons;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              fundingSourceDetailsCoupons.add(loadJSON(entry.getValue().toString(), context));
          }
          return fundingSourceDetailsCoupons;
        } else {
          // Fifth, check if it's pure JsonObject
          fundingSourceDetailsCoupons.add(loadJSON(json, context));
          return fundingSourceDetailsCoupons;
        }
      }
    } catch (Exception e) {
    }
    return null;
  }

  @Override
  public APIContext getContext() {
    return mContext;
  }

  @Override
  public void setContext(APIContext context) {
    mContext = context;
  }

  @Override
  public String toString() {
    return getGson().toJson(this);
  }


  public Long getFieldAmount() {
    return mAmount;
  }

  public FundingSourceDetailsCoupon setFieldAmount(Long value) {
    this.mAmount = value;
    return this;
  }

  public String getFieldCurrency() {
    return mCurrency;
  }

  public FundingSourceDetailsCoupon setFieldCurrency(String value) {
    this.mCurrency = value;
    return this;
  }

  public String getFieldDisplayAmount() {
    return mDisplayAmount;
  }

  public FundingSourceDetailsCoupon setFieldDisplayAmount(String value) {
    this.mDisplayAmount = value;
    return this;
  }

  public String getFieldExpiration() {
    return mExpiration;
  }

  public FundingSourceDetailsCoupon setFieldExpiration(String value) {
    this.mExpiration = value;
    return this;
  }




  synchronized /*package*/ static Gson getGson() {
    if (gson != null) {
      return gson;
    } else {
      gson = new GsonBuilder()
        .excludeFieldsWithModifiers(Modifier.STATIC)
        .excludeFieldsWithModifiers(Modifier.PROTECTED)
        .disableHtmlEscaping()
        .create();
    }
    return gson;
  }

  public FundingSourceDetailsCoupon copyFrom(FundingSourceDetailsCoupon instance) {
    this.mAmount = instance.mAmount;
    this.mCurrency = instance.mCurrency;
    this.mDisplayAmount = instance.mDisplayAmount;
    this.mExpiration = instance.mExpiration;
    this.mContext = instance.mContext;
    this.rawValue = instance.rawValue;
    return this;
  }
}