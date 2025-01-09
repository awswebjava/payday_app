package web ;
import com.genexus.*;

public final  class StructSdtEmpresa_abm_1_base_calculo implements Cloneable, java.io.Serializable
{
   public StructSdtEmpresa_abm_1_base_calculo( )
   {
      this( -1, new ModelContext( StructSdtEmpresa_abm_1_base_calculo.class ));
   }

   public StructSdtEmpresa_abm_1_base_calculo( int remoteHandle ,
                                               ModelContext context )
   {
      gxTv_SdtEmpresa_abm_1_base_calculo_Empbasetipo = "" ;
      gxTv_SdtEmpresa_abm_1_base_calculo_Empbasecod1 = "" ;
      gxTv_SdtEmpresa_abm_1_base_calculo_Empbasecod2 = "" ;
      gxTv_SdtEmpresa_abm_1_base_calculo_Empbaseplus = new java.math.BigDecimal(0) ;
      gxTv_SdtEmpresa_abm_1_base_calculo_Mode = "" ;
      gxTv_SdtEmpresa_abm_1_base_calculo_Empbasetipo_Z = "" ;
      gxTv_SdtEmpresa_abm_1_base_calculo_Empbasecod1_Z = "" ;
      gxTv_SdtEmpresa_abm_1_base_calculo_Empbasecod2_Z = "" ;
      gxTv_SdtEmpresa_abm_1_base_calculo_Empbaseplus_Z = new java.math.BigDecimal(0) ;
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

   public byte getEmpbaseclaseleg( )
   {
      return gxTv_SdtEmpresa_abm_1_base_calculo_Empbaseclaseleg ;
   }

   public void setEmpbaseclaseleg( byte value )
   {
      gxTv_SdtEmpresa_abm_1_base_calculo_N = (byte)(0) ;
      gxTv_SdtEmpresa_abm_1_base_calculo_Empbaseclaseleg = value ;
   }

   public String getEmpbasetipo( )
   {
      return gxTv_SdtEmpresa_abm_1_base_calculo_Empbasetipo ;
   }

   public void setEmpbasetipo( String value )
   {
      gxTv_SdtEmpresa_abm_1_base_calculo_N = (byte)(0) ;
      gxTv_SdtEmpresa_abm_1_base_calculo_Empbasetipo = value ;
   }

   public String getEmpbasecod1( )
   {
      return gxTv_SdtEmpresa_abm_1_base_calculo_Empbasecod1 ;
   }

   public void setEmpbasecod1( String value )
   {
      gxTv_SdtEmpresa_abm_1_base_calculo_N = (byte)(0) ;
      gxTv_SdtEmpresa_abm_1_base_calculo_Empbasecod1 = value ;
   }

   public String getEmpbasecod2( )
   {
      return gxTv_SdtEmpresa_abm_1_base_calculo_Empbasecod2 ;
   }

   public void setEmpbasecod2( String value )
   {
      gxTv_SdtEmpresa_abm_1_base_calculo_N = (byte)(0) ;
      gxTv_SdtEmpresa_abm_1_base_calculo_Empbasecod2 = value ;
   }

   public java.math.BigDecimal getEmpbaseplus( )
   {
      return gxTv_SdtEmpresa_abm_1_base_calculo_Empbaseplus ;
   }

   public void setEmpbaseplus( java.math.BigDecimal value )
   {
      gxTv_SdtEmpresa_abm_1_base_calculo_N = (byte)(0) ;
      gxTv_SdtEmpresa_abm_1_base_calculo_Empbaseplus = value ;
   }

   public String getMode( )
   {
      return gxTv_SdtEmpresa_abm_1_base_calculo_Mode ;
   }

   public void setMode( String value )
   {
      gxTv_SdtEmpresa_abm_1_base_calculo_N = (byte)(0) ;
      gxTv_SdtEmpresa_abm_1_base_calculo_Mode = value ;
   }

   public short getModified( )
   {
      return gxTv_SdtEmpresa_abm_1_base_calculo_Modified ;
   }

   public void setModified( short value )
   {
      gxTv_SdtEmpresa_abm_1_base_calculo_N = (byte)(0) ;
      gxTv_SdtEmpresa_abm_1_base_calculo_Modified = value ;
   }

   public short getInitialized( )
   {
      return gxTv_SdtEmpresa_abm_1_base_calculo_Initialized ;
   }

   public void setInitialized( short value )
   {
      gxTv_SdtEmpresa_abm_1_base_calculo_N = (byte)(0) ;
      gxTv_SdtEmpresa_abm_1_base_calculo_Initialized = value ;
   }

   public byte getEmpbaseclaseleg_Z( )
   {
      return gxTv_SdtEmpresa_abm_1_base_calculo_Empbaseclaseleg_Z ;
   }

   public void setEmpbaseclaseleg_Z( byte value )
   {
      gxTv_SdtEmpresa_abm_1_base_calculo_N = (byte)(0) ;
      gxTv_SdtEmpresa_abm_1_base_calculo_Empbaseclaseleg_Z = value ;
   }

   public String getEmpbasetipo_Z( )
   {
      return gxTv_SdtEmpresa_abm_1_base_calculo_Empbasetipo_Z ;
   }

   public void setEmpbasetipo_Z( String value )
   {
      gxTv_SdtEmpresa_abm_1_base_calculo_N = (byte)(0) ;
      gxTv_SdtEmpresa_abm_1_base_calculo_Empbasetipo_Z = value ;
   }

   public String getEmpbasecod1_Z( )
   {
      return gxTv_SdtEmpresa_abm_1_base_calculo_Empbasecod1_Z ;
   }

   public void setEmpbasecod1_Z( String value )
   {
      gxTv_SdtEmpresa_abm_1_base_calculo_N = (byte)(0) ;
      gxTv_SdtEmpresa_abm_1_base_calculo_Empbasecod1_Z = value ;
   }

   public String getEmpbasecod2_Z( )
   {
      return gxTv_SdtEmpresa_abm_1_base_calculo_Empbasecod2_Z ;
   }

   public void setEmpbasecod2_Z( String value )
   {
      gxTv_SdtEmpresa_abm_1_base_calculo_N = (byte)(0) ;
      gxTv_SdtEmpresa_abm_1_base_calculo_Empbasecod2_Z = value ;
   }

   public java.math.BigDecimal getEmpbaseplus_Z( )
   {
      return gxTv_SdtEmpresa_abm_1_base_calculo_Empbaseplus_Z ;
   }

   public void setEmpbaseplus_Z( java.math.BigDecimal value )
   {
      gxTv_SdtEmpresa_abm_1_base_calculo_N = (byte)(0) ;
      gxTv_SdtEmpresa_abm_1_base_calculo_Empbaseplus_Z = value ;
   }

   protected byte gxTv_SdtEmpresa_abm_1_base_calculo_Empbaseclaseleg ;
   protected byte gxTv_SdtEmpresa_abm_1_base_calculo_Empbaseclaseleg_Z ;
   private byte gxTv_SdtEmpresa_abm_1_base_calculo_N ;
   protected short gxTv_SdtEmpresa_abm_1_base_calculo_Modified ;
   protected short gxTv_SdtEmpresa_abm_1_base_calculo_Initialized ;
   protected String gxTv_SdtEmpresa_abm_1_base_calculo_Empbasetipo ;
   protected String gxTv_SdtEmpresa_abm_1_base_calculo_Empbasecod1 ;
   protected String gxTv_SdtEmpresa_abm_1_base_calculo_Empbasecod2 ;
   protected String gxTv_SdtEmpresa_abm_1_base_calculo_Mode ;
   protected String gxTv_SdtEmpresa_abm_1_base_calculo_Empbasetipo_Z ;
   protected String gxTv_SdtEmpresa_abm_1_base_calculo_Empbasecod1_Z ;
   protected String gxTv_SdtEmpresa_abm_1_base_calculo_Empbasecod2_Z ;
   protected java.math.BigDecimal gxTv_SdtEmpresa_abm_1_base_calculo_Empbaseplus ;
   protected java.math.BigDecimal gxTv_SdtEmpresa_abm_1_base_calculo_Empbaseplus_Z ;
}

