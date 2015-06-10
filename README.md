Outpan.com API
==============

Java wrapper for the [Outpan.com API][outpan_api]

Usage
-----

You'll first need to [create an account][outpan_register] and get your API key.

Once you have your API key and the JAR file you're ready to go!

### Getting ready

To access the Outpan API you'll need to create an instance of `OutpanAPI` with
your API key. You'll use this object to access the API.

```java
OutpanAPI api = new OutpanAPI(your_api_key);
```

### Getting a product's data

Now that you are set it is time to make calls to the API. The first thing you
will want to do is retrieve a products information. For our test we'll use this barcode `0796435419035`.

```java
api.getProduct("0796435419035");
```

This call will return the product's data as an `OutpanObject` which contains the data from this JSON Response:

```javascript
{
    "gtin": "0796435419035",
    "outpan_url": "http:\/\/www.outpan.com\/view_product.php?barcode=0796435419035",
    "name": "Optoma ML750 Palm-sized Projection Powerhouse",
    "attributes": {
        "Aspect Ratio": "16:10 Native, 16:9 and 4:3 compatible",
        "Audio": "One 1-Watt speaker",
        "Brand": "Optoma",
        "Brightness": "700 Lumens",
        "Contrast Ratio": "10,000:1 (full on\/full off)",
        "Dimensions": "4.1\"x 1.5\" x 4.2\" (104 x 38 x 107 mm)",
        "Display Technology": "Single 0.45\" DMD DLP\u00ae Technology by Texas Instruments\u2122",
        "Light Source Type": "LED",
        "Maximum Resolution": "VGA: WSXGA+ (1680 x 1050)  HDMI: HD 1920 x 1080",
        "Memory": "1.5GB Onboard memory, microSD slot supports up to 32GB",
        "Native Resolution": "WXGA (1280 x 800)",
        "Power Consumption": "Max 62W, <0.5W (standby)",
        "Power Supply": "AC Input 100\u2013240V, 50\u201360Hz, auto-switching DC output: 19v\/3.2A, 65W",
        "Projection Method": "Front, rear, ceiling mount, table top",
        "Remote Control": "IR remote control",
        "Security": "Kensington Lock Port",
        "Throw Ratio": "1.5 (distance\/width)",
        "Uniformity": ">85%",
        "Warranty": "1-Year Optoma Parts and Labor",
        "Zoom": "1.7x"
    },
    "images": [
        "https:\/\/outpan-images.s3.amazonaws.com\/osbz3rkovm-0796435419035.png",
        "https:\/\/outpan-images.s3.amazonaws.com\/862i3fr7ql-0796435419035.jpg",
        "https:\/\/outpan-images.s3.amazonaws.com\/pj11al8tov-0796435419035.jpg",
        "https:\/\/outpan-images.s3.amazonaws.com\/r6sfntqd8z-0796435419035.jpg",
        "https:\/\/outpan-images.s3.amazonaws.com\/9r5ggdqz8g-0796435419035.jpg",
        "https:\/\/outpan-images.s3.amazonaws.com\/ipzmiamm4y-0796435419035.jpg",
        "https:\/\/outpan-images.s3.amazonaws.com\/ibr9os5ekn-0796435419035.jpg",
        "https:\/\/outpan-images.s3.amazonaws.com\/2nkkz3k1jw-0796435419035.jpg",
        "https:\/\/outpan-images.s3.amazonaws.com\/iqb21flk3y-0796435419035.jpg"
    ],
    "videos": [
        "https:\/\/outpan-images.s3.amazonaws.com\/v44yyd2vzy-0796435419035.mp4"
    ]
}
```

The `v1` API allows you to retrieve specific attributes of a product using the
following methods:

```python
api.getName("0796435419035");
api.getAttributes("0796435419035");
api.getImages("0796435419035");
api.getVideos("0796435419035");
```

The output of these calls is an `OutpanObject` that contains the JSON data as returned by the API.

You can access this data like so:

```java
OutpanAPI api = new OutpanAPI("1a74a95c40a331e50d4b2c7fe311328c");
OutpanObject obj = api.getProduct("0796435419035");

System.out.println(obj.gtin); // --> 0796435419035
System.out.println(obj.outpan_url); // --> http://www.outpan.com/view_product.php?barcode=0796435419035
System.out.println(obj.name); // --> Optoma ML750 Palm-sized Projection Powerhouse
System.out.println(obj.attributes.toString()); // --> [https://outpan-images.s3.amazonaws.com/nwa6sgegin-0796435419035.jpg, https://outpan-images.s3.amazonaws.com/yirge30fjg-0796435419035.jpg, https://outpan-images.s3.amazonaws.com/tpns1u2obk-0796435419035.jpg, https://outpan-images.s3.amazonaws.com/itbos1qyu8-0796435419035.jpg, https://outpan-images.s3.amazonaws.com/0vwjidtenr-0796435419035.jpg, https://outpan-images.s3.amazonaws.com/5djuz37ucz-0796435419035.jpg, https://outpan-images.s3.amazonaws.com/q37qshnjcm-0796435419035.jpg]
System.out.println(obj.images.toString()); // --> [https://outpan-images.s3.amazonaws.com/nwa6sgegin-0796435419035.jpg, https://outpan-images.s3.amazonaws.com/yirge30fjg-0796435419035.jpg, https://outpan-images.s3.amazonaws.com/tpns1u2obk-0796435419035.jpg, https://outpan-images.s3.amazonaws.com/itbos1qyu8-0796435419035.jpg, https://outpan-images.s3.amazonaws.com/0vwjidtenr-0796435419035.jpg, https://outpan-images.s3.amazonaws.com/5djuz37ucz-0796435419035.jpg, https://outpan-images.s3.amazonaws.com/q37qshnjcm-0796435419035.jpg]
System.out.println(obj.videos.toString()); // --> []
```

[outpan_api]: http://www.outpan.com/developers.php
[outpan_register]: http://www.outpan.com/index.php
