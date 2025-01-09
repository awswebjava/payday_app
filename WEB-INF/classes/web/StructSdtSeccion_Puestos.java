package web ;
import com.genexus.*;

public final  class StructSdtSeccion_Puestos implements Cloneable, java.io.Serializable
{
   public StructSdtSeccion_Puestos( )
   {
      this( -1, new ModelContext( StructSdtSeccion_Puestos.class ));
   }

   public StructSdtSeccion_Puestos( int remoteHandle ,
                                    ModelContext context )
   {
      gxTv_SdtSeccion_Puestos_Puestocodigo = "" ;
      gxTv_SdtSeccion_Puestos_Puestodescrip = "" ;
      gxTv_SdtSeccion_Puestos_Puestodescripsinac = "" ;
      gxTv_SdtSeccion_Puestos_Puestopadre = "" ;
      gxTv_SdtSeccion_Puestos_Puestorelref = "" ;
      gxTv_SdtSeccion_Puestos_Puestoold = "" ;
      gxTv_SdtSeccion_Puestos_Mode = "" ;
      gxTv_SdtSeccion_Puestos_Puestocodigo_Z = "" ;
      gxTv_SdtSeccion_Puestos_Puestodescrip_Z = "" ;
      gxTv_SdtSeccion_Puestos_Puestodescripsinac_Z = "" ;
      gxTv_SdtSeccion_Puestos_Puestopadre_Z = "" ;
      gxTv_SdtSeccion_Puestos_Puestorelref_Z = "" ;
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

   public String getPuestocodigo( )
   {
      return gxTv_SdtSeccion_Puestos_Puestocodigo ;
   }

   public void setPuestocodigo( String value )
   {
      gxTv_SdtSeccion_Puestos_N = (byte)(0) ;
      gxTv_SdtSeccion_Puestos_Puestocodigo = value ;
   }

   public String getPuestodescrip( )
   {
      return gxTv_SdtSeccion_Puestos_Puestodescrip ;
   }

   public void setPuestodescrip( String value )
   {
      gxTv_SdtSeccion_Puestos_N = (byte)(0) ;
      gxTv_SdtSeccion_Puestos_Puestodescrip = value ;
   }

   public String getPuestodescripsinac( )
   {
      return gxTv_SdtSeccion_Puestos_Puestodescripsinac ;
   }

   public void setPuestodescripsinac( String value )
   {
      gxTv_SdtSeccion_Puestos_N = (byte)(0) ;
      gxTv_SdtSeccion_Puestos_Puestodescripsinac = value ;
   }

   public boolean getPuestohorasext( )
   {
      return gxTv_SdtSeccion_Puestos_Puestohorasext ;
   }

   public void setPuestohorasext( boolean value )
   {
      gxTv_SdtSeccion_Puestos_N = (byte)(0) ;
      gxTv_SdtSeccion_Puestos_Puestohorasext = value ;
   }

   public int getPuestorelsec( )
   {
      return gxTv_SdtSeccion_Puestos_Puestorelsec ;
   }

   public void setPuestorelsec( int value )
   {
      gxTv_SdtSeccion_Puestos_N = (byte)(0) ;
      gxTv_SdtSeccion_Puestos_Puestorelsec = value ;
   }

   public int getPuestorelseccli( )
   {
      return gxTv_SdtSeccion_Puestos_Puestorelseccli ;
   }

   public void setPuestorelseccli( int value )
   {
      gxTv_SdtSeccion_Puestos_N = (byte)(0) ;
      gxTv_SdtSeccion_Puestos_Puestorelseccli = value ;
   }

   public String getPuestopadre( )
   {
      return gxTv_SdtSeccion_Puestos_Puestopadre ;
   }

   public void setPuestopadre( String value )
   {
      gxTv_SdtSeccion_Puestos_N = (byte)(0) ;
      gxTv_SdtSeccion_Puestos_Puestopadre = value ;
   }

   public String getPuestorelref( )
   {
      return gxTv_SdtSeccion_Puestos_Puestorelref ;
   }

   public void setPuestorelref( String value )
   {
      gxTv_SdtSeccion_Puestos_N = (byte)(0) ;
      gxTv_SdtSeccion_Puestos_Puestorelref = value ;
   }

   public String getPuestoold( )
   {
      return gxTv_SdtSeccion_Puestos_Puestoold ;
   }

   public void setPuestoold( String value )
   {
      gxTv_SdtSeccion_Puestos_N = (byte)(0) ;
      gxTv_SdtSeccion_Puestos_Puestoold = value ;
   }

   public String getMode( )
   {
      return gxTv_SdtSeccion_Puestos_Mode ;
   }

   public void setMode( String value )
   {
      gxTv_SdtSeccion_Puestos_N = (byte)(0) ;
      gxTv_SdtSeccion_Puestos_Mode = value ;
   }

   public short getModified( )
   {
      return gxTv_SdtSeccion_Puestos_Modified ;
   }

   public void setModified( short value )
   {
      gxTv_SdtSeccion_Puestos_N = (byte)(0) ;
      gxTv_SdtSeccion_Puestos_Modified = value ;
   }

   public short getInitialized( )
   {
      return gxTv_SdtSeccion_Puestos_Initialized ;
   }

   public void setInitialized( short value )
   {
      gxTv_SdtSeccion_Puestos_N = (byte)(0) ;
      gxTv_SdtSeccion_Puestos_Initialized = value ;
   }

   public String getPuestocodigo_Z( )
   {
      return gxTv_SdtSeccion_Puestos_Puestocodigo_Z ;
   }

   public void setPuestocodigo_Z( String value )
   {
      gxTv_SdtSeccion_Puestos_N = (byte)(0) ;
      gxTv_SdtSeccion_Puestos_Puestocodigo_Z = value ;
   }

   public String getPuestodescrip_Z( )
   {
      return gxTv_SdtSeccion_Puestos_Puestodescrip_Z ;
   }

   public void setPuestodescrip_Z( String value )
   {
      gxTv_SdtSeccion_Puestos_N = (byte)(0) ;
      gxTv_SdtSeccion_Puestos_Puestodescrip_Z = value ;
   }

   public String getPuestodescripsinac_Z( )
   {
      return gxTv_SdtSeccion_Puestos_Puestodescripsinac_Z ;
   }

   public void setPuestodescripsinac_Z( String value )
   {
      gxTv_SdtSeccion_Puestos_N = (byte)(0) ;
      gxTv_SdtSeccion_Puestos_Puestodescripsinac_Z = value ;
   }

   public boolean getPuestohorasext_Z( )
   {
      return gxTv_SdtSeccion_Puestos_Puestohorasext_Z ;
   }

   public void setPuestohorasext_Z( boolean value )
   {
      gxTv_SdtSeccion_Puestos_N = (byte)(0) ;
      gxTv_SdtSeccion_Puestos_Puestohorasext_Z = value ;
   }

   public int getPuestorelsec_Z( )
   {
      return gxTv_SdtSeccion_Puestos_Puestorelsec_Z ;
   }

   public void setPuestorelsec_Z( int value )
   {
      gxTv_SdtSeccion_Puestos_N = (byte)(0) ;
      gxTv_SdtSeccion_Puestos_Puestorelsec_Z = value ;
   }

   public int getPuestorelseccli_Z( )
   {
      return gxTv_SdtSeccion_Puestos_Puestorelseccli_Z ;
   }

   public void setPuestorelseccli_Z( int value )
   {
      gxTv_SdtSeccion_Puestos_N = (byte)(0) ;
      gxTv_SdtSeccion_Puestos_Puestorelseccli_Z = value ;
   }

   public String getPuestopadre_Z( )
   {
      return gxTv_SdtSeccion_Puestos_Puestopadre_Z ;
   }

   public void setPuestopadre_Z( String value )
   {
      gxTv_SdtSeccion_Puestos_N = (byte)(0) ;
      gxTv_SdtSeccion_Puestos_Puestopadre_Z = value ;
   }

   public String getPuestorelref_Z( )
   {
      return gxTv_SdtSeccion_Puestos_Puestorelref_Z ;
   }

   public void setPuestorelref_Z( String value )
   {
      gxTv_SdtSeccion_Puestos_N = (byte)(0) ;
      gxTv_SdtSeccion_Puestos_Puestorelref_Z = value ;
   }

   private byte gxTv_SdtSeccion_Puestos_N ;
   protected short gxTv_SdtSeccion_Puestos_Modified ;
   protected short gxTv_SdtSeccion_Puestos_Initialized ;
   protected int gxTv_SdtSeccion_Puestos_Puestorelsec ;
   protected int gxTv_SdtSeccion_Puestos_Puestorelseccli ;
   protected int gxTv_SdtSeccion_Puestos_Puestorelsec_Z ;
   protected int gxTv_SdtSeccion_Puestos_Puestorelseccli_Z ;
   protected String gxTv_SdtSeccion_Puestos_Puestocodigo ;
   protected String gxTv_SdtSeccion_Puestos_Puestopadre ;
   protected String gxTv_SdtSeccion_Puestos_Mode ;
   protected String gxTv_SdtSeccion_Puestos_Puestocodigo_Z ;
   protected String gxTv_SdtSeccion_Puestos_Puestopadre_Z ;
   protected boolean gxTv_SdtSeccion_Puestos_Puestohorasext ;
   protected boolean gxTv_SdtSeccion_Puestos_Puestohorasext_Z ;
   protected String gxTv_SdtSeccion_Puestos_Puestoold ;
   protected String gxTv_SdtSeccion_Puestos_Puestodescrip ;
   protected String gxTv_SdtSeccion_Puestos_Puestodescripsinac ;
   protected String gxTv_SdtSeccion_Puestos_Puestorelref ;
   protected String gxTv_SdtSeccion_Puestos_Puestodescrip_Z ;
   protected String gxTv_SdtSeccion_Puestos_Puestodescripsinac_Z ;
   protected String gxTv_SdtSeccion_Puestos_Puestorelref_Z ;
}

