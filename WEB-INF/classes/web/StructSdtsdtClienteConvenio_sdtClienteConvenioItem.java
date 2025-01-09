package web ;
import com.genexus.*;

public final  class StructSdtsdtClienteConvenio_sdtClienteConvenioItem implements Cloneable, java.io.Serializable
{
   public StructSdtsdtClienteConvenio_sdtClienteConvenioItem( )
   {
      this( -1, new ModelContext( StructSdtsdtClienteConvenio_sdtClienteConvenioItem.class ));
   }

   public StructSdtsdtClienteConvenio_sdtClienteConvenioItem( int remoteHandle ,
                                                              ModelContext context )
   {
      java.util.Calendar cal = java.util.Calendar.getInstance();
      cal.set(1, 0, 1, 0, 0, 0);
      cal.set(java.util.Calendar.MILLISECOND, 0);
      gxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Cliconvenio = "" ;
      gxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Cliconvevig = cal.getTime() ;
      gxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Convemeshspext = new java.math.BigDecimal(0) ;
      gxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Convediahspext = "" ;
      gxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Cliconvevig_N = (byte)(1) ;
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
      return gxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Clipaiconve ;
   }

   public void setClipaiconve( short value )
   {
      gxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_N = (byte)(0) ;
      gxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Clipaiconve = value ;
   }

   public String getCliconvenio( )
   {
      return gxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Cliconvenio ;
   }

   public void setCliconvenio( String value )
   {
      gxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_N = (byte)(0) ;
      gxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Cliconvenio = value ;
   }

   public java.util.Date getCliconvevig( )
   {
      return gxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Cliconvevig ;
   }

   public void setCliconvevig( java.util.Date value )
   {
      gxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Cliconvevig_N = (byte)(0) ;
      gxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_N = (byte)(0) ;
      gxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Cliconvevig = value ;
   }

   public boolean getConvedefault( )
   {
      return gxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Convedefault ;
   }

   public void setConvedefault( boolean value )
   {
      gxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_N = (byte)(0) ;
      gxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Convedefault = value ;
   }

   public short getConveinterdiasjor( )
   {
      return gxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Conveinterdiasjor ;
   }

   public void setConveinterdiasjor( short value )
   {
      gxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_N = (byte)(0) ;
      gxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Conveinterdiasjor = value ;
   }

   public byte getConveminmesesvac( )
   {
      return gxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Conveminmesesvac ;
   }

   public void setConveminmesesvac( byte value )
   {
      gxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_N = (byte)(0) ;
      gxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Conveminmesesvac = value ;
   }

   public java.math.BigDecimal getConvemeshspext( )
   {
      return gxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Convemeshspext ;
   }

   public void setConvemeshspext( java.math.BigDecimal value )
   {
      gxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_N = (byte)(0) ;
      gxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Convemeshspext = value ;
   }

   public String getConvediahspext( )
   {
      return gxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Convediahspext ;
   }

   public void setConvediahspext( String value )
   {
      gxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_N = (byte)(0) ;
      gxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Convediahspext = value ;
   }

   public boolean getConvefondocese( )
   {
      return gxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Convefondocese ;
   }

   public void setConvefondocese( boolean value )
   {
      gxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_N = (byte)(0) ;
      gxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Convefondocese = value ;
   }

   public byte getConveguaredadmin( )
   {
      return gxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Conveguaredadmin ;
   }

   public void setConveguaredadmin( byte value )
   {
      gxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_N = (byte)(0) ;
      gxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Conveguaredadmin = value ;
   }

   public byte getConveguaredadmax( )
   {
      return gxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Conveguaredadmax ;
   }

   public void setConveguaredadmax( byte value )
   {
      gxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_N = (byte)(0) ;
      gxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Conveguaredadmax = value ;
   }

   protected byte gxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Conveminmesesvac ;
   protected byte gxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Conveguaredadmin ;
   protected byte gxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Conveguaredadmax ;
   protected byte gxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Cliconvevig_N ;
   protected byte gxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_N ;
   protected short gxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Clipaiconve ;
   protected short gxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Conveinterdiasjor ;
   protected String gxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Cliconvenio ;
   protected String gxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Convediahspext ;
   protected boolean gxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Convedefault ;
   protected boolean gxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Convefondocese ;
   protected java.util.Date gxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Cliconvevig ;
   protected java.math.BigDecimal gxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Convemeshspext ;
}

