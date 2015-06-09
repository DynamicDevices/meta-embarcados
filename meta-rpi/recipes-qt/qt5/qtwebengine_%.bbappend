export QMAKE_CACHE_EVAL="CONFIG+=${EXTRA_OECONF}"

EXTRA_OECONF_append = " CXXFLAGS='-I${STAGING_DIR_TARGET}/usr/include/interface/vcos/pthreads \
                                   -I${STAGING_DIR_TARGET}/usr/include/interface/vmcs_host/linux' \
								   "

# Do not get out of memory
LDFLAGS += "-Wl,--no-keep-memory"

do_configure_prepend() {
    export QMAKE_CACHE_EVAL="CONFIG+=${EXTRA_OECONF}"
}
