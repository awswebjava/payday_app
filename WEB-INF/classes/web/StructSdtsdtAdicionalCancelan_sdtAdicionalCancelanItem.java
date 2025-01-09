package web ;
import com.genexus.*;

public final  class StructSdtsdtAdicionalCancelan_sdtAdicionalCancelanItem implements Cloneable, java.io.Serializable
{
   public StructSdtsdtAdicionalCancelan_sdtAdicionalCancelanItem( )
   {
      this( -1, new ModelContext( StructSdtsdtAdicionalCancelan_sdtAdicionalCancelanItem.class ));
   }

   public StructSdtsdtAdicionalCancelan_sdtAdicionalCancelanItem( int remoteHandle ,
                                                                  ModelContext context )
   {
      gxTv_SdtsdtAdicionalCancelan_sdtAdicionalCancelanItem_Cliconvenio = "" ;
      gxTv_SdtsdtAdicionalCancelan_sdtAdicionalCancelanItem_Conveadicod = "" ;
      gxTv_SdtsdtAdicionalCancelan_sdtAdicionalCancelanItem_Conveadisitcancela = "" ;
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
      return gxTv_SdtsdtAdicionalCancelan_sdtAdicionalCancelanItem_Clipaiconve ;
   }

   public void setClipaiconve( short value )
   {
      gxTv_SdtsdtAdicionalCancelan_sdtAdicionalCancelanItem_N = (byte)(0) ;
      gxTv_SdtsdtAdicionalCancelan_sdtAdicionalCancelanItem_Clipaiconve = value ;
   }

   public String getCliconvenio( )
   {
      return gxTv_SdtsdtAdicionalCancelan_sdtAdicionalCancelanItem_Cliconvenio ;
   }

   public void setCliconvenio( String value )
   {
      gxTv_SdtsdtAdicionalCancelan_sdtAdicionalCancelanItem_N = (byte)(0) ;
      gxTv_SdtsdtAdicionalCancelan_sdtAdicionalCancelanItem_Cliconvenio = value ;
   }

   public String getConveadicod( )
   {
      return gxTv_SdtsdtAdicionalCancelan_sdtAdicionalCancelanItem_Conveadicod ;
   }

   public void setConveadicod( String value )
   {
      gxTv_SdtsdtAdicionalCancelan_sdtAdicionalCancelanItem_N = (byte)(0) ;
      gxTv_SdtsdtAdicionalCancelan_sdtAdicionalCancelanItem_Conveadicod = value ;
   }

   public String getConveadisitcancela( )
   {
      return gxTv_SdtsdtAdicionalCancelan_sdtAdicionalCancelanItem_Conveadisitcancela ;
   }

   public void setConveadisitcancela( String value )
   {
      gxTv_SdtsdtAdicionalCancelan_sdtAdicionalCancelanItem_N = (byte)(0) ;
      gxTv_SdtsdtAdicionalCancelan_sdtAdicionalCancelanItem_Conveadisitcancela = value ;
   }

   protected byte gxTv_SdtsdtAdicionalCancelan_sdtAdicionalCancelanItem_N ;
   protected short gxTv_SdtsdtAdicionalCancelan_sdtAdicionalCancelanItem_Clipaiconve ;
   protected String gxTv_SdtsdtAdicionalCancelan_sdtAdicionalCancelanItem_Cliconvenio ;
   protected String gxTv_SdtsdtAdicionalCancelan_sdtAdicionalCancelanItem_Conveadicod ;
   protected String gxTv_SdtsdtAdicionalCancelan_sdtAdicionalCancelanItem_Conveadisitcancela ;
}

