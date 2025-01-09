package web.wwpbaseobjects ;
import com.genexus.*;

public final  class StructSdtdatos_fin_pdf implements Cloneable, java.io.Serializable
{
   public StructSdtdatos_fin_pdf( )
   {
      this( -1, new ModelContext( StructSdtdatos_fin_pdf.class ));
   }

   public StructSdtdatos_fin_pdf( int remoteHandle ,
                                  ModelContext context )
   {
      gxTv_Sdtdatos_fin_pdf_Liqlote = "" ;
      gxTv_Sdtdatos_fin_pdf_Tporecibo = "" ;
      gxTv_Sdtdatos_fin_pdf_Error = "" ;
      gxTv_Sdtdatos_fin_pdf_Daemonuuid = "" ;
      gxTv_Sdtdatos_fin_pdf_Legnumero_N = (byte)(1) ;
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

   public int getClicod( )
   {
      return gxTv_Sdtdatos_fin_pdf_Clicod ;
   }

   public void setClicod( int value )
   {
      gxTv_Sdtdatos_fin_pdf_N = (byte)(0) ;
      gxTv_Sdtdatos_fin_pdf_Clicod = value ;
   }

   public short getEmpcod( )
   {
      return gxTv_Sdtdatos_fin_pdf_Empcod ;
   }

   public void setEmpcod( short value )
   {
      gxTv_Sdtdatos_fin_pdf_N = (byte)(0) ;
      gxTv_Sdtdatos_fin_pdf_Empcod = value ;
   }

   public int getLiqnro( )
   {
      return gxTv_Sdtdatos_fin_pdf_Liqnro ;
   }

   public void setLiqnro( int value )
   {
      gxTv_Sdtdatos_fin_pdf_N = (byte)(0) ;
      gxTv_Sdtdatos_fin_pdf_Liqnro = value ;
   }

   public String getLiqlote( )
   {
      return gxTv_Sdtdatos_fin_pdf_Liqlote ;
   }

   public void setLiqlote( String value )
   {
      gxTv_Sdtdatos_fin_pdf_N = (byte)(0) ;
      gxTv_Sdtdatos_fin_pdf_Liqlote = value ;
   }

   public String getTporecibo( )
   {
      return gxTv_Sdtdatos_fin_pdf_Tporecibo ;
   }

   public void setTporecibo( String value )
   {
      gxTv_Sdtdatos_fin_pdf_N = (byte)(0) ;
      gxTv_Sdtdatos_fin_pdf_Tporecibo = value ;
   }

   public String getError( )
   {
      return gxTv_Sdtdatos_fin_pdf_Error ;
   }

   public void setError( String value )
   {
      gxTv_Sdtdatos_fin_pdf_N = (byte)(0) ;
      gxTv_Sdtdatos_fin_pdf_Error = value ;
   }

   public String getDaemonuuid( )
   {
      return gxTv_Sdtdatos_fin_pdf_Daemonuuid ;
   }

   public void setDaemonuuid( String value )
   {
      gxTv_Sdtdatos_fin_pdf_N = (byte)(0) ;
      gxTv_Sdtdatos_fin_pdf_Daemonuuid = value ;
   }

   public java.util.Vector getLegnumero( )
   {
      return gxTv_Sdtdatos_fin_pdf_Legnumero ;
   }

   public void setLegnumero( java.util.Vector value )
   {
      gxTv_Sdtdatos_fin_pdf_Legnumero_N = (byte)(0) ;
      gxTv_Sdtdatos_fin_pdf_N = (byte)(0) ;
      gxTv_Sdtdatos_fin_pdf_Legnumero = value ;
   }

   protected byte gxTv_Sdtdatos_fin_pdf_Legnumero_N ;
   protected byte gxTv_Sdtdatos_fin_pdf_N ;
   protected short gxTv_Sdtdatos_fin_pdf_Empcod ;
   protected int gxTv_Sdtdatos_fin_pdf_Clicod ;
   protected int gxTv_Sdtdatos_fin_pdf_Liqnro ;
   protected String gxTv_Sdtdatos_fin_pdf_Tporecibo ;
   protected String gxTv_Sdtdatos_fin_pdf_Daemonuuid ;
   protected String gxTv_Sdtdatos_fin_pdf_Liqlote ;
   protected String gxTv_Sdtdatos_fin_pdf_Error ;
   protected java.util.Vector gxTv_Sdtdatos_fin_pdf_Legnumero=null ;
}

