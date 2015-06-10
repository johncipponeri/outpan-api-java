Outpan.com API
==============

Java wrapper for the [Outpan.com API][outpan_api]

Usage
-----

You'll first need to [create an account][outpan_register] and get your API key.

Once you have your API key and the compiled JAR file you're ready to go!

### Getting ready

To access the Outpan API you'll need to create an instance of `OutpanAPI` with
your API key. You'll use this object to access the API.

```java
OutpanAPI api = new OutpanAPI(your_api_key);
```

### Getting a product's data

Now that you are set it is time to make calls to the API. The first thing you
will want to do is retrieve a products information. For our test we'll use the
test barcode `078915030900`.

```java
api.getProduct("078915030900");
```

This call will return the product's data as an `OutpanObject` which contains the data from this JSON Response:

```javascript
{'attributes': {'Care': 'Dishwasher safe',
                'Colors': 'White',
                'Manufacturer': 'Progressive International',
                'Material': 'Plastic, Stainless Steel',
                'Part Number': 'GPC-5000'},
 'gtin': '0078915030900',
 'images': ['https://outpan-images.s3.amazonaws.com/rg6j1l9iqd-0078915030900.jpg',
            'https://outpan-images.s3.amazonaws.com/835ggkjjq0-0078915030900.png',
            'https://outpan-images.s3.amazonaws.com/8fn652ptobh3ecw886.jpg',
            'https://outpan-images.s3.amazonaws.com/26naopw9flteq3qrcs.jpg',
            'https://outpan-images.s3.amazonaws.com/uhqq6sdj47-0078915030900.jpg'],
 'name': 'Progressive International Cherry-It Pitter',
 'videos': ['https://outpan-images.s3.amazonaws.com/lo0e22j0nj-0078915030900.mp4',
            'https://outpan-images.s3.amazonaws.com/nkvaonl839-0078915030900.mp4',
            'https://outpan-images.s3.amazonaws.com/pjkhqlbgwl-0078915030900.mp4']}
```

The `v1` API allows you to retrieve specific attributes of a product using the
following methods:

```java
api.getName("078915030900");
api.getAttributes("078915030900");
api.getImages("078915030900");
api.getVideos("078915030900");
```

The output of these calls is the `OutpanObject` that contains the JSON Response from the API. You can read data from the `OutpanObject` like so:

```java
OutpanObject obj = new OutpanObject(api.getProduct(""078915030900"));

System.out.println(obj.gtin);
```

[outpan_api]: http://www.outpan.com/developers.php
[outpan_register]: http://www.outpan.com/index.php
