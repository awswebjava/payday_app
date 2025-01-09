package web ;
import com.genexus.*;

public final  class StructSdtsdtAdicional_sdtAdicionalItem implements Cloneable, java.io.Serializable
{
   public StructSdtsdtAdicional_sdtAdicionalItem( )
   {
      this( -1, new ModelContext( StructSdtsdtAdicional_sdtAdicionalItem.class ));
   }

   public StructSdtsdtAdicional_sdtAdicionalItem( int remoteHandle ,
                                                  ModelContext context )
   {
      gxTv_SdtsdtAdicional_sdtAdicionalItem_Cliconvenio = "" ;
      gxTv_SdtsdtAdicional_sdtAdicionalItem_Conveadicod = "" ;
      gxTv_SdtsdtAdicional_sdtAdicionalItem_Conveadidescri = "" ;
      gxTv_SdtsdtAdicional_sdtAdicionalItem_Conveadiali = new java.math.BigDecimal(0) ;
      gxTv_SdtsdtAdicional_sdtAdicionalItem_Conveadiinfo = "" ;
      gxTv_SdtsdtAdicional_sdtAdicionalItem_Conveaditipo = "" ;
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
      return gxTv_SdtsdtAdicional_sdtAdicionalItem_Clipaiconve ;
   }

   public void setClipaiconve( short value )
   {
      gxTv_SdtsdtAdicional_sdtAdicionalItem_N = (byte)(0) ;
      gxTv_SdtsdtAdicional_sdtAdicionalItem_Clipaiconve = value ;
   }

   public String getCliconvenio( )
   {
      return gxTv_SdtsdtAdicional_sdtAdicionalItem_Cliconvenio ;
   }

   public void setCliconvenio( String value )
   {
      gxTv_SdtsdtAdicional_sdtAdicionalItem_N = (byte)(0) ;
      gxTv_SdtsdtAdicional_sdtAdicionalItem_Cliconvenio = value ;
   }

   public String getConveadicod( )
   {
      return gxTv_SdtsdtAdicional_sdtAdicionalItem_Conveadicod ;
   }

   public void setConveadicod( String value )
   {
      gxTv_SdtsdtAdicional_sdtAdicionalItem_N = (byte)(0) ;
      gxTv_SdtsdtAdicional_sdtAdicionalItem_Conveadicod = value ;
   }

   public String getConveadidescri( )
   {
      return gxTv_SdtsdtAdicional_sdtAdicionalItem_Conveadidescri ;
   }

   public void setConveadidescri( String value )
   {
      gxTv_SdtsdtAdicional_sdtAdicionalItem_N = (byte)(0) ;
      gxTv_SdtsdtAdicional_sdtAdicionalItem_Conveadidescri = value ;
   }

   public java.math.BigDecimal getConveadiali( )
   {
      return gxTv_SdtsdtAdicional_sdtAdicionalItem_Conveadiali ;
   }

   public void setConveadiali( java.math.BigDecimal value )
   {
      gxTv_SdtsdtAdicional_sdtAdicionalItem_N = (byte)(0) ;
      gxTv_SdtsdtAdicional_sdtAdicionalItem_Conveadiali = value ;
   }

   public String getConveadiinfo( )
   {
      return gxTv_SdtsdtAdicional_sdtAdicionalItem_Conveadiinfo ;
   }

   public void setConveadiinfo( String value )
   {
      gxTv_SdtsdtAdicional_sdtAdicionalItem_N = (byte)(0) ;
      gxTv_SdtsdtAdicional_sdtAdicionalItem_Conveadiinfo = value ;
   }

   public String getConveaditipo( )
   {
      return gxTv_SdtsdtAdicional_sdtAdicionalItem_Conveaditipo ;
   }

   public void setConveaditipo( String value )
   {
      gxTv_SdtsdtAdicional_sdtAdicionalItem_N = (byte)(0) ;
      gxTv_SdtsdtAdicional_sdtAdicionalItem_Conveaditipo = value ;
   }

   protected byte gxTv_SdtsdtAdicional_sdtAdicionalItem_N ;
   protected short gxTv_SdtsdtAdicional_sdtAdicionalItem_Clipaiconve ;
   protected String gxTv_SdtsdtAdicional_sdtAdicionalItem_Cliconvenio ;
   protected String gxTv_SdtsdtAdicional_sdtAdicionalItem_Conveadicod ;
   protected String gxTv_SdtsdtAdicional_sdtAdicionalItem_Conveaditipo ;
   protected String gxTv_SdtsdtAdicional_sdtAdicionalItem_Conveadiinfo ;
   protected String gxTv_SdtsdtAdicional_sdtAdicionalItem_Conveadidescri ;
   protected java.math.BigDecimal gxTv_SdtsdtAdicional_sdtAdicionalItem_Conveadiali ;
}

