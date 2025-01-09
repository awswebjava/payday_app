package web ;
import com.genexus.*;

public final  class StructSdtLiqImportarAuxTrn implements Cloneable, java.io.Serializable
{
   public StructSdtLiqImportarAuxTrn( )
   {
      this( -1, new ModelContext( StructSdtLiqImportarAuxTrn.class ));
   }

   public StructSdtLiqImportarAuxTrn( int remoteHandle ,
                                      ModelContext context )
   {
      gxTv_SdtLiqImportarAuxTrn_Empnom = "" ;
      gxTv_SdtLiqImportarAuxTrn_Cativadesc = "" ;
      gxTv_SdtLiqImportarAuxTrn_Empdir = "" ;
      gxTv_SdtLiqImportarAuxTrn_Emptel = "" ;
      gxTv_SdtLiqImportarAuxTrn_Empcp = "" ;
      gxTv_SdtLiqImportarAuxTrn_Painom = "" ;
      gxTv_SdtLiqImportarAuxTrn_Provnom = "" ;
      gxTv_SdtLiqImportarAuxTrn_Locnom = "" ;
      gxTv_SdtLiqImportarAuxTrn_Actcodigo = "" ;
      gxTv_SdtLiqImportarAuxTrn_Actdescrip = "" ;
      gxTv_SdtLiqImportarAuxTrn_Tipemplecod = "" ;
      gxTv_SdtLiqImportarAuxTrn_Empzoncod = "" ;
      gxTv_SdtLiqImportarAuxTrn_Empzondescrip = "" ;
      gxTv_SdtLiqImportarAuxTrn_Tipempledefins = "" ;
      gxTv_SdtLiqImportarAuxTrn_Mode = "" ;
      gxTv_SdtLiqImportarAuxTrn_Empnom_Z = "" ;
      gxTv_SdtLiqImportarAuxTrn_Cativadesc_Z = "" ;
      gxTv_SdtLiqImportarAuxTrn_Empdir_Z = "" ;
      gxTv_SdtLiqImportarAuxTrn_Emptel_Z = "" ;
      gxTv_SdtLiqImportarAuxTrn_Empcp_Z = "" ;
      gxTv_SdtLiqImportarAuxTrn_Painom_Z = "" ;
      gxTv_SdtLiqImportarAuxTrn_Provnom_Z = "" ;
      gxTv_SdtLiqImportarAuxTrn_Locnom_Z = "" ;
      gxTv_SdtLiqImportarAuxTrn_Actcodigo_Z = "" ;
      gxTv_SdtLiqImportarAuxTrn_Actdescrip_Z = "" ;
      gxTv_SdtLiqImportarAuxTrn_Tipemplecod_Z = "" ;
      gxTv_SdtLiqImportarAuxTrn_Empzoncod_Z = "" ;
      gxTv_SdtLiqImportarAuxTrn_Empzondescrip_Z = "" ;
      gxTv_SdtLiqImportarAuxTrn_Tipempledefins_Z = "" ;
      gxTv_SdtLiqImportarAuxTrn_Cativacod_N = (byte)(1) ;
      gxTv_SdtLiqImportarAuxTrn_Cativadesc_N = (byte)(1) ;
      gxTv_SdtLiqImportarAuxTrn_Emptel_N = (byte)(1) ;
      gxTv_SdtLiqImportarAuxTrn_Empcp_N = (byte)(1) ;
      gxTv_SdtLiqImportarAuxTrn_Paicod_N = (byte)(1) ;
      gxTv_SdtLiqImportarAuxTrn_Provcod_N = (byte)(1) ;
      gxTv_SdtLiqImportarAuxTrn_Loccod_N = (byte)(1) ;
      gxTv_SdtLiqImportarAuxTrn_Actcodigo_N = (byte)(1) ;
      gxTv_SdtLiqImportarAuxTrn_Tipemplecod_N = (byte)(1) ;
      gxTv_SdtLiqImportarAuxTrn_Empzoncod_N = (byte)(1) ;
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
      return gxTv_SdtLiqImportarAuxTrn_Clicod ;
   }

   public void setClicod( int value )
   {
      gxTv_SdtLiqImportarAuxTrn_N = (byte)(0) ;
      gxTv_SdtLiqImportarAuxTrn_Clicod = value ;
   }

   public short getEmpcod( )
   {
      return gxTv_SdtLiqImportarAuxTrn_Empcod ;
   }

   public void setEmpcod( short value )
   {
      gxTv_SdtLiqImportarAuxTrn_N = (byte)(0) ;
      gxTv_SdtLiqImportarAuxTrn_Empcod = value ;
   }

   public String getEmpnom( )
   {
      return gxTv_SdtLiqImportarAuxTrn_Empnom ;
   }

   public void setEmpnom( String value )
   {
      gxTv_SdtLiqImportarAuxTrn_N = (byte)(0) ;
      gxTv_SdtLiqImportarAuxTrn_Empnom = value ;
   }

   public long getEmpcuit( )
   {
      return gxTv_SdtLiqImportarAuxTrn_Empcuit ;
   }

   public void setEmpcuit( long value )
   {
      gxTv_SdtLiqImportarAuxTrn_N = (byte)(0) ;
      gxTv_SdtLiqImportarAuxTrn_Empcuit = value ;
   }

   public short getCativacod( )
   {
      return gxTv_SdtLiqImportarAuxTrn_Cativacod ;
   }

   public void setCativacod( short value )
   {
      gxTv_SdtLiqImportarAuxTrn_Cativacod_N = (byte)(0) ;
      gxTv_SdtLiqImportarAuxTrn_N = (byte)(0) ;
      gxTv_SdtLiqImportarAuxTrn_Cativacod = value ;
   }

   public String getCativadesc( )
   {
      return gxTv_SdtLiqImportarAuxTrn_Cativadesc ;
   }

   public void setCativadesc( String value )
   {
      gxTv_SdtLiqImportarAuxTrn_Cativadesc_N = (byte)(0) ;
      gxTv_SdtLiqImportarAuxTrn_N = (byte)(0) ;
      gxTv_SdtLiqImportarAuxTrn_Cativadesc = value ;
   }

   public String getEmpdir( )
   {
      return gxTv_SdtLiqImportarAuxTrn_Empdir ;
   }

   public void setEmpdir( String value )
   {
      gxTv_SdtLiqImportarAuxTrn_N = (byte)(0) ;
      gxTv_SdtLiqImportarAuxTrn_Empdir = value ;
   }

   public String getEmptel( )
   {
      return gxTv_SdtLiqImportarAuxTrn_Emptel ;
   }

   public void setEmptel( String value )
   {
      gxTv_SdtLiqImportarAuxTrn_Emptel_N = (byte)(0) ;
      gxTv_SdtLiqImportarAuxTrn_N = (byte)(0) ;
      gxTv_SdtLiqImportarAuxTrn_Emptel = value ;
   }

   public String getEmpcp( )
   {
      return gxTv_SdtLiqImportarAuxTrn_Empcp ;
   }

   public void setEmpcp( String value )
   {
      gxTv_SdtLiqImportarAuxTrn_Empcp_N = (byte)(0) ;
      gxTv_SdtLiqImportarAuxTrn_N = (byte)(0) ;
      gxTv_SdtLiqImportarAuxTrn_Empcp = value ;
   }

   public short getPaicod( )
   {
      return gxTv_SdtLiqImportarAuxTrn_Paicod ;
   }

   public void setPaicod( short value )
   {
      gxTv_SdtLiqImportarAuxTrn_Paicod_N = (byte)(0) ;
      gxTv_SdtLiqImportarAuxTrn_N = (byte)(0) ;
      gxTv_SdtLiqImportarAuxTrn_Paicod = value ;
   }

   public String getPainom( )
   {
      return gxTv_SdtLiqImportarAuxTrn_Painom ;
   }

   public void setPainom( String value )
   {
      gxTv_SdtLiqImportarAuxTrn_N = (byte)(0) ;
      gxTv_SdtLiqImportarAuxTrn_Painom = value ;
   }

   public short getProvcod( )
   {
      return gxTv_SdtLiqImportarAuxTrn_Provcod ;
   }

   public void setProvcod( short value )
   {
      gxTv_SdtLiqImportarAuxTrn_Provcod_N = (byte)(0) ;
      gxTv_SdtLiqImportarAuxTrn_N = (byte)(0) ;
      gxTv_SdtLiqImportarAuxTrn_Provcod = value ;
   }

   public String getProvnom( )
   {
      return gxTv_SdtLiqImportarAuxTrn_Provnom ;
   }

   public void setProvnom( String value )
   {
      gxTv_SdtLiqImportarAuxTrn_N = (byte)(0) ;
      gxTv_SdtLiqImportarAuxTrn_Provnom = value ;
   }

   public short getLoccod( )
   {
      return gxTv_SdtLiqImportarAuxTrn_Loccod ;
   }

   public void setLoccod( short value )
   {
      gxTv_SdtLiqImportarAuxTrn_Loccod_N = (byte)(0) ;
      gxTv_SdtLiqImportarAuxTrn_N = (byte)(0) ;
      gxTv_SdtLiqImportarAuxTrn_Loccod = value ;
   }

   public String getLocnom( )
   {
      return gxTv_SdtLiqImportarAuxTrn_Locnom ;
   }

   public void setLocnom( String value )
   {
      gxTv_SdtLiqImportarAuxTrn_N = (byte)(0) ;
      gxTv_SdtLiqImportarAuxTrn_Locnom = value ;
   }

   public String getActcodigo( )
   {
      return gxTv_SdtLiqImportarAuxTrn_Actcodigo ;
   }

   public void setActcodigo( String value )
   {
      gxTv_SdtLiqImportarAuxTrn_Actcodigo_N = (byte)(0) ;
      gxTv_SdtLiqImportarAuxTrn_N = (byte)(0) ;
      gxTv_SdtLiqImportarAuxTrn_Actcodigo = value ;
   }

   public String getActdescrip( )
   {
      return gxTv_SdtLiqImportarAuxTrn_Actdescrip ;
   }

   public void setActdescrip( String value )
   {
      gxTv_SdtLiqImportarAuxTrn_N = (byte)(0) ;
      gxTv_SdtLiqImportarAuxTrn_Actdescrip = value ;
   }

   public String getTipemplecod( )
   {
      return gxTv_SdtLiqImportarAuxTrn_Tipemplecod ;
   }

   public void setTipemplecod( String value )
   {
      gxTv_SdtLiqImportarAuxTrn_Tipemplecod_N = (byte)(0) ;
      gxTv_SdtLiqImportarAuxTrn_N = (byte)(0) ;
      gxTv_SdtLiqImportarAuxTrn_Tipemplecod = value ;
   }

   public String getEmpzoncod( )
   {
      return gxTv_SdtLiqImportarAuxTrn_Empzoncod ;
   }

   public void setEmpzoncod( String value )
   {
      gxTv_SdtLiqImportarAuxTrn_Empzoncod_N = (byte)(0) ;
      gxTv_SdtLiqImportarAuxTrn_N = (byte)(0) ;
      gxTv_SdtLiqImportarAuxTrn_Empzoncod = value ;
   }

   public String getEmpzondescrip( )
   {
      return gxTv_SdtLiqImportarAuxTrn_Empzondescrip ;
   }

   public void setEmpzondescrip( String value )
   {
      gxTv_SdtLiqImportarAuxTrn_N = (byte)(0) ;
      gxTv_SdtLiqImportarAuxTrn_Empzondescrip = value ;
   }

   public boolean getEmpreducc( )
   {
      return gxTv_SdtLiqImportarAuxTrn_Empreducc ;
   }

   public void setEmpreducc( boolean value )
   {
      gxTv_SdtLiqImportarAuxTrn_N = (byte)(0) ;
      gxTv_SdtLiqImportarAuxTrn_Empreducc = value ;
   }

   public String getTipempledefins( )
   {
      return gxTv_SdtLiqImportarAuxTrn_Tipempledefins ;
   }

   public void setTipempledefins( String value )
   {
      gxTv_SdtLiqImportarAuxTrn_N = (byte)(0) ;
      gxTv_SdtLiqImportarAuxTrn_Tipempledefins = value ;
   }

   public String getMode( )
   {
      return gxTv_SdtLiqImportarAuxTrn_Mode ;
   }

   public void setMode( String value )
   {
      gxTv_SdtLiqImportarAuxTrn_N = (byte)(0) ;
      gxTv_SdtLiqImportarAuxTrn_Mode = value ;
   }

   public short getInitialized( )
   {
      return gxTv_SdtLiqImportarAuxTrn_Initialized ;
   }

   public void setInitialized( short value )
   {
      gxTv_SdtLiqImportarAuxTrn_N = (byte)(0) ;
      gxTv_SdtLiqImportarAuxTrn_Initialized = value ;
   }

   public int getClicod_Z( )
   {
      return gxTv_SdtLiqImportarAuxTrn_Clicod_Z ;
   }

   public void setClicod_Z( int value )
   {
      gxTv_SdtLiqImportarAuxTrn_N = (byte)(0) ;
      gxTv_SdtLiqImportarAuxTrn_Clicod_Z = value ;
   }

   public short getEmpcod_Z( )
   {
      return gxTv_SdtLiqImportarAuxTrn_Empcod_Z ;
   }

   public void setEmpcod_Z( short value )
   {
      gxTv_SdtLiqImportarAuxTrn_N = (byte)(0) ;
      gxTv_SdtLiqImportarAuxTrn_Empcod_Z = value ;
   }

   public String getEmpnom_Z( )
   {
      return gxTv_SdtLiqImportarAuxTrn_Empnom_Z ;
   }

   public void setEmpnom_Z( String value )
   {
      gxTv_SdtLiqImportarAuxTrn_N = (byte)(0) ;
      gxTv_SdtLiqImportarAuxTrn_Empnom_Z = value ;
   }

   public long getEmpcuit_Z( )
   {
      return gxTv_SdtLiqImportarAuxTrn_Empcuit_Z ;
   }

   public void setEmpcuit_Z( long value )
   {
      gxTv_SdtLiqImportarAuxTrn_N = (byte)(0) ;
      gxTv_SdtLiqImportarAuxTrn_Empcuit_Z = value ;
   }

   public short getCativacod_Z( )
   {
      return gxTv_SdtLiqImportarAuxTrn_Cativacod_Z ;
   }

   public void setCativacod_Z( short value )
   {
      gxTv_SdtLiqImportarAuxTrn_N = (byte)(0) ;
      gxTv_SdtLiqImportarAuxTrn_Cativacod_Z = value ;
   }

   public String getCativadesc_Z( )
   {
      return gxTv_SdtLiqImportarAuxTrn_Cativadesc_Z ;
   }

   public void setCativadesc_Z( String value )
   {
      gxTv_SdtLiqImportarAuxTrn_N = (byte)(0) ;
      gxTv_SdtLiqImportarAuxTrn_Cativadesc_Z = value ;
   }

   public String getEmpdir_Z( )
   {
      return gxTv_SdtLiqImportarAuxTrn_Empdir_Z ;
   }

   public void setEmpdir_Z( String value )
   {
      gxTv_SdtLiqImportarAuxTrn_N = (byte)(0) ;
      gxTv_SdtLiqImportarAuxTrn_Empdir_Z = value ;
   }

   public String getEmptel_Z( )
   {
      return gxTv_SdtLiqImportarAuxTrn_Emptel_Z ;
   }

   public void setEmptel_Z( String value )
   {
      gxTv_SdtLiqImportarAuxTrn_N = (byte)(0) ;
      gxTv_SdtLiqImportarAuxTrn_Emptel_Z = value ;
   }

   public String getEmpcp_Z( )
   {
      return gxTv_SdtLiqImportarAuxTrn_Empcp_Z ;
   }

   public void setEmpcp_Z( String value )
   {
      gxTv_SdtLiqImportarAuxTrn_N = (byte)(0) ;
      gxTv_SdtLiqImportarAuxTrn_Empcp_Z = value ;
   }

   public short getPaicod_Z( )
   {
      return gxTv_SdtLiqImportarAuxTrn_Paicod_Z ;
   }

   public void setPaicod_Z( short value )
   {
      gxTv_SdtLiqImportarAuxTrn_N = (byte)(0) ;
      gxTv_SdtLiqImportarAuxTrn_Paicod_Z = value ;
   }

   public String getPainom_Z( )
   {
      return gxTv_SdtLiqImportarAuxTrn_Painom_Z ;
   }

   public void setPainom_Z( String value )
   {
      gxTv_SdtLiqImportarAuxTrn_N = (byte)(0) ;
      gxTv_SdtLiqImportarAuxTrn_Painom_Z = value ;
   }

   public short getProvcod_Z( )
   {
      return gxTv_SdtLiqImportarAuxTrn_Provcod_Z ;
   }

   public void setProvcod_Z( short value )
   {
      gxTv_SdtLiqImportarAuxTrn_N = (byte)(0) ;
      gxTv_SdtLiqImportarAuxTrn_Provcod_Z = value ;
   }

   public String getProvnom_Z( )
   {
      return gxTv_SdtLiqImportarAuxTrn_Provnom_Z ;
   }

   public void setProvnom_Z( String value )
   {
      gxTv_SdtLiqImportarAuxTrn_N = (byte)(0) ;
      gxTv_SdtLiqImportarAuxTrn_Provnom_Z = value ;
   }

   public short getLoccod_Z( )
   {
      return gxTv_SdtLiqImportarAuxTrn_Loccod_Z ;
   }

   public void setLoccod_Z( short value )
   {
      gxTv_SdtLiqImportarAuxTrn_N = (byte)(0) ;
      gxTv_SdtLiqImportarAuxTrn_Loccod_Z = value ;
   }

   public String getLocnom_Z( )
   {
      return gxTv_SdtLiqImportarAuxTrn_Locnom_Z ;
   }

   public void setLocnom_Z( String value )
   {
      gxTv_SdtLiqImportarAuxTrn_N = (byte)(0) ;
      gxTv_SdtLiqImportarAuxTrn_Locnom_Z = value ;
   }

   public String getActcodigo_Z( )
   {
      return gxTv_SdtLiqImportarAuxTrn_Actcodigo_Z ;
   }

   public void setActcodigo_Z( String value )
   {
      gxTv_SdtLiqImportarAuxTrn_N = (byte)(0) ;
      gxTv_SdtLiqImportarAuxTrn_Actcodigo_Z = value ;
   }

   public String getActdescrip_Z( )
   {
      return gxTv_SdtLiqImportarAuxTrn_Actdescrip_Z ;
   }

   public void setActdescrip_Z( String value )
   {
      gxTv_SdtLiqImportarAuxTrn_N = (byte)(0) ;
      gxTv_SdtLiqImportarAuxTrn_Actdescrip_Z = value ;
   }

   public String getTipemplecod_Z( )
   {
      return gxTv_SdtLiqImportarAuxTrn_Tipemplecod_Z ;
   }

   public void setTipemplecod_Z( String value )
   {
      gxTv_SdtLiqImportarAuxTrn_N = (byte)(0) ;
      gxTv_SdtLiqImportarAuxTrn_Tipemplecod_Z = value ;
   }

   public String getEmpzoncod_Z( )
   {
      return gxTv_SdtLiqImportarAuxTrn_Empzoncod_Z ;
   }

   public void setEmpzoncod_Z( String value )
   {
      gxTv_SdtLiqImportarAuxTrn_N = (byte)(0) ;
      gxTv_SdtLiqImportarAuxTrn_Empzoncod_Z = value ;
   }

   public String getEmpzondescrip_Z( )
   {
      return gxTv_SdtLiqImportarAuxTrn_Empzondescrip_Z ;
   }

   public void setEmpzondescrip_Z( String value )
   {
      gxTv_SdtLiqImportarAuxTrn_N = (byte)(0) ;
      gxTv_SdtLiqImportarAuxTrn_Empzondescrip_Z = value ;
   }

   public boolean getEmpreducc_Z( )
   {
      return gxTv_SdtLiqImportarAuxTrn_Empreducc_Z ;
   }

   public void setEmpreducc_Z( boolean value )
   {
      gxTv_SdtLiqImportarAuxTrn_N = (byte)(0) ;
      gxTv_SdtLiqImportarAuxTrn_Empreducc_Z = value ;
   }

   public String getTipempledefins_Z( )
   {
      return gxTv_SdtLiqImportarAuxTrn_Tipempledefins_Z ;
   }

   public void setTipempledefins_Z( String value )
   {
      gxTv_SdtLiqImportarAuxTrn_N = (byte)(0) ;
      gxTv_SdtLiqImportarAuxTrn_Tipempledefins_Z = value ;
   }

   public byte getCativacod_N( )
   {
      return gxTv_SdtLiqImportarAuxTrn_Cativacod_N ;
   }

   public void setCativacod_N( byte value )
   {
      gxTv_SdtLiqImportarAuxTrn_N = (byte)(0) ;
      gxTv_SdtLiqImportarAuxTrn_Cativacod_N = value ;
   }

   public byte getCativadesc_N( )
   {
      return gxTv_SdtLiqImportarAuxTrn_Cativadesc_N ;
   }

   public void setCativadesc_N( byte value )
   {
      gxTv_SdtLiqImportarAuxTrn_N = (byte)(0) ;
      gxTv_SdtLiqImportarAuxTrn_Cativadesc_N = value ;
   }

   public byte getEmptel_N( )
   {
      return gxTv_SdtLiqImportarAuxTrn_Emptel_N ;
   }

   public void setEmptel_N( byte value )
   {
      gxTv_SdtLiqImportarAuxTrn_N = (byte)(0) ;
      gxTv_SdtLiqImportarAuxTrn_Emptel_N = value ;
   }

   public byte getEmpcp_N( )
   {
      return gxTv_SdtLiqImportarAuxTrn_Empcp_N ;
   }

   public void setEmpcp_N( byte value )
   {
      gxTv_SdtLiqImportarAuxTrn_N = (byte)(0) ;
      gxTv_SdtLiqImportarAuxTrn_Empcp_N = value ;
   }

   public byte getPaicod_N( )
   {
      return gxTv_SdtLiqImportarAuxTrn_Paicod_N ;
   }

   public void setPaicod_N( byte value )
   {
      gxTv_SdtLiqImportarAuxTrn_N = (byte)(0) ;
      gxTv_SdtLiqImportarAuxTrn_Paicod_N = value ;
   }

   public byte getProvcod_N( )
   {
      return gxTv_SdtLiqImportarAuxTrn_Provcod_N ;
   }

   public void setProvcod_N( byte value )
   {
      gxTv_SdtLiqImportarAuxTrn_N = (byte)(0) ;
      gxTv_SdtLiqImportarAuxTrn_Provcod_N = value ;
   }

   public byte getLoccod_N( )
   {
      return gxTv_SdtLiqImportarAuxTrn_Loccod_N ;
   }

   public void setLoccod_N( byte value )
   {
      gxTv_SdtLiqImportarAuxTrn_N = (byte)(0) ;
      gxTv_SdtLiqImportarAuxTrn_Loccod_N = value ;
   }

   public byte getActcodigo_N( )
   {
      return gxTv_SdtLiqImportarAuxTrn_Actcodigo_N ;
   }

   public void setActcodigo_N( byte value )
   {
      gxTv_SdtLiqImportarAuxTrn_N = (byte)(0) ;
      gxTv_SdtLiqImportarAuxTrn_Actcodigo_N = value ;
   }

   public byte getTipemplecod_N( )
   {
      return gxTv_SdtLiqImportarAuxTrn_Tipemplecod_N ;
   }

   public void setTipemplecod_N( byte value )
   {
      gxTv_SdtLiqImportarAuxTrn_N = (byte)(0) ;
      gxTv_SdtLiqImportarAuxTrn_Tipemplecod_N = value ;
   }

   public byte getEmpzoncod_N( )
   {
      return gxTv_SdtLiqImportarAuxTrn_Empzoncod_N ;
   }

   public void setEmpzoncod_N( byte value )
   {
      gxTv_SdtLiqImportarAuxTrn_N = (byte)(0) ;
      gxTv_SdtLiqImportarAuxTrn_Empzoncod_N = value ;
   }

   protected byte gxTv_SdtLiqImportarAuxTrn_Cativacod_N ;
   protected byte gxTv_SdtLiqImportarAuxTrn_Cativadesc_N ;
   protected byte gxTv_SdtLiqImportarAuxTrn_Emptel_N ;
   protected byte gxTv_SdtLiqImportarAuxTrn_Empcp_N ;
   protected byte gxTv_SdtLiqImportarAuxTrn_Paicod_N ;
   protected byte gxTv_SdtLiqImportarAuxTrn_Provcod_N ;
   protected byte gxTv_SdtLiqImportarAuxTrn_Loccod_N ;
   protected byte gxTv_SdtLiqImportarAuxTrn_Actcodigo_N ;
   protected byte gxTv_SdtLiqImportarAuxTrn_Tipemplecod_N ;
   protected byte gxTv_SdtLiqImportarAuxTrn_Empzoncod_N ;
   private byte gxTv_SdtLiqImportarAuxTrn_N ;
   protected short gxTv_SdtLiqImportarAuxTrn_Empcod ;
   protected short gxTv_SdtLiqImportarAuxTrn_Cativacod ;
   protected short gxTv_SdtLiqImportarAuxTrn_Paicod ;
   protected short gxTv_SdtLiqImportarAuxTrn_Provcod ;
   protected short gxTv_SdtLiqImportarAuxTrn_Loccod ;
   protected short gxTv_SdtLiqImportarAuxTrn_Initialized ;
   protected short gxTv_SdtLiqImportarAuxTrn_Empcod_Z ;
   protected short gxTv_SdtLiqImportarAuxTrn_Cativacod_Z ;
   protected short gxTv_SdtLiqImportarAuxTrn_Paicod_Z ;
   protected short gxTv_SdtLiqImportarAuxTrn_Provcod_Z ;
   protected short gxTv_SdtLiqImportarAuxTrn_Loccod_Z ;
   protected int gxTv_SdtLiqImportarAuxTrn_Clicod ;
   protected int gxTv_SdtLiqImportarAuxTrn_Clicod_Z ;
   protected long gxTv_SdtLiqImportarAuxTrn_Empcuit ;
   protected long gxTv_SdtLiqImportarAuxTrn_Empcuit_Z ;
   protected String gxTv_SdtLiqImportarAuxTrn_Empcp ;
   protected String gxTv_SdtLiqImportarAuxTrn_Actcodigo ;
   protected String gxTv_SdtLiqImportarAuxTrn_Tipemplecod ;
   protected String gxTv_SdtLiqImportarAuxTrn_Empzoncod ;
   protected String gxTv_SdtLiqImportarAuxTrn_Tipempledefins ;
   protected String gxTv_SdtLiqImportarAuxTrn_Mode ;
   protected String gxTv_SdtLiqImportarAuxTrn_Empcp_Z ;
   protected String gxTv_SdtLiqImportarAuxTrn_Actcodigo_Z ;
   protected String gxTv_SdtLiqImportarAuxTrn_Tipemplecod_Z ;
   protected String gxTv_SdtLiqImportarAuxTrn_Empzoncod_Z ;
   protected String gxTv_SdtLiqImportarAuxTrn_Tipempledefins_Z ;
   protected boolean gxTv_SdtLiqImportarAuxTrn_Empreducc ;
   protected boolean gxTv_SdtLiqImportarAuxTrn_Empreducc_Z ;
   protected String gxTv_SdtLiqImportarAuxTrn_Empnom ;
   protected String gxTv_SdtLiqImportarAuxTrn_Cativadesc ;
   protected String gxTv_SdtLiqImportarAuxTrn_Empdir ;
   protected String gxTv_SdtLiqImportarAuxTrn_Emptel ;
   protected String gxTv_SdtLiqImportarAuxTrn_Painom ;
   protected String gxTv_SdtLiqImportarAuxTrn_Provnom ;
   protected String gxTv_SdtLiqImportarAuxTrn_Locnom ;
   protected String gxTv_SdtLiqImportarAuxTrn_Actdescrip ;
   protected String gxTv_SdtLiqImportarAuxTrn_Empzondescrip ;
   protected String gxTv_SdtLiqImportarAuxTrn_Empnom_Z ;
   protected String gxTv_SdtLiqImportarAuxTrn_Cativadesc_Z ;
   protected String gxTv_SdtLiqImportarAuxTrn_Empdir_Z ;
   protected String gxTv_SdtLiqImportarAuxTrn_Emptel_Z ;
   protected String gxTv_SdtLiqImportarAuxTrn_Painom_Z ;
   protected String gxTv_SdtLiqImportarAuxTrn_Provnom_Z ;
   protected String gxTv_SdtLiqImportarAuxTrn_Locnom_Z ;
   protected String gxTv_SdtLiqImportarAuxTrn_Actdescrip_Z ;
   protected String gxTv_SdtLiqImportarAuxTrn_Empzondescrip_Z ;
}

