/*
 * Copyright (c) 2011-present, salesforce.com, inc.
 * All rights reserved.
 * Redistribution and use of this software in source and binary forms, with or
 * without modification, are permitted provided that the following conditions
 * are met:
 * - Redistributions of source code must retain the above copyright notice, this
 * list of conditions and the following disclaimer.
 * - Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation
 * and/or other materials provided with the distribution.
 * - Neither the name of salesforce.com, inc. nor the names of its contributors
 * may be used to endorse or promote products derived from this software without
 * specific prior written permission of salesforce.com, inc.
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */
package com.salesforce.androidsdk.util

import android.content.Intent
import android.os.Bundle

/**
 * Helper methods for logging
 */
object LogUtil {
    /**
     * Helper method for printing out intent
     * @param intent
     * @return string representation
     */
	@JvmStatic
	fun intentToString(intent: Intent?): String {
        return objectToString(intent)
    }

    /**
     * Helper method for printing out bundle
     * @param bundle
     * @return string representation
     */
    @JvmStatic
    fun bundleToString(bundle: Bundle?): String {
        return objectToString(bundle)
    }

    @Suppress("DEPRECATION")
    private fun objectToString(obj: Any?): String {
        return if (obj == null) {
            "null"
        } else if (obj is Intent) {
            "$obj extras = ${objectToString(obj.extras)}"
        } else if (obj is Bundle) {
            obj.keySet().map { key ->
                "$key = ${objectToString(obj[key])}"
            }.joinToString(" ", "{ ", " }")
        } else {
            obj.toString()
        }
    }
}