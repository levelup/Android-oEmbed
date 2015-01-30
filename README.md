Android-oEmbed
==================

A simple oEmbed parsing library for Android.

You provide the URL of a webpage and the library will give you an OEmbed object if it finds one.

Dependencies
--------

* [Tophe](https://github.com/levelup/Android-HttpClient)

Sample Code
-----------

```java
OEmbedSource dataSource = OEmbedFinder.parse("http://www.youtube.com/watch?v=ODrLMCXKTS8");
String thumbnail = dataSource.getThumbnail();
```

### Download

Download [the latest JAR][1] or grab via Maven:
```xml
<dependency>
  <groupId>co.tophe</groupId>
  <artifactId>android-oembed</artifactId>
  <version>1.0.1</version>
</dependency>
```
or Gradle:
```groovy
compile 'co.tophe:tophe:android-oembed:1.0.1'
```

License
-------

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

[1]: https://search.maven.org/remote_content?g=co.tophe&a=android-oembed&v=LATEST
