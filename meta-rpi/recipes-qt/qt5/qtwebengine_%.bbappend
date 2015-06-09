export QMAKE_CACHE_EVAL="CONFIG+=${EXTRA_OECONF}"

EXTRA_OECONF_append = " CXXFLAGS='-I${STAGING_DIR_TARGET}/usr/include/interface/vcos/pthreads \
                                   -I${STAGING_DIR_TARGET}/usr/include/interface/vmcs_host/linux' \
								   "

do_configure_prepend() {
    export QMAKE_CACHE_EVAL="CONFIG+=${EXTRA_OECONF}"
}
