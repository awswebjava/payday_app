package web ;
import com.genexus.*;

public final  class StructSdtcal_par_valores_cal_par_valoresItem implements Cloneable, java.io.Serializable
{
   public StructSdtcal_par_valores_cal_par_valoresItem( )
   {
      this( -1, new ModelContext( StructSdtcal_par_valores_cal_par_valoresItem.class ));
   }

   public StructSdtcal_par_valores_cal_par_valoresItem( int remoteHandle ,
                                                        ModelContext context )
   {
      gxTv_Sdtcal_par_valores_cal_par_valoresItem_Calparid = "" ;
      gxTv_Sdtcal_par_valores_cal_par_valoresItem_Value = "" ;
      gxTv_Sdtcal_par_valores_cal_par_valoresItem_Calparcampo = "" ;
      gxTv_Sdtcal_par_valores_cal_par_valoresItem_Calparvallista = "" ;
      gxTv_Sdtcal_par_valores_cal_par_valoresItem_Calpardef = "" ;
      gxTv_Sdtcal_par_valores_cal_par_valoresItem_Calparnombre = "" ;
   }

   public Object clone()
   {
      Object cloned = null;
      try
      {
         cloned = super.clone();
      }catch (CloneNotSupportedException e){ ; }
      return cloned;
   }

   public String getCalparid( )
   {
      return gxTv_Sdtcal_par_valores_cal_par_valoresItem_Calparid ;
   }

   public void setCalparid( String value )
   {
      gxTv_Sdtcal_par_valores_cal_par_valoresItem_N = (byte)(0) ;
      gxTv_Sdtcal_par_valores_cal_par_valoresItem_Calparid = value ;
   }

   public String getValue( )
   {
      return gxTv_Sdtcal_par_valores_cal_par_valoresItem_Value ;
   }

   public void setValue( String value )
   {
      gxTv_Sdtcal_par_valores_cal_par_valoresItem_N = (byte)(0) ;
      gxTv_Sdtcal_par_valores_cal_par_valoresItem_Value = value ;
   }

   public String getCalparcampo( )
   {
      return gxTv_Sdtcal_par_valores_cal_par_valoresItem_Calparcampo ;
   }

   public void setCalparcampo( String value )
   {
      gxTv_Sdtcal_par_valores_cal_par_valoresItem_N = (byte)(0) ;
      gxTv_Sdtcal_par_valores_cal_par_valoresItem_Calparcampo = value ;
   }

   public String getCalparvallista( )
   {
      return gxTv_Sdtcal_par_valores_cal_par_valoresItem_Calparvallista ;
   }

   public void setCalparvallista( String value )
   {
      gxTv_Sdtcal_par_valores_cal_par_valoresItem_N = (byte)(0) ;
      gxTv_Sdtcal_par_valores_cal_par_valoresItem_Calparvallista = value ;
   }

   public byte getCalpargrp( )
   {
      return gxTv_Sdtcal_par_valores_cal_par_valoresItem_Calpargrp ;
   }

   public void setCalpargrp( byte value )
   {
      gxTv_Sdtcal_par_valores_cal_par_valoresItem_N = (byte)(0) ;
      gxTv_Sdtcal_par_valores_cal_par_valoresItem_Calpargrp = value ;
   }

   public byte getCalpargrpdep( )
   {
      return gxTv_Sdtcal_par_valores_cal_par_valoresItem_Calpargrpdep ;
   }

   public void setCalpargrpdep( byte value )
   {
      gxTv_Sdtcal_par_valores_cal_par_valoresItem_N = (byte)(0) ;
      gxTv_Sdtcal_par_valores_cal_par_valoresItem_Calpargrpdep = value ;
   }

   public boolean getCalparobl( )
   {
      return gxTv_Sdtcal_par_valores_cal_par_valoresItem_Calparobl ;
   }

   public void setCalparobl( boolean value )
   {
      gxTv_Sdtcal_par_valores_cal_par_valoresItem_N = (byte)(0) ;
      gxTv_Sdtcal_par_valores_cal_par_valoresItem_Calparobl = value ;
   }

   public String getCalpardef( )
   {
      return gxTv_Sdtcal_par_valores_cal_par_valoresItem_Calpardef ;
   }

   public void setCalpardef( String value )
   {
      gxTv_Sdtcal_par_valores_cal_par_valoresItem_N = (byte)(0) ;
      gxTv_Sdtcal_par_valores_cal_par_valoresItem_Calpardef = value ;
   }

   public String getCalparnombre( )
   {
      return gxTv_Sdtcal_par_valores_cal_par_valoresItem_Calparnombre ;
   }

   public void setCalparnombre( String value )
   {
      gxTv_Sdtcal_par_valores_cal_par_valoresItem_N = (byte)(0) ;
      gxTv_Sdtcal_par_valores_cal_par_valoresItem_Calparnombre = value ;
   }

   protected byte gxTv_Sdtcal_par_valores_cal_par_valoresItem_Calpargrp ;
   protected byte gxTv_Sdtcal_par_valores_cal_par_valoresItem_Calpargrpdep ;
   protected byte gxTv_Sdtcal_par_valores_cal_par_valoresItem_N ;
   protected String gxTv_Sdtcal_par_valores_cal_par_valoresItem_Calparid ;
   protected String gxTv_Sdtcal_par_valores_cal_par_valoresItem_Value ;
   protected String gxTv_Sdtcal_par_valores_cal_par_valoresItem_Calpardef ;
   protected boolean gxTv_Sdtcal_par_valores_cal_par_valoresItem_Calparobl ;
   protected String gxTv_Sdtcal_par_valores_cal_par_valoresItem_Calparcampo ;
   protected String gxTv_Sdtcal_par_valores_cal_par_valoresItem_Calparvallista ;
   protected String gxTv_Sdtcal_par_valores_cal_par_valoresItem_Calparnombre ;
}

