package web ;
import com.genexus.*;

public final  class StructSdtparm_recLegSuelBas implements Cloneable, java.io.Serializable
{
   public StructSdtparm_recLegSuelBas( )
   {
      this( -1, new ModelContext( StructSdtparm_recLegSuelBas.class ));
   }

   public StructSdtparm_recLegSuelBas( int remoteHandle ,
                                       ModelContext context )
   {
      gxTv_Sdtparm_recLegSuelBas_Trnpalabra = "" ;
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

   public short getClipaicod( )
   {
      return gxTv_Sdtparm_recLegSuelBas_Clipaicod ;
   }

   public void setClipaicod( short value )
   {
      gxTv_Sdtparm_recLegSuelBas_N = (byte)(0) ;
      gxTv_Sdtparm_recLegSuelBas_Clipaicod = value ;
   }

   public int getClicod( )
   {
      return gxTv_Sdtparm_recLegSuelBas_Clicod ;
   }

   public void setClicod( int value )
   {
      gxTv_Sdtparm_recLegSuelBas_N = (byte)(0) ;
      gxTv_Sdtparm_recLegSuelBas_Clicod = value ;
   }

   public short getEmpcod( )
   {
      return gxTv_Sdtparm_recLegSuelBas_Empcod ;
   }

   public void setEmpcod( short value )
   {
      gxTv_Sdtparm_recLegSuelBas_N = (byte)(0) ;
      gxTv_Sdtparm_recLegSuelBas_Empcod = value ;
   }

   public int getParmlegnumero( )
   {
      return gxTv_Sdtparm_recLegSuelBas_Parmlegnumero ;
   }

   public void setParmlegnumero( int value )
   {
      gxTv_Sdtparm_recLegSuelBas_N = (byte)(0) ;
      gxTv_Sdtparm_recLegSuelBas_Parmlegnumero = value ;
   }

   public String getTrnpalabra( )
   {
      return gxTv_Sdtparm_recLegSuelBas_Trnpalabra ;
   }

   public void setTrnpalabra( String value )
   {
      gxTv_Sdtparm_recLegSuelBas_N = (byte)(0) ;
      gxTv_Sdtparm_recLegSuelBas_Trnpalabra = value ;
   }

   protected byte gxTv_Sdtparm_recLegSuelBas_N ;
   protected short gxTv_Sdtparm_recLegSuelBas_Clipaicod ;
   protected short gxTv_Sdtparm_recLegSuelBas_Empcod ;
   protected int gxTv_Sdtparm_recLegSuelBas_Clicod ;
   protected int gxTv_Sdtparm_recLegSuelBas_Parmlegnumero ;
   protected String gxTv_Sdtparm_recLegSuelBas_Trnpalabra ;
}

