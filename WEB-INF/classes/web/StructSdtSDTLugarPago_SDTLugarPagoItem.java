package web ;
import com.genexus.*;

public final  class StructSdtSDTLugarPago_SDTLugarPagoItem implements Cloneable, java.io.Serializable
{
   public StructSdtSDTLugarPago_SDTLugarPagoItem( )
   {
      this( -1, new ModelContext( StructSdtSDTLugarPago_SDTLugarPagoItem.class ));
   }

   public StructSdtSDTLugarPago_SDTLugarPagoItem( int remoteHandle ,
                                                  ModelContext context )
   {
      gxTv_SdtSDTLugarPago_SDTLugarPagoItem_Lpgcodigo = "" ;
      gxTv_SdtSDTLugarPago_SDTLugarPagoItem_Lpgdescri = "" ;
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

   public String getLpgcodigo( )
   {
      return gxTv_SdtSDTLugarPago_SDTLugarPagoItem_Lpgcodigo ;
   }

   public void setLpgcodigo( String value )
   {
      gxTv_SdtSDTLugarPago_SDTLugarPagoItem_N = (byte)(0) ;
      gxTv_SdtSDTLugarPago_SDTLugarPagoItem_Lpgcodigo = value ;
   }

   public String getLpgdescri( )
   {
      return gxTv_SdtSDTLugarPago_SDTLugarPagoItem_Lpgdescri ;
   }

   public void setLpgdescri( String value )
   {
      gxTv_SdtSDTLugarPago_SDTLugarPagoItem_N = (byte)(0) ;
      gxTv_SdtSDTLugarPago_SDTLugarPagoItem_Lpgdescri = value ;
   }

   protected byte gxTv_SdtSDTLugarPago_SDTLugarPagoItem_N ;
   protected String gxTv_SdtSDTLugarPago_SDTLugarPagoItem_Lpgcodigo ;
   protected String gxTv_SdtSDTLugarPago_SDTLugarPagoItem_Lpgdescri ;
}

