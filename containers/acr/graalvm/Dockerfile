# -----------------------------------------------------------------------------
#
# Note this Dockerfile is an skeleton that you can use as a starting point for 
# your own Dockerfile. It is NOT intended to be used for production workloads.
#
# -----------------------------------------------------------------------------

FROM debian
EXPOSE 8080
COPY target/graalvm /opt/graalvm/graalvm
COPY entrypoint.sh /opt/graalvm/entrypoint.sh
RUN chmod a+x /opt/graalvm/entrypoint.sh
ENTRYPOINT ["/opt/graalvm/entrypoint.sh"]
CMD ["/opt/graalvm/graalvm"]
