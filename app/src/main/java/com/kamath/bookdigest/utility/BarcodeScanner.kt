package com.kamath.bookdigest.utility

import android.content.Context
import android.util.Log
import com.google.mlkit.vision.barcode.common.Barcode
import com.google.mlkit.vision.codescanner.GmsBarcodeScannerOptions
import com.google.mlkit.vision.codescanner.GmsBarcodeScanning
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.tasks.await

class BarcodeScanner(appContext: Context) {
    val TAG = "BARCODE SCANNER"
    val options = GmsBarcodeScannerOptions.Builder()
        .setBarcodeFormats(
            Barcode.FORMAT_ALL_FORMATS)//this needs to be changed to only isbn detection
        .build()

    val scanner = GmsBarcodeScanning.getClient(appContext,options)
    val barCodeResults = MutableStateFlow<String?>(null)

    suspend fun startScan() {
        try {
            val result = scanner.startScan().await()
            barCodeResults.value = result.rawValue
            
            Log.d(TAG, "startScan: ")
        } catch (e: Exception) {
            Log.d(TAG, "startScan: ${e.printStackTrace()}")
        }
    }
}