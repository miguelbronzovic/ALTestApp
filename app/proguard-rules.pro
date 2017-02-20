# OkHttp
-dontwarn com.squareup.okhttp.**

# Gson
-keepattributes Signature
-keep class sun.misc.Unsafe { *; }

# Retrofit
-dontwarn retrofit.**
-keep class retrofit.** { *; }

# Okio
-dontwarn java.nio.file.*
-dontwarn org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement

# Exceptions
-keepattributes Exceptions
