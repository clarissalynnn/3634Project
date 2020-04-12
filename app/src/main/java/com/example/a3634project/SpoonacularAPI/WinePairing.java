package com.example.a3634project.SpoonacularAPI;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WinePairing implements Serializable
{

    @SerializedName("pairedWines")
    @Expose
    private List<Object> pairedWines = new ArrayList<Object>();
    @SerializedName("pairingText")
    @Expose
    private String pairingText;
    @SerializedName("productMatches")
    @Expose
    private List<Object> productMatches = new ArrayList<Object>();
    private final static long serialVersionUID = -6446708726138502302L;

    /**
     * No args constructor for use in serialization
     *
     */
    public WinePairing() {
    }

    /**
     *
     * @param productMatches
     * @param pairingText
     * @param pairedWines
     */
    public WinePairing(List<Object> pairedWines, String pairingText, List<Object> productMatches) {
        super();
        this.pairedWines = pairedWines;
        this.pairingText = pairingText;
        this.productMatches = productMatches;
    }

    public List<Object> getPairedWines() {
        return pairedWines;
    }

    public void setPairedWines(List<Object> pairedWines) {
        this.pairedWines = pairedWines;
    }

    public WinePairing withPairedWines(List<Object> pairedWines) {
        this.pairedWines = pairedWines;
        return this;
    }

    public String getPairingText() {
        return pairingText;
    }

    public void setPairingText(String pairingText) {
        this.pairingText = pairingText;
    }

    public WinePairing withPairingText(String pairingText) {
        this.pairingText = pairingText;
        return this;
    }

    public List<Object> getProductMatches() {
        return productMatches;
    }

    public void setProductMatches(List<Object> productMatches) {
        this.productMatches = productMatches;
    }

    public WinePairing withProductMatches(List<Object> productMatches) {
        this.productMatches = productMatches;
        return this;
    }

}
