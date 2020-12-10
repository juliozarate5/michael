mkdir -p expanded
unzip build/distributions/Client-0.0.1-SNAPSHOT.zip -d expanded
find ./expanded/lib -name '*.jar' | xargs -n1 zipinfo -1 | grep '.*.class' | sort | uniq -c | sort