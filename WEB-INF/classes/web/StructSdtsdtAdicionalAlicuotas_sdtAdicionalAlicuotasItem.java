package web ;
import com.genexus.*;

public final  class StructSdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem implements Cloneable, java.io.Serializable
{
   public StructSdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem( )
   {
      this( -1, new ModelContext( StructSdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem.class ));
   }

   public StructSdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem( int remoteHandle ,
                                                                    ModelContext context )
   {
      gxTv_SdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem_Cliconvenio = "" ;
      gxTv_SdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem_Conveadicod = "" ;
      gxTv_SdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem_Conveadiopcfor = "" ;
      gxTv_SdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem_Conveadiopcdes = "" ;
      gxTv_SdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem_Conveadiopcali = new java.math.BigDecimal(0) ;
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

   public short getClipaiconve( )
   {
      return gxTv_SdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem_Clipaiconve ;
   }

   public void setClipaiconve( short value )
   {
      gxTv_SdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem_N = (byte)(0) ;
      gxTv_SdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem_Clipaiconve = value ;
   }

   public String getCliconvenio( )
   {
      return gxTv_SdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem_Cliconvenio ;
   }

   public void setCliconvenio( String value )
   {
      gxTv_SdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem_N = (byte)(0) ;
      gxTv_SdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem_Cliconvenio = value ;
   }

   public String getConveadicod( )
   {
      return gxTv_SdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem_Conveadicod ;
   }

   public void setConveadicod( String value )
   {
      gxTv_SdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem_N = (byte)(0) ;
      gxTv_SdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem_Conveadicod = value ;
   }

   public short getConveadiopccod( )
   {
      return gxTv_SdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem_Conveadiopccod ;
   }

   public void setConveadiopccod( short value )
   {
      gxTv_SdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem_N = (byte)(0) ;
      gxTv_SdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem_Conveadiopccod = value ;
   }

   public String getConveadiopcfor( )
   {
      return gxTv_SdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem_Conveadiopcfor ;
   }

   public void setConveadiopcfor( String value )
   {
      gxTv_SdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem_N = (byte)(0) ;
      gxTv_SdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem_Conveadiopcfor = value ;
   }

   public String getConveadiopcdes( )
   {
      return gxTv_SdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem_Conveadiopcdes ;
   }

   public void setConveadiopcdes( String value )
   {
      gxTv_SdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem_N = (byte)(0) ;
      gxTv_SdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem_Conveadiopcdes = value ;
   }

   public java.math.BigDecimal getConveadiopcali( )
   {
      return gxTv_SdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem_Conveadiopcali ;
   }

   public void setConveadiopcali( java.math.BigDecimal value )
   {
      gxTv_SdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem_N = (byte)(0) ;
      gxTv_SdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem_Conveadiopcali = value ;
   }

   protected byte gxTv_SdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem_N ;
   protected short gxTv_SdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem_Clipaiconve ;
   protected short gxTv_SdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem_Conveadiopccod ;
   protected String gxTv_SdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem_Cliconvenio ;
   protected String gxTv_SdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem_Conveadicod ;
   protected String gxTv_SdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem_Conveadiopcfor ;
   protected String gxTv_SdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem_Conveadiopcdes ;
   protected java.math.BigDecimal gxTv_SdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem_Conveadiopcali ;
}

