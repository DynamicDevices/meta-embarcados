
# Ugly workaround for do_compileconfigs task error for subsequents run.
do_compileconfigs_prepend() {
    rm -f ${D}/lib/modules/${KERNEL_VERSION}/build
    KERNEL_SRC_PATH="/usr/src/kernel"
    kerneldir=${D}${KERNEL_SRC_PATH}
    rm -rf $kerneldir/Documentation
    mkdir -p "${D}/lib/modules/${KERNEL_VERSION}-systest"
    touch "${D}/lib/modules/${KERNEL_VERSION}-systest/build"
    touch "${D}/lib/modules/${KERNEL_VERSION}-systest/source"
    mkdir -p "${D}/lib/modules/${KERNEL_VERSION}-systest/kernel"
}    
